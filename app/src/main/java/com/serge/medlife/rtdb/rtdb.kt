package com.serge.medlife.rtdb

import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.serge.medlife.screens.servicesScreen.chatDoc.AppointmentData
import com.serge.medlife.screens.servicesScreen.medicationReminder.MedicationData

class RTDB {
    val auth = FirebaseAuth.getInstance()
    val db = FirebaseDatabase.getInstance().reference
    val uid = auth.currentUser?.uid ?: ""


    // Patient side

    fun fetchUserInfo(onResult: (String, String, String, String) -> Unit) {
        db.child("users").child(uid).get()
            .addOnSuccessListener { snapshot ->
                val userName = snapshot.child("userName").value as? String ?: ""
                val email = snapshot.child("email").value as? String ?: ""
                val gender = snapshot.child("gender").value as? String ?: ""
                val dateOfBirth = snapshot.child("dateOfBirth").value as? String ?: ""
                onResult(userName, email,gender, dateOfBirth)
//                Log.i("userNameFetch", userName)
            }
    }
    fun fetchUserName(onResult: (String) -> Unit) {
        db.child("users").child(uid).get()
            .addOnSuccessListener { snapshot ->
                val userName = snapshot.child("userName").value as? String ?: ""
                onResult(userName)
            }
    }


    // Doctor side

    fun fetchDoctorUserName(onResult: (String) -> Unit) {
        db.child("doctors").child(uid).get()
            .addOnSuccessListener { snapshot ->
                val doctorUserName = snapshot.child("doctorUserName").value as? String ?: ""
                onResult(doctorUserName)
            }
    }

    fun fetchDoctorInfo(onResult: (List<DoctorDetailsDTO>) -> Unit) {
        db.child("doctors").get()
            .addOnSuccessListener { snapshot ->
                val doctorList = snapshot.children.mapNotNull {
                    it.getValue(DoctorDetailsDTO::class.java)
                }
                onResult(doctorList)
            }
    }

    fun fetchAppointments(onResult: (List<AppointmentData>) -> Unit): ValueEventListener {
        val listener = object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val list = snapshot.children.mapNotNull {
                    it.getValue(AppointmentData::class.java)?.copy(key = it.key ?: "")
                }
                onResult(list)
            }
            override fun onCancelled(error: DatabaseError) {
                Log.e("fetchAppointments", "Error: ${error.message}")
            }
        }
        db.child("appointments").child(uid).addValueEventListener(listener)
        return listener
    }

    fun updateStatus(
        patientUid: String,
        appointmentKey: String,
        appointmentStatus: String,
        onSuccess: () -> Unit,
        onError: (String) -> Unit
    ) {
        db.child("appointments").child(patientUid)
            .child(appointmentKey)
            .child("appointmentStatus")
            .setValue(appointmentStatus)
            .addOnSuccessListener { onSuccess() }
            .addOnFailureListener {e -> onError(e.message ?: "Failed to update status")}
    }

    fun updateAppointment(
        key: String,
        newDate: String,
        newHour: String,
        onSuccess: () -> Unit,
        onError: (String) -> Unit
    ) {
        val updates = mapOf(
            "selectedDate" to newDate,
            "selectedHour" to newHour
        )

        db.child("appointments").child(uid).child(key)
            .updateChildren(updates)
            .addOnSuccessListener { onSuccess() }
            .addOnFailureListener { e -> onError(e.message ?: "Failed to update") }
    }

    fun fetchMedication(onResult: (List<MedicationData>) -> Unit): ValueEventListener {
            val listener = object: ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    Log.i("RTDB", "Raw snapshot: ${snapshot.value}")
                    val list = snapshot.children.mapNotNull {child ->
                        Log.i("RTDB", "Child key: ${child.key}")
                        Log.i("RTDB", "Child value: ${child.value}")
                        child.getValue(MedicationData::class.java)?.copy(
                            key = child.key ?: ""
                        )
                    }
                    Log.i("RTDB", "List size: ${list.size}")
                    onResult(list)
                }

                override fun onCancelled(error: DatabaseError) {
                    Log.e("fetchMedications", error.message)
                }
            }
        db.child("reminders").child(uid).addValueEventListener(listener)
        return listener
    }

    data class AppointmentWithPatient(
        val appointment: AppointmentData,
        val patientUid: String
    )

    fun fetchDoctorAppointments(onResult: (List<AppointmentWithPatient>) -> Unit): ValueEventListener {
        val listener = object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val list = mutableListOf<AppointmentWithPatient>()
                for (userSnapshot in snapshot.children) {
                    val patientUid = userSnapshot.key ?: ""
                    for (appointmentSnapshot in userSnapshot.children) {
                        val appointment = appointmentSnapshot.getValue(AppointmentData::class.java)
                            ?.copy(key = appointmentSnapshot.key ?: "")

                        if (appointment != null) {
                            list.add(RTDB.AppointmentWithPatient(appointment, patientUid))
                        }
                    }
                }
                onResult(list)
            }

            override fun onCancelled(error: DatabaseError) {
                Log.e("fetchError", error.message)
            }
        }
        db.child("appointments").addValueEventListener(listener)
        return listener
    }

    fun fetchAppointmentsDoctor(onResult: (List<AppointmentData>) -> Unit): ValueEventListener {
        val listener = object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val list = mutableListOf<AppointmentData>()

                for (userSnapshot in snapshot.children) {
                    for (appointmentSnapshots in userSnapshot.children) {
                        val appointment = appointmentSnapshots
                            .getValue(AppointmentData::class.java)?.copy(key = appointmentSnapshots.key ?: "")

                        if (appointment != null) {
                            list.add(appointment)
                        }
                    }
                }
                onResult(list)
            }

            override fun onCancelled(error: DatabaseError) {
                Log.e("fetchingError", error.message)
            }
        }
        db.child("appointments")
            .addValueEventListener(listener)
        return listener
    }
}

data class DoctorDetailsDTO (
    val doctorUserName: String = "",
    val doctorGender: String = "",
    val doctorSpecialization: String = ""
)
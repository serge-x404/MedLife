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

    fun updateAppointment(
        key: String,
        newDate: String,
        newHour: String,
        onSuccess: () -> Unit
    ) {
        val updates = mapOf(
            "selectedDate" to newDate,
            "selectedHour" to newHour
        )

        db.child("appointments").child(uid).child(key)
            .updateChildren(updates)
            .addOnSuccessListener { onSuccess() }
            .addOnFailureListener { e -> error(e) }
    }

    fun fetchMedication(onResult: (List<MedicationData>) -> Unit): ValueEventListener {
        db.child("reminders").child(uid)
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

}

data class DoctorDetailsDTO (
    val doctorUserName: String = "",
    val doctorGender: String = "",
    val doctorSpecialization: String = ""
)
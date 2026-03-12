package com.example.medcare.rtdb

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase

class RTDB {
    val auth = FirebaseAuth.getInstance()
    val db = FirebaseDatabase.getInstance().reference
    val uid = auth.currentUser?.uid ?: ""


    // Patient side

    fun FetchUserInfo(onResult: (String, String, String, String) -> Unit) {
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
    fun FetchUserName(onResult: (String) -> Unit) {
        db.child("users").child(uid).get()
            .addOnSuccessListener { snapshot ->
                val userName = snapshot.child("userName").value as? String ?: ""
                onResult(userName)
            }
    }


    // Doctor side

    fun FetchDoctorUserName(onResult: (String) -> Unit) {
        db.child("doctors").child(uid).get()
            .addOnSuccessListener { snapshot ->
                val doctorUserName = snapshot.child("doctorUserName").value as? String ?: ""
                onResult(doctorUserName)
            }
    }

}
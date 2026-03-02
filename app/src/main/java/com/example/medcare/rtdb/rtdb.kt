package com.example.medcare.rtdb

import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase

class RTDB {
    val auth = FirebaseAuth.getInstance()
    val db = FirebaseDatabase.getInstance().reference
    val uid = auth.currentUser?.uid ?: ""

    fun FetchUserInfo(onResult: (String, String) -> Unit) {
        db.child("users").child(uid).get()
            .addOnSuccessListener { snapshot ->
                val userName = snapshot.child("userName").value as? String ?: ""
                val email = snapshot.child("email").value as? String ?: ""
                onResult(userName, email)
                Log.i("userNameFetch", "${userName}")
            }
    }
}
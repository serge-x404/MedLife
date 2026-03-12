package com.example.medcare.screens.homeScreen

import android.content.SharedPreferences
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.core.content.edit
import com.example.medcare.rtdb.RTDB
import com.google.firebase.auth.FirebaseAuth

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DoctorHomeScreen(
    navigateToAuthSplash: () -> Unit,
    sharedPreferences: SharedPreferences
) {
    var doctorName by remember { mutableStateOf("") }
    val rtdb = RTDB()
    val auth = FirebaseAuth.getInstance()
    LaunchedEffect(Unit) {
        rtdb.FetchDoctorInfo { it ->
            doctorName = it
        }
    }
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(
                    "Hey $doctorName",
                    style = MaterialTheme.typography.headlineLarge,
                    color = MaterialTheme.colorScheme.onBackground
                ) },
                colors = TopAppBarDefaults.topAppBarColors(MaterialTheme.colorScheme.surfaceContainerHighest)
            )
        }
    ) {
        Column(modifier = Modifier
            .padding(it)
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.surfaceContainerHighest)
        ) {
            Text(
                "Chats",
                color = MaterialTheme.colorScheme.onBackground,
                style = MaterialTheme.typography.displayMedium
            )

            Button(
                onClick = {
                    auth.signOut()
                    navigateToAuthSplash()
                    sharedPreferences.edit(commit = true){
                        putBoolean("isDoctorLoggedIn",false)
                        putBoolean("isDoctor",false)
                    }
                },
                modifier = Modifier.align(alignment = Alignment.CenterHorizontally)
            ) {
                Text("Sign out")
            }
        }
    }
}
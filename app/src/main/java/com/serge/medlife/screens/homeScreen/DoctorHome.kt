package com.serge.medlife.screens.homeScreen

import android.content.SharedPreferences
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PowerSettingsNew
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.core.content.edit
import com.serge.medlife.rtdb.RTDB
import com.serge.medlife.screens.servicesScreen.chatDoc.AppointmentData

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DoctorHomeScreen(
    navigateToAuthSplash: () -> Unit,
    sharedPreferences: SharedPreferences
) {
    var doctorName by remember { mutableStateOf("") }
    var scheduledAppointments by remember { mutableStateOf<List<AppointmentData>>(emptyList()) }
    var isLoading by remember { mutableStateOf(true) }
    val rtdb = RTDB()
    LaunchedEffect(Unit) {
        rtdb.fetchDoctorUserName { it ->
            doctorName = it
        }
    }

    DisposableEffect(Unit) {
        val listener = rtdb.fetchAppointments { appointmentData ->
            scheduledAppointments = appointmentData
            isLoading = false
        }
        onDispose {
            rtdb.fetchAppointments {
                rtdb.db.child("appointments").child(rtdb.uid)
                    .removeEventListener(listener)
            }
        }
    }

    if (isLoading) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            CircularProgressIndicator(
                color = MaterialTheme.colorScheme.primary
            )
        }
    }
    else {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Text(
                            "Hey $doctorName",
                            style = MaterialTheme.typography.headlineLarge,
                            color = MaterialTheme.colorScheme.onBackground
                        )
                    },
                    actions = {
                        IconButton(
                            onClick = {
                                rtdb.auth.signOut()
                                navigateToAuthSplash()
                                sharedPreferences.edit(commit = true) {
                                    putBoolean("isDoctorLoggedIn", false)
                                    putBoolean("isDoctor", false)
                                }
                            }
                        ) {
                            Icon(
                                imageVector = Icons.Default.PowerSettingsNew,
                                contentDescription = null
                            )
                        }
                    },
                    colors = TopAppBarDefaults.topAppBarColors(MaterialTheme.colorScheme.surfaceContainerHighest)
                )
            }
        ) {
            Column(
                modifier = Modifier
                    .padding(it)
                    .fillMaxSize()
                    .background(MaterialTheme.colorScheme.surfaceContainerHighest)
            ) {
                if (scheduledAppointments.isEmpty()) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(
                            "No upcoming appointments",
                            style = MaterialTheme.typography.titleMedium,
                            color = MaterialTheme.colorScheme.onBackground
                        )
                    }
                }
                else {
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                    ) {
                        Text("")
                    }
                }
            }
        }
    }
}
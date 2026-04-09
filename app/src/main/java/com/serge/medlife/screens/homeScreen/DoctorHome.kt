package com.serge.medlife.screens.homeScreen

import android.content.SharedPreferences
import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Logout
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.core.content.edit
import com.serge.medlife.rtdb.RTDB
import com.serge.medlife.screens.history.isUpcoming

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DoctorHomeScreen(
    navigateToAuthSplash: () -> Unit,
    sharedPreferences: SharedPreferences
) {
    var doctorName by remember { mutableStateOf("") }
    var scheduledAppointments by remember { mutableStateOf<List<RTDB.AppointmentWithPatient>>(emptyList()) }
    val pendingAppointments = scheduledAppointments.filter {
        isUpcoming(it.appointment.selectedDate) && it.appointment.doctorName == doctorName
    }
    var isLoading by remember { mutableStateOf(true) }
    var showDialog by remember { mutableStateOf(false) }

    val rtdb = RTDB()
    LaunchedEffect(Unit) {
        rtdb.fetchDoctorUserName { fetchedName ->
            doctorName = fetchedName
        }
    }

    DisposableEffect(Unit) {
        val listener = rtdb.fetchDoctorAppointments { appointmentData ->
            scheduledAppointments = appointmentData
            Log.d("appointmentData",scheduledAppointments.toString())
            isLoading = false
        }
        onDispose {
            rtdb.fetchAppointments {
                rtdb.db.child("appointments")
                    .removeEventListener(listener)
            }
        }
    }

    if (showDialog) {
        AlertDialog(
            onDismissRequest = { showDialog = false },
            icon = {
                Icon(
                    imageVector = Icons.Default.Warning,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.error
                )
            },
            title = {
                Text(
                    "Logout",
                    style = MaterialTheme.typography.headlineSmall,
                    color = MaterialTheme.colorScheme.onBackground,
                )
            },
            text = {
                Text(
                    "Are you sure you want to log out?",
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.onBackground
                )
            },
            confirmButton = {
                Button(
                    onClick = {
                        rtdb.auth.signOut()
                        navigateToAuthSplash()
                        sharedPreferences.edit(commit = true) {
                            putBoolean("isDoctorLoggedIn",false)
                            putBoolean("isDoctor",false)
                        }
                    },
                    colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.errorContainer),
                    border = BorderStroke(1.dp, MaterialTheme.colorScheme.outline),
                ) {
                    Text(
                        "Logout",
                        style = MaterialTheme.typography.labelLarge,
                        color = MaterialTheme.colorScheme.onErrorContainer,
                        textAlign = TextAlign.Center
                    )
                }
            },
            dismissButton = {
                Button(
                    onClick = { showDialog = false },
                    colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.primaryContainer),
                    border = BorderStroke(1.dp, MaterialTheme.colorScheme.outline)
                ) {
                    Text(
                        "Cancel",
                        style = MaterialTheme.typography.labelLarge,
                        color = MaterialTheme.colorScheme.onPrimaryContainer,
                        textAlign = TextAlign.Center
                    )
                }
            }
        )
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
                            "Dr. $doctorName",
                            style = MaterialTheme.typography.headlineLarge,
                            color = MaterialTheme.colorScheme.onBackground
                        )
                    },
                    actions = {
                        IconButton(
                            onClick = { showDialog = !showDialog}
                        ) {
                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.Logout,
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
                if (pendingAppointments.isEmpty()) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(
                            "No appointments",
                            style = MaterialTheme.typography.titleMedium,
                            color = MaterialTheme.colorScheme.onBackground
                        )
                    }
                }
                else {
                    LazyColumn {
                        items(pendingAppointments) {appointment ->
                            var status by remember { mutableStateOf(appointment.appointment.appointmentStatus) }
                            Card(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(horizontal = 12.dp, vertical = 6.dp),
                                colors = CardDefaults.cardColors(MaterialTheme.colorScheme.surfaceContainer),
                                border = BorderStroke(0.5.dp, MaterialTheme.colorScheme.outlineVariant),
                                elevation = CardDefaults.cardElevation(2.dp)
                            ) {
                                Column(
                                    modifier = Modifier.padding(16.dp)
                                ) {
                                    Text(
                                        "Patient: ${appointment.appointment.userName}",
                                        style = MaterialTheme.typography.titleMedium,
                                        color = MaterialTheme.colorScheme.onBackground
                                    )
                                    Text(
                                        "Date: ${appointment.appointment.selectedDate}",
                                        style = MaterialTheme.typography.labelLarge,
                                        color = MaterialTheme.colorScheme.onBackground
                                    )
                                    Text(
                                        "Date: ${appointment.appointment.selectedHour}",
                                        style = MaterialTheme.typography.labelLarge,
                                        color = MaterialTheme.colorScheme.onBackground
                                    )
                                    Spacer(Modifier.height(8.dp))
                                    Text(
                                        text = status,
                                        color = when (status) {
                                            "Confirmed" -> MaterialTheme.colorScheme.onPrimaryContainer
                                            "Rejected" -> MaterialTheme.colorScheme.onErrorContainer
                                            else -> MaterialTheme.colorScheme.onSurface
                                        },
                                        style = MaterialTheme.typography.labelMedium,
                                        modifier = Modifier
                                            .clip(RoundedCornerShape(12.dp))
                                            .background(
                                                when (status) {
                                                    "Confirmed" -> MaterialTheme.colorScheme.primaryContainer
                                                    "Rejected" -> MaterialTheme.colorScheme.errorContainer
                                                    else -> MaterialTheme.colorScheme.surfaceContainer
                                                }
                                            )
                                            .padding(horizontal = 8.dp, vertical = 4.dp)
                                    )
                                    if (status == "Waiting for confirmation") {
                                        Spacer(Modifier.height(12.dp))
                                        HorizontalDivider()
                                        Spacer(Modifier.height(8.dp))
                                        Row(
                                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                                        ) {
                                            Button(
                                                onClick = {
                                                    rtdb.updateStatus(
                                                        patientUid = appointment.patientUid,
                                                        appointmentKey = appointment.appointment.key,
                                                        appointmentStatus = "Confirmed",
                                                        onSuccess = { status = "Confirmed"},
                                                        onError = {Log.e("Status",it)}
                                                    )
                                                },
                                                colors = ButtonDefaults.buttonColors(
                                                    MaterialTheme.colorScheme.surfaceContainerLowest
                                                ),
                                                border = BorderStroke(0.5.dp, MaterialTheme.colorScheme.outlineVariant)
                                            ) {
                                                Text(
                                                    "Confirm",
                                                    color = MaterialTheme.colorScheme.onSurface
                                                )
                                            }
                                            Button(
                                                onClick = {
                                                    rtdb.updateStatus(
                                                        patientUid = appointment.patientUid,
                                                        appointmentKey = appointment.appointment.key,
                                                        appointmentStatus = "Rejected",
                                                        onSuccess = {status = "Rejected"},
                                                        onError = {Log.e("Status",it)}
                                                    )
                                                },
                                                colors = ButtonDefaults.buttonColors(
                                                    MaterialTheme.colorScheme.errorContainer
                                                ),
                                                border = BorderStroke(0.5.dp, MaterialTheme.colorScheme.outlineVariant)
                                            ) {
                                                Text(
                                                    "Reject",
                                                    color = MaterialTheme.colorScheme.onErrorContainer
                                                )
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
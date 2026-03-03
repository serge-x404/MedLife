package com.example.medcare.registerScreen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Popup
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PatientRegister(
    navigateToLoginScreen: () -> Unit,
    navigateToHomeScreen: () -> Unit
) {
    val auth = FirebaseAuth.getInstance()
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var userName by remember { mutableStateOf("") }
    var checked by remember { mutableStateOf(false) }
    var showDatePicker by remember { mutableStateOf(false) }
    val datePickerState = rememberDatePickerState()
    var selectedDate = datePickerState.selectedDateMillis?.let { convertMillisToDate(it) } ?: ""
    var isLoading by remember { mutableStateOf(false) }
    var errorMessage by remember { mutableStateOf("") }

//    if (isLoading) {
//        CircularProgressIndicator()
//    }

    if (errorMessage.isNotEmpty()) {
        Text(
            errorMessage,
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.onBackground
        )
    }
    Scaffold(
        contentWindowInsets = WindowInsets(0.dp)
    ) { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)) {
            Column(
                Modifier
                    .background(MaterialTheme.colorScheme.surfaceContainerHighest)
                    .border(2.dp, MaterialTheme.colorScheme.outlineVariant)
                    .padding(horizontal = 12.dp)
                    .fillMaxSize()
            ) {
                Spacer(Modifier.height(10.dp))
                Text(
                    text = "Email",
                    color = MaterialTheme.colorScheme.onBackground,
                    style = MaterialTheme.typography.titleLarge
                )
                OutlinedTextField(
                    value = email,
                    label = {
                        Text(
                            "Enter your email",
                            color = MaterialTheme.colorScheme.onBackground,
                            style = MaterialTheme.typography.titleSmall
                        )
                    },
                    onValueChange = { email = it },
                    maxLines = 1    ,
                    modifier = Modifier.fillMaxWidth(),
                    textStyle = MaterialTheme.typography.titleSmall,
                    colors = TextFieldDefaults.colors(MaterialTheme.colorScheme.onBackground)
                )
                Spacer(Modifier.height(5.dp))
                Text(
                    text = "Password",
                    color = MaterialTheme.colorScheme.onBackground,
                    style = MaterialTheme.typography.titleLarge
                )
                OutlinedTextField(
                    value = password,
                    label = {
                        Text(
                            "Create a password",
                            color = MaterialTheme.colorScheme.onBackground,
                            style = MaterialTheme.typography.titleSmall
                        )
                    },
                    onValueChange = { password = it },
                    maxLines = 1,
                    modifier = Modifier.fillMaxWidth(),
                    textStyle = MaterialTheme.typography.titleSmall,
                    colors = TextFieldDefaults.colors(MaterialTheme.colorScheme.onBackground)
                )
                Spacer(Modifier.height(5.dp))
                Text(
                    text = "Full Name",
                    color = MaterialTheme.colorScheme.onBackground,
                    style = MaterialTheme.typography.titleLarge
                )
                OutlinedTextField(
                    value = userName,
                    label = {
                        Text(
                            "Enter your full name",
                            color = MaterialTheme.colorScheme.onBackground,
                            style = MaterialTheme.typography.titleSmall
                        )
                    },
                    onValueChange = {userName = it},
                    modifier = Modifier.fillMaxWidth(),
                    textStyle = MaterialTheme.typography.titleSmall,
                    colors = TextFieldDefaults.colors(MaterialTheme.colorScheme.onBackground)
                )
                Spacer(Modifier.height(5.dp))
                Text(
                    text = "Gender",
                    color = MaterialTheme.colorScheme.onBackground,
                    style = MaterialTheme.typography.titleLarge
                )
                OutlinedTextField(
                    value = "",
                    placeholder = {
                        Text(
                            "Choose your gender",
                            modifier = Modifier.fillMaxWidth(),
                            color = MaterialTheme.colorScheme.onBackground,
                            style = MaterialTheme.typography.titleSmall
                        )
                    },
                    onValueChange = {}
                )
                Spacer(Modifier.height(5.dp))
                Text(
                    text = "Date of birth",
                    color = MaterialTheme.colorScheme.onBackground,
                    style = MaterialTheme.typography.titleLarge
                )
                OutlinedTextField(
                    value = selectedDate,
                    placeholder = {
                        Text(
                            "Enter your date of birth",
                            color = MaterialTheme.colorScheme.onBackground,
                            style = MaterialTheme.typography.titleSmall
                        )
                    },
                    onValueChange = {},
                    textStyle = MaterialTheme.typography.titleSmall,
                    colors = TextFieldDefaults.colors(MaterialTheme.colorScheme.onBackground),
                    modifier = Modifier
                        .fillMaxWidth(),
                    readOnly = true,
                    trailingIcon = {
                        IconButton(onClick = { showDatePicker = !showDatePicker }) {
                            Icon(
                                imageVector = Icons.Default.DateRange,
                                contentDescription = null,
                                tint = MaterialTheme.colorScheme.onBackground
                            )
                            if (showDatePicker) {
                                Popup(
                                    onDismissRequest = { showDatePicker = false },
                                    alignment = Alignment.Center
                                ) {
                                    Box {
                                        DatePicker(
                                            state = datePickerState,
                                            showModeToggle = false
                                        )
                                    }
                                }
                            }
                        }
                    }
                )
                Spacer(Modifier.height(5.dp))
                Row(
                    horizontalArrangement = Arrangement.spacedBy(5.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Checkbox(
                        checked = checked,
                        onCheckedChange = { checked = it },
                        modifier = Modifier.size(18.dp)
                    )
                    Text(
                        text = "You agree to receive information and notifications sent by MedCare",
                        style = MaterialTheme.typography.titleSmall,
                        color = MaterialTheme.colorScheme.onBackground,
                    )
                }
            }
        }
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 12.dp, vertical = 20.dp),
            contentAlignment = Alignment.BottomCenter
        ) {
            Column {
                Button(
                    onClick = {
                        if (email.isBlank() || password.isBlank() || userName.isBlank()) {
                            errorMessage = "Please fill in all fields"
                            return@Button
                        }
                        if (password.length<8) {
                            errorMessage = "Length of password must be at least of 8 characters"
                            return@Button
                        }
                        isLoading = true
                        auth.createUserWithEmailAndPassword(email, password)
                            .addOnCompleteListener { task ->
                                isLoading = false
                                if (task.isSuccessful) {
                                    val db = FirebaseDatabase.getInstance().reference
                                    val uid = auth.currentUser!!.uid
                                    val userMap = mapOf(
                                        "userName" to userName,
                                        "email" to email,
                                        "password" to password
                                    )
                                    db.child("users").child(uid).setValue(userMap)
                                        .addOnSuccessListener { navigateToHomeScreen() }
                                        .addOnFailureListener { e -> errorMessage = e.message ?: "Failed to save data" }
                                }
                                else {
                                    errorMessage = task.exception?.message ?: "Registration failed"
                                }
                            }
                    },
                    Modifier.fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.secondary),
                    border = BorderStroke(2.dp, MaterialTheme.colorScheme.outlineVariant)
                ) {
                    if (isLoading) {
                        CircularProgressIndicator(
                            color = MaterialTheme.colorScheme.onTertiary
                        )
                    }
                    else {
                        Text(
                            text = "Register",
                            style = MaterialTheme.typography.titleMedium,
                            color = MaterialTheme.colorScheme.onTertiary
                        )
                    }
                }
                Row(
                    modifier = Modifier
                        .clickable(
                            enabled = true,
                            onClick = navigateToLoginScreen
                        ),
                    horizontalArrangement = Arrangement.spacedBy(4.dp),
                ) {
                    Text(
                        text = "Already have an account?",
                        textAlign = TextAlign.Center,
                        color = MaterialTheme.colorScheme.onBackground,
                        style = MaterialTheme.typography.labelLarge
                    )
                    Text(
                        text = "Click here to login",
                        textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.labelLarge,
                        color = MaterialTheme.colorScheme.onBackground,
                    )
                }
            }
        }
    }
}

@Composable
fun convertMillisToDate(millis: Long): String {
    val formatter = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
    return formatter.format(Date(millis))
}
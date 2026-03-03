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
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.DatePicker
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Popup
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.TextFieldDefaults
import com.google.firebase.Firebase
import com.google.firebase.auth.auth
import com.google.firebase.database.FirebaseDatabase

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DoctorRegister(
    navigateToLoginScreen: () -> Unit,
    navigateToHomeScreen: () -> Unit,
    navigateToConfirmationScreen: () -> Unit
) {
    var userName by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var checked by remember { mutableStateOf(false) }
    var password by remember { mutableStateOf("") }
    var showDatePicker by remember { mutableStateOf(false) }
    val auth = Firebase.auth
    var errorMessage by remember { mutableStateOf("") }
    var isLoading by remember { mutableStateOf(false) }
    val datePickerState = rememberDatePickerState()
    val selectedDate = datePickerState.selectedDateMillis?.let {convertMillisToDate(it) }?:""
    Scaffold(
        contentWindowInsets = WindowInsets(0.dp)
    ) {
        Column(
            modifier = Modifier.padding(it)
        ) {
            Column(
                modifier = Modifier
                    .background(MaterialTheme.colorScheme.surfaceContainerHighest)
                    .border(2.dp, MaterialTheme.colorScheme.outlineVariant)
                    .fillMaxSize()
                    .padding(horizontal = 12.dp)
            ) {
                Spacer(Modifier.height(10.dp))
                Text(
                    text = "Email",
                    style = MaterialTheme.typography.titleLarge,
                    color = MaterialTheme.colorScheme.onBackground
                )
                OutlinedTextField(
                    value = email,
                    label = {
                        Text(
                            "Enter your email",
                            style = MaterialTheme.typography.titleSmall,
                            color = MaterialTheme.colorScheme.onBackground
                        )
                    },
                    onValueChange = {email = it},
                    textStyle = MaterialTheme.typography.titleSmall,
                    colors = TextFieldDefaults.colors(MaterialTheme.colorScheme.onBackground),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
                    modifier = Modifier.fillMaxWidth(),
                )
                Spacer(Modifier.height(5.dp))
                Text(
                    text = "Password",
                    color = MaterialTheme.colorScheme.onBackground,
                    style = MaterialTheme.typography.titleLarge
                )
                OutlinedTextField(
                    value = password,
                    label = { Text(
                        "Create a password",
                        color = MaterialTheme.colorScheme.onBackground,
                        style = MaterialTheme.typography.titleSmall
                    ) },
                    modifier = Modifier.fillMaxWidth(),
                    onValueChange = {password = it},
                    textStyle = MaterialTheme.typography.titleSmall,
                    colors = TextFieldDefaults.colors(MaterialTheme.colorScheme.onBackground),
                )
                Spacer(Modifier.height(5.dp))
                Text(
                    text = "Full Name",
                    style = MaterialTheme.typography.titleLarge,
                    color = MaterialTheme.colorScheme.onBackground
                )
                OutlinedTextField(
                    value = userName,
                    label = {
                        Text(
                            "Enter your full name",
                            style = MaterialTheme.typography.titleSmall,
                            color = MaterialTheme.colorScheme.onBackground,
                        )
                    },
                    modifier = Modifier.fillMaxWidth(),
                    onValueChange = {userName = it},
                    textStyle = MaterialTheme.typography.titleSmall,
                    colors = TextFieldDefaults.colors(MaterialTheme.colorScheme.onBackground),
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
                            color = MaterialTheme.colorScheme.onBackground,
                            style = MaterialTheme.typography.titleSmall
                        )
                    },
                    modifier = Modifier.fillMaxWidth(),
                    onValueChange = {},
                    textStyle = MaterialTheme.typography.titleSmall,
                    colors = TextFieldDefaults.colors(MaterialTheme.colorScheme.onBackground),
                )
                Spacer(Modifier.height(5.dp))
                Text(
                    text = "Upload documents",
                    color = MaterialTheme.colorScheme.onBackground,
                    style = MaterialTheme.typography.titleLarge
                )
                OutlinedTextField(
                    value = selectedDate,
                    placeholder = { Text(
                        "Upload documents",
                        color = MaterialTheme.colorScheme.onBackground,
                        style = MaterialTheme.typography.titleSmall
                    ) },
                    modifier = Modifier.fillMaxWidth(),
                    onValueChange = {},
//                    readOnly = true,
//                    trailingIcon = {
//                        IconButton(onClick = {showDatePicker = !showDatePicker}) {
//                            Icon(
//                                imageVector = Icons.Default.DateRange,
//                                contentDescription = null
//                            )
//                            if (showDatePicker) {
//                                Popup(
//                                    onDismissRequest = { showDatePicker = false },
//                                    alignment = Alignment.Center
//                                ) {
//                                    Box {
//                                        DatePicker(
//                                            state = datePickerState,
//                                            showModeToggle = false
//                                        )
//                                    }
//                                }
//                            }
//                        }
//                    }
                )
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
                        if (password.length < 8) {
                            errorMessage = "Password length must be at least of 8 characters"
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
                                        "doctorEmail" to email,
                                        "doctorPassword" to password,
                                        "doctorUserName" to userName
                                    )
                                    db.child("doctors").child(uid).setValue(userMap)
                                        .addOnSuccessListener { navigateToConfirmationScreen() }
                                        .addOnFailureListener { e -> errorMessage = e.message ?: "Failed to register" }
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
                            onClick = navigateToConfirmationScreen
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
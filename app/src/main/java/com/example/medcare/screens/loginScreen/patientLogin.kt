package com.example.medcare.screens.loginScreen

import android.content.SharedPreferences
import android.util.Log
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
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.core.content.edit
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase

@Composable
fun PatientLogin(
    navigateToHomeScreen: () -> Unit,
    navigateToRegister: () -> Unit,
    sharedPreferences: SharedPreferences
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordVisibility by remember { mutableStateOf(false) }
    var errorMessage by remember { mutableStateOf("") }
    var isLoading by remember { mutableStateOf(false) }
    val auth = FirebaseAuth.getInstance()
    val db = FirebaseDatabase.getInstance().reference
    Scaffold(
        contentWindowInsets = WindowInsets(0.dp)
    ) { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)) {
            Column(modifier = Modifier
                .background(MaterialTheme.colorScheme.surfaceContainerHighest)
                .border(2.dp, MaterialTheme.colorScheme.outlineVariant)
                .padding(horizontal = 12.dp)
                .fillMaxSize()
            ) {
                Spacer(Modifier.height(10.dp))
//                Text(
//                    "Patient",
//                    style = MaterialTheme.typography.headlineSmall,
//                    color = MaterialTheme.colorScheme.onBackground,
//                    modifier = Modifier.align(Alignment.CenterHorizontally)
//                )
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
                    modifier = Modifier.fillMaxWidth(),
                    onValueChange = { email = it},
                    maxLines = 1,
                    textStyle = MaterialTheme.typography.titleSmall,
                    colors = TextFieldDefaults.colors(MaterialTheme.colorScheme.onBackground)
                )
                Spacer(Modifier.height(10.dp))
                Text(
                    text = "Password",
                    style = MaterialTheme.typography.titleLarge,
                    color = MaterialTheme.colorScheme.onBackground
                )
                OutlinedTextField(
                    value = password,
                    label = {
                        Text(
                            "Enter your password",
                            style = MaterialTheme.typography.titleSmall,
                            color = MaterialTheme.colorScheme.onBackground
                        )
                    },
                    onValueChange = { password = it},
                    modifier = Modifier.fillMaxWidth(),
                    visualTransformation = if (passwordVisibility) VisualTransformation.None
                    else PasswordVisualTransformation(),
                    singleLine = true,
                    trailingIcon = {
                        val icon = if (passwordVisibility) Icons.Default.Clear else Icons.Default.Check
                        IconButton(onClick = {passwordVisibility = !passwordVisibility}) {
                            Icon(
                                imageVector = icon,
                                contentDescription = null
                            )
                        }
                    },
                    textStyle = MaterialTheme.typography.titleSmall,
                    colors = TextFieldDefaults.colors(MaterialTheme.colorScheme.onBackground)
                )
                Spacer(Modifier.height(10.dp))
                Text(
                    text = "Is there any issue with your email?",
                    style = MaterialTheme.typography.titleSmall,
                    color = MaterialTheme.colorScheme.onBackground,
                    modifier = Modifier.clickable(
                        enabled = true,
                        onClick = {}
                    )
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
                        if (email.isBlank() || password.isBlank()) {
                            errorMessage = "Please fill all the fields"
                            return@Button
                        }
                        isLoading = true
                        auth.signInWithEmailAndPassword(email, password)
                            .addOnCompleteListener { task ->
                                isLoading =false
                                Log.i("login btn click", "$isLoading")
                                if (task.isSuccessful) {
                                    val uid = auth.currentUser!!.uid
                                    db.child("users").child(uid).get()
                                        .addOnSuccessListener { snapshot ->
                                            if (snapshot.exists()) {
                                                navigateToHomeScreen()
                                                sharedPreferences.edit(commit = true) {
                                                    putBoolean("isLoggedIn", true)
                                                }
                                            }
                                        }
                                }
                                else {
                                    errorMessage = task.exception?.message ?: "Login failed"
                                }
                            }
                    },
                    Modifier.fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.secondary),
                    border = BorderStroke(2.dp, MaterialTheme.colorScheme.outlineVariant)
                ) {
                    if (isLoading) {
                        CircularProgressIndicator(
                            color = MaterialTheme.colorScheme.onTertiary
                        )
                    }
                    else {
                        Text(
                            text = "Login",
                            style = MaterialTheme.typography.titleMedium,
                            color = MaterialTheme.colorScheme.onTertiary
                        )
                    }
                }
                Spacer(Modifier.height(4.dp))
                Row(
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Text(
                        text = "Don't have a MedCare account?",
                        style = MaterialTheme.typography.labelLarge,
                        color = MaterialTheme.colorScheme.onBackground,
                        textAlign = TextAlign.Center
                    )
                    Spacer(Modifier.width(4.dp))
                    Text(
                        text = "Sign up",
                        textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.labelLarge.copy(
                            fontWeight = FontWeight.SemiBold
                        ),
                        color = MaterialTheme.colorScheme.onBackground,
                        modifier = Modifier
                            .clickable(
                                enabled = true,
                                onClick = { navigateToRegister() }
                            )
                    )
                }
            }
        }
    }
}
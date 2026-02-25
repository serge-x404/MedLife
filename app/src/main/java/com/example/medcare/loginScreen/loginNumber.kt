package com.example.medcare.loginScreen

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
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun PhoneNumberLogin(
    navigateToRegister: () -> Unit
) {
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
                Text(
                    text = "Phone Number",
                    color = MaterialTheme.colorScheme.onBackground,
                    style = MaterialTheme.typography.titleLarge
                )
                OutlinedTextField(
                    value = "",
                    label = {
                        Text(
                            "Enter your number",
                            style = MaterialTheme.typography.titleSmall,
                            color = MaterialTheme.colorScheme.onBackground
                        )
                    },
                    onValueChange = {},
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
        Box(modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 12.dp, vertical = 20.dp),
            contentAlignment = Alignment.BottomCenter
        ) {
            Column {
                Button(
                    onClick = {
                        //
                    },
                    Modifier.fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.secondary),
                    border = BorderStroke(2.dp, MaterialTheme.colorScheme.outlineVariant)
                ) {
                    Text(
                        text = "Login",
                        style = MaterialTheme.typography.titleMedium,
                        color = MaterialTheme.colorScheme.onTertiary
                    )
                }
                Spacer(Modifier.height(4.dp))
                Row(
                    horizontalArrangement = Arrangement.spacedBy(4.dp),
                    modifier = Modifier.clickable(
                        enabled = true,
                        onClick = { navigateToRegister() }
                    )
                ) {
                    Text(
                        text = "Don't have a MedCare account?",
                        style = MaterialTheme.typography.labelLarge,
                        color = MaterialTheme.colorScheme.onBackground,
                        textAlign = TextAlign.Center
                    )
                    Text(
                        text = "Sign up",
                        textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.labelLarge,
                        color = MaterialTheme.colorScheme.onBackground
                    )
                }
            }
        }
    }
}
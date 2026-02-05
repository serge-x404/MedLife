package com.example.medcare.loginScreen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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

@Preview(
    showBackground = true, showSystemUi = true
)
@Composable
fun PhoneNumberLogin() {
    Scaffold() { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)) {
            Column(modifier = Modifier.padding(horizontal = 12.dp)) {
                Text(
                    text = "Phone Number",
                    color = Color(0xFF26408B),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
                OutlinedTextField(
                    value = "",
                    label = { Text("Enter your number") },
                    onValueChange = {},
                )
                Spacer(Modifier.height(14.dp))
                Text(
                    text = "Is there any issue with your email?",
                    fontSize = 14.sp,
                    modifier = Modifier.clickable(
                        enabled = true,
                        onClick = {}
                    )
                )
                Spacer(Modifier.height(340.dp))
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Button(
                        onClick = {
                            //
                        },
                        Modifier.fillMaxWidth(),
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF26408B))
                    ) {
                        Text(
                            text = "Login"
                        )
                    }
                    Spacer(Modifier.height(4.dp))
                    Row(horizontalArrangement = Arrangement.spacedBy(4.dp)) {
                        Text(
                            text = "Don't have a MedCare account?",
                            textAlign = TextAlign.Center
                        )
                        Text(
                            text = "Sign up",
                            textAlign = TextAlign.Center,
                            color = Color(0xFF26408B),
                            modifier = Modifier.clickable(
                                enabled = true,
                                onClick = {}
                            )
                        )
                    }
                }
            }
        }
    }
}
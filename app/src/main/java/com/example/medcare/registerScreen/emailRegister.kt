package com.example.medcare.registerScreen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun EmailRegister() {
    var checked by remember { mutableStateOf(false) }
    Scaffold { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)) {
            Column(Modifier.padding(horizontal = 12.dp)) {
                Text(
                    text = "Email",
                    color = Color(0xFF26408B),
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )
                OutlinedTextField(
                    value = "",
                    label = { Text("Enter your email") },
                    onValueChange = {}
                )
                Spacer(Modifier.height(20.dp))
                Text(
                    text = "Full Name",
                    color = Color(0xFF26408B),
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )
                OutlinedTextField(
                    value = "",
                    label = { Text("Enter your full name") },
                    onValueChange = {}
                )
                Spacer(Modifier.height(20.dp))
                Text(
                    text = "Gender",
                    color = Color(0xFF26408B),
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )
                OutlinedTextField(
                    value = "",
                    label = { Text("Choose your gender") },
                    onValueChange = {}
                )
                Spacer(Modifier.height(20.dp))
                Text(
                    text = "Date of birth",
                    color = Color(0xFF26408B),
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )
                OutlinedTextField(
                    value = "",
                    label = { Text("Enter your date of birth") },
                    onValueChange = {}
                )
                Spacer(Modifier.height(20.dp))
                Row(horizontalArrangement = Arrangement.spacedBy(5.dp)) {
                    Checkbox(
                        checked = checked,
                        onCheckedChange = { checked = it },
                        modifier = Modifier.size(18.dp)
                    )
                    Text(
                        text = "You agree to receive information and notifications sent by MedCare",
                        fontSize = 15.sp
                    )
                }
                Spacer(Modifier.height(30.dp))
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Bottom
                ) {
                    Button(
                        onClick = {
                            //
                        },
                        Modifier.fillMaxWidth(),
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF26408B))
                    ) {
                        Text(
                            text = "Register"
                        )
                    }
                    Row(horizontalArrangement = Arrangement.spacedBy(4.dp)) {
                        Text(
                            text = "Already have an account?",
                            textAlign = TextAlign.Center
                        )
                        Text(
                            text = "Click here to login",
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
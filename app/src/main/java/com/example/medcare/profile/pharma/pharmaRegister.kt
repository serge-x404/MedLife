package com.example.medcare.profile.pharma

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview(showBackground = true,
    showSystemUi = true)
@Composable
fun RegisterPharma() {
    Column(Modifier.fillMaxSize()
        .background(Color(0xFF26408B))
        .padding(12.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Text(
                    text = "Register",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color(0xFF4D4D4D)
                )
                OutlinedTextField(
                    value = "",
                    onValueChange = {},
                    label = { Text("Enter your name") },
                    modifier = Modifier.fillMaxWidth(),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
                )
                OutlinedTextField(
                    value = "",
                    onValueChange = {},
                    label = { Text("Enter your email") },
                    modifier = Modifier.fillMaxWidth(),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
                )
                OutlinedTextField(
                    value = "",
                    onValueChange = {},
                    label = { Text("Enter your GSTIN number") },
                    modifier = Modifier.fillMaxWidth(),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                )
                Spacer(Modifier.height(8.dp))
                Button(
                    onClick = {

                    },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF26408B)),
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                ) {
                    Text(
                        "Login",
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 14.sp
                    )
                }

            }
        }
    }
}
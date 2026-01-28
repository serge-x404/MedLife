package com.example.medcare.splashScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview(showBackground = true,
    showSystemUi = true)
@Composable
fun EmailRegister() {
    Scaffold{ innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)) {
            Text(
                text = "Email",
                color = Color(0xFF26408B),
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp
            )
            OutlinedTextField(
                value = "",
                label = {Text("Enter your email")},
                onValueChange = {}
            )
            Spacer(Modifier.height(30.dp))
            Text(
                text = "Full Name",
                color = Color(0xFF26408B),
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp
            )
            OutlinedTextField(
                value = "",
                label = {Text("Enter your full name")},
                onValueChange = {}
            )
            Spacer(Modifier.height(30.dp))
            Text(
                text = "Gender",
                color = Color(0xFF26408B),
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp
            )
            OutlinedTextField(
                value = "",
                label = {Text("Choose your gender")},
                onValueChange = {}
            )
            Spacer(Modifier.height(30.dp))
            Text(
                text = "Date of birth",
                color = Color(0xFF26408B),
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp
            )
            OutlinedTextField(
                value = "",
                label = {Text("Enter your date of birth")},
                onValueChange = {}
            )
            Spacer(Modifier.height(30.dp))
            Row() {
                Text("You agree to receive information and notifications sent by MedCare")
            }
        }
    }
}
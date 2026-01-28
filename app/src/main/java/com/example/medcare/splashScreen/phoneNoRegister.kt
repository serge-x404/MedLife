package com.example.medcare.splashScreen

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
fun PhoneNumberRegister() {
    Scaffold {
        Column(
            modifier = Modifier
                .padding(it)
        ) {
            Text(
                text = "Phone No*",
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                color = Color(0xFF24608B)
            )
            OutlinedTextField(
                value = "",
                label = { Text("Enter Phone Number") },
                onValueChange = {})
            Spacer(Modifier.height(5.dp))
            Text(
                text = "Full Name",
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                color = Color(0xFF24608B)
            )
            OutlinedTextField(
                value = "",
                label = { Text("Enter your full name") },
                onValueChange = {})
            Spacer(Modifier.height(5.dp))
            Text(
                text = "Gender",
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                color = Color(0xFF24608B)
            )
            OutlinedTextField(
                value = "",
                label = { Text("Choose your gender") },
                onValueChange = {})
            Text(
                text = "Date of birth",
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                color = Color(0xFF24608B)
            )
            OutlinedTextField(
                value = "",
                label = { Text("Enter your date of birth") },
                onValueChange = {})
            Spacer(Modifier.height(50.dp))
            Row(horizontalArrangement = Arrangement.spacedBy(5.dp)) {
                Checkbox(
                    checked = false,
                    onCheckedChange = {},
                    modifier = Modifier.size(18.dp)
                )
                Text(
                    text = "You agree to receive information and notifications sent by MedCare",
                    fontSize = 15.sp,

                )
            }
            Spacer(Modifier.height(55.dp))
            Column(horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Bottom) {
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
                Text(
                    text = "Already have an account? Click here to login",
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}
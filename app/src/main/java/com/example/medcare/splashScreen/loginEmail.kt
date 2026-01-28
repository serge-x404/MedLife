package com.example.medcare.splashScreen

import androidx.compose.foundation.layout.Column
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
fun EmailLogin() {
    Scaffold() { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)) {
            Text(
                text = "Email",
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                color = Color(0xFF26408B)
            )
            OutlinedTextField(
                value = "",
                label = {Text("Enter your email")},
                onValueChange = {}
            )
            Spacer(Modifier.height(25.dp))
            Text(
                text = "Is there any issue with your email?",
                fontSize = 14.sp
            )
        }
    }
}
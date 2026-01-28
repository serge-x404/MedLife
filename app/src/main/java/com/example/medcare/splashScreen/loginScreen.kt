package com.example.medcare.splashScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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

@Preview(showBackground = true,
    showSystemUi = true)
@Composable
fun LoginScreen() {
    Box(modifier = Modifier
        .fillMaxSize()
        .padding(18.dp)) {
        Column() {
            IconButton(
                onClick = {
                    //
                }) {
                Icon(
                    imageVector = Icons.Default.KeyboardArrowLeft,
                    contentDescription = "Back Button"
                )
            }
            Spacer(Modifier.padding(top = 10.dp))
            Text(
                text = "Enter your phone number or email",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(start = 15.dp)
            )
            Spacer(Modifier.padding(12.dp))
            Box(
                Modifier
                    .background(Color(0xFF000000))
                    .size(500.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Work in progress",
                    color = Color(0xFFFFFFFF),
                    textAlign = TextAlign.Center
                )
            }
            Spacer(Modifier.padding(35.dp))
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
                Spacer(Modifier.padding(top = 4.dp))
                Text(
                    text = "Don't have a MedCare account? Sign up",
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}
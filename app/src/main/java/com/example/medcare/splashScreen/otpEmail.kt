package com.example.medcare.splashScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview(
    showBackground = true, showSystemUi = true
)
@Composable
fun OtpEmail() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(18.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(
                onClick = { },
            ) {
                Icon(
                    imageVector = Icons.Default.KeyboardArrowLeft,
                    contentDescription = "Back Button"
                )
            }
            Text(
                text = "Register",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
            )
        }
        Spacer(Modifier.padding(top = 80.dp))
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Enter the 4-digit verification code (OTP) sent to your email",
                fontSize = 16.sp,
                fontWeight = FontWeight.Normal,
                textAlign = TextAlign.Center,
            )
            Spacer(Modifier.padding(10.dp))
            Text(
                text = "info@gmail.com",
                color = Color(0xFF26408B),
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp
            )
            Spacer(Modifier.padding(20.dp))
            Row(horizontalArrangement = Arrangement.spacedBy(20.dp)) {
                Surface(
                    shape = RectangleShape,
                    modifier = Modifier.size(50.dp)
                        .border(width = 2.dp, color = Color(0xFFa6CFDF))
                        .background(Color(0xFFFFFFFF))
                ) { }
                Surface(
                    shape = RectangleShape,
                    modifier = Modifier.size(50.dp)
                        .border(width = 2.dp, color = Color(0xFFa6CFDF))
                        .background(Color(0xFFFFFFFF))
                ) { }
                Surface(
                    shape = RectangleShape,
                    modifier = Modifier.size(50.dp)
                        .border(width = 2.dp, color = Color(0xFFa6CFDF))
                        .background(Color(0xFFFFFFFF))
                ) { }
                Surface(
                    shape = RectangleShape,
                    modifier = Modifier.size(50.dp)
                        .border(width = 2.dp, color = Color(0xFFa6CFDF))
                        .background(Color(0xFFFFFFFF))
                ) { }
            }
            Spacer(Modifier.padding(30.dp))
            Button(
                onClick = {},
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF26408B)),
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "Continue"
                )
            }
            Spacer(Modifier.padding(4.dp))
            Text(
                text = "Resend in 60 seconds",
                fontSize = 16.sp
            )
        }
    }
}


@Composable
fun OtpBox() {
    repeat(4) {
        Surface(
            shape = RectangleShape,
            modifier = Modifier.size(12.dp)
        ) { }
    }
}
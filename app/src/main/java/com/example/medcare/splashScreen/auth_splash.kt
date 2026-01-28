package com.example.medcare.splashScreen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.medcare.R


@Preview(
    showBackground = true, showSystemUi = true
)
@Composable
fun authsplash() {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Button(
            onClick = {},
            colors = ButtonDefaults.buttonColors(Color(0xFFFFFFFF)),
            border = BorderStroke(width = 1.dp, color = Color(0xFFC2E7D9)),
            modifier = Modifier.padding(start = 250.dp, top = 5.dp)
        ) {
            Text(
                text = "English", color = Color(0xFF000000)
            )
        }
        val image = painterResource(R.drawable.medcare_auth)

        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = image, contentDescription = null, Modifier.size(250.dp)
            )
            Text(
                text = "We're here to keep you healthy",
                fontSize = 16.sp,
                textAlign = TextAlign.Center,
            )
        }
        Column(
            verticalArrangement = Arrangement.spacedBy(4.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(start = 10.dp, end = 10.dp)
        ) {
            Button(
                onClick = {
                    //
                },
                colors = ButtonDefaults.buttonColors(Color(0xFF26408B)),
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "Next"
                )
            }
            Button(
                onClick = {
                    //
                },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFFFFFF)),
                border = BorderStroke(width = 1.dp, Color(0xFF26408B)),
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "Register", color = Color(0xFF000000)
                )
            }
        }
    }
}

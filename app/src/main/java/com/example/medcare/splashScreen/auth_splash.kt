package com.example.medcare.splashScreen

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
    Box(modifier = Modifier.fillMaxWidth()
        .padding(25.dp)) {
        Button(
            onClick = {},
            colors = ButtonDefaults.buttonColors(Color(0xFFFFFFFF)),
            border = BorderStroke(width = 1.dp, color = Color(0xFFC2E7D9)),
            modifier = Modifier.align(Alignment.TopEnd)
        ) {
            Text(
                text = "English", color = Color.Black
            )
        }
    }
    Column(
        modifier = Modifier
            .padding(horizontal = 16.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom
    ) {
        Image(
            painter = painterResource(R.drawable.medcare_auth),
            contentDescription = null, Modifier.size(250.dp)
        )
        Text(
            text = "We're here to keep you healthy",
            fontSize = 16.sp,
            textAlign = TextAlign.Center,
        )
        Spacer(Modifier.height(150.dp))
        Column(Modifier.padding(vertical = 40.dp)) {
            Button(
                onClick = {
                    Log.d("NEXT BTN","next button")
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
                    Log.i("MYTAG", "clicked")
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

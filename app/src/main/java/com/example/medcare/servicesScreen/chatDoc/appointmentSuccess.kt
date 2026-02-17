package com.example.medcare.servicesScreen.chatDoc

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.medcare.R

@Preview(showBackground = true,
    showSystemUi = true)
@Composable
fun AppointmentSuccess(
    navigateToHistory: () -> Unit
) {
    Column(horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(R.drawable.calendar),
            contentDescription = null,
            modifier = Modifier.size(150.dp)
        )
        Spacer(Modifier.height(16.dp))
        Text(
            text = "Appointments have been made",
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold
        )
        Spacer(Modifier.height(20.dp))
        Text(
            text = "Prepare your attendance well, arrive 30\n" +
                    "minutes before the appointed time",
            textAlign = TextAlign.Center,
            maxLines = 2,
            color = Color(0xFF4D4D4D)
        )
        Spacer(Modifier.height(20.dp))
        Button(onClick = navigateToHistory,
            colors = ButtonDefaults.buttonColors(containerColor = Color.White),
            border = BorderStroke(width = 1.dp, color = Color(0xFFA6CFD5)),
            modifier = Modifier.fillMaxWidth()
                .padding(horizontal = 80.dp)
        ) {
            Text(
                text = "Go to details",
                color = Color(0xFF26408B)
            )
        }
    }
}
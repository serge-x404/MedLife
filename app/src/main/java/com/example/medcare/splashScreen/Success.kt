package com.example.medcare.splashScreen

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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.medcare.R

@Preview(
    showBackground = true, showSystemUi = true
)
@Composable
fun SuccessPage() {
    Box(Modifier.fillMaxSize()) {
        Column(horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.align(Alignment.Center)) {
            val image = painterResource(R.drawable.success_icon)
            Image(
                painter = image, contentDescription = null, modifier = Modifier.size(160.dp)
            )
            Spacer(Modifier.height(50.dp))
            Text(
                text = "Verification success",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
            )
            Spacer(Modifier.height(15.dp))
            Text(
                text = "Congratulations, your account has been verified"
            )
        }
        Button(
            onClick = {},
            colors = ButtonDefaults.buttonColors(Color(0xFF26408B)),
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp)
                .align(Alignment.BottomCenter)
        ) {
            Text(
                text = "Continue"
            )
        }
    }
}
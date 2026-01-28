package com.example.medcare.splashScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun walkthrough(onBoardingPage: OnBoardingPage) {
    Column(
        modifier = Modifier
            .background(Color(0xFFFFFFFF))
            .fillMaxSize()
    ) {
        val image = painterResource(onBoardingPage.image)
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(12.dp)
        ) {
            Image(
                painter = image,
                contentDescription = null,
                Modifier
                    .size(height = 400.dp, width = 300.dp)
                    .padding(top = 50.dp)
            )
            Spacer(Modifier.padding(10.dp))
            Text(
                text = onBoardingPage.title,
                fontSize = 20.sp,
                fontWeight = FontWeight.SemiBold,
                fontFamily = FontFamily.Serif,
            )
            Spacer(Modifier.padding(10.dp))
            Text(
                text = onBoardingPage.description,
                fontSize = 16.sp,
                fontWeight = FontWeight.Normal,
                textAlign = TextAlign.Center
            )

        }
    }
}

@Composable
fun dotIndiactor(current: Int) {
    Row {
        repeat(3) { index ->
            val isSelected = if (current == index) Color(0xFF26408B)
            else Color(0xFFC2E7D9)
            Surface(
                color = isSelected,
                modifier = Modifier
                    .size(20.dp)
                    .padding(4.dp),
                shape = CircleShape
            ) { }
        }
    }
}
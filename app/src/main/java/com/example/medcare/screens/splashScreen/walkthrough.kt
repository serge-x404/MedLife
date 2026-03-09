package com.example.medcare.screens.splashScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
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
fun walkthrough(onBoardingPage: com.example.medcare.screens.splashScreen.OnBoardingPage) {
    Column(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.surfaceContainerHighest)
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
            Spacer(Modifier.height(8.dp))
            Text(
                text = onBoardingPage.title,
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.onBackground
            )
            Spacer(Modifier.height(10.dp))
            Text(
                text = onBoardingPage.description,
                style = MaterialTheme.typography.labelLarge,
                color = MaterialTheme.colorScheme.onBackground,
                textAlign = TextAlign.Center
            )

        }
    }
}

@Composable
fun dotIndiactor(current: Int) {
    Row {
        repeat(3) { index ->
            val isSelected = if (current == index) MaterialTheme.colorScheme.secondary
            else MaterialTheme.colorScheme.primary
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
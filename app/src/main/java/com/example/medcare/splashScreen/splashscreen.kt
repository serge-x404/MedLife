package com.example.medcare.splashScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.medcare.R
import kotlinx.coroutines.delay

@Preview(showBackground = true,
    showSystemUi = true)
@Composable
fun splashscreen(
    navigateToHome: () -> Unit,
    navigateToOnBoard: () -> Unit
) {

    LaunchedEffect(Unit) {
        delay(1000)
        navigateToHome()
    }

    Box(modifier = Modifier.background(Color(0xFF26408B))
        .fillMaxSize()) {
        val image = painterResource(R.drawable.medcare)
        Image(
            painter = image,
            contentDescription = null,
            Modifier.size(250.dp)
                .align(Alignment.Center)
        )
    }
}
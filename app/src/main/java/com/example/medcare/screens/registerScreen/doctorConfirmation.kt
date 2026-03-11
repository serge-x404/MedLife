package com.example.medcare.screens.registerScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay

@Composable
fun DoctorConfirmation(
    navigateToLoginScreen: () -> Unit
) {

    var countdown by remember { mutableIntStateOf(5) }

    LaunchedEffect(Unit) {
        while (countdown > 0) {
            delay(1000L)
            countdown--
        }
        navigateToLoginScreen()
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.surfaceContainerHighest),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Spacer(Modifier.height(40.dp))
        Text(
            "Registered successfully",
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.onBackground
        )
        Text(
            "You'll be able to login once you are verified",
            style = MaterialTheme.typography.titleSmall,
            color = MaterialTheme.colorScheme.onBackground

        )
        Spacer(Modifier.height(20.dp))
        Text(
            "Redirecting you to login in $countdown seconds",
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.onBackground
        )
        Box(contentAlignment = Alignment.Center) {
//            CircularProgressIndicator(
//                progress = { countdown / 5f },
//                modifier = Modifier.size(80.dp),
//                strokeWidth = 6.dp,
//                color = MaterialTheme.colorScheme.secondary
//            )
//            Text(
//                text = "$countdown",
//                style = MaterialTheme.typography.titleMedium,
//                color = MaterialTheme.colorScheme.onBackground
//            )
        }
    }
}
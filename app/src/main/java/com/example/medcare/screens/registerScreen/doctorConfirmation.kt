package com.example.medcare.screens.registerScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun DoctorConfirmation() {
    Column(modifier = Modifier
        .fillMaxSize()
        .background(MaterialTheme.colorScheme.surfaceContainerHighest),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        LinearProgressIndicator()
        Spacer(Modifier.height(40.dp))
        Text(
            "Hold on!",
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.onBackground
        )
        Text(
            "Your documents are being verified",
            style = MaterialTheme.typography.titleSmall,
            color = MaterialTheme.colorScheme.onBackground

        )
    }
}
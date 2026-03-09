package com.example.medcare.screens.homeScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.medcare.rtdb.RTDB

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DoctorHomeScreen() {
    var doctorName by remember { mutableStateOf("") }
    val rtdb = RTDB()
    LaunchedEffect(Unit) {
        rtdb.FetchDoctorInfo { it ->
            doctorName = it
        }
    }
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(
                    "Hey $doctorName",
                    style = MaterialTheme.typography.headlineLarge,
                    color = MaterialTheme.colorScheme.onBackground
                ) },
                colors = TopAppBarDefaults.topAppBarColors(MaterialTheme.colorScheme.surfaceContainerHighest)
            )
        }
    ) {
        Modifier.padding(it)
        Column(modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.surfaceContainerHighest)
        ) {
            Text(
                "Chats",
                color = MaterialTheme.colorScheme.onBackground,
                style = MaterialTheme.typography.displayLarge
            )
        }
    }
}
package com.example.medcare.history

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun StaticHistoryPage() {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "History",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )
                },
                navigationIcon = {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft,
                        contentDescription = null
                    )
                }
            )
        }
    ) { innerPadding ->
        Column(Modifier.padding(innerPadding)) {
            UpcomingAppointment()
        }
    }
}
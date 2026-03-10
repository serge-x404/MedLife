package com.example.medcare.screens.history

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

enum class HistoryTabs { UPCOMING, COMPLETED }


@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HistoryScreen(
    navigateToChatDoc: () -> Unit
) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "History",
                        style = MaterialTheme.typography.titleMedium,
                        color = MaterialTheme.colorScheme.onBackground
                    )
                },
//                navigationIcon = {
//                    IconButton(
//                        onClick = back
//                    ) {
//                        Icon(
//                            imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft,
//                            contentDescription = null,
//                            tint = MaterialTheme.colorScheme.onBackground
//                        )
//                    }
//                }
            )
        }
    ) { it ->
        Column(Modifier.padding(it)) {
            HistoryLogic(navigateToChatDoc)
        }
    }
}
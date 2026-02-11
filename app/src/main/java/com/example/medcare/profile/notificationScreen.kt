package com.example.medcare.profile

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.medcare.class_objects.notification

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true,
    showSystemUi = true)
@Composable
fun NotificationScreen(
    back: () -> Unit,
    navigateToClearNotifications: () -> Unit
) {
    Scaffold(
        topBar = { CenterAlignedTopAppBar(
            title = { Text("Notifications",
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold
            ) },
            navigationIcon = {
                IconButton(onClick = back) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft,
                        contentDescription = null
                    )
                }
            }
        ) }
    ) { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)) {
            LazyColumn(modifier = Modifier.padding(horizontal = 12.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)) {
                items(notification.data) {
                    item -> NotificationLayout(item)
                }
            }
            Spacer(Modifier.height(60.dp))
            Button(
                onClick = {navigateToClearNotifications()},
                modifier = Modifier.align(Alignment.CenterHorizontally),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF26408B))
            ) {
                Text("Clear All")
            }
        }
    }
}
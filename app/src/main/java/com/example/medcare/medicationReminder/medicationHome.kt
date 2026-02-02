package com.example.medcare.medicationReminder

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.medcare.R

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showSystemUi = true,
    showBackground = true)
@Composable
fun MedicationHome() {
    Scaffold(
        topBar = { CenterAlignedTopAppBar(
            title = { Text("Medication Reminder",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold) },
            navigationIcon = { Icon(
                imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft,
                contentDescription = null
            ) }
        ) }
    ) { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)) {
            Box(modifier = Modifier.fillMaxSize()
                .padding(horizontal = 12.dp)) {
                Column {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(
                            "Reminder to take medicine",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = Color(0xFF4D4D4D),
                            modifier = Modifier.weight(1f)
                        )
                        Text(
                            "Some text",
                            color = Color(0xFF26408B)
                        )
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                            contentDescription = null,
                            tint = Color(0xFF26408B)
                        )
                    }
                    Spacer(Modifier.height(12.dp))
                    Column(
                        modifier = Modifier.fillMaxWidth()
                            .padding(horizontal = 8.dp)
                            .border(width = 1.dp, color = Color(0xFFC2E7D9)),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Spacer(Modifier.height(40.dp))
                        Image(
                            painter = painterResource(R.drawable.medication),
                            contentDescription = null,
                            modifier = Modifier.size(160.dp)
                        )
                        Text(
                            "Manage your medication",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.SemiBold
                        )
                        Spacer(Modifier.height(6.dp))
                        Text(
                            "Add the medicine you are taking and create a reminder to take the medicine",
                            fontSize = 16.sp,
                            color = Color(0xFF4D4D4D),
                            textAlign = TextAlign.Center
                        )
                    }
                    Spacer(Modifier.height(20.dp))
                    Text(
                        "History of Taking Medication",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = Color(0xFF4D4D4D)
                    )
                    Spacer(Modifier.height(12.dp))
                    Column(
                        modifier = Modifier.fillMaxWidth()
                            .padding(horizontal = 8.dp)
                            .border(width = 1.dp, color = Color(0xFFC2E7D9)),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Spacer(Modifier.height(40.dp))
                        Image(
                            painter = painterResource(R.drawable.medication),
                            contentDescription = null,
                            modifier = Modifier.size(160.dp)
                        )
                        Text(
                            "View your medication history",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.SemiBold
                        )
                        Spacer(Modifier.height(6.dp))
                        Text(
                            "Add the medicine you are taking and create a reminder to take the medicine",
                            fontSize = 16.sp,
                            color = Color(0xFF4D4D4D),
                            textAlign = TextAlign.Center
                        )
                    }
                }
                Button(
                    onClick = {},
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF26408B)),
                    modifier = Modifier.fillMaxWidth()
                        .align(Alignment.BottomCenter)
                ) {
                    Text("Add Medicine",
                        fontWeight = FontWeight.SemiBold)
                }
            }
        }
    }
}
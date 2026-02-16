package com.example.medcare.profile

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true,
    showSystemUi = true)
@Composable
fun PrescriptionHistory(
    back: () -> Unit
) {
    Scaffold(
        topBar = { CenterAlignedTopAppBar(
            title = { Text("Prescription History",
                fontWeight = FontWeight.SemiBold,
                fontSize = 16.sp
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
            Column(modifier = Modifier.fillMaxSize()
                .padding(horizontal = 12.dp)
                .verticalScroll(rememberScrollState())) {
                Row(modifier = Modifier.fillMaxWidth()
                    .border(1.dp, color = Color(0xFFE3E3E3))
                    .padding(12.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text("Active Recipe",
                        color = Color(0xFF26408B),
                        modifier = Modifier.weight(1f)
                    )
                    Icon(
                        imageVector = Icons.Default.KeyboardArrowDown,
                        contentDescription = null,
                        tint = Color(0xFF26408B)
                    )
                }
                Spacer(Modifier.height(30.dp))
                Card(colors = CardDefaults.cardColors(containerColor = Color(0xFFE3E3E3))) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Row(modifier = Modifier.fillMaxWidth()
                            .background(Color(0xFF26408B))
                            .padding(15.dp)) {
                            Text("Doctor's Name:",
                                color = Color.White
                            )
                            Text("Dr. Emily Smith, MD",
                                color = Color.White,
                                fontWeight = FontWeight.SemiBold
                            )
                        }
                        Column(modifier = Modifier.fillMaxWidth()
                            .background(Color.White)
                            .padding(15.dp)) {
                            Text("Paracetamol 500 mg",
                                fontSize = 16.sp,
                                fontWeight = FontWeight.SemiBold
                            )
                            Spacer(Modifier.height(6.dp))
                            Text("Take 1 tablet every 6 hours as needed to reduce fever or pain.",
                                fontWeight = FontWeight.Normal,
                                color = Color(0xFF4D4D4D)
                            )
                        }
                        HorizontalDivider()
                        Column(modifier = Modifier.fillMaxWidth()
                            .background(Color.White)
                            .padding(15.dp)) {
                            Text("Amoxicillin 500 mg",
                                fontSize = 16.sp,
                                fontWeight = FontWeight.SemiBold
                            )
                            Spacer(Modifier.height(6.dp))
                            Text("Take 1 tablet every 8 hours for 7 days to treat bacterial infection.",
                                fontWeight = FontWeight.Normal,
                                color = Color(0xFF4D4D4D)
                            )
                        }
                        HorizontalDivider()
                        Column(modifier = Modifier.fillMaxWidth()
                            .background(Color.White)
                            .padding(15.dp)) {
                            Text("Omeprazole 20 mg",
                                fontSize = 16.sp,
                                fontWeight = FontWeight.SemiBold
                            )
                            Spacer(Modifier.height(6.dp))
                            Text("Take 1 tablet every morning before eating to reduce stomach acid production.",
                                fontWeight = FontWeight.Normal,
                                color = Color(0xFF4D4D4D)
                            )
                        }
                        Text("12 Jan 2026 - 20 Jan 2026",
                            color = Color(0xFF8F8F8F)
                        )
                    }
                }
                Spacer(Modifier.height(30.dp))
                Card(colors = CardDefaults.cardColors(containerColor = Color(0xFFE3E3E3))) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Row(modifier = Modifier.fillMaxWidth()
                            .background(Color(0xFF26408B))
                            .padding(15.dp)) {
                            Text("Doctor's Name:",
                                color = Color.White
                            )
                            Text("Dr. Emily Smith, MD",
                                color = Color.White,
                                fontWeight = FontWeight.SemiBold
                            )
                        }
                        Column(modifier = Modifier.fillMaxWidth()
                            .background(Color.White)
                            .padding(15.dp)) {
                            Text("Paracetamol 500 mg",
                                fontSize = 16.sp,
                                fontWeight = FontWeight.SemiBold
                            )
                            Spacer(Modifier.height(6.dp))
                            Text("Take 1 tablet every 6 hours as needed to reduce fever or pain.",
                                fontWeight = FontWeight.Normal,
                                color = Color(0xFF4D4D4D)
                            )
                        }
                        HorizontalDivider()
                        Column(modifier = Modifier.fillMaxWidth()
                            .background(Color.White)
                            .padding(15.dp)) {
                            Text("Amoxicillin 500 mg",
                                fontSize = 16.sp,
                                fontWeight = FontWeight.SemiBold
                            )
                            Spacer(Modifier.height(6.dp))
                            Text("Take 1 tablet every 8 hours for 7 days to treat bacterial infection.",
                                fontWeight = FontWeight.Normal,
                                color = Color(0xFF4D4D4D)
                            )
                        }
                        HorizontalDivider()
                        Column(modifier = Modifier.fillMaxWidth()
                            .background(Color.White)
                            .padding(15.dp)) {
                            Text("Omeprazole 20 mg",
                                fontSize = 16.sp,
                                fontWeight = FontWeight.SemiBold
                            )
                            Spacer(Modifier.height(6.dp))
                            Text("Take 1 tablet every morning before eating to reduce stomach acid production.",
                                fontWeight = FontWeight.Normal,
                                color = Color(0xFF4D4D4D)
                            )
                        }
                        Text("12 Jan 2026 - 20 Jan 2026",
                            color = Color(0xFF8F8F8F)
                        )
                    }
                }
            }
        }
    }
}
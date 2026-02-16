package com.example.medcare.profile

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun HealthHistory(
    back: () -> Unit
) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        "Health History",
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 16.sp
                    )
                },
                navigationIcon = {
                    IconButton(onClick = back) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft,
                            contentDescription = null
                        )
                    }
                }
            )
        }
    ) { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 12.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .border(1.dp, color = Color(0xFFC2E7D9))
                        .padding(12.dp)
                ) {
                    Text(
                        "Disease History",
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
                Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        colors = CardDefaults.cardColors(containerColor = Color.Black)
                    ) {
                        Column(
                            modifier = Modifier
                                .padding(12.dp)
                                .fillMaxWidth()
                        ) {
                            AssistChip(
                                onClick = {},
                                label = { Text("Disease History") },
                                modifier = Modifier.align(Alignment.End),
                                colors = AssistChipDefaults.assistChipColors(
                                    Color(0xFF4D4D4D),
                                    Color.White
                                )
                            )
                            Text(
                                "Diagnosis: December 12, 2025",
                                color = Color(0xFF8F8F8F)
                            )
                            Spacer(Modifier.height(4.dp))
                            Text(
                                "Check Details",
                                color = Color(0xFF26408B),
                                textDecoration = TextDecoration.Underline
                            )
                        }
                    }
                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        colors = CardDefaults.cardColors(containerColor = Color.Black)
                    ) {
                        Column(
                            modifier = Modifier
                                .padding(12.dp)
                                .fillMaxWidth()
                        ) {
                            AssistChip(
                                onClick = {},
                                label = { Text("Disease History") },
                                modifier = Modifier.align(Alignment.End),
                                colors = AssistChipDefaults.assistChipColors(
                                    Color(0xFF4D4D4D),
                                    Color.White
                                )
                            )
                            Text(
                                "Diagnosis: January 16, 2026",
                                color = Color(0xFF8F8F8F)
                            )
                            Spacer(Modifier.height(4.dp))
                            Text(
                                "Check Details",
                                color = Color(0xFF26408B),
                                textDecoration = TextDecoration.Underline
                            )
                        }
                    }
                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        colors = CardDefaults.cardColors(containerColor = Color.Black)
                    ) {
                        Column(
                            modifier = Modifier
                                .padding(12.dp)
                                .fillMaxWidth()
                        ) {
                            AssistChip(
                                onClick = {},
                                label = { Text("Allergy History") },
                                modifier = Modifier.align(Alignment.End),
                                colors = AssistChipDefaults.assistChipColors(
                                    Color(0xFF4D4D4D),
                                    Color.White
                                )
                            )
                            Text(
                                "Severity: Severe, Precautions\n" +
                                        "Avoid foods containing nuts",
                                color = Color(0xFF8F8F8F),
                                lineHeight = 30.sp
                            )
                            Spacer(Modifier.height(4.dp))
                            Text(
                                "Check Details",
                                color = Color(0xFF26408B),
                                textDecoration = TextDecoration.Underline
                            )
                        }
                    }
                }
            }
        }
    }
}
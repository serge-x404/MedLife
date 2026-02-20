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
import androidx.compose.material3.MaterialTheme
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
@Composable
fun PrescriptionHistory(
    back: () -> Unit
) {
    Scaffold(
        topBar = { CenterAlignedTopAppBar(
            title = { Text(
                "Prescription History",
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.onBackground
            ) },
            navigationIcon = {
                IconButton(onClick = back) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.onBackground
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
                    .border(2.dp, color = MaterialTheme.colorScheme.outlineVariant)
                    .padding(12.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        "Active Recipe",
                        style = MaterialTheme.typography.labelLarge,
                        color = MaterialTheme.colorScheme.onBackground,
                        modifier = Modifier.weight(1f)
                    )
                    Icon(
                        imageVector = Icons.Default.KeyboardArrowDown,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.onBackground
                    )
                }
                Spacer(Modifier.height(30.dp))
                Card(colors = CardDefaults.cardColors(MaterialTheme.colorScheme.surfaceContainerHighest)) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Row(modifier = Modifier.fillMaxWidth()
                            .background(MaterialTheme.colorScheme.tertiaryContainer)
                            .padding(15.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text("Doctor's Name:",
                                style = MaterialTheme.typography.titleSmall,
                                color = MaterialTheme.colorScheme.onBackground
                            )
                            Text("Dr. Emily Smith, MD",
                                style = MaterialTheme.typography.titleMedium,
                                color = MaterialTheme.colorScheme.onBackground
                            )
                        }
                        Column(modifier = Modifier.fillMaxWidth()
                            .background(Color.White)
                            .padding(15.dp)) {
                            Text(
                                "Paracetamol 500 mg",
                                style = MaterialTheme.typography.titleMedium,
                                color = MaterialTheme.colorScheme.onBackground
                            )
                            Spacer(Modifier.height(6.dp))
                            Text(
                                "Take 1 tablet every 6 hours as needed to reduce fever or pain.",
                                style = MaterialTheme.typography.titleSmall,
                                color = MaterialTheme.colorScheme.onBackground
                            )
                        }
                        HorizontalDivider()
                        Column(modifier = Modifier.fillMaxWidth()
                            .background(Color.White)
                            .padding(15.dp)) {
                            Text("Amoxicillin 500 mg",
                                style = MaterialTheme.typography.titleMedium,
                                color = MaterialTheme.colorScheme.onBackground
                            )
                            Spacer(Modifier.height(6.dp))
                            Text(
                                "Take 1 tablet every 8 hours for 7 days to treat bacterial infection.",
                                style = MaterialTheme.typography.titleSmall,
                                color = MaterialTheme.colorScheme.onBackground
                            )
                        }
                        HorizontalDivider()
                        Column(modifier = Modifier.fillMaxWidth()
                            .background(Color.White)
                            .padding(15.dp)) {
                            Text(
                                "Omeprazole 20 mg",
                                style = MaterialTheme.typography.titleMedium,
                                color = MaterialTheme.colorScheme.onBackground
                            )
                            Spacer(Modifier.height(6.dp))
                            Text(
                                "Take 1 tablet every morning before eating to reduce stomach acid production.",
                                style = MaterialTheme.typography.titleMedium,
                                color = MaterialTheme.colorScheme.onBackground
                            )
                        }
                        Text(
                            "12 Jan 2026 - 20 Jan 2026",
                            style = MaterialTheme.typography.labelSmall,
                            color = MaterialTheme.colorScheme.onBackground,
                            modifier = Modifier.padding(vertical = 4.dp)
                        )
                    }
                }
                Spacer(Modifier.height(30.dp))
                Card(colors = CardDefaults.cardColors(MaterialTheme.colorScheme.surfaceContainerHighest)) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Row(modifier = Modifier.fillMaxWidth()
                            .background(MaterialTheme.colorScheme.tertiaryContainer)
                            .padding(15.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text("Doctor's Name:",
                                style = MaterialTheme.typography.titleSmall,
                                color = MaterialTheme.colorScheme.onBackground
                            )
                            Text("Dr. Emily Smith, MD",
                                style = MaterialTheme.typography.titleMedium,
                                color = MaterialTheme.colorScheme.onBackground
                            )
                        }
                        Column(modifier = Modifier.fillMaxWidth()
                            .background(Color.White)
                            .padding(15.dp)) {
                            Text(
                                "Paracetamol 500 mg",
                                style = MaterialTheme.typography.titleMedium,
                                color = MaterialTheme.colorScheme.onBackground
                            )
                            Spacer(Modifier.height(6.dp))
                            Text(
                                "Take 1 tablet every 6 hours as needed to reduce fever or pain.",
                                style = MaterialTheme.typography.titleSmall,
                                color = MaterialTheme.colorScheme.onBackground
                            )
                        }
                        HorizontalDivider()
                        Column(modifier = Modifier.fillMaxWidth()
                            .background(Color.White)
                            .padding(15.dp)) {
                            Text("Amoxicillin 500 mg",
                                style = MaterialTheme.typography.titleMedium,
                                color = MaterialTheme.colorScheme.onBackground
                            )
                            Spacer(Modifier.height(6.dp))
                            Text(
                                "Take 1 tablet every 8 hours for 7 days to treat bacterial infection.",
                                style = MaterialTheme.typography.titleSmall,
                                color = MaterialTheme.colorScheme.onBackground
                            )
                        }
                        HorizontalDivider()
                        Column(modifier = Modifier.fillMaxWidth()
                            .background(Color.White)
                            .padding(15.dp)) {
                            Text(
                                "Omeprazole 20 mg",
                                style = MaterialTheme.typography.titleMedium,
                                color = MaterialTheme.colorScheme.onBackground
                            )
                            Spacer(Modifier.height(6.dp))
                            Text(
                                "Take 1 tablet every morning before eating to reduce stomach acid production.",
                                style = MaterialTheme.typography.titleMedium,
                                color = MaterialTheme.colorScheme.onBackground
                            )
                        }
                        Text(
                            "12 Jan 2026 - 20 Jan 2026",
                            style = MaterialTheme.typography.labelSmall,
                            color = MaterialTheme.colorScheme.onBackground,
                            modifier = Modifier.padding(vertical = 4.dp)
                        )
                    }
                }
            }
        }
    }
}
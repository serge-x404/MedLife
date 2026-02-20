package com.example.medcare.article

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material3.AssistChip
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.medcare.R
import com.example.medcare.ui.theme.Khula

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DisplayArticle(
    back: () -> Unit
) {
    Scaffold(
        topBar = { CenterAlignedTopAppBar(
            title = {""},
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
            Column(modifier = Modifier
                .padding(horizontal = 12.dp)
                .verticalScroll(rememberScrollState())) {
                Text(
                    "Getting to know Hanta Virus Disease from Rodents",
                    style = MaterialTheme.typography.headlineSmall,
                    fontWeight = FontWeight.SemiBold
                )
                Spacer(Modifier.height(8.dp))
                Text(
                    "Written by Lonard on January 19, 2026",
                    style = MaterialTheme.typography.bodyMedium
                )
                Spacer(Modifier.height(6.dp))
                Image(
                    painter = painterResource(R.drawable.bigvirus),
                    contentDescription = null,
                    modifier = Modifier.fillMaxWidth(),
                    contentScale = ContentScale.FillWidth
                )
                Spacer(Modifier.height(16.dp))
                Text("Title: Understanding Hanta Virus Disease: " +
                        "Risks, Symptoms, and Prevention Measures from Rodents",
                    style = MaterialTheme.typography.labelLarge,
                    color = MaterialTheme.colorScheme.onBackground
                )
                Spacer(Modifier.height(16.dp))
                Text("Introduction:",
                    style = MaterialTheme.typography.labelLarge,
                    color = MaterialTheme.colorScheme.onBackground
                )
                Spacer(Modifier.height(4.dp))
                Text("Hanta virus disease, transmitted primarily through contact with rodent urine, " +
                        "droppings, or saliva, poses a significant health threat to humans worldwide. " +
                        "This article aims to provide an overview of Hanta virus disease, its potential risks, common symptoms, and essential prevention measures.",
                    style = MaterialTheme.typography.labelMedium,
                    color = MaterialTheme.colorScheme.onBackground
                )
                Spacer(Modifier.height(16.dp))
                Text("What is Hanta virus?",
                    style = MaterialTheme.typography.labelLarge,
                    color = MaterialTheme.colorScheme.onBackground
                )
                Spacer(Modifier.height(4.dp))
                Text("Hanta virus disease is a rare but potentially deadly viral infection caused by several strains of hantaviruses. " +
                        "These viruses are typically carried by rodents, such as mice, rats, and voles, and can be transmitted to humans through inhalation of airborne particles contaminated with rodent excreta.",
                    style = MaterialTheme.typography.labelMedium,
                    color = MaterialTheme.colorScheme.onBackground
                )
                Spacer(Modifier.height(16.dp))
                Text("Understanding the risk:",
                    style = MaterialTheme.typography.labelLarge,
                    color = MaterialTheme.colorScheme.onBackground
                )
                Spacer(Modifier.height(4.dp))
                Text("Individuals who live or work in areas with high rodent populations, " +
                        "such as rural or semi-rural environments, are at an increased risk of contracting Hanta virus disease. " +
                        "Activities that involve disturbing rodent habitats, such as cleaning barns, sheds, or attics, can also elevate the risk of exposure",
                    style = MaterialTheme.typography.labelMedium,
                    color = MaterialTheme.colorScheme.onBackground
                )
                Spacer(Modifier.height(16.dp))
                Text("Common Symptoms:",
                    style = MaterialTheme.typography.labelLarge,
                    color = MaterialTheme.colorScheme.onBackground
                )
                Spacer(Modifier.height(4.dp))
                Text("The symptoms of Hanta virus disease can vary widely but often include flu-like symptoms such as fever, muscle aches, headaches, and fatigue. " +
                        "As the disease progresses, individuals may experience respiratory symptoms such as coughing and shortness of breath, which can rapidly escalate to severe respiratory distress and potentially fatal complications.",
                    style = MaterialTheme.typography.labelMedium,
                    color = MaterialTheme.colorScheme.onBackground
                )
                Spacer(Modifier.height(16.dp))
                Column {
                    Text(
                        "Tags:",
                        style = MaterialTheme.typography.labelLarge,
                        color = MaterialTheme.colorScheme.onBackground
                    )
                    Row {
                        AssistChip(
                            onClick = {},
                            label = {
                                Text(
                                    "Content-healthy",
                                    style = MaterialTheme.typography.labelMedium,
                                    color = MaterialTheme.colorScheme.onBackground
                                )
                            },
                            modifier = Modifier.weight(1f)
                        )
                        AssistChip(
                            onClick = {},
                            label = {
                                Text(
                                    "Healthcare",
                                    style = MaterialTheme.typography.labelMedium,
                                    color = MaterialTheme.colorScheme.onBackground
                                )
                            },
                            modifier = Modifier.weight(1f)
                        )
                        AssistChip(
                            onClick = {},
                            label = {
                                Text(
                                    "Healthy-environment",
                                    style = MaterialTheme.typography.labelMedium,
                                    color = MaterialTheme.colorScheme.onBackground
                                )
                            },
                            modifier = Modifier.weight(1f)
                        )
                    }
                }
            }
        }
    }
}
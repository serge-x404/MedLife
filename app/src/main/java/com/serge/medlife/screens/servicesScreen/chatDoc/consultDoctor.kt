package com.serge.medlife.screens.servicesScreen.chatDoc

import android.net.Uri
import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.serge.medlife.R
import com.serge.medlife.rtdb.DoctorDetailsDTO
import com.serge.medlife.rtdb.RTDB

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ConsultDoctorScreen(
    category: String = "All",
    back: () -> Unit,
    navigateToDocDtls: (String, String, String) -> Unit
) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text(
                    text = category,
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.onBackground
                ) },
                navigationIcon = { IconButton(onClick = back) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.onBackground
                    )
                } }
            )
        }
    ) { innerPadding ->
        Column(modifier = Modifier
            .padding(innerPadding)
            .padding(horizontal = 12.dp)
        ) {
            val rtdb = RTDB()
            var doctorList by remember { mutableStateOf(emptyList<DoctorDetailsDTO>()) }
            var isLoading by remember { mutableStateOf(true) }

            LaunchedEffect(Unit) {
                rtdb.fetchDoctorInfo {
                    doctorList = it
                    isLoading = false
                }
            }

            val filteredList = if (category == "All" || category.isEmpty()) doctorList
            else doctorList.filter { it.doctorSpecialization == category }

            Log.d("Filter", "Category: $category")
            Log.d("Filter", "DoctorList size: ${doctorList.size}")
            Log.d("Filter", "FilteredList size: ${filteredList.size}")

            if (isLoading) {
                Column(
                    modifier = Modifier
                        .fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    CircularProgressIndicator(
                        color = MaterialTheme.colorScheme.primary
                    )
                }
            }  else {
                LazyVerticalGrid(
                    columns = GridCells.Fixed(1),
                    modifier = Modifier
                        .padding(start = 8.dp, end = 8.dp)
                        .height((filteredList.size * 102).dp),
                    verticalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    items(filteredList) {
                        Card(
                            onClick = {
                                val docName = Uri.encode(it.doctorUserName)
                                val docSpeciality = Uri.encode(it.doctorSpecialization)
                                val docGender = Uri.encode(it.doctorGender)
                                navigateToDocDtls(docName, docSpeciality, docGender)
                            },
                            colors = CardDefaults.cardColors(MaterialTheme.colorScheme.surfaceContainerLowest),
                            border = BorderStroke(0.5.dp, MaterialTheme.colorScheme.outlineVariant),
                            elevation = CardDefaults.elevatedCardElevation(2.dp)
                        ) {
                            val image = when (it.doctorGender) {
                                "Male" -> R.drawable.maledoctor
                                "Female" -> R.drawable.femaledoctor
                                else -> R.drawable.profile
                            }
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                Image(
                                    painter = painterResource(image),
                                    contentDescription = null,
                                    Modifier
                                        .size(86.dp)
                                        .padding(start = 4.dp, end = 4.dp)
                                )
                                Spacer(Modifier.width(6.dp))
                                Column(
                                    modifier = Modifier
                                        .padding(vertical = 6.dp)
                                        .weight(.1f),
                                    verticalArrangement = Arrangement.SpaceBetween
                                ) {
                                    Row(
                                        verticalAlignment = Alignment.CenterVertically,
                                        horizontalArrangement = Arrangement.spacedBy(4.dp)
                                    ) {
                                        Text(
                                            text = it.doctorUserName,
                                            style = MaterialTheme.typography.titleMedium,
                                            color = MaterialTheme.colorScheme.onSurface
                                        )
                                        Text(
                                            text = it.doctorSpecialization,
                                            style = MaterialTheme.typography.bodyMedium,
                                            color = MaterialTheme.colorScheme.onSurfaceVariant
                                        )
                                    }
                                    Spacer(Modifier.height(2.dp))
                                    Text(
                                        text = "Available",
                                        color = MaterialTheme.colorScheme.onTertiaryContainer,
                                        fontWeight = FontWeight.Normal,
                                        textAlign = TextAlign.Center,
                                        modifier = Modifier
                                            .clip(RoundedCornerShape(6.dp))
                                            .background(MaterialTheme.colorScheme.tertiaryContainer)
                                            .padding(horizontal = 8.dp, vertical = 2.dp)
                                    )
                                }
                                Icon(
                                    imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                                    contentDescription = null,
                                    tint = MaterialTheme.colorScheme.tertiary,
                                    modifier = Modifier.padding(end = 12.dp)
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}
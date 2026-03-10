package com.example.medcare.screens.servicesScreen.chatDoc

import android.net.Uri
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.medcare.R
import com.example.medcare.rtdb.RTDB
import com.example.medcare.screens.class_objects.DateScreen
import com.example.medcare.screens.class_objects.docWorkHrs
import com.example.medcare.screens.class_objects.review
import com.example.medcare.screens.layoutsFile.DoctorWorkingHours
import com.example.medcare.screens.layoutsFile.Reviews
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import java.time.LocalDate

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DoctorDetails(
    back: () -> Unit,
    navigateToAppointment: (String, String) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }
    var selectedIndex by remember { mutableStateOf(-1) }
    var selectedDate by remember { mutableStateOf<LocalDate?>(null) }
    val selectedHour = if (selectedIndex != -1) _root_ide_package_.com.example.medcare.screens.class_objects.docWorkHrs.workingHours[selectedIndex] else ""
    var errorMessage by remember { mutableStateOf("") }
    val auth = FirebaseAuth.getInstance()
    val db = FirebaseDatabase.getInstance().reference
    val rtdb = RTDB()
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "Doctor Details",
                        style = MaterialTheme.typography.titleMedium,
                        color = MaterialTheme.colorScheme.onBackground
                    )
                },
                navigationIcon = {
                    IconButton(onClick = back) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft,
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.onBackground
                        )
                    }
                },
                actions = {
                    Icon(
                        imageVector = Icons.Default.Share,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.onBackground
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(MaterialTheme.colorScheme.surfaceContainer),
            )
        }
    ) { innerPadding ->
        Column(modifier = Modifier
            .padding(innerPadding)
            .verticalScroll(rememberScrollState())) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(MaterialTheme.colorScheme.surfaceContainer)
            ) {
                Card(
                    colors = CardDefaults.cardColors(MaterialTheme.colorScheme.surfaceContainer)
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.padding(bottom = 10.dp)
                        ) {
                        Spacer(Modifier.height(10.dp))
                        Image(
                            painter = painterResource(R.drawable.dr_luca),
                            contentDescription = null,
                            modifier = Modifier
                                .size(100.dp)
                                .clip(CircleShape)
                        )
                        Text(
                            text = "Dr. Luca Rossi",
                            style = MaterialTheme.typography.titleMedium,
                            fontSize = 16.sp
                        )
                        Text(
                            text = "Cardiology Specialist",
                            style = MaterialTheme.typography.labelMedium
                        )
                        Spacer(Modifier.height(5.dp))
                        Row {
                            repeat(5, {
                                Icon(
                                    imageVector = Icons.Default.Star,
                                    contentDescription = null,
                                    tint = Color(0xFFFFC107)
                                )
                            })
                        }
                    }
                }
            }
            Spacer(Modifier.height(14.dp))
            Column {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    Column(
                        modifier = Modifier
                            .background(MaterialTheme.colorScheme.surfaceContainer)
                            .border(BorderStroke(1.dp, MaterialTheme.colorScheme.onSurfaceVariant))
                            .padding(8.dp)
                    ) {
                        Text(
                            text = "Education",
                            style = MaterialTheme.typography.titleSmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                        Text(
                            text = "University of Milan",
                            style = MaterialTheme.typography.titleMedium,
                            color = MaterialTheme.colorScheme.onSurface
                        )
                    }
                    Column(
                        modifier = Modifier
                            .background(MaterialTheme.colorScheme.surfaceContainer)
                            .border(BorderStroke(1.dp, MaterialTheme.colorScheme.onSurfaceVariant))
                            .padding(8.dp)
                    ) {
                        Text(
                            text = "License",
                            style = MaterialTheme.typography.titleSmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                        Text(
                            text = "1276126552881",
                            style = MaterialTheme.typography.titleMedium,
                            color = MaterialTheme.colorScheme.onSurface
                        )
                    }
                }
                Spacer(Modifier.height(14.dp))
                Column(modifier = Modifier.padding(horizontal = 20.dp)) {
                    Text(
                        text = "Practice Location",
                        style = MaterialTheme.typography.titleLarge,
                        color = MaterialTheme.colorScheme.onBackground
                    )
                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        colors = CardDefaults.cardColors(MaterialTheme.colorScheme.surfaceContainer)
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.padding(8.dp)) {
                            Text(
                                text = "Rossi Cardiology Clinic",
                                style = MaterialTheme.typography.labelLarge,
                                color = MaterialTheme.colorScheme.onSurface,
                                textAlign = TextAlign.Center
                            )
                        }
                    }
                    Spacer(Modifier.height(18.dp))
                    Text(
                        "Working Hours",
                        style = MaterialTheme.typography.titleLarge,
                        color = MaterialTheme.colorScheme.onBackground
                    )
                    Spacer(Modifier.height(10.dp))
                    LazyVerticalGrid(
                        GridCells.Fixed(4),
                        modifier = Modifier.height(80.dp),
                        verticalArrangement = Arrangement.spacedBy(10.dp),
                        horizontalArrangement = Arrangement.spacedBy(4.dp)
                    ) {
                        itemsIndexed(docWorkHrs.workingHours) { index, item ->
                            DoctorWorkingHours(
                                hours = item,
                                selected = selectedIndex == index,
                                onClick = { selectedIndex = index }
                            )
                        }
                    }
                    Spacer(Modifier.height(10.dp))
                    Text(
                        text = "Date",
                        style = MaterialTheme.typography.titleLarge,
                        color = MaterialTheme.colorScheme.onBackground
                    )
                    Spacer(Modifier.height(5.dp))
                    DateScreen(
                        selectedDate = selectedDate,
                        onDateSelected = { selectedDate = it }
                    )
                    Spacer(Modifier.height(10.dp))
                    Text(
                        text = "Review",
                        style = MaterialTheme.typography.titleLarge,
                        color = MaterialTheme.colorScheme.onBackground
                    )
                    Spacer(Modifier.height(4.dp))
                    LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                        items(review.reviews) { item ->
                            Reviews(item)
                        }
                    }
                    Spacer(Modifier.height(30.dp))
                }
            }
            Spacer(Modifier.height(50.dp))
        }
        Box(modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 24.dp),
            contentAlignment = Alignment.BottomCenter) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(5.dp),
                modifier = Modifier.padding(horizontal = 16.dp)
            ) {
                Button(
                    onClick = {},
                    modifier = Modifier.weight(1f),
                    colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.surfaceContainer),
                    border = BorderStroke(2.dp, color = MaterialTheme.colorScheme.outlineVariant)
                ) {
                    Image(
                        painter = painterResource(R.drawable.chat),
                        contentDescription = null,
                        Modifier
                            .size(28.dp)
                            .weight(1f),
                        colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onSurfaceVariant)
                    )
                    Text(
                        text = "Chat",
                        style = MaterialTheme.typography.titleMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
                Button(
                    onClick = {
                        if (selectedHour.isBlank()) {
                            errorMessage = "Please select a time"
                            return@Button
                        }
                        if (selectedDate == null) {
                            errorMessage = "Please select a date"
                            return@Button
                        }
                        val encodeHour = Uri.encode(selectedHour)
                        val encodeDate = Uri.encode(selectedDate.toString())
                        Log.i("encodeDate", encodeDate)
                        navigateToAppointment(encodeDate, encodeHour)
                    },
                    modifier = Modifier.weight(2f),
                    colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.tertiaryContainer),
                    border = BorderStroke(2.dp, color = MaterialTheme.colorScheme.outlineVariant)
                ) {
                    Text(
                        text = "Make an Appointment",
                        style = MaterialTheme.typography.titleMedium,
                        color = MaterialTheme.colorScheme.onTertiaryContainer
                    )
                }
            }
        }
    }
}
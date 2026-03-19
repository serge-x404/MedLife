package com.example.medcare.screens.history

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.medcare.R
import com.example.medcare.rtdb.RTDB
import com.example.medcare.screens.class_objects.DateScreen
import com.example.medcare.screens.class_objects.docWorkHrs
import com.example.medcare.screens.layoutsFile.DoctorWorkingHours
import com.example.medcare.screens.servicesScreen.chatDoc.AppointmentData
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.util.Locale

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun UpcomingAppointment(currentList: List<AppointmentData>, navigateToChatDoc: () -> Unit) {

    if (currentList.isEmpty()) {
        Box(
            modifier = Modifier
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(
                "No appointments",
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.onBackground
            )
        }
    }
    else {
        LazyColumn {
            items(currentList) {
                CardLayoutHistory(
                    it,
                    isUpcoming(it.selectedDate),
                    navigateToChatDoc
                )
            }
        }
    }
}


fun formatDate(dateString: String): String {
    return  try {
        val inputFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        val outputFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
        val dateFormat = inputFormat.parse(dateString)
        outputFormat.format(dateFormat!!)
    }
    catch (e: Exception) {
        dateString
    }
}


@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CardLayoutHistory(appointmentData: AppointmentData,isUpcoming: Boolean, navigateToChatDoc: () -> Unit) {
    var notificationToggle by remember { mutableStateOf(false) }
    val sheetState = rememberModalBottomSheetState()
    var showNotificationState by remember { mutableStateOf(false) }
    var showBottomSheet by remember { mutableStateOf(false) }
    var addReview by remember { mutableStateOf(false) }
    var selectedIndex by remember { mutableStateOf(-1) }
    var selectedDate by remember { mutableStateOf<LocalDate?>(null) }
    if (selectedIndex != -1) docWorkHrs.workingHours[selectedIndex] else ""

    val rtdb = RTDB()

    if (addReview) {
        ModalBottomSheet(
            onDismissRequest = { addReview = false },
            sheetState = sheetState
        ) {
            Column(modifier = Modifier.padding(horizontal = 12.dp)) {
                Text(
                    "Review",
                    style = MaterialTheme.typography.titleLarge,
                    color = MaterialTheme.colorScheme.onBackground,
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )
                Text(
                    text = "Ratings",
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.onBackground
                )
                Spacer(Modifier.height(8.dp))
                Row(horizontalArrangement = Arrangement.spacedBy(4.dp)) {
                    repeat(5, action = {
                        Icon(
                            imageVector = Icons.Default.Star,
                            contentDescription = null,
                            tint = Color(0xFFFFA740)
                        )
                    })
                }
                Spacer(Modifier.height(10.dp))
                Text(
                    text = "Your Review",
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.onBackground
                )
                TextField(
                    value = "",
                    onValueChange = {},
                    placeholder = { Text(text = "Write your Review") },
                    modifier = Modifier
                        .height(100.dp)
                        .fillMaxWidth()
                )
            }
        }
    }

    if (showBottomSheet) {
        ModalBottomSheet(
            onDismissRequest = { showBottomSheet = false },
            sheetState = sheetState
        ) {
            Column(modifier = Modifier.padding( horizontal = 16.dp)) {
                Text(
                    text = "Reschedule Appointment",
                    style = MaterialTheme.typography.titleLarge,
                    color = MaterialTheme.colorScheme.onBackground,
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )
                Text(
                    "Working Hours",
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.onBackground
                )
                Spacer(Modifier.height(10.dp))
                LazyVerticalGrid(
                    GridCells.Fixed(3),
                    modifier = Modifier.height(80.dp),
                    verticalArrangement = Arrangement.spacedBy(10.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
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
                    text = "Schedule",
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.onBackground
                )
                Spacer(Modifier.height(5.dp))
                DateScreen(
                    selectedDate = selectedDate,
                    onDateSelected = { selectedDate = it }
                )

                Spacer(Modifier.height(20.dp))

                Button(
                    onClick = {
                        val newDate = selectedDate?.toString() ?: ""
                        val newHour = if (selectedIndex != -1) docWorkHrs.workingHours[selectedIndex] else ""

                        if (newHour.isBlank() || newDate.isBlank()) return@Button

                        rtdb.updateAppointment(
                            key = appointmentData.key,
                            newDate = newDate,
                            newHour = newHour,
                            onSuccess = {showBottomSheet = false}
                        )
                    },
                    modifier = Modifier
                        .fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.secondaryContainer),
                    border = BorderStroke(2.dp, MaterialTheme.colorScheme.outlineVariant)
                ) {
                    Text(
                        "Reschedule",
                        style = MaterialTheme.typography.titleMedium,
                        color = MaterialTheme.colorScheme.onTertiaryContainer
                    )
                }
            }
        }
    }

    if (showNotificationState) {
        ModalBottomSheet(
            onDismissRequest = { showNotificationState = false },
            sheetState = sheetState
        ) {
            Row(
                modifier = Modifier
                    .padding(40.dp)
                    .fillMaxWidth()
                    .border(
                        border = BorderStroke(
                            width = 2.dp,
                            MaterialTheme.colorScheme.outlineVariant
                        ),
                        shape = RoundedCornerShape(4.dp)
                    )
                    .padding(horizontal = 12.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Activate Notifications",
                    style = MaterialTheme.typography.titleSmall,
                    modifier = Modifier.weight(1f)
                )
                Switch(
                    checked = notificationToggle,
                    onCheckedChange = { notificationToggle = it },
                    colors = SwitchDefaults.colors(checkedTrackColor = MaterialTheme.colorScheme.tertiary)
                )
            }
        }
    }
    Card(
        Modifier
            .fillMaxWidth()
            .padding(horizontal = 15.dp, vertical = 10.dp),
        colors = CardDefaults.cardColors(MaterialTheme.colorScheme.surfaceContainerHighest),
        elevation = CardDefaults.elevatedCardElevation(4.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = " Dr. ${appointmentData.doctorName}",
                        style = MaterialTheme.typography.titleMedium,
                        fontSize = 18.sp
                    )
                }
            }
            Spacer(Modifier.height(10.dp))
            HorizontalDivider()
            Spacer(Modifier.height(30.dp))
            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp)
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = "Date & Time",
                        style = MaterialTheme.typography.labelMedium
                    )
                    Text(
                        text = "${formatDate(appointmentData.selectedDate)} ${appointmentData.selectedHour}",
                        style = MaterialTheme.typography.titleSmall,
                        color = MaterialTheme.colorScheme.onBackground
                    )
                }
                Column {
                    Text(
                        text = "Location",
                        style = MaterialTheme.typography.labelMedium
                    )
                    Text(
                        text = "${appointmentData.doctorName}'s clinic",
                        style = MaterialTheme.typography.titleSmall,
                        color = MaterialTheme.colorScheme.onBackground
                    )
                }
            }
            Spacer(Modifier.height(60.dp))


            if (isUpcoming) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(
                        modifier = Modifier.weight(1f),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        TextButton(onClick = {
                            showNotificationState = true
                        }) {
                            Image(
                                painter = painterResource(R.drawable.bell),
                                contentDescription = null,
                                modifier = Modifier.size(18.dp),
                                colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onBackground)
                            )
                            Spacer(Modifier.width(4.dp))
                            Text(
                                text = "Notifications:",
                                style = MaterialTheme.typography.labelLarge,
                                color = MaterialTheme.colorScheme.onBackground
                            )
                            Spacer(Modifier.width(2.dp))
                            Text(
                                text = if (notificationToggle)"On" else "Off",
                                textDecoration = TextDecoration.Underline,
                                style = MaterialTheme.typography.labelMedium,
                                color = MaterialTheme.colorScheme.onBackground
                            )
                        }
                    }
                    Button(
                        onClick = {
                            showBottomSheet = true
                        },
                        colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.secondaryContainer),
                        border = BorderStroke(2.dp, MaterialTheme.colorScheme.outlineVariant)
                    ) {
                        Text(
                            text = "Reschedule",
                            style = MaterialTheme.typography.labelMedium,
                            color = MaterialTheme.colorScheme.onBackground
                        )
                    }
                }
            }
            else {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    Row {
                        Button(
                            onClick = {
                                addReview = true
                            },
                            colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.surfaceContainer),
                            border = BorderStroke(width = 2.dp, MaterialTheme.colorScheme.outlineVariant)
                        ) {
                            Text(
                                text = "Add Review",
                                style = MaterialTheme.typography.labelMedium,
                                color = MaterialTheme.colorScheme.onBackground
                            )
                        }
                    }
                    Button(
                        onClick = navigateToChatDoc,
                        colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.secondaryContainer),
                        border = BorderStroke(width = 2.dp, MaterialTheme.colorScheme.outlineVariant)
                    ) {
                        Text(
                            text = "Next Appointment",
                            style = MaterialTheme.typography.labelMedium,
                            color = MaterialTheme.colorScheme.onBackground
                        )
                    }
                }
            }
        }
    }
}
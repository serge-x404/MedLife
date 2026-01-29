package com.example.medcare.history

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.medcare.R
import com.example.medcare.layoutsFile.doctorWorkingHours
import com.example.medcare.layoutsFile.selectionDate
import com.example.medcare.servicesScreen.chatDoc.dates
import com.example.medcare.servicesScreen.chatDoc.docWorkHrs

@Preview(
    showBackground = true, showSystemUi = true
)
@Composable
fun UpcomingAppointment() {
    LazyVerticalGrid(GridCells.Fixed(1)) {
        items(Appointment.AppointmentList) { item ->
            CardLayoutUpcoming(item)
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CardLayoutUpcoming(appointmentCard: AppointmentCard) {
    val sheetState = rememberModalBottomSheetState()
    var showNotificationState by remember { mutableStateOf(false) }
    var showBottomSheet by remember { mutableStateOf(false) }

    if(showBottomSheet) {
        ModalBottomSheet(
            onDismissRequest = {showBottomSheet = false},
            sheetState = sheetState
        ) {
            CenterAlignedTopAppBar(
                title = {Text(
                    text = "Reschedule Appointment",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )}
            )
            Column (modifier = Modifier.padding(horizontal = 15.dp)) {
                Text(
                    "Working Hours",
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )
                Spacer(Modifier.height(10.dp))
                LazyVerticalGrid(
                    GridCells.Fixed(4),
                    modifier = Modifier.height(80.dp),
                    verticalArrangement = Arrangement.spacedBy(10.dp),
                    horizontalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    items(docWorkHrs.workingHours) { item ->
                        doctorWorkingHours(item)
                    }
                }
                Spacer(Modifier.height(10.dp))
                Text(
                    text = "Schedule",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
                Spacer(Modifier.height(5.dp))
                LazyRow(
                    modifier = Modifier,
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    items(dates.dates) { item ->
                        selectionDate(item)
                    }
                }
            }
        }
    }

    if(showNotificationState) {
        ModalBottomSheet(
            onDismissRequest = {showNotificationState = false},
            sheetState = sheetState
        ) {
            Row(modifier = Modifier
                .padding(40.dp)
                .fillMaxWidth()
                .border(
                    border = BorderStroke(width = 1.dp, Color(0xFFC2E7D9)),
                    shape = RoundedCornerShape(4.dp)
                )
                .padding(horizontal = 12.dp),
                verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = "Activate Notifications",
                    modifier = Modifier.weight(1f)
                )
                Switch(checked = false,
                    onCheckedChange = {}
                )
            }
        }
    }
    Card(
        onClick = {},
        Modifier
            .fillMaxWidth()
            .padding(horizontal = 15.dp, vertical = 10.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.elevatedCardElevation(4.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth()
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = appointmentCard.doctorName,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(Modifier.height(5.dp))
                    Text(
                        text = appointmentCard.speciality,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Normal,
                        color = Color(0xFF4D4D4D),
                    )
                }
                Image(
                    painterResource(appointmentCard.image),
                    contentDescription = null,
                    modifier = Modifier
                        .size(60.dp)
                        .clip(CircleShape)
                )
            }
            Spacer(Modifier.height(20.dp))
            HorizontalDivider()
            Spacer(Modifier.height(30.dp))
            Row {
                Column {
                    Text(
                        text = "Date & Time", fontSize = 12.sp, color = Color(0xFF4D4D4D)
                    )
                    Spacer(Modifier.height(2.dp))
                    Text(
                        text = appointmentCard.dateAndTime,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF26408B)
                    )
                }
                Spacer(Modifier.width(30.dp))
                Column {
                    Text(
                        text = "Location", fontSize = 12.sp, color = Color(0xFF4D4D4D)
                    )
                    Spacer(Modifier.height(2.dp))
                    Text(
                        text = appointmentCard.address,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF26408B)
                    )
                }
            }
            Spacer(Modifier.height(60.dp))
            Row(
                modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically
            ) {
                Row(modifier = Modifier.weight(1f),
                    verticalAlignment = Alignment.CenterVertically) {
                    Image(
                        painter = painterResource(R.drawable.bell),
                        contentDescription = null,
                        modifier = Modifier.size(18.dp)
                    )
                    Spacer(Modifier.width(4.dp))
                    Text(
                        text = "Notifications"
                    )
                    Spacer(Modifier.width(3.dp))
                    TextButton(onClick = {
                        showNotificationState = true
                    }) {
                        Text(
                            text = "On",
                            textDecoration = TextDecoration.Underline,
                            color = Color(0xFF26408B)
                        )
                    }
                }
                Button(
                    onClick = {
                        showBottomSheet = true
                    }, colors = ButtonDefaults.buttonColors(Color(0xFF26408b))
                ) {
                    Text(
                        text = "Reschedule", fontWeight = FontWeight.Bold, fontSize = 12.sp
                    )
                }
            }
        }
    }
}

data class AppointmentCard(
    val doctorName: String,
    val image: Int,
    val speciality: String,
    val dateAndTime: String,
    val address: String
)

object Appointment {
    val AppointmentList = listOf(
        AppointmentCard(
            "Dr. Rajesh Patel",
            R.drawable.dr_rajesh,
            "General Surgery",
            "Wednesday, 29 Feb, 04:00 PM",
            "Bella Vista Surgery Clinic, Via Garibaldi 10, Milan, Italy"
        ), AppointmentCard(
            "Dr. Luca Rossi",
            R.drawable.dr_luca,
            "Cardiology Specialist",
            "Wednesday, 22 Feb, 04:00 PM",
            "Rossi Cardiology Clinic Via Garibaldi 15, Milan, Italy"
        )
    )
}
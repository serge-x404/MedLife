package com.example.medcare.hospitals

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.medcare.R
import com.example.medcare.class_objects.ListHospital
import com.example.medcare.class_objects.Rooms
import com.example.medcare.class_objects.Specialities

@Composable
fun HospitalLayout(hospital: ListHospital,
                   navigateToDetail: () -> Unit,
                   navigateToMap: () -> Unit
) {
    Card(onClick = {
        navigateToDetail()
    },
        colors = CardDefaults.cardColors(containerColor = Color.White),
        border = BorderStroke(1.dp, Color(0xFFC2E7D9))
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = painterResource(hospital.hospitalImage),
                    contentDescription = null,
                    modifier = Modifier.size(80.dp)
                )
                Spacer(Modifier.width(12.dp))
                Column {
                    Text(
                        text = hospital.hospitalName,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(Modifier.height(4.dp))
                    Text(
                        text = hospital.hospitalLocation,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Normal,
                        color = Color(0xFF4D4D4D)
                    )
                    Spacer(Modifier.height(4.dp))
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            painter = painterResource(R.drawable.phone),
                            contentDescription = null,
                            modifier = Modifier.size(16.dp)
                        )
                        Spacer(Modifier.width(6.dp))
                        Text(
                            text = hospital.hospitalNumber,
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF26408B)
                        )
                    }
                }
            }
            Spacer(Modifier.height(12.dp))
            HorizontalDivider()
            Spacer(Modifier.height(12.dp))
            Row(verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()) {
                Button(
                    onClick = {
                        navigateToDetail()
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = Color.White),
                    border = BorderStroke(1.dp, Color(0xFF26408B)),
                    modifier = Modifier.weight(1f)
                ) {
                    Text(
                        text = "Bed detail",
                        color = Color(0xFF26408B)
                    )
                }
                Spacer(Modifier.width(10.dp))
                Button(onClick = {
                    navigateToMap()
                },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF26408B)),
                    modifier = Modifier.weight(1f)
                ) {
                    Text(
                        text = "Location"
                    )
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                        contentDescription = null
                    )
                }
            }
        }
    }
}


@Composable
fun SpecialitiesGrid(specialities: Specialities) {
    Card(onClick = {},
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.elevatedCardElevation(2.dp),
        modifier = Modifier
            .size(80.dp)
            .padding(vertical = 6.dp)) {
        Column(horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize()) {
            Image(
                painter = painterResource(specialities.image),
                contentDescription = null,
                modifier = Modifier.size(40.dp)
            )
            Text(
                text = specialities.name,
                fontSize = 12.sp,
                textAlign = TextAlign.Center
            )
        }
    }
}

@Composable
fun RoomGrid(rooms: Rooms) {
    Card(onClick = {},
        modifier = Modifier.padding(10.dp)
            .fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        border = BorderStroke(1.dp, Color(0xFFC2E7D9))) {
        Column(modifier = Modifier.padding(15.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = rooms.roomName,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color(0xFF26408B)
                )
                Spacer(Modifier.width(4.dp))
                Text(
                    text = "(4 persons per room)",
                    fontWeight = FontWeight.Normal,
                    color = Color(0xFF4D4D4D)
                )
            }
            Spacer(Modifier.height(4.dp))
            Row {
                Text(
                    text = stringResource(R.string.t_bed),
                    color = Color(0xFF4D4D4D)
                )
                Spacer(Modifier.width(4.dp))
                Text(
                    text = rooms.totalBeds,
                    fontWeight = FontWeight.SemiBold
                )
            }
            Spacer(Modifier.height(2.dp))
            Row {
                Text(
                    text = stringResource(R.string.r_bed),
                    color = Color(0xFF4D4D4D)
                )
                Spacer(Modifier.width(4.dp))
                Text(
                    text = rooms.availableBeds,
                    fontWeight = FontWeight.SemiBold
                )
            }
            Spacer(Modifier.height(4.dp))
            Row {
                Text(
                    text = stringResource(R.string.price),
                    color = Color(0xFF4D4D4D)
                )
                Spacer(Modifier.width(4.dp))
                Text(
                    text = rooms.price,
                    fontWeight = FontWeight.SemiBold
                )
            }
        }
    }
}
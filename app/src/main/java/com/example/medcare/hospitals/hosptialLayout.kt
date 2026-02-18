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
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
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
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.secondaryContainer),
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.surfaceTint)
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
                        style = MaterialTheme.typography.titleMedium
                    )
                    Spacer(Modifier.height(4.dp))
                    Text(
                        text = hospital.hospitalLocation,
                        style = MaterialTheme.typography.labelMedium,
                        color = MaterialTheme.colorScheme.onSecondaryContainer
                    )
                    Spacer(Modifier.height(10.dp))
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            painter = painterResource(R.drawable.phone),
                            contentDescription = null,
                            modifier = Modifier.size(16.dp),
                            tint = MaterialTheme.colorScheme.surfaceTint
                        )
                        Spacer(Modifier.width(6.dp))
                        Text(
                            text = hospital.hospitalNumber,
                            style = MaterialTheme.typography.labelSmall,
                            color = MaterialTheme.colorScheme.onSecondaryContainer
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
                    colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.surfaceContainer),
                    border = BorderStroke(1.dp, MaterialTheme.colorScheme.onSurfaceVariant),
                    modifier = Modifier.weight(1f)
                ) {
                    Text(
                        text = "Bed detail",
                        style = MaterialTheme.typography.labelMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
                Spacer(Modifier.width(10.dp))
                Button(onClick = {
                    navigateToMap()
                },
                    colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primaryContainer),
                    border = BorderStroke(1.dp, MaterialTheme.colorScheme.onPrimaryContainer),
                    modifier = Modifier.weight(1f)
                ) {
                    Text(
                        text = "Location",
                        style = MaterialTheme.typography.labelMedium,
                        color = MaterialTheme.colorScheme.onPrimaryContainer
                    )
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.surfaceTint
                    )
                }
            }
        }
    }
}


@Composable
fun SpecialitiesGrid(specialities: Specialities) {
    Card(
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primaryContainer),
        elevation = CardDefaults.elevatedCardElevation(2.dp),
        modifier = Modifier
            .size(80.dp)
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize()) {
            Image(
                painter = painterResource(specialities.image),
                contentDescription = null,
                modifier = Modifier.size(40.dp),
                colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.surfaceTint)
            )
            Text(
                text = specialities.name,
                style = MaterialTheme.typography.labelMedium,
                color = MaterialTheme.colorScheme.onPrimaryContainer,
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
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primaryContainer),
        border = BorderStroke(1.dp, Color(0xFFC2E7D9))) {
        Column(modifier = Modifier.padding(15.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = rooms.roomName,
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.onPrimaryContainer
                )
                Spacer(Modifier.width(4.dp))
                Text(
                    text = "(4 persons per room)",
                    style = MaterialTheme.typography.labelMedium,
                    color = MaterialTheme.colorScheme.onPrimaryContainer
                )
            }
            Spacer(Modifier.height(4.dp))
            Row {
                Text(
                    text = stringResource(R.string.t_bed),
                    style = MaterialTheme.typography.labelMedium,
                    color = MaterialTheme.colorScheme.onPrimaryContainer
                )
                Spacer(Modifier.width(4.dp))
                Text(
                    text = rooms.totalBeds,
                    style = MaterialTheme.typography.labelMedium,
                    color = MaterialTheme.colorScheme.onPrimaryContainer
                )
            }
            Spacer(Modifier.height(2.dp))
            Row {
                Text(
                    text = stringResource(R.string.r_bed),
                    style = MaterialTheme.typography.labelMedium,
                    color = MaterialTheme.colorScheme.onPrimaryContainer
                )
                Spacer(Modifier.width(4.dp))
                Text(
                    text = rooms.availableBeds,
                    style = MaterialTheme.typography.labelMedium,
                    color = MaterialTheme.colorScheme.onPrimaryContainer
                )
            }
            Spacer(Modifier.height(4.dp))
            Row {
                Text(
                    text = stringResource(R.string.price),
                    style = MaterialTheme.typography.labelMedium,
                    color = MaterialTheme.colorScheme.onPrimaryContainer
                )
                Spacer(Modifier.width(4.dp))
                Text(
                    text = rooms.price,
                    style = MaterialTheme.typography.labelMedium,
                    color = MaterialTheme.colorScheme.onPrimaryContainer
                )
            }
        }
    }
}
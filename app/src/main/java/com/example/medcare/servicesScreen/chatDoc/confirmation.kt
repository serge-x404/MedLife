package com.example.medcare.servicesScreen.chatDoc

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.medcare.R

@SuppressLint("InvalidColorHexValue")
@OptIn(ExperimentalMaterial3Api::class)
@Preview(
    showBackground = true, showSystemUi = true
)
@Composable
fun Confirmation() {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(title = {
                Text(
                    text = "Confirmation", fontWeight = FontWeight.Bold, fontSize = 15.sp
                )
            }, navigationIcon = {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft,
                    contentDescription = null
                )
            })
        }) { innerPadding ->
        Column(Modifier.padding(innerPadding)) {
            Column(Modifier.padding(horizontal = 20.dp)) {
                Card(
                    onClick = {},
                    colors = CardDefaults.cardColors(containerColor = Color.White),
                    modifier = Modifier,
                    elevation = CardDefaults.elevatedCardElevation(6.dp)
                ) {
                    Row(modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 20.dp, top = 15.dp),
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                        verticalAlignment = Alignment.CenterVertically) {
                        Image(
                            painter = painterResource(R.drawable.dr_luca),
                            contentDescription = null,
                            Modifier
                                .size(80.dp)
                                .clip(CircleShape)
                        )
                        Column {
                            Text(
                                text = "Dr. Luca Rossi",
                                fontWeight = FontWeight.Bold,
                                fontSize = 22.sp
                            )
                            Text(
                                text = "Cardiology Specialist"
                            )
                        }
                    }
                    Spacer(Modifier.height(12.dp))
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 15.dp),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        Column(
                            modifier = Modifier
                                .border(BorderStroke(2.dp, Color(0xFFE3E3E3)))
                                .padding(8.dp)
                        ) {
                            Text(
                                text = "Education",
                                fontWeight = FontWeight.Normal,
                                color = Color.Gray,
                                fontSize = 12.sp
                            )
                            Text(
                                text = "University of Milan",
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color(0xFF26408B)
                            )
                        }
                        Column(
                            modifier = Modifier
                                .border(BorderStroke(2.dp, Color(0xFFE3E3E3)))
                                .padding(8.dp)
                        ) {
                            Text(
                                text = "License",
                                fontWeight = FontWeight.Normal,
                                color = Color.Gray,
                                fontSize = 12.sp
                            )
                            Text(
                                text = "1276126552881",
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color(0xFF26408B)
                            )
                        }
                    }
                }
                Spacer(Modifier.height(20.dp))
                Card(onClick = {},
                    colors = CardDefaults.cardColors(containerColor = Color.White),
                    modifier = Modifier.fillMaxWidth(),
                    elevation = CardDefaults.elevatedCardElevation(6.dp)) {
                    Column(modifier = Modifier.padding(15.dp)) {
                        Text(
                            text = "Detail Appointment",
                            color = Color(0xFF26408B),
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp
                        )
                        Spacer(Modifier.height(10.dp))
                        HorizontalDivider()
                        Spacer(Modifier.height(6.dp))
                        Text(
                            text = "Date & Time",
                            color = Color(0xFF4D4D4D)
                        )
                        Spacer(Modifier.height(2.dp))
                        Text(
                            text = "Wednesday, 22 Feb 1.00PM",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Spacer(Modifier.height(12.dp))
                        Text(
                            text = "Location",
                            color = Color(0xFFF4D4D4D)
                        )
                        Spacer(Modifier.height(2.dp))
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text(
                                text = "Rossi Cardiology Clinic\n" +
                                        "Via Garibaldi 15, Milan, Italy",
                                maxLines = 2,
                                fontSize = 15.sp,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier.weight(1f)
                            )
                            Text(
                                text = "See Maps",
                                color = Color(0xFF26408B)
                            )
                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                                contentDescription = null,
                                tint = Color(0xFF26408B)
                            )
                        }
                    }
                }
                Spacer(Modifier.height(20.dp))
                Card(onClick = {},
                    colors = CardDefaults.cardColors(containerColor = Color.White),
                    border = BorderStroke(width = 1.dp, color = Color(0xFFC2E7D9)),
                    modifier = Modifier.fillMaxWidth()) {
                    Row(modifier = Modifier.padding(8.dp),
                        verticalAlignment = Alignment.CenterVertically) {
                        Image(
                            painter = painterResource(R.drawable.bell),
                            contentDescription = null,
                            Modifier.size(20.dp),
                            colorFilter = ColorFilter.tint(Color(0xFF26408B))
                        )
                        Spacer(Modifier.width(10.dp))
                        Text(
                            text = "Activate notifications",
                            color = Color(0xFFF4D4D4D),
                            modifier = Modifier.weight(1f)
                        )
                        Switch(checked = false,
                            onCheckedChange = {},
                            colors = SwitchDefaults.colors(
                                checkedTrackColor = Color(0xFF26408B)
                            )
                        )
                    }
                }
            }

        }
    }
}
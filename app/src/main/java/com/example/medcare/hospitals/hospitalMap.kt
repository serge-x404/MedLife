package com.example.medcare.hospitals

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.medcare.R
import com.example.medcare.clobs.HospitalData
import com.example.medcare.clobs.ListHospital


@Composable
fun HospitalMap(hospital: ListHospital) {
    Scaffold() { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
            Column(modifier = Modifier.fillMaxSize()) {
                Image(
                    painter = painterResource(R.drawable.map),
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize()
                )
            }
            Card(
                onClick = {},
                colors = CardDefaults.cardColors(containerColor = Color.White),
                border = BorderStroke(1.dp, Color(0xFFC2E7D9)),
                modifier = Modifier
                    .padding(22.dp)
                    .align(Alignment.BottomCenter)
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
                            Row {
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
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Button(
                            onClick = {},
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
                        Button(
                            onClick = {},
                            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF26408B)),
                            modifier = Modifier.weight(1f)
                        ) {
                            Text(
                                text = "Contact Now"
                            )
                        }
                    }
                }
            }
        }
    }
}


@Preview(showBackground = true,
    showSystemUi = true)
@Composable
fun Map() {
    HospitalMap(hospital = HospitalData.data.first())
}
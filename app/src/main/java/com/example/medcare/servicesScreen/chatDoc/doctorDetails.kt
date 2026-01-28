package com.example.medcare.servicesScreen.chatDoc

import android.media.Image
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
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.medcare.R
import com.example.medcare.layoutsFile.Reviews
import com.example.medcare.layoutsFile.doctorWorkingHours
import com.example.medcare.layoutsFile.selectionDate

@OptIn(ExperimentalMaterial3Api::class)
@Preview(
    showBackground = true, showSystemUi = true
)
@Composable
fun DoctorDetails() {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                Text(
                    text = "Doctor Details", fontSize = 15.sp, fontWeight = FontWeight.Bold
                )
            }, navigationIcon = {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft,
                    contentDescription = null
                )
            }, actions = {
                Icon(
                    imageVector = Icons.Default.Share, contentDescription = null
                )
            }, colors = TopAppBarDefaults.topAppBarColors(Color(0XFFF6F1FF)),
            )
        },
        bottomBar = {
            BottomAppBar() {
                Row(horizontalArrangement = Arrangement.spacedBy(5.dp),
                    modifier = Modifier.padding(horizontal = 16.dp)) {
                    Button(
                        onClick = {},
                        modifier = Modifier.weight(1f),
                        colors = ButtonDefaults.buttonColors(Color.White),
                        border = BorderStroke(width = 1.dp, color = Color(0xFF26408B))
                    ) {
                        Image(
                            painter = painterResource(R.drawable.chat),
                            contentDescription = null,
                            Modifier.size(28.dp)
                        )
                        Text(
                            text = "Chat",
                            fontSize = 19.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF26408B)
                        )
                    }
                    Button(
                        onClick = {},
                        modifier = Modifier.weight(2f),
                        colors = ButtonDefaults.buttonColors(Color(0xFF26408B))
                    ) {
                        Text(
                            text = "Make an Appointment",
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }
        }) { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFFF6F1FF))
            ) {
                Card(
                    onClick = {}, colors = CardDefaults.cardColors(Color(0xFFF6F1FF))
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
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
                            textAlign = TextAlign.Center,
                            fontWeight = FontWeight.Bold,
                            fontSize = 16.sp
                        )
                        Text(
                            text = "Cardiology Specialist"
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
            Spacer(Modifier.height(20.dp))
            Column() {
                Row(
                    modifier = Modifier.fillMaxWidth(),
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
                Spacer(Modifier.height(14.dp))
                Column(modifier = Modifier.padding(start = 40.dp, end = 40.dp)) {
                    Text(
                        text = "Practice Location",
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp
                    )
                    Spacer(Modifier.height(10.dp))
                    Row(modifier = Modifier
                        .background(Color(0xFFF9F8FD))
                        .fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically) {
                        Text(
                            text = "Rossi Cardiology Clinic",
                            fontSize = 14.sp,
                            color = Color(0xFF26408B),
                            modifier = Modifier.weight(1f)
                        )
                        Icon(
                            imageVector = Icons.Default.ArrowDropDown,
                            contentDescription = null
                        )
                    }
                    Spacer(Modifier.height(18.dp))
                    Text("Working Hours",
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp)
                    Spacer(Modifier.height(10.dp))
                    LazyVerticalGrid(GridCells.Fixed(4),
                        modifier = Modifier.height(80.dp),
                        verticalArrangement = Arrangement.spacedBy(10.dp),
                        horizontalArrangement = Arrangement.spacedBy(4.dp)) {
                        items(docWorkHrs.workingHours) {
                            item ->
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
                    LazyRow(modifier = Modifier,
                        horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                        items(dates.dates) {
                            item ->
                            selectionDate(item)
                        }
                    }
                    Spacer(Modifier.height(10.dp))
                    Text(
                        text = "Review",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(Modifier.height(4.dp))
                    LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                        items(review.reviews) {
                            item ->
                            Reviews(item)
                        }
                    }
                }
            }
        }
    }
}

object docWorkHrs {
    val workingHours = listOf<String>("9:00 AM","10:00 AM", "1:00 PM", "2:00 PM", "3:00 PM", "4:00 PM")
}

object dates {
    val dates = listOf(
        DateDay("Wed","22"),
        DateDay("Thu","23"),
        DateDay("Fri","24"),
        DateDay("Sat","25"),
        DateDay("Sun","26"),
    )
}

data class DateDay(
    val day: String,
    val date: String
)

data class ReviewContents(
    val image: Int,
    val name: String,
    val timeperiod: String,
    val body: String
)

object review {
    val reviews = listOf(
        ReviewContents(R.drawable.sofia,"Emily Johnson","1 day ago","My consultation with Dr. Luca Rossi was excellent. He's knowledgeable, attentive, and provided"),
        ReviewContents(R.drawable.john,"Daniel Mark","8 days ago","My consultation with Dr. Luca Rossi was excellent. He's knowledgeable, attentive, and provided")
    )
}
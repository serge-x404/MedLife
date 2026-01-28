package com.example.medcare.layoutsFile

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.medcare.R
import com.example.medcare.homeScreen.Categories
import com.example.medcare.servicesScreen.chatDoc.DateDay
import com.example.medcare.servicesScreen.chatDoc.ReviewContents
import com.example.medcare.servicesScreen.chatDoc.docWorkHrs
import com.example.medcare.servicesScreen.chatDoc.doctorsSyntax

@Composable
fun gridViewLayout(categories: Categories) {
    Card(onClick = {},
        modifier = Modifier
            .padding(8.dp)
            .size(82.dp),
        colors = CardDefaults.cardColors(Color.White)) {
        Box {
            Column(horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .align(Alignment.Center)
                    .padding(4.dp)
                    .fillMaxSize()) {
                Image(
                    painter = painterResource(categories.icon),
                    contentDescription = "Image",
                    Modifier.size(36.dp)
                    )
                Text(
                    text = categories.name,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}

@Composable
fun doctorsListGrid(doctorsSyntax: doctorsSyntax) {
    Card(onClick = {},
        colors = CardDefaults.cardColors(Color(0xFFFFFFFF))) {
        Row(verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()) {
            Image(
                painter = painterResource(doctorsSyntax.image),
                contentDescription = null,
                Modifier
                    .size(90.dp)
                    .padding(start = 4.dp, end = 4.dp)
            )
            Column(modifier = Modifier.weight(.1f)) {
                Text(
                    text = doctorsSyntax.name,
                    fontWeight = FontWeight.Bold,
                )
                Text(
                    text = doctorsSyntax.speciality,
                    fontWeight = FontWeight.Normal,
                    modifier = Modifier.padding(top = 4.dp)
                )
                Text(
                    text = doctorsSyntax.availability,
                    fontWeight = FontWeight.Normal,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .padding(top = 8.dp)
                        .background(Color(0xFFDCFFDD))
                )
            }
            Icon(
                imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                contentDescription = null,
            )
        }
    }
}

@Composable
fun doctorWorkingHours(hours: String) {
    Card(onClick = {},
        colors = CardDefaults.cardColors(containerColor = Color.White),
        border = BorderStroke(width = 2.dp, color = Color(0xFFE3E3E3)),
        shape = CardDefaults.shape,
        modifier = Modifier.size(height = 30.dp, width = 100.dp)) {
        Box(modifier = Modifier.fillMaxSize()) {
            Text(
                text = hours,
                modifier = Modifier.align(Alignment.Center)
            )
        }
    }
}

@Composable
fun selectionDate(dateDay: DateDay) {
    Card(onClick = {},
        modifier = Modifier
            .size(60.dp),
        colors = CardDefaults.cardColors(Color.White),
        border = BorderStroke(width = 1.dp, color = Color(0xFFE3E3E3))
        ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            Text(
                text = dateDay.day
            )
            Text(
                text = dateDay.date
            )
        }
    }
}

@Composable
fun Reviews(reviewContents: ReviewContents) {
    Card(onClick = {},
        modifier = Modifier.size(height = 150.dp, width = 220.dp)) {
        Column(modifier = Modifier.padding(12.dp)) {
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                Image(
                    painter = painterResource(reviewContents.image),
                    contentDescription = null,
                    Modifier.size(70.dp)
                )
                Column(verticalArrangement = Arrangement.Center,
                    modifier = Modifier.padding(top = 10.dp)) {
                    Text(
                        text = reviewContents.name,
                        fontSize = 16.sp,
                    )
                    Text(
                        text = reviewContents.timeperiod,
                        fontSize = 12.sp
                    )
                }
            }
            Text(
                text = reviewContents.body,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}
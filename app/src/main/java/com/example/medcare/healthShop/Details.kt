package com.example.medcare.healthShop

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.medcare.layoutsFile.Reviews
import com.example.medcare.servicesScreen.chatDoc.review

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true,
    showSystemUi = true)
@Composable
fun Details() {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text(
                    text = "Bufect Strip of 4 Tablets -Heat and Pain Relief Medicine",
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold,
                    lineHeight = 18.sp
                ) },
                navigationIcon = { Icon(
                    imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft,
                    contentDescription = null
                ) },
                actions = {Icon(
                    imageVector = Icons.Default.Share,
                    contentDescription = null
                )},
            )
        }
    ) { innerPadding ->
        Column(modifier = Modifier
            .padding(innerPadding)
            .background(Color.White))
        { Box(modifier = Modifier.padding(horizontal = 16.dp)
            .fillMaxSize()) {
            Column() {
                Spacer(Modifier.height(15.dp))
                Text(
                    text = "Composition", fontSize = 16.sp, fontWeight = FontWeight.Bold
                )
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = "\u2022", fontSize = 30.sp, fontWeight = FontWeight.ExtraBold
                    )
                    Spacer(Modifier.width(8.dp))
                    Text(
                        text = "Acetaminophen (500 mg)",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Light
                    )
                }
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = "\u2022", fontSize = 30.sp, fontWeight = FontWeight.ExtraBold
                    )
                    Spacer(Modifier.width(8.dp))
                    Text(
                        text = "Ibuprofen (200 mg)",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Light
                    )
                }
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = "\u2022", fontSize = 30.sp, fontWeight = FontWeight.ExtraBold
                    )
                    Spacer(Modifier.width(8.dp))
                    Text(
                        text = "Caffeine (50 mg)",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Light
                    )
                }
                Spacer(Modifier.height(15.dp))
                Text(
                    text = "Dosage", fontSize = 16.sp, fontWeight = FontWeight.Bold
                )
                Spacer(Modifier.height(5.dp))
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = "\u2022", fontSize = 30.sp, fontWeight = FontWeight.ExtraBold
                    )
                    Spacer(Modifier.width(8.dp))
                    Text(
                        text = "Adults: Take 1 tablet every 4 to 6 hours as needed. " +
                                "Do not exceed 4 tablets in 24 hours.",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Light
                    )
                }
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = "\u2022", fontSize = 30.sp, fontWeight = FontWeight.ExtraBold
                    )
                    Spacer(Modifier.width(8.dp))
                    Text(
                        text = "Children (ages 6-12): Take half a tablet every 4 to 6 hours as needed. " +
                                "Do not exceed 2 tablets in 24 hours.",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Light
                    )
                }
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = "\u2022", fontSize = 30.sp, fontWeight = FontWeight.ExtraBold
                    )
                    Spacer(Modifier.width(8.dp))
                    Text(
                        text = "Children under 6 years: Consult a healthcare professional before use.",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Light
                    )
                }
                Spacer(Modifier.height(15.dp))
                Text(text = "Storage Instructions", fontSize = 16.sp, fontWeight = FontWeight.Bold)
                Spacer(Modifier.height(5.dp))
                Text(
                    text = "For optimal potency and safety, it is recommended to store this medication in a cool, " +
                            "dry place, away from direct sunlight. Exposure to excessive heat or moisture may compromise the quality of the product. " +
                            "Additionally, it is important to keep this medication out of reach of children and pets to prevent accidental ingestion and ensure their safety",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Light
                )
                Spacer(Modifier.height(15.dp))
                Text(text = "Special Precautions", fontSize = 16.sp, fontWeight = FontWeight.Bold)
                Spacer(Modifier.height(5.dp))
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = "\u2022", fontSize = 30.sp, fontWeight = FontWeight.ExtraBold
                    )
                    Spacer(Modifier.width(8.dp))
                    Text(
                        text = "Do not exceed the recommended dosage.",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Light
                    )
                }
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = "\u2022", fontSize = 30.sp, fontWeight = FontWeight.ExtraBold
                    )
                    Spacer(Modifier.width(8.dp))
                    Text(
                        text = "Consult a healthcare professional before use if pregnant, breastfeeding, or taking other medications.",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Light
                    )
                }
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = "\u2022", fontSize = 30.sp, fontWeight = FontWeight.ExtraBold
                    )
                    Spacer(Modifier.width(8.dp))
                    Text(
                        text = "Discontinue use and seek medical advice if adverse reactions occur.",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Light
                    )
                }
                Spacer(Modifier.height(15.dp))
                Text(text = "Review", fontSize = 16.sp, fontWeight = FontWeight.Bold)
                Spacer(Modifier.height(5.dp))
                LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    items(review.reviews) { item ->
                        Reviews(item)
                    }
                }
            }
            Button(onClick = {},
                colors = ButtonDefaults.buttonColors(Color(0xFF26408B)),
                modifier = Modifier.align(Alignment.BottomCenter)
                    .fillMaxWidth()) {
                Text(
                    text = "Add to Cart"
                )
            }
        } }
    }
}
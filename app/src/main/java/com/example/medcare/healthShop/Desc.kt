package com.example.medcare.healthShop

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
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

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true,
    showSystemUi = true)
@Composable
fun Description() {
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
        Column(modifier = Modifier.padding(innerPadding)
            .background(Color.White)) {
            Box(
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .fillMaxSize()
            ) {
                Column() {
                    Text(text = "TABS COMING HERE")
                    Spacer(Modifier.height(60.dp))
                    Text(
                        text = "Product Description", fontWeight = FontWeight.Bold, fontSize = 16.sp
                    )
                    Spacer(Modifier.height(5.dp))
                    Text(
                        text = "Bufect is a reliable and effective medication presented in a convenient strip containing four tablets." +
                                " Each tablet is meticulously formulated to provide targeted relief from various ailments. " +
                                "With its user-friendly packaging and easy-to-carry design, " +
                                "Bufect ensures quick access to relief whenever and wherever needed. " +
                                "Trust Bufect for fast-acting and dependable relief from discomfort.",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Light
                    )
                    Spacer(Modifier.height(15.dp))
                    Text(
                        text = "Benefits", fontSize = 16.sp, fontWeight = FontWeight.Bold
                    )
                    Spacer(Modifier.height(5.dp))
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(
                            text = "\u2022", fontSize = 30.sp, fontWeight = FontWeight.ExtraBold
                        )
                        Spacer(Modifier.width(8.dp))
                        Text(
                            text = "Provides fast and effective relief from pain and discomfort",
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
                            text = "Provides fast and effective relief from pain and discomfort",
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
                            text = "Provides fast and effective relief from pain and discomfort",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Light
                        )
                    }
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
                            text = "Adults: Take 1 tablet every 4 to 6 hours as needed. " +
                                    "Do not exceed 4 tablets in 24 hours.",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Light
                        )
                    }
                }
                Button(onClick = {},
                    colors = ButtonDefaults.buttonColors(Color(0xFF26408b)),
                    modifier = Modifier.fillMaxWidth()
                        .align(Alignment.BottomCenter)) {
                    Text(
                        text = "Add to Cart"
                    )
                }
            }
        } }
}
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
import com.example.medcare.clobs.pharmaImages
import com.example.medcare.layoutsFile.Reviews
import com.example.medcare.servicesScreen.chatDoc.review

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true,
    showSystemUi = true)
@Composable
fun Review() {
    Scaffold(
        topBar = { CenterAlignedTopAppBar(
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
            .background(Color.White)) {
            Box(modifier = Modifier
                .padding(horizontal = 16.dp)
                .fillMaxSize()) {
                Column() {
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
                    Spacer(Modifier.height(15.dp))
                    Text(text = "Related Products", fontSize = 16.sp, fontWeight = FontWeight.Bold)
                    Spacer(Modifier.height(5.dp))
                    LazyRow(modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                        items(pharmaImages.hotSales) { item ->
                            HotSalesGrid(item)
                        }
                    }
                }
                Button(onClick = {},
                    colors = ButtonDefaults.buttonColors(Color(0xFF26408B)),
                    modifier = Modifier.fillMaxWidth()
                        .align(Alignment.BottomCenter)) {
                    Text(
                        text = "Add to Cart"
                    )
                }
            }
        }
    }
}

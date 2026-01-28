package com.example.medcare.healthShop

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.medcare.R

@OptIn(ExperimentalMaterial3Api::class)
@Preview(
    showBackground = true, showSystemUi = true
)
@Composable
fun MedicineDescription() {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(title = {}, navigationIcon = {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft,
                    contentDescription = null
                )
            }, actions = {
                Icon(
                    imageVector = Icons.Default.Share, contentDescription = null
                )
            })
        }) { innerPadding ->
        Column(
            Modifier
                .padding(innerPadding)
                .background(Color.White)
        ) {
            Box(
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .fillMaxSize()
            ) {
                Column {
                    Box(
                        modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center
                    ) {
                        Image(
                            painter = painterResource(R.drawable.bufect),
                            contentDescription = null,
                            Modifier.size(230.dp)
                        )
                    }
                    Text(
                        text = "Bufect Strip of 4 Tablets -Heat and Pain Relief Medicine",
                        fontSize = 15.sp,
                        fontWeight = FontWeight.ExtraBold
                    )
                    Spacer(Modifier.height(10.dp))
                    Text(
                        text = "Per Strip", fontSize = 15.sp
                    )
                    Spacer(Modifier.height(10.dp))
                    Text(
                        text = "Start from", fontSize = 12.sp, color = Color(0xFF8F8F8F)
                    )
                    Spacer(Modifier.height(5.dp))
                    Text(
                        text = "$2.00",
                        fontSize = 25.sp,
                        color = Color(0xFF26408B),
                        fontWeight = FontWeight.ExtraBold
                    )
                    Spacer(Modifier.height(15.dp))
                    HorizontalDivider()
                    Spacer(Modifier.height(15.dp))
                    Text(
                        text = "Product Description", fontWeight = FontWeight.Bold, fontSize = 16.sp
                    )
                    Spacer(Modifier.height(5.dp))
                    Text(
                        text = "Bufect is a reliable and effective medication presented in a convenient strip containing four tablets." + " Each tablet is meticulously formulated to provide targeted relief from various ailments. " + "With its user-friendly packaging and easy-to-carry design, " + "Bufect ensures quick access to relief whenever and wherever needed. " + "Trust Bufect for fast-acting and dependable relief from discomfort.",
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
                            text = "Provides fast and effective relief from pain and discomfort"
                        )
                    }
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(
                            text = "\u2022", fontSize = 30.sp, fontWeight = FontWeight.ExtraBold
                        )
                        Spacer(Modifier.width(8.dp))
                        Text(
                            text = "Provides fast and effective relief from pain and discomfort"
                        )
                    }
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(
                            text = "\u2022", fontSize = 30.sp, fontWeight = FontWeight.ExtraBold
                        )
                        Spacer(Modifier.width(8.dp))
                        Text(
                            text = "Provides fast and effective relief from pain and discomfort"
                        )
                    }
                    Spacer(Modifier.height(15.dp))
                    Text(
                        text = "Composition", fontSize = 16.sp, fontWeight = FontWeight.Bold
                    )
                }
                Button(onClick = {},
                    colors = ButtonDefaults.buttonColors(Color(0xFF26408B)),
                    modifier = Modifier.align(alignment = Alignment.BottomCenter)
                        .fillMaxWidth()) {
                    Text(text = "Add to Cart")
                }
            }
        }
    }
}
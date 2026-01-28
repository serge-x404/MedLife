package com.example.medcare.healthShop

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.medcare.R

@Composable
fun ImageGridPharma(item: Int) {
    Card(
        onClick = {},
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Image(
            painter = painterResource(item),
            contentDescription = null,
            modifier = Modifier.size(100.dp)
        )
    }
}

@Composable
fun HotSalesGrid(hotSales: HotSales) {
    Card(
        onClick = {},
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.elevatedCardElevation(6.dp),
    ) {
        Column(Modifier.padding(6.dp)) {
            Image(
                painter = painterResource(hotSales.image),
                contentDescription = null,
                Modifier.size(100.dp)
            )
            Spacer(Modifier.height(8.dp))
            Text(
                text = hotSales.medicineName,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "Per Strip",
                color = Color(0xFF8F8F8F)
            )
            Spacer(Modifier.height(20.dp))
            Row {
                Column {
                    Text(
                        text = "Starts from",
                        fontSize = 12.sp
                    )
                    Text(
                        text = "$2.00",
                        color = Color(0xFF26408B),
                        fontWeight = FontWeight.ExtraBold,
                        fontSize = 16.sp
                    )
                }
                Spacer(Modifier.width(6.dp))
                Button(onClick = {},
                    colors = ButtonDefaults.buttonColors(containerColor = Color.White),
                    border = BorderStroke(1.dp,Color(0xFF26408B))
                ) {
                    Text(
                        text = "Add",
                        color = Color(0xFF26408B)
                    )
                }
            }
        }
    }
}
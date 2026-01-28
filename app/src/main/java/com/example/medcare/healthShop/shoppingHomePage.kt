package com.example.medcare.healthShop

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.medcare.R

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true,
    showSystemUi = true)
@Composable
fun ShoppingHomePage() {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { TextField(
                    value = "",
                    onValueChange = {},
                    placeholder = { Text(
                        text = "Search for product or store"
                    ) },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = null
                        )
                    },
                ) },
                navigationIcon = {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft,
                        contentDescription = null
                    )
                },
                actions = {
                    Image(
                        painter = painterResource(R.drawable.cart),
                        contentDescription = null,
                        modifier = Modifier.size(25.dp),
                    )
                }
            )
        }
    )
    {innerPadding -> Column(modifier = Modifier.padding(innerPadding))  {
        Column() {
            LazyRow(modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center) {
                items(shoppingList.ShoppingList) { item ->
                    Chips(item)
                }
            }
            Spacer(Modifier.height(8.dp))
            Column(modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFFC2E7D9))
                .padding(15.dp)) {
                Row {
                    Text(
                        text = "Official Store",
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 16.sp,
                        modifier = Modifier.weight(1f)
                    )
                    Text(
                        text = "See all",
                        color = Color(0xFF26408B)
                    )
                }
                Spacer(Modifier.height(8.dp))
                Text(
                    text = "Special offers from various renowned brands",
                    fontWeight = FontWeight.W400
                )
                Spacer(Modifier.height(10.dp))
                LazyRow(modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(10.dp),
                    ) {
                    items(pharmaImages.PharmaImages) {
                        item -> ImageGridPharma(item)
                    }
                }
            }
            Spacer(Modifier.height(6.dp))
            Column(modifier = Modifier.padding(15.dp)) {
                Row {
                    Text(
                        text = "Hot Sales",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.SemiBold,
                        modifier = Modifier.weight(1f)
                    )
                    Text(
                        text = "See all",
                        color = Color(0xFF26408B)
                    )
                }
                Spacer(Modifier.height(6.dp))
                LazyRow(modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                    items(pharmaImages.hotSales) { item ->
                        HotSalesGrid(item)
                    }
                }
                Spacer(Modifier.height(15.dp))
                Row {
                    Text(
                        text = "Recently Viewed",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.SemiBold,
                        modifier = Modifier.weight(1f)
                    )
                    Text(
                        text = "See all",
                        color = Color(0xFF26408B)
                    )
                }
                Spacer(Modifier.height(6.dp))
                LazyRow(modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                    items(pharmaImages.hotSales) { item ->
                        HotSalesGrid(item)
                    }
                }
            }
        }
    }}
}

object shoppingList {
    val ShoppingList = listOf(
        "Medicine & Treatment",
        "Milk",
        "Sexual Health"
    )
}

@Composable
fun Chips(item: String) {
    Card(onClick = {},
        colors = CardDefaults.cardColors(containerColor = Color.White),
        border = BorderStroke(1.dp, Color(0xFFE3E3E3)),
        shape = RoundedCornerShape(8.dp)
    ) {
        Text(
            text = item,
            modifier = Modifier.padding(10.dp)
        )
    }
}

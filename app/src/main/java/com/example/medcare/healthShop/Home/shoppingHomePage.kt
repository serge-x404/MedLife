package com.example.medcare.healthShop.Home

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.medcare.R
import com.example.medcare.healthShop.HotSalesGrid
import com.example.medcare.healthShop.ImageGridPharma
import com.example.medcare.class_objects.pharmaImages

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ShoppingHomePage(
    back: () -> Unit,
    navigateToMedGrid: () -> Unit,
    navigateToMedDesc: () -> Unit,
    navigateToCart: () -> Unit
) {

    var filterSelect by remember { mutableStateOf<String?>(null) }
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    OutlinedTextField(
                        value = "",
                        onValueChange = {},
                        placeholder = { Text(
                            text = "Search for product or store"
                        ) },
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Default.Search,
                                contentDescription = null,
                                tint = MaterialTheme.colorScheme.surfaceTint
                            )
                        },
                    )
                },
                navigationIcon = {
                    IconButton(onClick = back) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft,
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.surfaceTint
                        )
                    }
                },
                actions = {
                    Image(
                        painter = painterResource(R.drawable.cart),
                        contentDescription = null,
                        modifier = Modifier.size(25.dp)
                            .clickable(
                                onClick = {navigateToCart()}
                            ),
                        colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.surfaceTint)
                    )
                }
            )
        }
    )
    {innerPadding -> Column(modifier = Modifier.padding(innerPadding))  {
        Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
            LazyRow(modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                contentPadding = PaddingValues(16.dp)) {
                items(shoppingList.ShoppingList) { item ->
                    FilterChip(
                        selected = filterSelect == item,
                        onClick = {
                            filterSelect = item
                            navigateToMedGrid()
                        },
                        label = {Text(item)}
                    )
                }
            }
            Spacer(Modifier.height(8.dp))
            Column(modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.secondaryContainer)
                .padding(15.dp)) {
                Row {
                    Text(
                        text = "Official Store",
                        style = MaterialTheme.typography.titleLarge,
                        color = MaterialTheme.colorScheme.onSecondaryContainer,
                        modifier = Modifier.weight(1f)
                    )
                    Text(
                        text = "See all",
                        style = MaterialTheme.typography.labelLarge,
                        color = MaterialTheme.colorScheme.onSecondaryContainer
                    )
                }
                Spacer(Modifier.height(8.dp))
                Text(
                    text = "Special offers from various renowned brands",
                    style = MaterialTheme.typography.labelMedium
                )
                Spacer(Modifier.height(10.dp))
                LazyRow(modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(10.dp),
                    ) {
                    items(pharmaImages.PharmaImages) {
                        item ->
                        ImageGridPharma(item)
                    }
                }
            }
            Spacer(Modifier.height(6.dp))
            Column(modifier = Modifier.padding(15.dp)) {
                Row {
                    Text(
                        text = "Hot Sales",
                        style = MaterialTheme.typography.titleLarge,
                        color = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.weight(1f)
                    )
                    Text(
                        text = "See all",
                        style = MaterialTheme.typography.labelLarge,
                        color = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.clickable(
                            enabled = true,
                            onClick = {
                                navigateToMedGrid()
                            }
                        )
                    )
                }
                Spacer(Modifier.height(6.dp))
                LazyRow(modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                    items(pharmaImages.hotSales) { item ->
                        HotSalesGrid(item, navigateToMedDesc, navigateToCart)
                    }
                }
                Spacer(Modifier.height(15.dp))
                Row {
                    Text(
                        text = "Recently Viewed",
                        style = MaterialTheme.typography.titleLarge,
                        color = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.weight(1f)
                    )
                    Text(
                        text = "See all",
                        style = MaterialTheme.typography.labelLarge,
                        color = MaterialTheme.colorScheme.primary
                    )
                }
                Spacer(Modifier.height(6.dp))
                LazyRow(modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    items(pharmaImages.hotSales) { item ->
                        HotSalesGrid(item, navigateToMedDesc, navigateToCart)
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

package com.example.medcare.screens.homeScreen

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.medcare.R
import com.example.medcare.rtdb.RTDB
import com.example.medcare.screens.article.LatestArticle
import com.example.medcare.screens.class_objects.Hot
import com.example.medcare.screens.class_objects.bestSellingProducts
import com.example.medcare.screens.class_objects.hospitals
import com.example.medcare.screens.class_objects.lazyRow
import com.example.medcare.screens.homeScreen.homeComposables.CardServicesHomeScreen
import com.example.medcare.screens.homeScreen.homeComposables.ConsultDocComposable
import com.example.medcare.screens.homeScreen.homeComposables.HeaderBox
import com.example.medcare.screens.homeScreen.homeComposables.SearchBox
import com.example.medcare.screens.homeScreen.homeComposables.Title
import com.example.medcare.screens.homeScreen.homeComposables.categoriesHomeScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    navigateToChatDoc: () -> Unit,
    navigateToProfile: () -> Unit,
    navigateToNotifications: () -> Unit,
    navigateToCart: () -> Unit,
    navigateToHealthShop: () -> Unit,
    navigateToHospital: () -> Unit,
    navigateToArticle: () -> Unit
) {
    val rtdb = RTDB()
    var userName by remember { mutableStateOf("") }
    LaunchedEffect(Unit) {
        rtdb.FetchUserName {
            userName = it
        }
        Log.i("userNameFetch", "userName: ${userName}")
    }
    Scaffold(topBar = {
        TopAppBar(
            title = {
                Text(
                    text = "Hi, $userName",
                    color = MaterialTheme.colorScheme.onBackground,
                    style = MaterialTheme.typography.headlineLarge
                )
            },
            actions = {
                IconButton(onClick = {
                    navigateToCart()
                }) {
                    Icon(
                        painter = painterResource(R.drawable.cart),
                        contentDescription = "Cart",
                        Modifier.size(26.dp),
                        tint = MaterialTheme.colorScheme.onBackground
                    )
                }
                IconButton(onClick = {
                    navigateToNotifications()
                }) {
                    Icon(
                        painter = painterResource(R.drawable.bell),
                        contentDescription = "Bell",
                        Modifier.size(26.dp),
                        tint = MaterialTheme.colorScheme.onBackground
                    )
                }
            })
    }) { innerPadding ->
        Column(
            modifier = Modifier.padding(innerPadding)
        ) {
            Column(
                modifier = Modifier
                    .verticalScroll(rememberScrollState())
                    .fillMaxSize()
            ) {
                HeaderBox()
                Spacer(Modifier.height(20.dp))
                SearchBox()
                Spacer(Modifier.height(20.dp))
                LazyVerticalGrid(
                    columns = GridCells.Fixed(4),
                    modifier = Modifier
                        .padding(horizontal = 12.dp)
                        .height(220.dp),
                ) {
                    items(categoriesHomeScreen.servicesHomeScreen) { item ->
                        CardServicesHomeScreen(item)
                    }
                }
                Spacer(Modifier.height(30.dp))
                ConsultDocComposable( navigateToChatDoc )
                Spacer(Modifier.height(30.dp))


                Title("Chat Doctor")


                Spacer(Modifier.height(5.dp))
                LazyRow(
                    modifier = Modifier.padding(start = 26.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    items(lazyRow.doctors) { image ->
                        Image(
                            painter = painterResource(id = image),
                            contentDescription = null,
                            contentScale = ContentScale.FillBounds,
                            modifier = Modifier
                                .size(150.dp)
                                .clickable(
                                    enabled = true,
                                    onClick = {
                                        navigateToChatDoc()
                                    }
                                )
                        )
                    }
                }
                Spacer(Modifier.height(30.dp))


                Title("Best Selling Products")


                Spacer(Modifier.height(5.dp))
                LazyRow(
                    modifier = Modifier.padding(start = 26.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    items(bestSellingProducts.data) {
                        Image(
                            painter = painterResource(id = it),
                            contentDescription = null,
                            modifier = Modifier.clickable(
                                enabled = true,
                                onClick = {
                                    navigateToHealthShop()
                                }
                            )
                        )
                    }
                }
                Spacer(Modifier.height(30.dp))


                Title("Nearby Hospitals")


                Spacer(Modifier.height(5.dp))
                LazyRow(
                    modifier = Modifier.padding(start = 26.dp),
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    items(hospitals.images) {
                        Box(
                            modifier = Modifier
                                .size(180.dp)
                                .clickable(
                                    enabled = true,
                                    onClick = {
                                        navigateToHospital()
                                    })
                                .border(
                                    1.dp, color = MaterialTheme.colorScheme.outline,
                                    shape = RoundedCornerShape(4.dp)
                                )
                                .background(MaterialTheme.colorScheme.surfaceContainerHighest)
                        ) {
//                    Surface(shape = CircleShape,
//                        modifier = Modifier
//                            .offset(x = 20.dp, (-10).dp)
//                            .align(Alignment.TopEnd)
//                            .size(60.dp)) {}
                            Column(modifier = Modifier.padding(12.dp)) {
                                Image(
                                    painter = painterResource(it.img),
                                    contentDescription = null,
                                    modifier = Modifier.size(60.dp)
                                )
                                Text(
                                    it.name,
                                    color = MaterialTheme.colorScheme.onBackground,
                                    style = MaterialTheme.typography.labelLarge
                                )
                                Spacer(Modifier.height(8.dp))
                                Row(verticalAlignment = Alignment.CenterVertically) {
                                    Text(
                                        "See maps",
                                        style = MaterialTheme.typography.bodyLarge,
                                        color = MaterialTheme.colorScheme.onBackground
                                    )
                                    Icon(
                                        imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                                        contentDescription = null,
                                        tint = MaterialTheme.colorScheme.onBackground
                                    )
                                }
                            }
                        }
                    }
                }
                Spacer(Modifier.height(30.dp))


                Title("Health Article")


                Spacer(Modifier.height(10.dp))
                LazyColumn(
                    modifier = Modifier
                        .padding(horizontal = 26.dp)
                        .height(1120.dp),
                    verticalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    items(Hot.latestArticle) { item ->
                        LatestArticle(
                            item,
                            navigateToArticle
                        )
                    }
                }
            }
        }
    }
}


//@Preview(
//    showBackground = true,
//    showSystemUi = true
//)
//@Composable
//fun Test0() {
//    Column {
//        Text(
//            "Best Selling Products",
//            fontSize = 16.sp,
//            fontWeight = FontWeight.Bold,
//            modifier = Modifier.padding(start = 30.dp)
//        )
//        Spacer(Modifier.height(5.dp))
//        LazyRow(
//            modifier = Modifier.padding(start = 26.dp),
//            horizontalArrangement = Arrangement.spacedBy(8.dp)
//        ) {
//            items(bestSellingProducts.data) { it ->
//                Image(
//                    painter = painterResource(id = it),
//                    contentDescription = null
//                )
//            }
//        }
//        Spacer(Modifier.height(30.dp))
//        Text(
//            "Nearby Hospitals",
//            fontSize = 16.sp,
//            fontWeight = FontWeight.Bold,
//            modifier = Modifier.padding(start = 30.dp)
//        )
//        Spacer(Modifier.height(5.dp))
//        LazyRow(
//            modifier = Modifier.padding(start = 26.dp),
//            horizontalArrangement = Arrangement.spacedBy(12.dp)
//        ) {
//            items(hospitals.images) {
//                Box(modifier = Modifier.size(180.dp)
//                    .clickable(enabled = true,
//                        onClick = {})
//                    .border(1.dp, color = Color(0xFFC2E7D9), shape = RoundedCornerShape(4.dp))
//                ) {
////                    Surface(shape = CircleShape,
////                        modifier = Modifier
////                            .offset(x = 20.dp, (-10).dp)
////                            .align(Alignment.TopEnd)
////                            .size(60.dp)) {}
//                    Column(modifier = Modifier.padding(12.dp)) {
//                        Image(
//                            painter = painterResource(it.img),
//                            contentDescription = null,
//                            modifier = Modifier.size(60.dp)
//                        )
//                        Text(
//                            it.name,
//                            color = Color(0xFF26408B),
//                            fontSize = 16.sp,
//                            fontWeight = FontWeight.W400
//                        )
//                        Spacer(Modifier.height(8.dp))
//                        Row(verticalAlignment = Alignment.CenterVertically) {
//                            Text("See maps",
//                                color = Color(0xFF8F8F8F)
//                            )
//                            Icon(
//                                imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
//                                contentDescription = null,
//                                tint = Color(0xFF8F8F8F)
//                            )
//                        }
//                    }
//                }
//            }
//        }
//        Spacer(Modifier.height(30.dp))
//        Text("Health Article",
//            fontSize = 16.sp,
//            fontWeight = FontWeight.Bold,
//            modifier = Modifier.padding(start = 30.dp)
//        )
//        Spacer(Modifier.height(10.dp))
//        LazyColumn(modifier = Modifier.padding(horizontal = 26.dp)
//            .height(310.dp)) {
//            items(Hot.latestArticle) {
//                    item -> LatestArticle(item)
//            }
//        }
//    }
//}
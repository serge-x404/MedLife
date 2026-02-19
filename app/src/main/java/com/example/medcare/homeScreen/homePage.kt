package com.example.medcare.homeScreen

import androidx.compose.foundation.BorderStroke
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
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.medcare.R
import com.example.medcare.article.LatestArticle
import com.example.medcare.class_objects.Hot
import com.example.medcare.class_objects.Notifications
import com.example.medcare.class_objects.bestSellingProducts
import com.example.medcare.class_objects.gridData
import com.example.medcare.class_objects.hospitals
import com.example.medcare.class_objects.lazyRow
import com.example.medcare.layoutsFile.gridViewLayout

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
    Scaffold(topBar = {
        TopAppBar(
            title = {
                Text(
                    text = "Hi, serge",
                    color = MaterialTheme.colorScheme.primary,
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
                        tint = MaterialTheme.colorScheme.surfaceTint
                    )
                }
                IconButton(onClick = {
                    navigateToNotifications()
                }) {
                    Icon(
                        painter = painterResource(R.drawable.bell),
                        contentDescription = "Bell",
                        Modifier.size(26.dp),
                        tint = MaterialTheme.colorScheme.surfaceTint
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
                Box(
                    modifier = Modifier
                        .background(
                            brush = Brush.linearGradient(
                                colors = listOf(
                                    Color(0xFF2A083B), Color(0xFF152A65)
                                )
                            )
                        )
                        .fillMaxWidth()
                        .height(150.dp)
                ) {
                    Column(modifier = Modifier.padding(horizontal = 20.dp)
                        .padding(top = 20.dp)) {
                        Text(
                            text = "Experience Seamless Healthcare Management with MedLife",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = Color.White,
                        )
                        Button(
                            onClick = {
                                navigateToProfile()
                            },
                            colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primaryContainer),
                            shape = RectangleShape,
                        ) {
                            Row(verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.Center) {
                                Text(
                                    text = "Fill Your Profile Now!",
                                    color = MaterialTheme.colorScheme.onPrimaryContainer,
                                )
                                Icon(
                                    imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                                    contentDescription = "Arrow",
                                    tint = MaterialTheme.colorScheme.surfaceTint
                                )
                            }
                        }
                    }
                    Image(
                        painter = painterResource(R.drawable.doctor),
                        contentDescription = "Doctor",
                        modifier = Modifier
                            .align(Alignment.BottomEnd)
                            .size(90.dp)
                    )
                }
                Spacer(Modifier.height(30.dp))
                OutlinedTextField(
                    value = "",
                    onValueChange = {},
                    placeholder = {
                        Text(
                            "Find a doctor, medicine or health services",
                            fontSize = 12.sp
                        )
                    },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = null
                        )
                    },
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .padding(horizontal = 30.dp),
                )
                Spacer(Modifier.height(30.dp))
                LazyVerticalGrid(
                    columns = GridCells.Fixed(4),
                    modifier = Modifier
                        .padding(horizontal = 12.dp)
                        .height(220.dp),
                ) {
                    items(gridData.servicesList) { item ->
                        gridViewLayout(item)
                    }
                }
                Spacer(Modifier.height(30.dp))
                Button(
                    onClick = {
                        navigateToChatDoc()
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.secondaryContainer),
                    border = BorderStroke(width = 1.dp, color = MaterialTheme.colorScheme.surfaceTint),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(80.dp)
                        .padding(horizontal = 30.dp),
                    shape = RoundedCornerShape(10.dp)
                ) {
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.Start,
                        modifier = Modifier.weight(0.1f)
                    ) {
                        Text(
                            text = "Consult with a specialist",
                            color = MaterialTheme.colorScheme.secondary,
                            style = MaterialTheme.typography.titleMedium
                        )
                        Text(
                            text = "Promote health via chat or call",
                            color = MaterialTheme.colorScheme.secondary,
                            style = MaterialTheme.typography.labelSmall
                        )
                    }
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                        contentDescription = "Arrow Forward",
                        tint = MaterialTheme.colorScheme.surfaceTint
                    )
                }
                Spacer(Modifier.height(30.dp))
                Text(
                    text = "Chat Doctor",
                    style = MaterialTheme.typography.titleLarge,
                    color = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.padding(start = 30.dp)
                )
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
                Text(
                    "Best Selling Products",
                    style = MaterialTheme.typography.titleLarge,
                    color = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.padding(start = 30.dp)
                )
                Spacer(Modifier.height(5.dp))
                LazyRow(
                    modifier = Modifier.padding(start = 26.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    items(bestSellingProducts.data) { it ->
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
                Text(
                    "Nearby Hospitals",
                    style = MaterialTheme.typography.titleLarge,
                    color = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.padding(start = 30.dp)
                )
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
                                .border(1.dp, color = MaterialTheme.colorScheme.surfaceTint,
                                    shape = RoundedCornerShape(4.dp)
                                )
                                .background(MaterialTheme.colorScheme.secondaryContainer)
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
                                    color = MaterialTheme.colorScheme.onPrimaryContainer,
                                    style = MaterialTheme.typography.labelLarge
                                )
                                Spacer(Modifier.height(8.dp))
                                Row(verticalAlignment = Alignment.CenterVertically) {
                                    Text(
                                        "See maps",
                                        style = MaterialTheme.typography.bodyLarge,
                                        color = MaterialTheme.colorScheme.onPrimaryContainer
                                    )
                                    Icon(
                                        imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                                        contentDescription = null,
                                        tint = MaterialTheme.colorScheme.surfaceTint
                                    )
                                }
                            }
                        }
                    }
                }
                Spacer(Modifier.height(30.dp))
                Text(
                    "Health Article",
                    style = MaterialTheme.typography.titleLarge,
                    color = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.padding(start = 30.dp)
                )
                Spacer(Modifier.height(10.dp))
                LazyColumn(
                    modifier = Modifier
                        .padding(horizontal = 26.dp)
                        .height(1120.dp),
                    verticalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    items(Hot.latestArticle) { item ->
                        LatestArticle(item, navigateToArticle)
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
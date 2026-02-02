package com.example.medcare.homeScreen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.medcare.R
import com.example.medcare.layoutsFile.gridViewLayout

@OptIn(ExperimentalMaterial3Api::class)
@Preview(
    showBackground = true, showSystemUi = true
)
@Composable
fun HomeScreen() {
    Scaffold(topBar = {
        TopAppBar(title = { Text(text = "Hi") }, actions = {
            IconButton(onClick = {}) {
                Icon(
                    painter = painterResource(R.drawable.cart),
                    contentDescription = "Cart",
                    Modifier.size(26.dp)
                )
            }
            IconButton(onClick = {}) {
                Icon(
                    painter = painterResource(R.drawable.bell),
                    contentDescription = "Bell",
                    Modifier.size(26.dp)
                )
            }
        })
    }, bottomBar = {
        NavigationBar {
            NavigationBarItem(selected = true, onClick = {}, icon = {
                Icon(
                    painter = painterResource(R.drawable.home),
                    contentDescription = null,
                    modifier = Modifier.size(28.dp)
                )
            }, label = { Text(text = "Home") })
            NavigationBarItem(selected = false, onClick = {}, icon = {
                Icon(
                    painter = painterResource(R.drawable.services),
                    contentDescription = null,
                    modifier = Modifier.size(28.dp)
                )
            }, label = { Text(text = "Services")}
            )
        }
    }) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
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
                Column {
                    Text(
                        text = "Experience Seamless Healthcare Management with MediConnect",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = Color.White,
                        modifier = Modifier.padding(top = 30.dp, start = 20.dp)
                    )
                    Button(
                        onClick = {},
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF26408B)),
                        shape = RectangleShape,
                        modifier = Modifier.padding(start = 20.dp, top = 8.dp)
                    ) {
                        Text(
                            text = "Fill Your Profile Now!"
                        )
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                            contentDescription = "Arrow"
                        )
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
            TextField(
                value = "Find a doctor, medicine or health services",
                onValueChange = {},
                modifier = Modifier.align(Alignment.CenterHorizontally),
            )
            Spacer(Modifier.height(30.dp))
            LazyVerticalGrid(
                columns = GridCells.Fixed(4),
                modifier = Modifier
                    .wrapContentSize()
                    .align(Alignment.CenterHorizontally),
            ) {
                items(gridData.servicesList) { item ->
                    gridViewLayout(item)
                }
            }
            Spacer(Modifier.height(30.dp))
            Button(
                onClick = {},
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFFFFFF)),
                border = BorderStroke(width = 2.dp, color = Color(0xFFC2E7D9)),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(80.dp)
                    .padding(start = 30.dp, end = 30.dp),
                shape = RoundedCornerShape(10.dp)
            ) {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.Start,
                    modifier = Modifier.weight(0.1f)
                ) {
                    Text(
                        text = "Consult with a specialist",
                        color = Color.Black,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                    Text(
                        text = "Promote health via chat or call",
                        color = Color.Black,
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Normal
                    )
                }
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                    contentDescription = "Arrow Forward",
                    tint = Color(0xFF000000)
                )
            }
            Spacer(Modifier.height(30.dp))
            Text(
                text = "Chat Doctor",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(start = 30.dp)
            )
            Spacer(Modifier.height(5.dp))
            LazyRow(
                modifier = Modifier.padding(start = 26.dp), state = rememberLazyListState()
            ) {
                items(lazyRow.doctors) { image ->
                    Image(
                        painter = painterResource(id = image),
                        contentDescription = null,
                        contentScale = ContentScale.FillBounds,
                        modifier = Modifier
                            .padding(12.dp)
                            .size(100.dp)
                    )
                }
            }
        }
    }
}


object gridData {
    val servicesList = listOf(
        Categories("All", R.drawable.all),
        Categories("General Practitioner", R.drawable.general),
        Categories("Dentistry", R.drawable.dentist),
        Categories("Gynecology", R.drawable.gyanec),
        Categories("Ophthalmology", R.drawable.eye),
        Categories("Neurology", R.drawable.neuro),
        Categories("Otorhinolaryngology", R.drawable.ear),
        Categories("Pulmonologist", R.drawable.lungs),
    )
}

data class Categories(
    val name: String, val icon: Int
)

object lazyRow {
    val doctors = listOf(
        R.drawable.heart_specialist, R.drawable.doctor_dentist
    )
}
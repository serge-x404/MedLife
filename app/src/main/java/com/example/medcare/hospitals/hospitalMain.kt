package com.example.medcare.hospitals

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.medcare.clobs.HospitalData

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true,
    showSystemUi = true)
@Composable
fun HospitalMain() {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    TextField(
                        value = "",
                        onValueChange = {},
                        placeholder = { Text("Search product or store") },
                        leadingIcon = { Icon(
                            imageVector = Icons.Filled.Search,
                            contentDescription = null
                        )},
                        modifier = Modifier.fillMaxWidth()
                    )
                },
                navigationIcon = {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft,
                        contentDescription = null
                    )
                }
            )
        }
    ) { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)) {
            Column(modifier = Modifier.padding(horizontal = 25.dp)) {
                Spacer(Modifier.height(30.dp))
                Row(horizontalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .border(BorderStroke(1.dp, Color(0xFFE3E3E3)),
                            shape = RoundedCornerShape(8.dp))
                        .padding(15.dp)) {
                    Text(
                        text = "Search Provinces",
                        color = Color(0xFF26408B),
                        fontSize = 18.sp,
                        modifier = Modifier.weight(1f)
                    )
                    Icon(
                        imageVector = Icons.Default.KeyboardArrowDown,
                        contentDescription = null
                    )
                }
                Spacer(Modifier.height(20.dp))
                LazyVerticalGrid(GridCells.Fixed(1),
                    verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    items(HospitalData.data) {
                        item -> HospitalLayout(item)
                    }
                }
            }
        }
    }
}
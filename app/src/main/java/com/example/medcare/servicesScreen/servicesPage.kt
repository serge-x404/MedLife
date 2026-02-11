package com.example.medcare.servicesScreen

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.medcare.R
import com.example.medcare.class_objects.serviceGridData
import com.example.medcare.layoutsFile.gridViewLayout

@OptIn(ExperimentalMaterial3Api::class)
@Preview(
    showBackground = true, showSystemUi = true
)
@Composable
fun ServicesScreen(
    back: () -> Unit,
    navHostController: NavHostController
) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(title = {
                Text(
                    text = "Services", fontSize = 16.sp, fontWeight = FontWeight.SemiBold
                )
            }, navigationIcon = {
                IconButton(onClick = back) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft,
                        contentDescription = null
                    )
                }
            })
        }) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
        ) {
            Box(Modifier.fillMaxSize()) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    LazyVerticalGrid(
                        columns = GridCells.Fixed(4),
                        modifier = Modifier.height(220.dp)
                    ) {
                        items(serviceGridData.serviceImages) { item ->
                            gridViewLayout(item, navHostController)
                        }
                    }
                }
            }
        }
    }
}
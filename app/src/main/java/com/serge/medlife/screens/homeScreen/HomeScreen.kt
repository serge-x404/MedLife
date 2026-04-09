package com.serge.medlife.screens.homeScreen

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.CircularProgressIndicator
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.serge.medlife.R
import com.serge.medlife.network.NoInternet
import com.serge.medlife.network.isInternetAvailable
import com.serge.medlife.rtdb.DoctorDetailsDTO
import com.serge.medlife.rtdb.RTDB
import com.serge.medlife.screens.homeScreen.homeComposables.CardServicesHomeScreen
import com.serge.medlife.screens.homeScreen.homeComposables.CategoriesHomeScreen
import com.serge.medlife.screens.homeScreen.homeComposables.HeaderBox
import com.serge.medlife.screens.homeScreen.homeComposables.HomeCard
import com.serge.medlife.screens.homeScreen.homeComposables.HomeServiceCard

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    navigateToConsultDoc: (String) -> Unit,
    navigateToChatDoc: () -> Unit,
    navigateToNotifications: () -> Unit,
    navigateToCart: () -> Unit,
    navigateToHealthShop: () -> Unit,
    navigateToHospital: () -> Unit,
    navigateToArticle: () -> Unit,
    navigateToCategoryDoc: (String) -> Unit
) {
    val context = LocalContext.current

    var isConnected by remember { mutableStateOf(isInternetAvailable(context)) }

    val homeCards = listOf(
        HomeCard(
            title = "Pharmacy",
            subtitle = "Look for medicines",
            image = R.drawable.pill,
            onClick = navigateToHealthShop
        ),
        HomeCard(
            title = "Nearby Hospital",
            subtitle = "Find hospitals nearby",
            image = R.drawable.hospital_new,
            onClick = navigateToHospital
        )
    )

    LaunchedEffect(Unit) {
        isConnected = isInternetAvailable(context)
    }

    if (!isConnected) {
        NoInternet(
            onRetry = { isConnected = isInternetAvailable(context) }
        )
    }
    else {

        val rtdb = RTDB()
        var userName by remember { mutableStateOf("") }

        var selectedCategory by remember { mutableStateOf("All") }
        var doctorList by remember { mutableStateOf<List<DoctorDetailsDTO>>(emptyList()) }
        var isLoading by remember { mutableStateOf(true) }


        LaunchedEffect(Unit) {
            rtdb.fetchUserName {
                userName = it
                Log.i("fetchedData", "userName: $userName")
            }
            rtdb.fetchDoctorInfo {
                doctorList = it
                isLoading = false
                Log.i("fetchedData", "$doctorList")
            }
        }

        if (isLoading) {
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                CircularProgressIndicator(
                    color = MaterialTheme.colorScheme.primary
                )
            }
        }
        else {
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
                        IconButton(
                            onClick = navigateToCart
                        ) {
                            Icon(
                                imageVector = Icons.Default.ShoppingCart,
                                contentDescription = null,
                                tint = MaterialTheme.colorScheme.onBackground
                            )
                        }
                    }
                )
            }) { innerPadding ->
                Column(
                    modifier = Modifier
                        .padding(innerPadding)
                        .padding(bottom = 86.dp)
                        .background(MaterialTheme.colorScheme.background)
                ) {
                    Column(
                        modifier = Modifier
                            .verticalScroll(rememberScrollState())
                            .fillMaxSize()
                    ) {
                        HeaderBox(navigateToChatDoc)
                        Spacer(Modifier.height(20.dp))
                        LazyVerticalGrid(
                            columns = GridCells.Fixed(4),
                            modifier = Modifier
                                .padding(horizontal = 12.dp)
                                .height(210.dp),
                            horizontalArrangement = Arrangement.spacedBy(12.dp),
                            verticalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            items(CategoriesHomeScreen.servicesHomeScreen) { item ->
                                CardServicesHomeScreen(
                                    item,
                                    navigateToCategoryDoc
                                )
                            }
                        }

                        Spacer(Modifier.height(30.dp))
                        LazyVerticalGrid(
                            GridCells.Fixed(2),
                            verticalArrangement = Arrangement.spacedBy(12.dp),
                            horizontalArrangement = Arrangement.spacedBy(12.dp),
                            modifier = Modifier
                                .padding(horizontal = 12.dp)
                                .height(250.dp)
                        ) {
                           items(homeCards) {
                               HomeServiceCard(it)
                           }
                        }
//                        PharmacyComposable(navigateToHealthShop)
//
//                        Spacer(Modifier.height(30.dp))
//
//                        NearbyHospitalComposable(navigateToHospital)
//
//                        Spacer(Modifier.height(30.dp))
//
//                        ChatDocComposable { navigateToChatDoc() }
//
//                        Spacer(Modifier.height(6.dp))
                    }
                }
            }
        }
    }
}
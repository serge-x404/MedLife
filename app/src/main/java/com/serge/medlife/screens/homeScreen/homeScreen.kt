package com.serge.medlife.screens.homeScreen

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.serge.medlife.R
import com.serge.medlife.network.NoInternet
import com.serge.medlife.network.isInternetAvailable
import com.serge.medlife.rtdb.DoctorDetailsDTO
import com.serge.medlife.rtdb.RTDB
import com.serge.medlife.screens.homeScreen.homeComposables.CardServicesHomeScreen
import com.serge.medlife.screens.homeScreen.homeComposables.CategoriesHomeScreen
import com.serge.medlife.screens.homeScreen.homeComposables.ConsultDocComposable
import com.serge.medlife.screens.homeScreen.homeComposables.HeaderBox
import com.serge.medlife.screens.homeScreen.homeComposables.NearbyHospitalComposable
import com.serge.medlife.screens.homeScreen.homeComposables.PharmacyComposable

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    navigateToChatDoc: (String) -> Unit,
    navigateToProfile: () -> Unit,
    navigateToNotifications: () -> Unit,
    navigateToCart: () -> Unit,
    navigateToHealthShop: () -> Unit,
    navigateToHospital: () -> Unit,
    navigateToArticle: () -> Unit,
    navigateToCategoryDoc: (String) -> Unit
) {
    val context = LocalContext.current
    val networkObserver = remember { isInternetAvailable(context) }

    var isConnected by remember { mutableStateOf(networkObserver) }

    if (!isConnected) {
        NoInternet(
            onRetry = { isConnected = networkObserver }
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
                            onClick = {
                                navigateToCart()
                            }
                        ) {
                            Icon(
                                painter = painterResource(R.drawable.cart),
                                contentDescription = "Cart",
                                Modifier.size(26.dp),
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
                ) {
                    Column(
                        modifier = Modifier
                            .verticalScroll(rememberScrollState())
                            .fillMaxSize()
                    ) {
                        HeaderBox()
                        Spacer(Modifier.height(20.dp))
                        LazyVerticalGrid(
                            columns = GridCells.Fixed(4),
                            modifier = Modifier
                                .padding(horizontal = 12.dp)
                                .height(220.dp),
                        ) {
                            items(CategoriesHomeScreen.servicesHomeScreen) { item ->
                                CardServicesHomeScreen(
                                    item,
                                    navigateToCategoryDoc
                                )
                            }
                        }

                        Spacer(Modifier.height(30.dp))

                        ConsultDocComposable { navigateToChatDoc("All") }

                        Spacer(Modifier.height(30.dp))

                        PharmacyComposable(navigateToHealthShop)

                        Spacer(Modifier.height(30.dp))

                        NearbyHospitalComposable(navigateToHospital)

                        Spacer(Modifier.height(6.dp))
                    }
                }
            }
        }
    }
}
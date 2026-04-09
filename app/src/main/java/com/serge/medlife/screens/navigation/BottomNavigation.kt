package com.serge.medlife.screens.navigation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.serge.medlife.network.NoInternet
import com.serge.medlife.network.isInternetAvailable
import com.serge.medlife.screens.class_objects.ServiceGridData
import com.serge.medlife.screens.layoutsFile.GridViewLayout
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomNavigation(navController: NavController) {

    val context = LocalContext.current
    val networkObserver = remember { isInternetAvailable(context) }

    var isConnected by remember { mutableStateOf(networkObserver) }

    if (!isConnected) {
        NoInternet(
            onRetry = { isConnected = networkObserver }
        )
    }
    else {
        val navItems = listOf(NavItems.Home, NavItems.Services, NavItems.History, NavItems.Profile)

        val backStackEntry by navController.currentBackStackEntryAsState()

        val currentRoute = backStackEntry?.destination?.route

        val sheetState = rememberModalBottomSheetState(
            skipPartiallyExpanded = true
        )
        val scope = rememberCoroutineScope()
        var showModalBottomSheet by remember { mutableStateOf(false) }

        if (showModalBottomSheet) {
            ModalBottomSheet(
                onDismissRequest = {
                    showModalBottomSheet = false

                    // Temporary removal of Services ModalSheet redirect to Home

//                navController.navigate(NavRoute.Main.path) {
//                    launchSingleTop = true
//                    restoreState = true
//                    popUpTo(navController.graph.findStartDestination().id) {
//                        saveState = true
//                    }
//                }
                },
                sheetState = sheetState,
                modifier = Modifier
                    .wrapContentHeight()
            ) {
                Box {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(
                            "Services",
                            style = MaterialTheme.typography.titleMedium,
                            color = MaterialTheme.colorScheme.onBackground
                        )
                        LazyVerticalGrid(
                            columns = GridCells.Fixed(2),
                            modifier = Modifier
                                .padding(16.dp)
                        ) {
                            items(ServiceGridData.serviceImages) { item ->
                                GridViewLayout(
                                    item,
                                    onNavigate = {
                                        scope.launch {
                                            sheetState.hide()
                                            showModalBottomSheet = false
                                        }
                                        navController.navigate(it) {
                                            launchSingleTop = true
                                        }
                                    }
                                )
                            }
                        }
                    }
                }
            }

        }

        NavigationBar(
            tonalElevation = 4.dp,
            containerColor = MaterialTheme.colorScheme.surfaceContainer
        ) {
            navItems.forEachIndexed { index, items ->
                val isSelected = currentRoute?.startsWith(items.path) == true
                NavigationBarItem(
                    selected = isSelected,
                    onClick = {
                        if (items == NavItems.Services) {
                            showModalBottomSheet = true
                        } else {
                            showModalBottomSheet = false
                            if (currentRoute != items.path) {
                                navController.navigate(items.path) {
                                    launchSingleTop = true
                                    restoreState = true
                                    popUpTo(0) {
                                        saveState = true
                                    }
                                }
                            }
                        }
                    },
                    icon = {
                        val icon = if (isSelected) items.selectedIcon else items.icon

                        Image(
                            painter = painterResource(icon),
                            contentDescription = null,
                            modifier = Modifier.size(24.dp),
                            colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onBackground)
                        )
                    },
                    label = {
                        Text(
                            items.label,
                            color = MaterialTheme.colorScheme.onBackground
                        )
                    }
                )
            }
        }
    }
}
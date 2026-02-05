package com.example.medcare.navigation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun BottomNavigation(navController: NavController) {
    val navItems = listOf(NavItems.Home, NavItems.Services, NavItems.History, NavItems.Profile)

    val backStackEntry by navController.currentBackStackEntryAsState()

    var currentRoute = backStackEntry?.destination?.route

    NavigationBar(
        tonalElevation = 4.dp,
        containerColor = MaterialTheme.colorScheme.surfaceContainer
    ) {
        navItems.forEachIndexed { index, items ->
            val isSelected = currentRoute?.startsWith(items.path) == true
            NavigationBarItem(
                selected = isSelected,
                onClick = {
                    if(currentRoute != items.path) {
                        navController.navigate(items.path) {
                            launchSingleTop = true
                            restoreState = true
                            popUpTo(navController.graph.findStartDestination().id) {
                                saveState = true
                            }
                        }
                    }
                },
                icon = {
                    val icon = if(isSelected) items.selectedIcon else items.icon

                    Image(
                        painter = painterResource(icon),
                        contentDescription = null,
                        modifier = Modifier.size(24.dp)
                    )
                },
                label = {
                    Text(
                        items.label
                    )
                }
            )
        }
    }
}
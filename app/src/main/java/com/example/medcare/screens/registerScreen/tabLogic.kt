package com.example.medcare.screens.registerScreen

import android.content.SharedPreferences
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SecondaryTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp

enum class Tabs { PATIENT, DOCTOR }

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TabLogic(
    navigateToLoginScreen: () -> Unit,
    navigateToHomeScreen: () -> Unit,
    navigateToConfirmationScreen: () -> Unit,
    sharedPreferences: SharedPreferences
) {
    var storeIndex by remember { mutableIntStateOf(0) }
    Scaffold(
        contentWindowInsets = WindowInsets(0.dp)
    ) {
        Column(modifier = Modifier.padding(it)) {
            SecondaryTabRow(
                selectedTabIndex = storeIndex, tabs = {
                    val context = LocalContext.current

                    Tabs.entries.forEachIndexed { index, tabs ->
                        Tab(
                            selected = storeIndex == index,
                            onClick = {
                                storeIndex = index
                                Toast.makeText(context, tabs.name, Toast.LENGTH_SHORT).show()
                            },
                            text = {
                                Text(
                                    tabs.name
                                )
                            },
                            modifier = Modifier.background(MaterialTheme.colorScheme.surfaceContainerHighest)
                        )
                    }
                }
            )
            when (storeIndex) {
                0 -> PatientRegister(
                    navigateToLoginScreen,
                    navigateToHomeScreen,
                    sharedPreferences
                )
                else -> DoctorRegister(
                    navigateToLoginScreen,
                    navigateToHomeScreen,
                    navigateToConfirmationScreen,
                    sharedPreferences
                )
            }
        }
    }
}
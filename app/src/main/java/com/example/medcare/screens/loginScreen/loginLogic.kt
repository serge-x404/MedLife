package com.example.medcare.screens.loginScreen

import android.content.SharedPreferences
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import com.example.medcare.screens.registerScreen.Tabs


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginLogic(
    navigateToHomeScreen: () -> Unit,
    navigateToRegister: () -> Unit,
    navigateToDoctorHome: () -> Unit,
    sharedPreferences: SharedPreferences
) {
    var storeLoginIndex by remember { mutableIntStateOf(0) }
    Scaffold(contentWindowInsets = WindowInsets(0.dp)) {
        Column(modifier = Modifier.padding(it)) {
            SecondaryTabRow(
                selectedTabIndex = storeLoginIndex, tabs = {
                    val context = LocalContext.current


                    Tabs.entries.forEachIndexed { index, tabs ->
                        Tab(
                            selected = storeLoginIndex == index,
                            onClick = {
                                storeLoginIndex = index
                                Toast.makeText(context, tabs.name, Toast.LENGTH_SHORT).show()
                            },
                            text = {
                                Text(
                                    tabs.name
                                )
                            },
                            modifier = Modifier
                                .background(MaterialTheme.colorScheme.surfaceContainerHighest)
                                .border(2.dp, MaterialTheme.colorScheme.surfaceContainerHighest)
                        )
                    }
                }
            )
            when(storeLoginIndex) {
                0 -> PatientLogin(
                    navigateToHomeScreen,
                    navigateToRegister,
                    sharedPreferences
                )
                else -> DoctorLogin(
                    navigateToRegister,
                    navigateToDoctorHome,
                    sharedPreferences
                )
            }
        }
    }
}
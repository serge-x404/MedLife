package com.example.medcare.registerScreen

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
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

enum class Tabs { PHONE, EMAIL }

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TabLogic(
    navigateToHomeScreen: () -> Unit
) {
    var storeIndex by remember { mutableIntStateOf(0) }
    Scaffold(
        contentWindowInsets = WindowInsets(0.dp)
    ) {
        Column(modifier = Modifier.padding(it)) {
            SecondaryTabRow(
                selectedTabIndex = storeIndex, tabs = {

                    Tabs.entries.forEachIndexed { index, tabs ->
                        Tab(selected = storeIndex == index,
                            onClick = { storeIndex = index}, text = {
                            Text(
                                tabs.name
                            )
                        },
                            modifier = Modifier.background(MaterialTheme.colorScheme.surfaceContainerHighest)
                        )
                    }
                }
            )
            when(storeIndex) {
                0 -> PhoneNumberRegister(navigateToHomeScreen)
                else -> EmailRegister (navigateToHomeScreen)
            }
        }
    }
}
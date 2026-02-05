package com.example.medcare.history

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SecondaryTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.Modifier.Companion
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun HistoryLogic() {


    var storeHistoryIndex by remember { mutableIntStateOf(0) }
    var isCompleted by remember { mutableStateOf(false) }

    Scaffold { it ->
        Column(modifier = Modifier.padding(it)) {
            SecondaryTabRow(
                modifier = Modifier.padding(6.dp),
                indicator = {
                    TabRowDefaults.SecondaryIndicator(
                        color = Color(0xFF26408B),
                        modifier = Modifier.tabIndicatorOffset(
                            storeHistoryIndex,
                            matchContentSize = false
                        )
                    )
                },
                selectedTabIndex = storeHistoryIndex,
                tabs = {
                    HistoryTabs.entries.forEachIndexed {

                            index, tabs ->
                        Tab(
                            selected = storeHistoryIndex == index,
                            onClick = {
                                storeHistoryIndex = index
                                if(index == 0) isCompleted = false
                                else isCompleted = true
                            }, text = {
                                Text(
                                    tabs.name
                                )
                            }
                        )
                    }

                }
            )
            when (storeHistoryIndex) {
                0 -> UpcomingAppointment(isCompleted)
                else -> UpcomingAppointment(isCompleted)
            }
        }
    }
}
package com.example.medcare.loginScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SecondaryTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.medcare.registerScreen.Tabs


@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true,
    showSystemUi = true)
@Composable
fun LoginLogic() {
    var storeLoginIndex by remember { mutableIntStateOf(0) }
    Scaffold {it ->
        Column(modifier = Modifier.padding(it)) {
            SecondaryTabRow(
                selectedTabIndex = storeLoginIndex, tabs = {

                    Tabs.entries.forEachIndexed { index, tabs ->
                        Tab(selected = storeLoginIndex == index,
                            onClick = {storeLoginIndex = index}, text = {
                                Text(
                                    tabs.name
                                )
                            }
                        )
                    }
                }
            )
            when(storeLoginIndex) {
                0 -> PhoneNumberLogin()
                else -> EmailLogin()
            }
        }
    }
}
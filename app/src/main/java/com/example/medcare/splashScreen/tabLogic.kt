package com.example.medcare.splashScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
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
import androidx.compose.ui.tooling.preview.Preview

enum class Tabs { PHONE, EMAIL }

@Preview(
    showBackground = true, showSystemUi = true
)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TabLogic() {
    var storeIndex by remember { mutableIntStateOf(0) }
    Scaffold {
        Column(modifier = Modifier.padding(it)) {
            SecondaryTabRow(
                selectedTabIndex = storeIndex, tabs = {

                    Tabs.entries.forEachIndexed { index, tabs ->
                        Tab(selected = storeIndex == index,
                            onClick = { storeIndex = index}, text = {
                            Text(
                                tabs.name
                            )
                        })
                    }
                    when(storeIndex) {
                        0 -> PhoneNumberRegister()
                        else -> EmailRegister ()
                    }
                })
        }
    }
}
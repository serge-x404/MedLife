package com.example.medcare.splashScreen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview(
    showBackground = true, showSystemUi = true
)
@Composable
fun Register_page() {
    Box(modifier = Modifier
        .fillMaxSize()
        .padding(18.dp)) {
        Column() {
            IconButton(
                onClick = {
                    //
                }) {
                Icon(
                    imageVector = Icons.Default.KeyboardArrowLeft,
                    contentDescription = "Back Button"
                )
            }
            Spacer(Modifier.height(5.dp))
            Text(
                text = "Complete Personal Identification",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(start = 15.dp)
            )
            Spacer(Modifier.height(10.dp))
            Text(
                text = "You can connect with all healthcare facilities you've previously visited.",
                modifier = Modifier.padding(start = 15.dp)
            )
            Spacer(Modifier.height(10.dp))
            TabLogic()
        }
    }
}
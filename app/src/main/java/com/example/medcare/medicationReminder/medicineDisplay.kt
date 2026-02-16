package com.example.medcare.medicationReminder

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.medcare.R

@Composable
fun DisplayMedicine(
    medicine: List<String>
) {
    if (medicine.isEmpty()) {
        Image(
            painter = painterResource(R.drawable.reminder_med),
            contentDescription = null,
            modifier = Modifier.size(160.dp)
        )
        Spacer(Modifier.height(8.dp))
        Text(
            "No medication scheduled for today",
            fontWeight = FontWeight.SemiBold,
            fontSize = 16.sp
        )
        Spacer(Modifier.height(4.dp))
        Text(
            "Click add medicine below to add a schedule",
            fontWeight = FontWeight.Normal,
            color = Color(0xFF4D4D4D)
        )
    }
    else {
        Column(
            modifier = Modifier.padding(horizontal = 12.dp)
        ) {
            medicine.forEach {
                medicine -> MedicineCard(medicine)
            }
        }
    }
}



@Composable
fun MedicineCard(medicine: String) {
    Card {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier
                .fillMaxWidth()
                .border(1.dp, color = Color(0xFFE3E3E3))
                .padding(10.dp)
        ) {
            Image(
                painter = painterResource(R.drawable.paracetamol),
                contentDescription = null,
                modifier = Modifier.size(34.dp)
            )
            Spacer(Modifier.width(10.dp))
            Column {
                Text(
                    medicine,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 14.sp
                )
                Spacer(Modifier.height(4.dp))
                Text(
                    medicine,
                    fontSize = 14.sp
                )
            }
        }
    }
}
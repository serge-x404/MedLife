package com.example.medcare.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.medcare.class_objects.TransactionHelper

@Composable
fun TransactionCardLayout(transactionHelper: TransactionHelper) {
    Card(colors = CardDefaults.cardColors(containerColor = Color.Black),
        modifier = Modifier.fillMaxWidth()) {
        Row(modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(modifier = Modifier
                .background(color = Color.White)
                .size(60.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(transactionHelper.date,
                    fontSize = 16.sp,
                    color = Color(0xFF8F8F8F)
                )
                Spacer(Modifier.height(6.dp))
                Text(transactionHelper.day,
                    fontSize = 16.sp,
                    color = Color(0xFF8F8F8F)
                )
            }
            Spacer(Modifier.width(6.dp))
            Column(modifier = Modifier.weight(1f)) {
                Text(transactionHelper.tName,
                    color = Color.White,
                    fontWeight = FontWeight.SemiBold
                )
                Spacer(Modifier.height(12.dp))
                Text(transactionHelper.tAmt,
                    color = Color(0xFF26408B),
                    textDecoration = TextDecoration.Underline
                )
            }
            AssistChip(
                onClick = {},
                label = { Text(transactionHelper.aChipData) },
                colors = AssistChipDefaults.assistChipColors(
                    Color(0xFFC2E7D9),
                    Color(0xFF26408B)
                ),
                modifier = Modifier.align(Alignment.Top)
            )
        }
    }
}
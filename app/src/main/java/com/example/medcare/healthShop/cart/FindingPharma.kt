package com.example.medcare.healthShop.cart

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.medcare.R

@Preview(showBackground = true,
    showSystemUi = true)
@Composable
fun FindingPharmacy(
    navigateToEmptyCart: () -> Unit
) {
    Column(horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .padding(horizontal = 15.dp)
            .fillMaxSize()) {
        Image(
            painter = painterResource(R.drawable.pharmacy),
            contentDescription = null,
            modifier = Modifier.size(200.dp)
                .clickable(
                    onClick = {
                        navigateToEmptyCart()
                    }
                )
        )
        Text(
            text = "Finding Nearest Pharmacy",
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(Modifier.height(20.dp))
        Row() {
            Image(
                painter = painterResource(R.drawable.plus_vector),
                contentDescription = null,
                modifier = Modifier.size(18.dp)
            )
            Spacer(Modifier.width(16.dp))
            Text(
                text = "Pricing, product availability, and shipping methods may differ.",
                fontSize = 16.sp
            )
        }
        Spacer(Modifier.height(8.dp))
        Row() {
            Image(
                painter = painterResource(R.drawable.plus_vector),
                contentDescription = null,
                modifier = Modifier.size(18.dp)
            )
            Spacer(Modifier.width(16.dp))
            Text(
                text = "Select the delivery method that fits your requirements. " +
                        "Same-Day Delivery and Next-Day Delivery",
                fontSize = 16.sp
            )
        }
    }
}
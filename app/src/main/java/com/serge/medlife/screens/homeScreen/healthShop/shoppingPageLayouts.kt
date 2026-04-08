package com.serge.medlife.screens.homeScreen.healthShop

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.serge.medlife.R
import com.serge.medlife.roomdb.CartItems

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HotSalesGrid(
    cartItems: CartItems,
    navigateToMedDesc: () -> Unit,
    navigateToCart: () -> Unit
) {
    val sheetState = rememberModalBottomSheetState()
    var stateChange by remember { mutableStateOf(false) }
    var addSub by remember { mutableIntStateOf(1) }
    Card(
        modifier = Modifier
            .clickable { navigateToMedDesc() },
        colors = CardDefaults.cardColors(MaterialTheme.colorScheme.surfaceContainerHighest),
        border = BorderStroke(2.dp, MaterialTheme.colorScheme.outlineVariant),
        elevation = CardDefaults.elevatedCardElevation(2.dp),
    ) {
        Column(Modifier.padding(10.dp)) {
            Image(
                painter = painterResource(cartItems.image),
                contentDescription = null,
                Modifier.size(100.dp)
            )
            Spacer(Modifier.height(8.dp))
            Text(
                text = cartItems.medicineName,
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.onBackground
            )
            Text(
                text = "Per Strip",
                style = MaterialTheme.typography.labelMedium,
                color = MaterialTheme.colorScheme.onBackground
            )
            Spacer(Modifier.height(20.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column {
                    Text(
                        text = "Starts from",
                        style = MaterialTheme.typography.labelMedium,
                        color = MaterialTheme.colorScheme.onBackground,
                    )
                    Text(
                        text = "${cartItems.price}",
                        color = MaterialTheme.colorScheme.onBackground,
                        style = MaterialTheme.typography.titleMedium
                    )
                }
                Spacer(Modifier.width(6.dp))
                Button(
                    onClick = { stateChange = true },
                    colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.tertiaryContainer),
                    border = BorderStroke(2.dp, MaterialTheme.colorScheme.outlineVariant)
                ) {
                    Text(
                        text = "Add",
                        style = MaterialTheme.typography.labelMedium,
                        color = MaterialTheme.colorScheme.onSecondaryContainer
                    )
                }
            }
        }
    }
}


@Composable
fun CartCard(cartItems: CartItems) {
    Card(
        colors = CardDefaults.cardColors(MaterialTheme.colorScheme.surfaceContainerHighest),
        border = BorderStroke(width = 2.dp, MaterialTheme.colorScheme.outlineVariant)
    ) {
        Row(modifier = Modifier.padding(16.dp)) {
            Image(
                painter = painterResource(cartItems.image),
                contentDescription = null,
                modifier = Modifier.size(60.dp)
            )
            Spacer(Modifier.width(4.dp))
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = cartItems.medicineName,
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.onBackground
                )
                Spacer(Modifier.height(2.dp))
                Text(
                    text = stringResource(R.string.strip),
                    style = MaterialTheme.typography.titleSmall,
                    color = MaterialTheme.colorScheme.onBackground
                )
                Spacer(Modifier.height(8.dp))
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = "Starts from:",
                        style = MaterialTheme.typography.labelMedium,
                        color = MaterialTheme.colorScheme.onBackground,
                    )
                    Spacer(Modifier.width(6.dp))
                    Text(
                        text = "${cartItems.price}",
                        color = MaterialTheme.colorScheme.onBackground,
                        style = MaterialTheme.typography.titleMedium
                    )
                }
            }
        }
    }
}
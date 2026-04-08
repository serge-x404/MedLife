package com.serge.medlife.screens.homeScreen.healthShop.cart

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import com.serge.medlife.R
import com.serge.medlife.screens.homeScreen.healthShop.CartCard
import com.serge.medlife.viewmodel.CartViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Cart(
    back: () -> Unit,
    navigateToHealthShop: () -> Unit,
    cartViewModel: CartViewModel = hiltViewModel()
) {
    val cartItems by cartViewModel.allCartItems.collectAsState(emptyList())
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "Cart",
                        color = MaterialTheme.colorScheme.onBackground,
                        style = MaterialTheme.typography.titleMedium
                    )
                },
                navigationIcon = {
                    IconButton(
                        onClick = back
                    ) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft,
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.onBackground
                        )
                    }
                }
            )
        }
    ) { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)) {
            Box(
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .fillMaxSize()
            ) {
                if (cartItems.isEmpty()) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center,
                        modifier = Modifier.fillMaxSize()
                    ) {
                        Image(
                            painter = painterResource(R.drawable.empty_cart),
                            contentDescription = null,
                            modifier = Modifier.size(150.dp)
                        )
                        Spacer(Modifier.height(20.dp))
                        Text(
                            text = "Oops! Your shopping cart is still empty",
                            style = MaterialTheme.typography.labelLarge,
                            color = MaterialTheme.colorScheme.onBackground
                        )
                    }
                }
                else {
                    Column {
                        LazyVerticalGrid(
                            GridCells.Fixed(1),
                            verticalArrangement = Arrangement.spacedBy(12.dp)
                        ) {
                            items(cartItems) { item ->
                                CartCard(item)
                            }
                        }
                    }
                }
                if (cartItems.isEmpty()) {
                    Button(
                        onClick = { navigateToHealthShop() },
                        colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.secondary),
                        border = BorderStroke(
                            2.dp,
                            MaterialTheme.colorScheme.outlineVariant
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .align(Alignment.BottomCenter)
                    ) {
                        Text(
                            text = "Add Medicines",
                            style = MaterialTheme.typography.labelMedium,
                            color = MaterialTheme.colorScheme.onTertiary
                        )
                    }
                }
                else {
                    Column(
                        modifier = Modifier
                            .fillMaxSize(),
                        verticalArrangement = Arrangement.Bottom
                    ) {
                        HorizontalDivider()
                        Spacer(Modifier.height(8.dp))
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                        ) {
                            Text(
                                "Grand Total:",
                                style = MaterialTheme.typography.titleSmall,
                                color = MaterialTheme.colorScheme.onBackground,
                                modifier = Modifier
                                    .weight(1f)
                            )
                            Text(
                                text = "${cartViewModel.totalAmount(cartItems)}",
                                style = MaterialTheme.typography.titleSmall,
                                color = MaterialTheme.colorScheme.onBackground
                            )

                        }
                        HorizontalDivider()
                        Spacer(Modifier.height(8.dp))
                        Button(
                            onClick = { navigateToHealthShop() },
                            colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.primaryContainer),
                            border = BorderStroke(1.dp, MaterialTheme.colorScheme.outline),
                            modifier = Modifier
                                .fillMaxWidth()
                        ) {
                            Text(
                                text = "Add other medicines",
                                style = MaterialTheme.typography.labelMedium,
                                color = MaterialTheme.colorScheme.onPrimaryContainer
                            )
                        }
                        Button(
                            onClick = {
                                cartViewModel.clearCart()
                            },
                            colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.primary),
                            border = BorderStroke(1.dp, MaterialTheme.colorScheme.outline),
                            modifier = Modifier
                                .fillMaxWidth()
                        ) {
                            Text(
                                text = "Checkout",
                                style = MaterialTheme.typography.labelMedium,
                                color = MaterialTheme.colorScheme.onPrimary
                            )
                        }
                    }
                }
            }
        }
    }
}
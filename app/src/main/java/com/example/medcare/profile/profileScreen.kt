package com.example.medcare.profile

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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.medcare.R
import kotlin.math.sin

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(
    navigateToPresHist: () -> Unit,
    navigateToHealthHist: () -> Unit,
    navigateToTransactions: () -> Unit,
    navigateToAccSettings: () -> Unit,
    navigateToNotifications: () -> Unit,
    navigateToPharmaAdmin: () -> Unit,
    back: () -> Unit
) {
    Scaffold(
        topBar = { TopAppBar(
            title = { Text("My Profile",
                fontWeight = FontWeight.Normal,
                fontSize = 16.sp
            ) },
            navigationIcon = { IconButton(
                onClick = back
            ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft,
                    contentDescription = null
                )
            } }
        ) }
    ) { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)) {
            Column(modifier = Modifier
                .padding(horizontal = 12.dp)
                .fillMaxWidth()
                .verticalScroll(rememberScrollState())) {
                Card(modifier = Modifier.fillMaxWidth(),
                    colors = CardDefaults.cardColors(containerColor = Color.White)) {
                    Row(verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(12.dp)) {
                        Image(
                            painter = painterResource(R.drawable.lorenzo),
                            contentDescription = null,
                            modifier = Modifier.size(60.dp)
                        )
                        Spacer(Modifier.width(8.dp))
                        Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                            Text(
                                text = "userName",
                                fontSize = 16.sp,
                                fontWeight = FontWeight.SemiBold
                            )
                            Row {
                                Icon(
                                    imageVector = Icons.Default.Email,
                                    contentDescription = null,
                                    modifier = Modifier.size(20.dp)
                                )
                                Spacer(Modifier.width(6.dp))
                                Text(
                                    "lorenzoricci@example.com",
                                    color = Color(0xFF4D4D4D)
                                )
                            }
                            Row {
                                Icon(
                                    imageVector = Icons.Default.Phone,
                                    contentDescription = null,
                                    modifier = Modifier.size(20.dp)
                                )
                                Spacer(Modifier.width(6.dp))
                                Text(
                                    "+39 1234567890",
                                    color = Color(0xFF4D4D4D)
                                )
                            }
                        }
                    }
                }
                Spacer(Modifier.height(40.dp))
                Text("Menu",
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 16.sp,
                    color = Color(0xFF4D4D4D)
                )
                Card(modifier = Modifier.fillMaxWidth(),
                    colors = CardDefaults.cardColors(containerColor = Color.White)) {
                    Row(verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(12.dp)
                            .fillMaxWidth()
                            .clickable(
                                onClick = {navigateToPresHist()}
                            )) {
                        Image(
                            painter = painterResource(R.drawable.book),
                            contentDescription = null,
                            modifier = Modifier.size(30.dp)
                        )
                        Spacer(Modifier.width(8.dp))
                        Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                            Text("Prescription History",
                                fontSize = 16.sp,
                                fontWeight = FontWeight.SemiBold
                            )
                            Text("Check out the full prescription history here",
                                color = Color(0xFF4D4D4D)
                            )
                        }
                    }
                    Row(verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(12.dp)
                            .fillMaxWidth()
                            .clickable(
                                onClick = {navigateToHealthHist()}
                            )) {
                        Image(
                            painter = painterResource(R.drawable.heart),
                            contentDescription = null,
                            modifier = Modifier.size(30.dp)
                        )
                        Spacer(Modifier.width(8.dp))
                        Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                            Text("Health History",
                                fontSize = 16.sp,
                                fontWeight = FontWeight.SemiBold
                            )
                            Text("Check details regarding your medical history",
                                color = Color(0xFF4D4D4D)
                            )
                        }
                    }
                    Row(verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(12.dp)
                            .fillMaxWidth()
                            .clickable(
                                onClick = {navigateToTransactions()}
                            )) {
                        Image(
                            painter = painterResource(R.drawable.wallet),
                            contentDescription = null,
                            modifier = Modifier.size(30.dp)
                        )
                        Spacer(Modifier.width(8.dp))
                        Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                            Text("Transactions",
                                fontSize = 16.sp,
                                fontWeight = FontWeight.SemiBold
                            )
                            Text("Look back at your previous transactions",
                                color = Color(0xFF4D4D4D)
                            )
                        }
                    }
                }
                Spacer(Modifier.height(40.dp))
                Text("General Information",
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 16.sp,
                    color = Color(0xFF4D4D4D)
                )
                Card(modifier = Modifier.fillMaxWidth(),
                    colors = CardDefaults.cardColors(containerColor = Color.White)) {
                    Row(verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(12.dp)
                            .fillMaxWidth()
                            .clickable(
                                onClick = {navigateToAccSettings()}
                            )) {
                        Image(
                            painter = painterResource(R.drawable.gear),
                            contentDescription = null,
                            modifier = Modifier.size(30.dp)
                        )
                        Spacer(Modifier.width(8.dp))
                        Text("Account Settings",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.SemiBold
                        )
                    }
                    Row(verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(12.dp)
                            .fillMaxWidth()
                            .clickable(
                            onClick = {navigateToNotifications()}
                        )) {
                        Image(
                            painter = painterResource(R.drawable.bell),
                            contentDescription = null,
                            colorFilter = ColorFilter.tint(Color(0xFF26408B)),
                            modifier = Modifier.size(30.dp)
                        )
                        Spacer(Modifier.width(8.dp))
                        Text("Notifications",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.SemiBold
                        )
                    }
                    Row(verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(12.dp)
                            .fillMaxWidth()) {
                        Image(
                            painter = painterResource(R.drawable.docs),
                            contentDescription = null,
                            modifier = Modifier.size(30.dp)
                        )
                        Spacer(Modifier.width(8.dp))
                        Text("Reference Settings",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.SemiBold
                        )
                    }
                    Row(verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(12.dp)
                            .fillMaxWidth()) {
                        Image(
                            painter = painterResource(R.drawable.moon),
                            contentDescription = null,
                            modifier = Modifier.size(30.dp)
                        )
                        Spacer(Modifier.width(8.dp))
                        Text("Dark Mode",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.SemiBold,
                            modifier = Modifier.weight(1f)
                        )
                        Switch(checked = false,
                            onCheckedChange = {}
                        )
                    }
                }
                Spacer(Modifier.height(40.dp))
                Text("Pharmacy Portal",
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 16.sp,
                    color = Color(0xFF4D4D4D)
                )
                Card(modifier = Modifier.fillMaxWidth(),
                    colors = CardDefaults.cardColors(Color.White)) {
                    Row(modifier = Modifier.padding( 12.dp)
                        .fillMaxWidth()
                        .clickable(
                            onClick = {
                                navigateToPharmaAdmin()
                            }
                        ),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painter = painterResource(R.drawable.pharma_admin),
                            contentDescription = null,
                            modifier = Modifier.size(30.dp),
                            colorFilter = ColorFilter.tint(Color(0xFF26408B))
                        )
                        Spacer(Modifier.width(8.dp))
                        Text(
                            text = "Admin Login",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.SemiBold
                        )
                    }
                }
                Spacer(Modifier.height(30.dp))
                Button(onClick = {},
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(4.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color.White),
                    border = BorderStroke(1.dp, color = Color(0xFFC2E7D9)
                    )
                    ) {
                    Text("Log Out",
                        color = Color(0xFF9F3000)
                    )
                }
                Spacer(Modifier.height(100.dp))
            }
        }
    }
}
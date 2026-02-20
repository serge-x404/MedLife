package com.example.medcare.profile

import android.widget.Toast
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
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.platform.LocalContext
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
            title = {
                Text(
                    "My Profile",
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.onBackground
            ) },
            navigationIcon = { IconButton(
                onClick = back
            ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.onBackground
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
                    colors = CardDefaults.cardColors(MaterialTheme.colorScheme.surfaceContainerHighest),
                    border = BorderStroke(2.dp, MaterialTheme.colorScheme.outlineVariant)
                ) {
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
                                text = "serge",
                                style = MaterialTheme.typography.titleMedium,
                                color = MaterialTheme.colorScheme.onBackground
                            )
                            Row {
                                Icon(
                                    imageVector = Icons.Default.Email,
                                    contentDescription = null,
                                    tint = MaterialTheme.colorScheme.onBackground,
                                    modifier = Modifier.size(20.dp)
                                )
                                Spacer(Modifier.width(6.dp))
                                Text(
                                    "lorenzoricci@example.com",
                                    style = MaterialTheme.typography.labelLarge,
                                    color = MaterialTheme.colorScheme.onBackground
                                )
                            }
                            Row {
                                Icon(
                                    imageVector = Icons.Default.Phone,
                                    contentDescription = null,
                                    tint = MaterialTheme.colorScheme.onBackground,
                                    modifier = Modifier.size(20.dp)
                                )
                                Spacer(Modifier.width(6.dp))
                                Text(
                                    "+39 1234567890",
                                    style = MaterialTheme.typography.labelLarge,
                                    color = MaterialTheme.colorScheme.onBackground
                                )
                            }
                        }
                    }
                }
                Spacer(Modifier.height(20.dp))
                Text(
                    "Menu",
                    style = MaterialTheme.typography.titleLarge,
                    color = MaterialTheme.colorScheme.onBackground
                )
                Card(modifier = Modifier.fillMaxWidth(),
                    colors = CardDefaults.cardColors(MaterialTheme.colorScheme.surfaceContainerHighest)) {
                    Row(verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(12.dp)
                            .fillMaxWidth()
                            .clickable(
                                onClick = {navigateToPresHist()}
                            )) {
                        Image(
                            painter = painterResource(R.drawable.book),
                            contentDescription = null,
                            modifier = Modifier.size(30.dp),
                            colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onBackground)
                        )
                        Spacer(Modifier.width(8.dp))
                        Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                            Text(
                                "Prescription History",
                                style = MaterialTheme.typography.titleMedium,
                                color = MaterialTheme.colorScheme.onBackground
                            )
                            Text(
                                "Check out the full prescription history here",
                                style = MaterialTheme.typography.labelLarge,
                                color = MaterialTheme.colorScheme.onBackground
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
                            modifier = Modifier.size(30.dp),
                            colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onBackground)
                        )
                        Spacer(Modifier.width(8.dp))
                        Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                            Text(
                                "Health History",
                                style = MaterialTheme.typography.titleMedium,
                                color = MaterialTheme.colorScheme.onBackground
                            )
                            Text(
                                "Check details regarding your medical history",
                                style = MaterialTheme.typography.labelLarge,
                                color = MaterialTheme.colorScheme.onBackground
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
                            modifier = Modifier.size(30.dp),
                            colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onBackground)
                        )
                        Spacer(Modifier.width(8.dp))
                        Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                            Text(
                                "Transactions",
                                style = MaterialTheme.typography.titleMedium,
                                color = MaterialTheme.colorScheme.onBackground
                            )
                            Text(
                                "Look back at your previous transactions",
                                style = MaterialTheme.typography.labelLarge,
                                color = MaterialTheme.colorScheme.onBackground
                            )
                        }
                    }
                }
                Spacer(Modifier.height(40.dp))
                Text(
                    "General Information",
                    style = MaterialTheme.typography.titleLarge,
                    color = MaterialTheme.colorScheme.onBackground
                )
                Card(modifier = Modifier.fillMaxWidth(),
                    colors = CardDefaults.cardColors(MaterialTheme.colorScheme.surfaceContainerHighest)) {
                    Row(verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(12.dp)
                            .fillMaxWidth()
                            .clickable(
                                onClick = {navigateToAccSettings()}
                            )) {
                        Image(
                            painter = painterResource(R.drawable.gear),
                            contentDescription = null,
                            modifier = Modifier.size(30.dp),
                            colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onBackground)
                        )
                        Spacer(Modifier.width(8.dp))
                        Text(
                            "Account Settings",
                            style = MaterialTheme.typography.titleMedium,
                            color = MaterialTheme.colorScheme.onBackground
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
                            modifier = Modifier.size(30.dp),
                            colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onBackground)
                        )
                        Spacer(Modifier.width(8.dp))
                        Text(
                            "Notifications",
                            style = MaterialTheme.typography.titleMedium,
                            color = MaterialTheme.colorScheme.onBackground
                        )
                    }
                    Row(verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(12.dp)
                            .fillMaxWidth()) {
                        Image(
                            painter = painterResource(R.drawable.docs),
                            contentDescription = null,
                            modifier = Modifier.size(30.dp),
                            colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onBackground)
                        )
                        Spacer(Modifier.width(8.dp))
                        Text(
                            "Reference Settings",
                            style = MaterialTheme.typography.titleMedium,
                            color = MaterialTheme.colorScheme.onBackground
                        )
                    }
                    Row(verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(12.dp)
                            .fillMaxWidth()) {
                        Image(
                            painter = painterResource(R.drawable.moon),
                            contentDescription = null,
                            modifier = Modifier.size(30.dp),
                            colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onBackground)
                        )
                        Spacer(Modifier.width(8.dp))
                        Text(
                            "Dark Mode",
                            style = MaterialTheme.typography.titleMedium,
                            color = MaterialTheme.colorScheme.onBackground,
                            modifier = Modifier.weight(1f)
                        )
                        val context = LocalContext.current
                        Switch(checked = false,
                            onCheckedChange = {
                                Toast.makeText(context,"Dark mode will be available soon", Toast.LENGTH_LONG).show()
                            }
                        )
                    }
                }
                Spacer(Modifier.height(40.dp))
                Text(
                    "Pharmacy Portal",
                    style = MaterialTheme.typography.titleLarge,
                    color = MaterialTheme.colorScheme.onBackground
                )
                Card(modifier = Modifier.fillMaxWidth(),
                    colors = CardDefaults.cardColors(MaterialTheme.colorScheme.surfaceContainerHighest)) {
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
                            colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onBackground)
                        )
                        Spacer(Modifier.width(8.dp))
                        Text(
                            text = "Admin Login",
                            style = MaterialTheme.typography.titleMedium,
                            color = MaterialTheme.colorScheme.onBackground
                        )
                    }
                }
                Spacer(Modifier.height(30.dp))
                val context = LocalContext.current
                Button(onClick = {
                    Toast.makeText(context,"You clicked logout button",Toast.LENGTH_SHORT).show()
                },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(4.dp),
                    colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.errorContainer),
                    border = BorderStroke(1.dp, MaterialTheme.colorScheme.onErrorContainer)
                    ) {
                    Text(
                        "Log Out",
                        style = MaterialTheme.typography.titleMedium,
                        color = MaterialTheme.colorScheme.onErrorContainer
                    )
                }
                Spacer(Modifier.height(100.dp))
            }
        }
    }
}
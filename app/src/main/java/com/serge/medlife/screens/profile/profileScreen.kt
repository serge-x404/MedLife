package com.serge.medlife.screens.profile

import android.content.SharedPreferences
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Android
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ContainedLoadingIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.core.content.edit
import com.google.firebase.auth.FirebaseAuth
import com.serge.medlife.R
import com.serge.medlife.rtdb.RTDB

@OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3ExpressiveApi::class)
@Composable
fun ProfileScreen(
    navigateToAuthSplash: () -> Unit,
    sharedPreferences: SharedPreferences
) {
    var showDialog by remember { mutableStateOf(false) }
    var editProfileDialog by remember { mutableStateOf(false) }
    var aboutApplication by remember { mutableStateOf(false) }
    var aboutMe by remember { mutableStateOf(false) }
    var isLoading by remember { mutableStateOf(true) }
    val rtdb = RTDB()
    val auth = FirebaseAuth.getInstance()
    var userName by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var gender by remember { mutableStateOf("") }
    var dateOfBirth by remember { mutableStateOf("") }
    var expanded by remember { mutableStateOf(false) }
    val context = LocalContext.current
    val versionName = context.getVersionName()
    LaunchedEffect(Unit) {
        rtdb.fetchUserInfo { uName, eMail, genderUser, dobUser ->
            userName = uName
            email = eMail
            gender = genderUser
            dateOfBirth = dobUser
            isLoading = false
        }
    }

    if (isLoading) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            ContainedLoadingIndicator()
        }
    }
    else {

        if (showDialog) {
            AlertDialog(
                onDismissRequest = { showDialog = false },
                icon = {
                    Icon(
                        imageVector = Icons.Default.Warning,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.error
                    )
                },
                title = {
                    Text(
                        "Logout",
                        style = MaterialTheme.typography.headlineSmall,
                        color = MaterialTheme.colorScheme.onBackground,
                    )
                },
                text = {
                    Text(
                        "Are you sure you want to log out?",
                        style = MaterialTheme.typography.titleMedium,
                        color = MaterialTheme.colorScheme.onBackground
                    )
                },
                confirmButton = {
                    Button(
                        onClick = {
                            auth.signOut()
                            navigateToAuthSplash()
                            sharedPreferences.edit(commit = true) {
                                putBoolean("isPatientLoggedIn", false)
                                putBoolean("isPatient", false)
                            }
                        },
                        colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.errorContainer),
                        border = BorderStroke(1.dp, MaterialTheme.colorScheme.outline),
                    ) {
                        Text(
                            "Logout",
                            style = MaterialTheme.typography.labelLarge,
                            color = MaterialTheme.colorScheme.onErrorContainer,
                            textAlign = TextAlign.Center
                        )
                    }
                },
                dismissButton = {
                    Button(
                        onClick = { showDialog = false },
                        colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.primaryContainer),
                        border = BorderStroke(1.dp, MaterialTheme.colorScheme.outline)
                    ) {
                        Text(
                            "Cancel",
                            style = MaterialTheme.typography.labelLarge,
                            color = MaterialTheme.colorScheme.onPrimaryContainer,
                            textAlign = TextAlign.Center
                        )
                    }
                }
            )
        }
        val profileImage = when (gender) {
            "Male" -> painterResource(R.drawable.lorenzo)
            "Female" -> painterResource(R.drawable.sofia)
            else -> painterResource(R.drawable.profile)
        }

        if (editProfileDialog) {
            Dialog(
                onDismissRequest = { editProfileDialog = false }
            ) {
                Card(
                    modifier = Modifier
                        .fillMaxWidth(),
                    colors = CardDefaults.cardColors(MaterialTheme.colorScheme.surfaceContainer)
                ) {
                    Column(
                        modifier = Modifier
                            .padding(16.dp)
                    ) {
                        Text(
                            "User Information",
                            style = MaterialTheme.typography.titleLarge,
                            color = MaterialTheme.colorScheme.onSurface,
                            modifier = Modifier
                                .align(Alignment.CenterHorizontally)
                        )
                        Spacer(Modifier.height(8.dp))
                        TextField(
                            value = userName,
                            onValueChange = {},
                            readOnly = true,
                            label = {
                                Text(
                                    "Username",
                                    style = MaterialTheme.typography.labelLarge
                                )
                            },
                            textStyle = MaterialTheme.typography.titleMedium,
                            colors = TextFieldDefaults.colors(
                                focusedIndicatorColor = Color.Transparent,
                                unfocusedIndicatorColor = Color.Transparent,
                                focusedTextColor = MaterialTheme.colorScheme.onPrimaryContainer,
                                unfocusedTextColor = MaterialTheme.colorScheme.onPrimaryContainer,
                                focusedContainerColor = MaterialTheme.colorScheme.primaryContainer,
                                unfocusedContainerColor = MaterialTheme.colorScheme.primaryContainer
                            ),
                            modifier = Modifier.fillMaxWidth()
                        )
                        Spacer(Modifier.height(6.dp))
                        TextField(
                            value = gender,
                            onValueChange = {},
                            label = {
                                Text(
                                    "Gender",
                                    style = MaterialTheme.typography.labelLarge
                                )
                            },
                            readOnly = true,
                            textStyle = MaterialTheme.typography.titleMedium,
                            colors = TextFieldDefaults.colors(
                                focusedIndicatorColor = Color.Transparent,
                                unfocusedIndicatorColor = Color.Transparent,
                                focusedTextColor = MaterialTheme.colorScheme.onPrimaryContainer,
                                unfocusedTextColor = MaterialTheme.colorScheme.onPrimaryContainer,
                                focusedContainerColor = MaterialTheme.colorScheme.primaryContainer,
                                unfocusedContainerColor = MaterialTheme.colorScheme.primaryContainer
                            ),
                            modifier = Modifier.fillMaxWidth()
                        )
                        Spacer(Modifier.height(6.dp))
                        TextField(
                            value = dateOfBirth,
                            onValueChange = {},
                            label = {
                                Text(
                                    "Date of Birth",
                                    style = MaterialTheme.typography.labelLarge
                                )
                            },
                            readOnly = true,
                            textStyle = MaterialTheme.typography.titleMedium,
                            colors = TextFieldDefaults.colors(
                                focusedIndicatorColor = Color.Transparent,
                                unfocusedIndicatorColor = Color.Transparent,
                                focusedTextColor = MaterialTheme.colorScheme.onPrimaryContainer,
                                unfocusedTextColor = MaterialTheme.colorScheme.onPrimaryContainer,
                                focusedContainerColor = MaterialTheme.colorScheme.primaryContainer,
                                unfocusedContainerColor = MaterialTheme.colorScheme.primaryContainer
                            ),
                            modifier = Modifier.fillMaxWidth()
                        )
                    }
                }
            }
        }

        if (aboutApplication) {
            Dialog(
                onDismissRequest = {aboutApplication = false}
            ) {
                Card(
                    modifier = Modifier
                        .fillMaxWidth(),
                    colors = CardDefaults.cardColors(MaterialTheme.colorScheme.surfaceContainer)
                ) {
                    Column(
                        modifier = Modifier
                            .padding(16.dp)
                    ) {
                        Text(
                            "App Information",
                            style = MaterialTheme.typography.titleLarge,
                            color = MaterialTheme.colorScheme.onSurface,
                            modifier = Modifier
                                .align(Alignment.CenterHorizontally)
                        )
                        Spacer(Modifier.height(8.dp))
                        TextField(
                            value = versionName,
                            onValueChange = {},
                            readOnly = true,
                            label = {
                                Text(
                                    "Version Name",
                                    style = MaterialTheme.typography.labelLarge
                                )
                            },
                            textStyle = MaterialTheme.typography.titleMedium,
                            colors = TextFieldDefaults.colors(
                                focusedIndicatorColor = Color.Transparent,
                                unfocusedIndicatorColor = Color.Transparent,
                                focusedTextColor = MaterialTheme.colorScheme.onPrimaryContainer,
                                unfocusedTextColor = MaterialTheme.colorScheme.onPrimaryContainer,
                                focusedContainerColor = MaterialTheme.colorScheme.primaryContainer,
                                unfocusedContainerColor = MaterialTheme.colorScheme.primaryContainer
                            ),
                            modifier = Modifier.fillMaxWidth()
                        )
                    }
                }
            }
        }

        if (aboutMe) {
            Dialog(
                onDismissRequest = { aboutMe = false}
            ) {
                Card(
                    modifier = Modifier
                        .fillMaxWidth(),
                    colors = CardDefaults.cardColors(MaterialTheme.colorScheme.surfaceContainer)
                ) {
                    Column(
                        modifier = Modifier
                            .padding(16.dp)
                    ) {
                        Text(
                            "About Me",
                            style = MaterialTheme.typography.titleLarge,
                            color = MaterialTheme.colorScheme.onSurface,
                            modifier = Modifier
                                .align(Alignment.CenterHorizontally)
                        )
                        Spacer(Modifier.height(8.dp))
                        TextField(
                            value = "Kabir Pancholi",
                            onValueChange = {},
                            readOnly = true,
                            label = {
                                Text(
                                    "Name",
                                    style = MaterialTheme.typography.labelLarge
                                )
                            },
                            textStyle = MaterialTheme.typography.titleMedium,
                            colors = TextFieldDefaults.colors(
                                focusedIndicatorColor = Color.Transparent,
                                unfocusedIndicatorColor = Color.Transparent,
                                focusedTextColor = MaterialTheme.colorScheme.onPrimaryContainer,
                                unfocusedTextColor = MaterialTheme.colorScheme.onPrimaryContainer,
                                focusedContainerColor = MaterialTheme.colorScheme.primaryContainer,
                                unfocusedContainerColor = MaterialTheme.colorScheme.primaryContainer
                            ),
                            modifier = Modifier.fillMaxWidth()
                        )
                        Spacer(Modifier.height(6.dp))
                        TextField(
                            value = "21, Male",
                            onValueChange = {},
                            label = {
                                Text(
                                    "Age, Gender",
                                    style = MaterialTheme.typography.labelLarge
                                )
                            },
                            readOnly = true,
                            textStyle = MaterialTheme.typography.titleMedium,
                            colors = TextFieldDefaults.colors(
                                focusedIndicatorColor = Color.Transparent,
                                unfocusedIndicatorColor = Color.Transparent,
                                focusedTextColor = MaterialTheme.colorScheme.onPrimaryContainer,
                                unfocusedTextColor = MaterialTheme.colorScheme.onPrimaryContainer,
                                focusedContainerColor = MaterialTheme.colorScheme.primaryContainer,
                                unfocusedContainerColor = MaterialTheme.colorScheme.primaryContainer
                            ),
                            modifier = Modifier.fillMaxWidth()
                        )
                        Spacer(Modifier.height(6.dp))
                        TextField(
                            value = "Android Intern",
                            onValueChange = {},
                            label = {
                                Text(
                                    "Role",
                                    style = MaterialTheme.typography.labelLarge
                                )
                            },
                            readOnly = true,
                            textStyle = MaterialTheme.typography.titleMedium,
                            colors = TextFieldDefaults.colors(
                                focusedIndicatorColor = Color.Transparent,
                                unfocusedIndicatorColor = Color.Transparent,
                                focusedTextColor = MaterialTheme.colorScheme.onPrimaryContainer,
                                unfocusedTextColor = MaterialTheme.colorScheme.onPrimaryContainer,
                                focusedContainerColor = MaterialTheme.colorScheme.primaryContainer,
                                unfocusedContainerColor = MaterialTheme.colorScheme.primaryContainer
                            ),
                            modifier = Modifier.fillMaxWidth()
                        )
                        Spacer(Modifier.height(6.dp))
                        TextField(
                            value = "Reading, Basketball, Writing",
                            onValueChange = {},
                            label = {
                                Text(
                                    "Hobbies",
                                    style = MaterialTheme.typography.labelLarge
                                )
                            },
                            readOnly = true,
                            textStyle = MaterialTheme.typography.titleMedium,
                            colors = TextFieldDefaults.colors(
                                focusedIndicatorColor = Color.Transparent,
                                unfocusedIndicatorColor = Color.Transparent,
                                focusedTextColor = MaterialTheme.colorScheme.onPrimaryContainer,
                                unfocusedTextColor = MaterialTheme.colorScheme.onPrimaryContainer,
                                focusedContainerColor = MaterialTheme.colorScheme.primaryContainer,
                                unfocusedContainerColor = MaterialTheme.colorScheme.primaryContainer
                            ),
                            modifier = Modifier.fillMaxWidth()
                        )
                        Spacer(Modifier.height(6.dp))
                        TextField(
                            value = "I love coffee ☕",
                            onValueChange = {},
                            label = {
                                Text(
                                    "More about me!",
                                    style = MaterialTheme.typography.labelLarge
                                )
                            },
                            readOnly = true,
                            textStyle = MaterialTheme.typography.titleMedium,
                            colors = TextFieldDefaults.colors(
                                focusedIndicatorColor = Color.Transparent,
                                unfocusedIndicatorColor = Color.Transparent,
                                focusedTextColor = MaterialTheme.colorScheme.onPrimaryContainer,
                                unfocusedTextColor = MaterialTheme.colorScheme.onPrimaryContainer,
                                focusedContainerColor = MaterialTheme.colorScheme.primaryContainer,
                                unfocusedContainerColor = MaterialTheme.colorScheme.primaryContainer
                            ),
                            modifier = Modifier.fillMaxWidth()
                        )
                    }
                }
            }
        }

        Scaffold(
            topBar = {
                CenterAlignedTopAppBar(
                    title = {
                        Text(
                            "My Profile",
                            style = MaterialTheme.typography.titleMedium,
                            color = MaterialTheme.colorScheme.onBackground
                        )
                    }
                )
            }
        ) { innerPadding ->
            Column(
                modifier = Modifier
                    .padding(innerPadding)
                    .padding(bottom = 86.dp)
            ) {
                Column(
                    modifier = Modifier
                        .padding(horizontal = 12.dp)
                        .fillMaxWidth()
                        .verticalScroll(rememberScrollState())
                ) {
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable(
                                enabled = true,
                                onClick = { editProfileDialog = !editProfileDialog }
                            ),
                        colors = CardDefaults.cardColors(MaterialTheme.colorScheme.surfaceContainer),
                        border = BorderStroke(0.5.dp, MaterialTheme.colorScheme.outlineVariant)
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.padding(12.dp)
                        ) {
                            Image(
                                painter = profileImage,
                                contentDescription = null,
                                modifier = Modifier.size(60.dp)
                            )
                            Spacer(Modifier.width(8.dp))
                            Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                                Text(
                                    userName,
                                    style = MaterialTheme.typography.titleMedium,
                                    color = MaterialTheme.colorScheme.onSurface
                                )
                                Row {
                                    Icon(
                                        imageVector = Icons.Default.Email,
                                        contentDescription = null,
                                        tint = MaterialTheme.colorScheme.onSurface,
                                        modifier = Modifier.size(20.dp)
                                    )
                                    Spacer(Modifier.width(6.dp))
                                    Text(
                                        email,
                                        style = MaterialTheme.typography.labelLarge,
                                        color = MaterialTheme.colorScheme.onSurface
                                    )
                                }
                                if (expanded) {
                                    Row {
                                        Icon(
                                            imageVector = Icons.Default.Person,
                                            contentDescription = null,
                                            tint = MaterialTheme.colorScheme.onBackground,
                                            modifier = Modifier.size(20.dp)
                                        )
                                        Spacer(Modifier.width(6.dp))
                                        Text(
                                            gender,
                                            style = MaterialTheme.typography.labelLarge,
                                            color = MaterialTheme.colorScheme.onBackground
                                        )
                                    }
                                    Row {
                                        Icon(
                                            imageVector = Icons.Default.DateRange,
                                            contentDescription = null,
                                            tint = MaterialTheme.colorScheme.onBackground,
                                            modifier = Modifier.size(20.dp)
                                        )
                                        Spacer(Modifier.width(6.dp))
                                        Text(
                                            dateOfBirth,
                                            style = MaterialTheme.typography.labelLarge,
                                            color = MaterialTheme.colorScheme.onBackground
                                        )
                                    }
                                }
                            }
                        }
                    }
                    Spacer(Modifier.height(20.dp))
                    Text(
                        "About",
                        style = MaterialTheme.typography.titleLarge,
                        color = MaterialTheme.colorScheme.onBackground
                    )
                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        colors = CardDefaults.cardColors(MaterialTheme.colorScheme.surfaceContainerHighest)
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .clickable(
                                    onClick = { aboutApplication = !aboutApplication }
                                )
                                .padding(12.dp)
                                .fillMaxWidth()
                        ) {
                            Icon(
                                imageVector = Icons.Default.Android,
                                contentDescription = null,
                                modifier = Modifier
                                    .size(30.dp),
                                tint = MaterialTheme.colorScheme.onBackground
                            )
                            Spacer(Modifier.width(8.dp))
                            Text(
                                "About Application",
                                style = MaterialTheme.typography.titleMedium,
                                color = MaterialTheme.colorScheme.onBackground
                            )
                        }
                        HorizontalDivider()
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .clickable(
                                    onClick = {aboutMe = !aboutMe }
                                )
                                .padding(12.dp)
                                .fillMaxWidth()
                        ) {
                            Icon(
                                imageVector = Icons.Default.Person,
                                contentDescription = null,
                                modifier = Modifier
                                    .size(30.dp),

                            )
                            Spacer(Modifier.width(8.dp))
                            Text(
                                "About Me",
                                style = MaterialTheme.typography.titleMedium,
                                color = MaterialTheme.colorScheme.onBackground
                            )
                        }
                    }
                    Spacer(Modifier.height(20.dp))
                    Text(
                        "Danger Zone",
                        style = MaterialTheme.typography.titleLarge,
                        color = MaterialTheme.colorScheme.onBackground
                    )
                    Button(
                        onClick = { showDialog = !showDialog },
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
                }
            }
        }
    }
}
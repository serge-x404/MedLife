package com.example.medcare.registerScreen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.DatePicker
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Popup
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PhoneNumberRegister(
    navigateToHomeScreen: () -> Unit
) {
    var checked by remember { mutableStateOf(false) }
    var password by remember { mutableStateOf("") }
    var showDatePicker by remember { mutableStateOf(false) }
    val datePickerState = rememberDatePickerState()
    val selectedDate = datePickerState.selectedDateMillis?.let {convertMillisToDate(it) }?:""
    Scaffold(
        contentWindowInsets = WindowInsets(0.dp)
    ) {
        Column(
            modifier = Modifier.padding(it)
        ) {
            Column(
                modifier = Modifier
                    .background(MaterialTheme.colorScheme.surfaceContainerHighest)
                    .border(2.dp, MaterialTheme.colorScheme.outlineVariant)
                    .fillMaxSize()
                    .padding(horizontal = 12.dp)
            ) {
                Spacer(Modifier.height(10.dp))
                Text(
                    text = "Phone No",
                    style = MaterialTheme.typography.titleLarge,
                    color = MaterialTheme.colorScheme.onBackground
                )
                OutlinedTextField(
                    value = "",
                    label = {
                        Text(
                            "Enter Phone Number",
                            style = MaterialTheme.typography.titleSmall,
                            color = MaterialTheme.colorScheme.onBackground
                        )
                    },
                    onValueChange = {})
                Spacer(Modifier.height(5.dp))
                Text(
                    text = "Password",
                    color = MaterialTheme.colorScheme.onBackground,
                    style = MaterialTheme.typography.titleLarge
                )
                OutlinedTextField(
                    value = password,
                    label = { Text(
                        "Create a password",
                        color = MaterialTheme.colorScheme.onBackground,
                        style = MaterialTheme.typography.titleSmall
                    ) },
                    onValueChange = {password = it}
                )
                Spacer(Modifier.height(5.dp))
                Text(
                    text = "Full Name",
                    style = MaterialTheme.typography.titleLarge,
                    color = MaterialTheme.colorScheme.onBackground
                )
                OutlinedTextField(
                    value = "",
                    label = {
                        Text(
                            "Enter your full name",
                            style = MaterialTheme.typography.titleSmall,
                            color = MaterialTheme.colorScheme.onBackground,
                        )
                    },
                    onValueChange = {}
                )
                Spacer(Modifier.height(5.dp))
                Text(
                    text = "Gender",
                    color = MaterialTheme.colorScheme.onBackground,
                    style = MaterialTheme.typography.titleLarge
                )
                OutlinedTextField(
                    value = "",
                    placeholder = {
                        Text(
                            "Choose your gender",
                            color = MaterialTheme.colorScheme.onBackground,
                            style = MaterialTheme.typography.titleSmall
                        )
                    },
                    onValueChange = {}
                )
                Spacer(Modifier.height(5.dp))
                Text(
                    text = "Date of birth",
                    color = MaterialTheme.colorScheme.onBackground,
                    style = MaterialTheme.typography.titleLarge
                )
                OutlinedTextField(
                    value = selectedDate,
                    placeholder = { Text(
                        "Enter your date of birth",
                        color = MaterialTheme.colorScheme.onBackground,
                        style = MaterialTheme.typography.titleSmall
                    ) },
                    onValueChange = {},
                    readOnly = true,
                    trailingIcon = {
                        IconButton(onClick = {showDatePicker = !showDatePicker}) {
                            Icon(
                                imageVector = Icons.Default.DateRange,
                                contentDescription = null
                            )
                            if (showDatePicker) {
                                Popup(
                                    onDismissRequest = { showDatePicker = false },
                                    alignment = Alignment.Center
                                ) {
                                    Box {
                                        DatePicker(
                                            state = datePickerState,
                                            showModeToggle = false
                                        )
                                    }
                                }
                            }
                        }
                    }
                )
                Spacer(Modifier.height(5.dp))
                Row(
                    horizontalArrangement = Arrangement.spacedBy(5.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Checkbox(
                        checked = checked,
                        onCheckedChange = { checked = it },
                        modifier = Modifier.size(18.dp)
                    )
                    Text(
                        text = "You agree to receive information and notifications sent by MedCare",
                        style = MaterialTheme.typography.titleSmall,
                        color = MaterialTheme.colorScheme.onBackground,
                    )
                }
            }
        }
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 12.dp, vertical = 20.dp),
            contentAlignment = Alignment.BottomCenter
        ) {
            Column {
                Button(
                    onClick = {
                        //
                    },
                    Modifier.fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.secondary),
                    border = BorderStroke(2.dp, MaterialTheme.colorScheme.outlineVariant)
                ) {
                    Text(
                        text = "Register",
                        style = MaterialTheme.typography.titleMedium,
                        color = MaterialTheme.colorScheme.onTertiary
                    )
                }
                Row(
                    modifier = Modifier
                        .clickable(
                            enabled = true,
                            onClick = {}
                        )
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(4.dp),
                ) {
                    Text(
                        text = "Already have an account?",
                        textAlign = TextAlign.Center,
                        color = MaterialTheme.colorScheme.onBackground,
                        style = MaterialTheme.typography.labelLarge
                    )
                    Text(
                        text = "Click here to login",
                        textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.labelLarge,
                        color = MaterialTheme.colorScheme.onBackground,
                    )
                }
            }
        }
    }
}
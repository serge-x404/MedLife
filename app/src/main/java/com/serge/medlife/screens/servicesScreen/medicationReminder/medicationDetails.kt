package com.serge.medlife.screens.servicesScreen.medicationReminder

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
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
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MenuAnchorType
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SelectableDates
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.google.firebase.Firebase
import com.google.firebase.auth.auth
import com.google.firebase.database.FirebaseDatabase
import com.serge.medlife.R
import com.serge.medlife.screens.registerScreen.convertMillisToDate
import java.util.Calendar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MedicationReminder(
    navigateToSavedReminder: () -> Unit
) {
    var expandedMedName by remember { mutableStateOf(false) }
    var medName by remember { mutableStateOf("") }
    var checked by remember { mutableStateOf(false) }
    var expandedDosage by remember { mutableStateOf(false) }
    var selectedDosage by remember { mutableStateOf("") }
    var expandedPeriod by remember { mutableStateOf(false) }
    var timePeriod by remember { mutableStateOf("") }
    var expandedTimePerDay by remember { mutableStateOf(false) }
    var timePerDay by remember { mutableStateOf("") }
    var expandedDrinkRules by remember { mutableStateOf(false) }
    var drinkRules by remember { mutableStateOf("") }
    var expandedConsumption by remember { mutableStateOf(false) }
    var consumption by remember { mutableStateOf("") }
    var addNotes by remember { mutableStateOf("") }

    var errorMessage by remember { mutableStateOf("") }
    var isLoading by remember { mutableStateOf(false) }

    val auth = Firebase.auth
    val db = FirebaseDatabase.getInstance().reference
    val uid = auth.currentUser!!.uid


    val calendar = Calendar.getInstance().apply {
        add(Calendar.DAY_OF_MONTH,7 )
        set(Calendar.HOUR_OF_DAY, 23)
        set(Calendar.MINUTE, 59)
        set(Calendar.SECOND, 59)
        set(Calendar.MILLISECOND, 999)
    }
    val maxDateMillis = calendar.timeInMillis

    val minDateMillis = Calendar.getInstance().apply {
        set(Calendar.HOUR_OF_DAY,0)
        set(Calendar.MINUTE,0)
        set(Calendar.SECOND,0)
        set(Calendar.MILLISECOND,0)
    }.timeInMillis

    var showDatePicker by remember { mutableStateOf(false) }
    var selectedDate by remember { mutableStateOf("") }
    val datePickerState = rememberDatePickerState(
        initialDisplayedMonthMillis = System.currentTimeMillis(),
        selectableDates = object : SelectableDates {

            override fun isSelectableDate(utcTimeMillis: Long): Boolean {
                return utcTimeMillis in minDateMillis..maxDateMillis
            }


            override fun isSelectableYear(year: Int): Boolean {
                return year == Calendar.getInstance().get(Calendar.YEAR)
            }
        }
    )

    val interactionSource = remember { MutableInteractionSource() }
    val isClicked by interactionSource.collectIsPressedAsState()

    val medicationData = MedicationData(
        medName = medName,
        dosage = selectedDosage,
        timePeriod = timePeriod,
        timesPerDay = timePerDay,
        medStartDate = selectedDate,
        medDuration = consumption,
        medNotes = addNotes,
        medNotifications = checked
    )
    val context = LocalContext.current

    if (errorMessage.isNotEmpty()) {
        Text(
            "Please fill all the details",
            style = MaterialTheme.typography.titleMedium
        )
    }


    LaunchedEffect(isClicked) {
        if (isClicked) showDatePicker = true
    }

    if (showDatePicker) {
        DatePickerDialog(
            onDismissRequest = { showDatePicker = false },
            confirmButton = {
                TextButton(onClick = {
                    datePickerState.selectedDateMillis?.let {
                        if (it <= maxDateMillis) {
                            selectedDate = convertMillisToDate(it)
                        }
                    }
                    showDatePicker = false
                }) {
                    Text("OK")
                }
            },
            dismissButton = {
                TextButton(onClick = { showDatePicker = false }) {
                    Text("Cancel")
                }
            }
        ) {
            DatePicker(state = datePickerState, showModeToggle = false)
        }
    }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        "Details About The Drug",
                        style = MaterialTheme.typography.titleMedium,
                        color = MaterialTheme.colorScheme.onBackground
                    )
                },
            )
        }
    ) { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)) {
            Column(
                modifier = Modifier
                    .padding(horizontal = 12.dp)
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
            ) {
                Card(
                    colors = CardDefaults.cardColors(MaterialTheme.colorScheme.tertiaryContainer),
                    border = BorderStroke(1.dp, MaterialTheme.colorScheme.outline)
                ) {
                    Column(modifier = Modifier.padding(12.dp)) {
                        Text(
                            "Paracetamol 500 mg",
                            style = MaterialTheme.typography.titleMedium,
                            color = MaterialTheme.colorScheme.onTertiaryContainer
                        )
                        Spacer(Modifier.height(10.dp))
                        Text(
                            "Take 1 tablet every 6 hours as needed to reduce fever or pain.",
                            style = MaterialTheme.typography.labelMedium,
                            color = MaterialTheme.colorScheme.onTertiaryContainer,
                        )
                    }
                }
                Spacer(Modifier.height(20.dp))
                Card(
                    modifier = Modifier.fillMaxSize(),
                    colors = CardDefaults.cardColors(MaterialTheme.colorScheme.secondaryContainer),
                    border = BorderStroke(1.dp, MaterialTheme.colorScheme.outline),
                    elevation = CardDefaults.elevatedCardElevation(4.dp)
                ) {
                    Column(modifier = Modifier.padding(10.dp)) {
                        Text(
                            "Medicine Details",
                            style = MaterialTheme.typography.titleMedium,
                            color = MaterialTheme.colorScheme.onTertiaryContainer
                        )
                        Spacer(Modifier.height(8.dp))
                        ExposedDropdownMenuBox(
                            expanded = expandedMedName,
                            onExpandedChange = { expandedMedName = !expandedMedName }
                        ) {
                            Row(
                                modifier = Modifier
                                    .border(
                                        1.dp,
                                        color = MaterialTheme.colorScheme.surfaceTint,
                                        shape = RoundedCornerShape(4.dp)
                                    )
                                    .padding(10.dp)
                                    .menuAnchor(MenuAnchorType.PrimaryNotEditable, true),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(
                                    text = medName,
                                    style = MaterialTheme.typography.titleSmall,
                                    color = MaterialTheme.colorScheme.onBackground,
                                    modifier = Modifier.weight(1f)
                                )
                                Icon(
                                    imageVector = if (expandedMedName) Icons.Default.KeyboardArrowUp else Icons.Default.KeyboardArrowDown,
                                    contentDescription = null,
                                    modifier = Modifier
                                        .size(20.dp),
                                    tint = MaterialTheme.colorScheme.surfaceTint
                                )
                            }
                            ExposedDropdownMenu(
                                expanded = expandedMedName,
                                onDismissRequest = { expandedMedName = !expandedMedName },
                                modifier = Modifier.background(MaterialTheme.colorScheme.background)
                            ) {
                                listOf(
                                    "Paracetamol",
                                    "Crocin",
                                    "LevoCetM",
                                    "Pressure Less"
                                ).forEach { it ->
                                    DropdownMenuItem(
                                        text = {
                                            Text(
                                                it,
                                                style = MaterialTheme.typography.titleSmall,
                                                color = MaterialTheme.colorScheme.onBackground
                                            )
                                        },
                                        onClick = {
                                            medName = it
                                            expandedMedName = false
                                        }
                                    )
                                }
                            }
                        }
                        Spacer(Modifier.height(10.dp))
                        Text(
                            "Dosage",
                            style = MaterialTheme.typography.titleMedium,
                            color = MaterialTheme.colorScheme.onTertiaryContainer
                        )
                        Spacer(Modifier.height(6.dp))
                        ExposedDropdownMenuBox(
                            expanded = expandedDosage,
                            onExpandedChange = { expandedDosage = !expandedDosage },
                        ) {
                            Row(
                                modifier = Modifier
                                    .border(
                                        1.dp,
                                        color = MaterialTheme.colorScheme.surfaceTint,
                                        shape = RoundedCornerShape(4.dp)
                                    )
                                    .padding(10.dp)
                                    .menuAnchor(MenuAnchorType.PrimaryNotEditable, true),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(
                                    text = selectedDosage,
                                    style = MaterialTheme.typography.titleSmall,
                                    color = MaterialTheme.colorScheme.onBackground,
                                    modifier = Modifier.weight(1f)
                                )
                                Icon(
                                    imageVector = if (expandedDosage) Icons.Default.KeyboardArrowUp else Icons.Default.KeyboardArrowDown,
                                    contentDescription = null,
                                    modifier = Modifier
                                        .size(20.dp),
                                    tint = MaterialTheme.colorScheme.surfaceTint
                                )
                            }
                            ExposedDropdownMenu(
                                expanded = expandedDosage,
                                onDismissRequest = { expandedDosage = !expandedDosage },
                                modifier = Modifier.background(MaterialTheme.colorScheme.background)
                            ) {
                                listOf("1", "2", "3", "4").forEach { items ->
                                    DropdownMenuItem(
                                        {
                                            Text(
                                                items,
                                                style = MaterialTheme.typography.titleSmall,
                                                color = MaterialTheme.colorScheme.onSecondaryContainer
                                            )
                                        },
                                        onClick = {
                                            selectedDosage = items
                                            expandedDosage = false
                                        },
                                    )
                                }
                            }
                        }
                        Spacer(Modifier.height(16.dp))
                        Text(
                            "Period of taking medicine",
                            style = MaterialTheme.typography.titleMedium,
                            color = MaterialTheme.colorScheme.onTertiaryContainer
                        )
                        Spacer(Modifier.height(6.dp))
                        ExposedDropdownMenuBox(
                            expanded = expandedPeriod,
                            onExpandedChange = { expandedPeriod = !expandedPeriod }
                        ) {
                            Row(
                                modifier = Modifier
                                    .menuAnchor(MenuAnchorType.PrimaryNotEditable, true)
                                    .border(
                                        1.dp,
                                        color = MaterialTheme.colorScheme.surfaceTint,
                                        shape = RoundedCornerShape(4.dp)
                                    )
                                    .padding(10.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(
                                    text = timePeriod,
                                    style = MaterialTheme.typography.titleSmall,
                                    color = MaterialTheme.colorScheme.onBackground,
                                    modifier = Modifier.weight(1f)
                                )
                                Icon(
                                    imageVector = if (expandedPeriod) Icons.Default.KeyboardArrowUp else Icons.Default.KeyboardArrowDown,
                                    contentDescription = null,
                                    tint = MaterialTheme.colorScheme.surfaceTint
                                )
                            }
                            ExposedDropdownMenu(
                                expanded = expandedPeriod,
                                onDismissRequest = { expandedPeriod = !expandedPeriod },
                                modifier = Modifier.background(MaterialTheme.colorScheme.background)
                            ) {
                                listOf(
                                    "Every Day",
                                    "Every alternative day",
                                    "Every two days",
                                    "Every three days",
                                    "Once in four days",
                                    "Once a week"
                                ).forEach { period ->
                                    DropdownMenuItem(
                                        text = {
                                            Text(
                                                period,
                                                style = MaterialTheme.typography.titleSmall,
                                                color = MaterialTheme.colorScheme.onBackground,
                                            )
                                        },
                                        onClick = {
                                            timePeriod = period
                                            expandedPeriod = false
                                        }
                                    )
                                }
                            }
                        }
                        Spacer(Modifier.height(16.dp))
                        Text(
                            "How many times a day",
                            style = MaterialTheme.typography.titleMedium,
                            color = MaterialTheme.colorScheme.onTertiaryContainer
                        )
                        Spacer(Modifier.height(6.dp))
                        ExposedDropdownMenuBox(
                            expanded = expandedTimePerDay,
                            onExpandedChange = { expandedTimePerDay = !expandedTimePerDay }
                        ) {
                            Row(
                                modifier = Modifier
                                    .menuAnchor(MenuAnchorType.PrimaryNotEditable, true)
                                    .border(
                                        1.dp,
                                        color = MaterialTheme.colorScheme.surfaceTint,
                                        shape = RoundedCornerShape(4.dp)
                                    )
                                    .padding(10.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(
                                    text = timePerDay,
                                    style = MaterialTheme.typography.titleSmall,
                                    color = MaterialTheme.colorScheme.onBackground,
                                    modifier = Modifier.weight(1f)
                                )
                                Icon(
                                    imageVector = if (expandedTimePerDay) Icons.Default.KeyboardArrowUp else Icons.Default.KeyboardArrowDown,
                                    contentDescription = null,
                                    tint = MaterialTheme.colorScheme.surfaceTint
                                )
                            }
                            ExposedDropdownMenu(
                                expanded = expandedTimePerDay,
                                onDismissRequest = { expandedTimePerDay = !expandedTimePerDay },
                                modifier = Modifier.background(MaterialTheme.colorScheme.background)
                            ) {
                                listOf("1 Time", "2 Times", "3 Times").forEach { it ->
                                    DropdownMenuItem(
                                        text = {
                                            Text(
                                                it,
                                                style = MaterialTheme.typography.titleSmall,
                                                color = MaterialTheme.colorScheme.onBackground,
                                            )
                                        },
                                        onClick = {
                                            timePerDay = it
                                            expandedTimePerDay = false
                                        }
                                    )
                                }
                            }
                        }
//                        Spacer(Modifier.height(16.dp))
//                        Text(
//                            "Time to take medicine",
//                            style = MaterialTheme.typography.titleMedium,
//                            color = MaterialTheme.colorScheme.onTertiaryContainer
//                        )
//                        Spacer(Modifier.height(6.dp))
//                        Row(
//                            modifier = Modifier
//                                .border(
//                                    1.dp,
//                                    color = MaterialTheme.colorScheme.surfaceTint,
//                                    shape = RoundedCornerShape(4.dp)
//                                )
//                                .padding(10.dp),
//                            verticalAlignment = Alignment.CenterVertically
//                        ) {
//                            Text(
//                                "Choose",
//                                style = MaterialTheme.typography.titleSmall,
//                                color = MaterialTheme.colorScheme.onBackground,
//                                modifier = Modifier.weight(1f)
//                            )
//                            Icon(
//                                imageVector = Icons.Default.KeyboardArrowDown,
//                                contentDescription = null,
//                                tint = MaterialTheme.colorScheme.surfaceTint
//                            )
//                        }
                        Spacer(Modifier.height(16.dp))
                        Text(
                            "Drinking Rules",
                            style = MaterialTheme.typography.titleMedium,
                            color = MaterialTheme.colorScheme.onTertiaryContainer
                        )
                        Spacer(Modifier.height(6.dp))
                        ExposedDropdownMenuBox(
                            expanded = expandedDrinkRules,
                            onExpandedChange = { expandedDrinkRules = !expandedDrinkRules }
                        ) {
                            Row(
                                modifier = Modifier
                                    .menuAnchor(MenuAnchorType.PrimaryNotEditable, true)
                                    .border(
                                        1.dp,
                                        color = MaterialTheme.colorScheme.surfaceTint,
                                        shape = RoundedCornerShape(4.dp)
                                    )
                                    .padding(10.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(
                                    text = drinkRules,
                                    style = MaterialTheme.typography.titleSmall,
                                    color = MaterialTheme.colorScheme.onBackground,
                                    modifier = Modifier.weight(1f)
                                )
                                Icon(
                                    imageVector = if (expandedDrinkRules) Icons.Default.KeyboardArrowUp else Icons.Default.KeyboardArrowDown,
                                    contentDescription = null
                                )
                            }
                            ExposedDropdownMenu(
                                expanded = expandedDrinkRules,
                                onDismissRequest = { expandedDrinkRules = !expandedDrinkRules },
                                modifier = Modifier
                                    .background(MaterialTheme.colorScheme.background)
                                    .border(1.dp, MaterialTheme.colorScheme.background)
                            ) {
                                listOf("Before Meals", "After Meals").forEach { it ->
                                    DropdownMenuItem(
                                        text = {
                                            Text(
                                                it,
                                                style = MaterialTheme.typography.titleSmall,
                                                color = MaterialTheme.colorScheme.onSecondaryContainer
                                            )
                                        },
                                        onClick = {
                                            drinkRules = it
                                            expandedDrinkRules = false
                                        }
                                    )
                                }
                            }
                        }
                        Spacer(Modifier.height(16.dp))
                        Text(
                            "Drinking Start Date",
                            style = MaterialTheme.typography.titleMedium,
                            color = MaterialTheme.colorScheme.onTertiaryContainer
                        )
                        Spacer(Modifier.height(6.dp))
                        OutlinedTextField(
                            value = selectedDate,
                            onValueChange = {},
                            placeholder = {
                                Text(
                                    "Select your date",
                                    style = MaterialTheme.typography.titleMedium,
                                    color = MaterialTheme.colorScheme.onTertiaryContainer
                                )},
                            interactionSource = interactionSource,
                            trailingIcon = {
                                Icon(
                                    imageVector = Icons.Default.DateRange,
                                    contentDescription = null
                                )
                            },
                            textStyle = MaterialTheme.typography.titleMedium,
                            readOnly = true,
                            modifier = Modifier
                                .fillMaxWidth()
                        )
                        Spacer(Modifier.height(16.dp))
                        Text(
                            "Duration of Consumption",
                            style = MaterialTheme.typography.titleMedium,
                            color = MaterialTheme.colorScheme.onTertiaryContainer
                        )
                        Spacer(Modifier.height(6.dp))
                        ExposedDropdownMenuBox(
                            expanded = expandedConsumption,
                            onExpandedChange = { expandedConsumption = !expandedConsumption }
                        ) {
                            Row(
                                modifier = Modifier
                                    .menuAnchor(MenuAnchorType.PrimaryNotEditable, true)
                                    .border(
                                        1.dp,
                                        color = MaterialTheme.colorScheme.surfaceTint,
                                        shape = RoundedCornerShape(4.dp)
                                    )
                                    .padding(10.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(
                                    text = consumption,
                                    style = MaterialTheme.typography.titleSmall,
                                    color = MaterialTheme.colorScheme.onBackground,
                                    modifier = Modifier.weight(1f)
                                )
                                Icon(
                                    imageVector = if (expandedConsumption) Icons.Default.KeyboardArrowUp else Icons.Default.KeyboardArrowDown,
                                    contentDescription = null,
                                    tint = MaterialTheme.colorScheme.surfaceTint
                                )
                            }
                            ExposedDropdownMenu(
                                expanded = expandedConsumption,
                                onDismissRequest = { expandedConsumption = !expandedConsumption },
                                modifier = Modifier.background(MaterialTheme.colorScheme.background)
                            ) {
                                listOf("1 Week", "2 Weeks", "3 Weeks", "4 Weeks").forEach { it ->
                                    DropdownMenuItem(
                                        text = {
                                            Text(
                                                it,
                                                style = MaterialTheme.typography.titleSmall,
                                                color = MaterialTheme.colorScheme.onBackground
                                            )
                                        },
                                        onClick = {
                                            consumption = it
                                            expandedConsumption = false
                                        }
                                    )
                                }
                            }
                        }
                        Spacer(Modifier.height(16.dp))
                        Text(
                            "Notes(Optional)",
                            style = MaterialTheme.typography.titleMedium,
                            color = MaterialTheme.colorScheme.onTertiaryContainer
                        )
                        Spacer(Modifier.height(6.dp))
                        OutlinedTextField(
                            value = addNotes,
                            onValueChange = {addNotes = it},
                            placeholder = {
                                Text(
                                    "Add your notes",
                                    style = MaterialTheme.typography.titleMedium
                                )
                            },
                            modifier = Modifier
                                .fillMaxWidth(),
                            singleLine = true,
                            textStyle = MaterialTheme.typography.titleMedium,
                            keyboardOptions = KeyboardOptions(
                                keyboardType = KeyboardType.Text
                            )
                        )
                    }
                }
                Spacer(Modifier.height(20.dp))
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .border(
                            1.dp,
                            color = MaterialTheme.colorScheme.outline,
                            shape = RoundedCornerShape(8.dp)
                        )
                        .clickable(onClick = { checked = !checked })
                        .padding(horizontal = 12.dp)
                ) {
                    Image(
                        painter = painterResource(R.drawable.bell),
                        contentDescription = null,
                        modifier = Modifier.size(30.dp),
                        colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onBackground)
                    )
                    Spacer(Modifier.width(4.dp))
                    Text(
                        "Activate notifications",
                        style = MaterialTheme.typography.labelLarge,
                        modifier = Modifier.weight(1f)
                    )
                    Switch(
                        checked = checked,
                        onCheckedChange = {
                            checked = it
                        },
                        colors = SwitchDefaults.colors(checkedTrackColor = MaterialTheme.colorScheme.tertiary)
                    )
                }
                Spacer(Modifier.height(10.dp))
                Button(
                    onClick = {
                        if (medName.isBlank() ||
                            selectedDosage.isBlank() ||
                            timePeriod.isBlank() ||
                            timePerDay.isBlank() ||
                            selectedDate.isBlank() ||
                            consumption.isBlank()
                            ) {
                            errorMessage = "Please fill all the required fields"
                            return@Button
                        }
                        isLoading = true
                        db.child("reminders").child(uid)
                            .push()
                            .setValue(medicationData)
                            .addOnSuccessListener {
                                isLoading = false
                                Toast.makeText(
                                    context, "Reminder created", Toast.LENGTH_SHORT
                                ).show()
                                navigateToSavedReminder()
                            }
                            .addOnFailureListener {
                                Log.e("MYTAG","Error: ${it.message}")
                            }

                    },
                    colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primaryContainer),
                    border = BorderStroke(2.dp, MaterialTheme.colorScheme.outlineVariant),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    if (isLoading) {
                        CircularProgressIndicator()
                    }
                    else {
                        Text(
                            "Save",
                            style = MaterialTheme.typography.titleMedium,
                            color = MaterialTheme.colorScheme.onPrimaryContainer
                        )
                    }

                }
            }
        }
    }
}
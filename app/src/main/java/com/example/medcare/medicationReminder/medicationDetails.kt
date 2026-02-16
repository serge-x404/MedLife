package com.example.medcare.medicationReminder

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.medcare.R

@OptIn(ExperimentalMaterial3Api::class)
@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun MedicationReminder(
    back: () -> Unit,
    navigateToSavedReminder: (String, String, String) -> Unit
) {
    var expandedMediName by remember { mutableStateOf(false) }
    var mediName by remember { mutableStateOf("") }
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

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        "Details About The Drug",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                },
                navigationIcon = {
                    IconButton(onClick = back) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft,
                            contentDescription = null
                        )
                    }
                }
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
                    onClick = {},
                    colors = CardDefaults.cardColors(containerColor = Color(0xFFC2E7D9))
                ) {
                    Column(modifier = Modifier.padding(12.dp)) {
                        Text(
                            "Paracetamol 500 mg",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.SemiBold
                        )
                        Spacer(Modifier.height(10.dp))
                        Text(
                            "Take 1 tablet every 6 hours as needed to reduce fever or pain.",
                            color = Color(0xFF4D4D4D),
                        )
                    }
                }
                Spacer(Modifier.height(20.dp))
                Card(
                    modifier = Modifier.fillMaxSize(),
                    colors = CardDefaults.cardColors(Color.White),
                    elevation = CardDefaults.elevatedCardElevation(4.dp)
                ) {
                    Column(modifier = Modifier.padding(10.dp)) {
                        Text(
                            "Medicine Details",
                            fontSize = 14.sp,
                            fontWeight = FontWeight.SemiBold
                        )
                        Spacer(Modifier.height(8.dp))
                        ExposedDropdownMenuBox(
                            expanded = expandedMediName,
                            onExpandedChange = { expandedMediName = !expandedMediName }
                        ) {
                            Row(
                                modifier = Modifier
                                    .border(
                                        1.dp,
                                        color = Color(0xFFA6CFD5),
                                        shape = RoundedCornerShape(4.dp)
                                    )
                                    .padding(10.dp)
                                    .menuAnchor(),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(
                                    text = mediName,
                                    color = Color(0xFF4D4D4D),
                                    modifier = Modifier.weight(1f)
                                )
                                Icon(
                                    imageVector = if (expandedMediName) Icons.Default.KeyboardArrowUp else Icons.Default.KeyboardArrowDown,
                                    contentDescription = null,
                                    modifier = Modifier
                                        .size(20.dp)
                                )
                            }
                            ExposedDropdownMenu(
                                expanded = expandedMediName,
                                onDismissRequest = {expandedMediName = !expandedMediName}
                            ) {
                                listOf("Paracetamol","Crocin","LevoCetM","Pressure Less").forEach {
                                    it ->
                                    DropdownMenuItem(
                                        text = { Text(it) },
                                        onClick = {
                                            mediName = it
                                            expandedMediName = false
                                        }
                                    )
                                }
                            }
                        }
                        Spacer(Modifier.height(10.dp))
                        Text(
                            "Dosage",
                            fontSize = 14.sp,
                            fontWeight = FontWeight.SemiBold
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
                                        color = Color(0xFFA6CFD5),
                                        shape = RoundedCornerShape(4.dp)
                                    )
                                    .padding(10.dp)
                                    .menuAnchor(),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(
                                    text = selectedDosage,
                                    color = Color(0xFF4D4D4D),
                                    modifier = Modifier.weight(1f)
                                )
                                Icon(
                                    imageVector = if (expandedDosage) Icons.Default.KeyboardArrowUp else Icons.Default.KeyboardArrowDown,
                                    contentDescription = null,
                                    modifier = Modifier
                                        .size(20.dp)
                                )
                            }
                            ExposedDropdownMenu(
                                expanded = expandedDosage,
                                onDismissRequest = { expandedDosage = !expandedDosage }
                            ) {
                                listOf("1", "2", "3", "4").forEach { items ->
                                    DropdownMenuItem(
                                        { Text(items) },
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
                            fontSize = 14.sp,
                            fontWeight = FontWeight.SemiBold
                        )
                        Spacer(Modifier.height(6.dp))
                        ExposedDropdownMenuBox(
                            expanded = expandedPeriod,
                            onExpandedChange = { expandedPeriod = !expandedPeriod }
                        ) {
                            Row(
                                modifier = Modifier
                                    .menuAnchor()
                                    .border(
                                        1.dp,
                                        color = Color(0xFFA6CFD5),
                                        shape = RoundedCornerShape(4.dp)
                                    )
                                    .padding(10.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(
                                    text = timePeriod,
                                    color = Color(0xFF4D4D4D),
                                    modifier = Modifier.weight(1f)
                                )
                                Icon(
                                    imageVector = if (expandedPeriod) Icons.Default.KeyboardArrowUp else Icons.Default.KeyboardArrowDown,
                                    contentDescription = null
                                )
                            }
                            ExposedDropdownMenu(
                                expanded = expandedPeriod,
                                onDismissRequest = { expandedPeriod = !expandedPeriod }
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
                                        text = { Text(period) },
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
                            fontSize = 14.sp,
                            fontWeight = FontWeight.SemiBold
                        )
                        Spacer(Modifier.height(6.dp))
                        ExposedDropdownMenuBox(
                            expanded = expandedTimePerDay,
                            onExpandedChange = { expandedTimePerDay = !expandedTimePerDay }
                        ) {
                            Row(
                                modifier = Modifier
                                    .menuAnchor()
                                    .border(
                                        1.dp,
                                        color = Color(0xFFA6CFD5),
                                        shape = RoundedCornerShape(4.dp)
                                    )
                                    .padding(10.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(
                                    text = timePerDay,
                                    color = Color(0xFF4D4D4D),
                                    modifier = Modifier.weight(1f)
                                )
                                Icon(
                                    imageVector = if (expandedTimePerDay) Icons.Default.KeyboardArrowUp else Icons.Default.KeyboardArrowDown,
                                    contentDescription = null
                                )
                            }
                            ExposedDropdownMenu(
                                expanded = expandedTimePerDay,
                                onDismissRequest = { expandedTimePerDay = !expandedTimePerDay }
                            ) {
                                listOf("1 Time", "2 Times", "3 Times").forEach { it ->
                                    DropdownMenuItem(
                                        text = { Text(it) },
                                        onClick = {
                                            timePerDay = it
                                            expandedTimePerDay = false
                                        }
                                    )
                                }
                            }
                        }
                        Spacer(Modifier.height(16.dp))
                        Text(
                            "Time to take medicine",
                            fontSize = 14.sp,
                            fontWeight = FontWeight.SemiBold
                        )
                        Spacer(Modifier.height(6.dp))
                        Row(
                            modifier = Modifier
                                .border(
                                    1.dp,
                                    color = Color(0xFFA6CFD5),
                                    shape = RoundedCornerShape(4.dp)
                                )
                                .padding(10.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                "Choose",
                                color = Color(0xFF4D4D4D),
                                modifier = Modifier.weight(1f)
                            )
                            Icon(
                                imageVector = Icons.Default.KeyboardArrowDown,
                                contentDescription = null
                            )
                        }
                        Spacer(Modifier.height(16.dp))
                        Text(
                            "Drinking Rules",
                            fontSize = 14.sp,
                            fontWeight = FontWeight.SemiBold
                        )
                        Spacer(Modifier.height(6.dp))
                        ExposedDropdownMenuBox(
                            expanded = expandedDrinkRules,
                            onExpandedChange = { expandedDrinkRules = !expandedDrinkRules }
                        ) {
                            Row(
                                modifier = Modifier
                                    .menuAnchor()
                                    .border(
                                        1.dp,
                                        color = Color(0xFFA6CFD5),
                                        shape = RoundedCornerShape(4.dp)
                                    )
                                    .padding(10.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(
                                    text = drinkRules,
                                    color = Color(0xFF4D4D4D),
                                    modifier = Modifier.weight(1f)
                                )
                                Icon(
                                    imageVector = if (expandedDrinkRules) Icons.Default.KeyboardArrowUp else Icons.Default.KeyboardArrowDown,
                                    contentDescription = null
                                )
                            }
                            ExposedDropdownMenu(
                                expanded = expandedDrinkRules,
                                onDismissRequest = { expandedDrinkRules = !expandedDrinkRules }
                            ) {
                                listOf("Before Meals", "After Meals").forEach { it ->
                                    DropdownMenuItem(
                                        text = { Text(it) },
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
                            fontSize = 14.sp,
                            fontWeight = FontWeight.SemiBold
                        )
                        Spacer(Modifier.height(6.dp))
                        Row(
                            modifier = Modifier
                                .border(
                                    1.dp,
                                    color = Color(0xFFA6CFD5),
                                    shape = RoundedCornerShape(4.dp)
                                )
                                .padding(10.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                "Choose",
                                color = Color(0xFF4D4D4D),
                                modifier = Modifier.weight(1f)
                            )
                            Icon(
                                imageVector = Icons.Default.KeyboardArrowDown,
                                contentDescription = null
                            )
                        }
                        Spacer(Modifier.height(16.dp))
                        Text(
                            "Duration of Consumption",
                            fontSize = 14.sp,
                            fontWeight = FontWeight.SemiBold
                        )
                        Spacer(Modifier.height(6.dp))
                        ExposedDropdownMenuBox(
                            expanded = expandedConsumption,
                            onExpandedChange = { expandedConsumption = !expandedConsumption }
                        ) {
                            Row(
                                modifier = Modifier
                                    .menuAnchor()
                                    .border(
                                        1.dp,
                                        color = Color(0xFFA6CFD5),
                                        shape = RoundedCornerShape(4.dp)
                                    )
                                    .padding(10.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(
                                    text = consumption,
                                    color = Color(0xFF4D4D4D),
                                    modifier = Modifier.weight(1f)
                                )
                                Icon(
                                    imageVector = if (expandedConsumption) Icons.Default.KeyboardArrowUp else Icons.Default.KeyboardArrowDown,
                                    contentDescription = null
                                )
                            }
                            ExposedDropdownMenu(
                                expanded = expandedConsumption,
                                onDismissRequest = { expandedConsumption = !expandedConsumption }
                            ) {
                                listOf("1 Week", "2 Weeks", "3 Weeks", "4 Weeks").forEach { it ->
                                    DropdownMenuItem(
                                        text = { Text(it) },
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
                            fontSize = 14.sp,
                            fontWeight = FontWeight.SemiBold
                        )
                        Spacer(Modifier.height(6.dp))
                        Row(
                            modifier = Modifier
                                .border(
                                    1.dp,
                                    color = Color(0xFFA6CFD5),
                                    shape = RoundedCornerShape(4.dp)
                                )
                                .padding(10.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                "Add your notes",
                                color = Color(0xFF4D4D4D),
                                modifier = Modifier.weight(1f)
                            )
                        }
                    }
                }
                Spacer(Modifier.height(20.dp))
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .border(1.dp, color = Color(0xFFC2E7D9), shape = RoundedCornerShape(8.dp))
                        .padding(horizontal = 12.dp)
                ) {
                    Image(
                        painter = painterResource(R.drawable.bell),
                        contentDescription = null,
                        modifier = Modifier.size(30.dp)
                    )
                    Spacer(Modifier.width(4.dp))
                    Text(
                        "Activate notifications",
                        color = Color(0xFF4D4D4D),
                        modifier = Modifier.weight(1f)
                    )
                    Switch(
                        checked = checked,
                        onCheckedChange = {
                            checked = it
                        },
                        colors = SwitchDefaults.colors(checkedTrackColor = Color(0xFF26408B))
                    )
                }
                Spacer(Modifier.height(10.dp))
                Button(
                    onClick = { navigateToSavedReminder(mediName,selectedDosage,drinkRules) },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF26408B)),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        "Save",
                        fontWeight = FontWeight.SemiBold
                    )
                }
            }
        }
    }
}
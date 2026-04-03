package com.serge.medlife.screens.servicesScreen.medicationReminder

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.serge.medlife.R
import com.serge.medlife.rtdb.RTDB
import com.serge.medlife.screens.class_objects.CalendarScreen
import java.time.LocalDate
import java.time.format.DateTimeFormatter


@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ReminderFilled(
    back: () -> Unit,
    navigateToAddMed: () -> Unit
) {

    val rtdb = remember { RTDB() }
    var medicationList by remember { mutableStateOf<List<MedicationData>>(emptyList()) }
    var selectedDate by remember { mutableStateOf<LocalDate?>(null) }

    DisposableEffect(Unit) {
        val listener = rtdb.fetchMedication { medicationList = it }
        Log.i("fetchedData","$medicationList")
        onDispose {
            rtdb.db.child("reminders").child(rtdb.uid)
                .removeEventListener(listener)
        }
    }

    val filterMedications = if (selectedDate == null) {
        emptyList()
    } else {
        medicationList.filter { med ->
            try {
                val formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")
                val medStartDate = LocalDate.parse(med.medStartDate, formatter)
                !selectedDate!!.isBefore(medStartDate)
            } catch (e: Exception) {
                false
            }
        }
    }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        "Medication Reminder",
                        style = MaterialTheme.typography.titleMedium,
                        color = MaterialTheme.colorScheme.onBackground
                    )
                },
                navigationIcon = {
                    IconButton(onClick = back) {
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
                    .padding(horizontal = 12.dp)
                    .fillMaxSize()
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {

                    CalendarScreen(
                        selectedDate = selectedDate,
                        onDateSelected = { selectedDate = it }
                    )
                    Spacer(Modifier.height(20.dp))

                    if (selectedDate == null) {
                        Text(
                            "No date selected",
                            style = MaterialTheme.typography.titleSmall,
                            color = MaterialTheme.colorScheme.onBackground
                        )
                    }
                    else if (filterMedications.isEmpty()) {
                        Text(
                            "No medications for this date",
                            style = MaterialTheme.typography.titleSmall,
                            color = MaterialTheme.colorScheme.onBackground
                        )
                    }
                    else {
                        LazyColumn(
                            verticalArrangement = Arrangement.spacedBy(8.dp),
                            modifier = Modifier
                                .padding(horizontal = 12.dp)
                        ) {
                            items(filterMedications) {med ->
                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.Start,
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .background(MaterialTheme.colorScheme.surfaceContainer)
                                        .border(
                                            1.dp,
                                            MaterialTheme.colorScheme.onSurfaceVariant,
                                            RoundedCornerShape(6.dp)
                                        )
                                        .padding(10.dp)
                                ) {
                                    Image(
                                        painter = painterResource(R.drawable.paracetamol),
                                        contentDescription = null,
                                        modifier = Modifier.size(34.dp)
                                    )
                                    Spacer(Modifier.width(10.dp))
                                    Column {
                                        Text(
                                            med.medName,
                                            style = MaterialTheme.typography.titleSmall,
                                            color = MaterialTheme.colorScheme.onSurface
                                        )
                                        Spacer(Modifier.height(4.dp))
                                        Row {
                                            Text(
                                                med.dosage,
                                                style = MaterialTheme.typography.labelMedium,
                                                color = MaterialTheme.colorScheme.onSurface
                                            )
                                            Spacer(Modifier.width(4.dp))
                                            Text(
                                                med.timePeriod,
                                                style = MaterialTheme.typography.labelMedium,
                                                color = MaterialTheme.colorScheme.onSurface
                                            )
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                Button(
                    onClick = navigateToAddMed,
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.BottomCenter),
                    colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.primary),
                    border = BorderStroke(2.dp, MaterialTheme.colorScheme.outlineVariant)
                ) {
                    Text(
                        "Add medicine",
                        style = MaterialTheme.typography.titleMedium,
                        color = MaterialTheme.colorScheme.onPrimary
                    )
                }
            }
        }
    }
}
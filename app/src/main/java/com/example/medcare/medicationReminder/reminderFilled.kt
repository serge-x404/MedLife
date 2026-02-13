package com.example.medcare.medicationReminder

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.medcare.R
import java.time.LocalDate
import java.time.YearMonth
import java.time.format.DateTimeFormatter
import java.time.format.TextStyle
import java.util.Locale


@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ReminderFilled(
    medName: String,
    dosage: String,
    timings: String,
    back: () -> Unit
) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        "Medication Reminder",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
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
            Box(
                modifier = Modifier
                    .padding(horizontal = 12.dp)
                    .fillMaxSize()
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {

                    CalendarScreen()

                    Spacer(Modifier.height(20.dp))
                    Text(
                        "Today, 20 February, 2024",
                        fontSize = 16.sp,
                        textAlign = TextAlign.Center,
                        color = Color(0xFF4D4D4D)
                    )
                    Spacer(Modifier.height(20.dp))
                    Column(Modifier.padding(horizontal = 12.dp)) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Start,
                            modifier = Modifier
                                .fillMaxWidth()
                                .border(1.dp, color = Color(0xFFE3E3E3))
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
                                    medName,
                                    fontWeight = FontWeight.SemiBold,
                                    fontSize = 14.sp
                                )
                                Spacer(Modifier.height(4.dp))
                                Row {
                                    Text(
                                        dosage,
                                        fontSize = 14.sp
                                    )
                                    Spacer(Modifier.width(4.dp))
                                    Text(
                                        timings,
                                        fontSize = 14.sp
                                    )
                                }
                            }
                        }
                    }
                }
                Button(
                    onClick = {},
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.BottomCenter),
                    colors = ButtonDefaults.buttonColors(Color(0xFF26408B)),
                ) {
                    Text(
                        "Add medicine",
                        fontWeight = FontWeight.SemiBold
                    )
                }
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun CalendarHeader(
    month: YearMonth,
    onPreviousMonth: () -> Unit,
    onNextMonth: () -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.fillMaxWidth()
    ) {
        IconButton(onClick = onPreviousMonth) {
            Icon(
                imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft,
                contentDescription = null,
            )
        }
        Text(
            text = month.format(
                DateTimeFormatter.ofPattern("MMMM yyyy")
            ),
        )
        IconButton(onClick = onNextMonth) {
            Icon(
                imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                contentDescription = null,
            )
        }
    }
}


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun CalendarScreen() {
    var baseMonth by remember { mutableStateOf(YearMonth.now()) }
    var currentMonth by remember { mutableStateOf(baseMonth) }
    val canGoBack = currentMonth.isAfter(baseMonth)

    Column {
        CalendarHeader(
            month = currentMonth,
            onPreviousMonth = {
                if (canGoBack) {
                    currentMonth = currentMonth.minusMonths(1)
                }
            },
            onNextMonth = { currentMonth = currentMonth.plusMonths(1) }
        )
    }
    DateGrid(currentMonth)
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun CalendarGrid(month: YearMonth) {
    val daysInMonth = month.format(
        DateTimeFormatter.ofPattern("MMMM yyyy")
    )
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun DateCard(
    date: LocalDate,
) {
    Card(
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.elevatedCardElevation(2.dp),
        modifier = Modifier
            .size(80.dp)
            .clickable(
                onClick = {}
            )
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            Text(
                text = date.dayOfWeek.getDisplayName(
                    TextStyle.SHORT,
                    Locale.getDefault()
                ).uppercase(),
                color = Color.Black,
                textAlign = TextAlign.Center
            )
            Spacer(Modifier.height(8.dp))
            Text(
                text = date.dayOfMonth.toString(),
                color = Color.Black,
                textAlign = TextAlign.Center
            )
        }
    }
}


@RequiresApi(Build.VERSION_CODES.O)
fun getDatesForMonth(
    month: YearMonth,
    today: LocalDate = LocalDate.now()
): List<LocalDate> {
    val startDate =
        if (month == YearMonth.from(today)) {
            today
        } else {
            month.atDay(1)
        }
    val endDate = month.atEndOfMonth()

    val displayDate = mutableListOf<LocalDate>()
    var current = startDate
    while (!current.isAfter(endDate)) {
        displayDate.add(current)
        current = current.plusDays(1)
    }
    return displayDate
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun DateGrid(
    month: YearMonth,
) {
    val today = LocalDate.now()
    val dates = getDatesForMonth(month, today)

    LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
        items(dates) { item ->
            DateCard(item)
        }
    }
}
package com.example.medcare.class_objects

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.time.LocalDate
import java.time.YearMonth
import java.time.format.DateTimeFormatter
import java.time.format.TextStyle
import java.util.Locale

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
    var selectedDate by remember { mutableStateOf<LocalDate?>(null) }

    Column {
        CalendarHeader(
            month = currentMonth,
            onPreviousMonth = {
                if (canGoBack) {
                    currentMonth = currentMonth.minusMonths(1)
                }
            },
            onNextMonth = { currentMonth = currentMonth.plusMonths(1)
            }
        )
    }
    DateGrid(
        currentMonth,
        onDateSelected = { selectedDate = it }
    )
    Spacer(Modifier.height(20.dp))
    DateDisplay(selectedDate)
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
    onClick: () -> Unit
) {
    Card(
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primaryContainer),
        elevation = CardDefaults.elevatedCardElevation(2.dp),
        modifier = Modifier
            .size(70.dp)
            .clickable(
                onClick = onClick
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
                style = MaterialTheme.typography.labelLarge,
                color = MaterialTheme.colorScheme.onPrimaryContainer,
                textAlign = TextAlign.Center
            )
            Spacer(Modifier.height(8.dp))
            Text(
                text = date.dayOfMonth.toString(),
                style = MaterialTheme.typography.labelLarge,
                color = MaterialTheme.colorScheme.onPrimaryContainer,
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
    onDateSelected: (LocalDate) -> Unit
) {
    val today = LocalDate.now()
    val dates = getDatesForMonth(month, today)

    LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
        items(dates) { item ->
            DateCard(
                item,
                onClick = { onDateSelected(item) }
            )
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun DateDisplay(selectedDate: LocalDate?) {
    val selectedDate = selectedDate?.let { dateFormat(it) }?.format(
        DateTimeFormatter.ofPattern("dd MMMM yyyy")
    )

    Text(
        text = selectedDate?: "No date selected",
        style = MaterialTheme.typography.labelLarge,
        textAlign = TextAlign.Center
    )
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun dateFormat(date: LocalDate): String {
    val today = LocalDate.now()
    val tomorrow = today.plusDays(1)

    val formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy")

    return when(date) {
        today -> "Today, ${today.format(formatter)}"
        tomorrow -> "Tomorrow, ${tomorrow.format(formatter)}"
        else -> date.format(formatter)
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun DateScreen() {
    var baseMonth by remember { mutableStateOf(YearMonth.now()) }
    var currentMonth by remember { mutableStateOf(baseMonth) }
    var selectedDate by remember { mutableStateOf<LocalDate?>(null) }

    DateGrid(
        currentMonth,
        onDateSelected = { selectedDate = it }
    )
}
package com.serge.medlife.screens.layoutsFile

import android.widget.Toast
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.serge.medlife.screens.class_objects.Categories
import com.serge.medlife.screens.class_objects.ReviewContents

@Composable
fun GridViewLayout(
    categories: Categories,
    onNavigate: (String) -> Unit
) {
    val context = LocalContext.current
    Card(
        onClick = {
            Toast.makeText(context, categories.name, Toast.LENGTH_SHORT).show()
            categories.route?.let { onNavigate(it) }
        },
        modifier = Modifier
            .padding(8.dp)
            .size(96.dp),
        colors = CardDefaults.cardColors(MaterialTheme.colorScheme.primaryContainer),
        elevation = CardDefaults.elevatedCardElevation(2.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp)
        ) {
            Image(
                painter = painterResource(categories.icon),
                contentDescription = "Image",
                Modifier.size(36.dp),
                colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onBackground)
            )
            Spacer(Modifier.height(8.dp))
            Text(
                text = categories.name,
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.labelMedium,
                color = MaterialTheme.colorScheme.onBackground
            )
        }
    }
}

@Composable
fun DoctorWorkingHours(
    hours: String,
    selected: Boolean,
    onClick: () -> Unit
) {
//    var selected by remember { mutableStateOf(false) }
    Card(
        onClick = onClick,
        colors = if (selected) CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primary)
        else CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceContainer),
        border = if (selected) {
            BorderStroke(width = 1.dp, color = MaterialTheme.colorScheme.outlineVariant)
        } else BorderStroke(width = 1.dp, color = MaterialTheme.colorScheme.outline),
        shape = CardDefaults.shape,
        modifier = Modifier.size(height = 30.dp, width = 100.dp)
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            Text(
                text = hours,
                style = MaterialTheme.typography.labelMedium,
                modifier = Modifier.align(Alignment.Center)
            )
        }
    }
}


// Static date selection

//@Composable
//fun selectionDate(dateDay: DateDay) {
//    Card(
//        onClick = {},
//        modifier = Modifier
//            .size(60.dp),
//        colors = CardDefaults.cardColors(Color.White),
//        border = BorderStroke(width = 1.dp, color = Color(0xFFE3E3E3))
//    ) {
//        Column(
//            horizontalAlignment = Alignment.CenterHorizontally,
//            verticalArrangement = Arrangement.Center,
//            modifier = Modifier.fillMaxSize()
//        ) {
//            Text(
//                text = dateDay.day
//            )
//            Text(
//                text = dateDay.date
//            )
//        }
//    }
//}

@Composable
fun Reviews(reviewContents: ReviewContents) {
    var expanded by remember { mutableStateOf(false) }
    Card(
        onClick = {
            expanded = !expanded
        },
        colors = CardDefaults.cardColors(MaterialTheme.colorScheme.secondaryContainer),
        modifier = Modifier
            .width(250.dp)
            .animateContentSize()
    ) {
        Column(modifier = Modifier.padding(12.dp)) {
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                Image(
                    painter = painterResource(reviewContents.image),
                    contentDescription = null,
                    Modifier.size(70.dp)
                )
                Column(
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier.padding(top = 10.dp)
                ) {
                    Text(
                        text = reviewContents.name,
                        style = MaterialTheme.typography.titleSmall,
                        color = MaterialTheme.colorScheme.onSecondaryContainer
                    )
                    Text(
                        text = reviewContents.timePeriod,
                        style = MaterialTheme.typography.labelMedium,
                        color = MaterialTheme.colorScheme.onSecondaryContainer
                    )
                }
            }
            Spacer(Modifier.height(4.dp))
            Text(
                text = reviewContents.body,
                style = MaterialTheme.typography.labelMedium,
                color = MaterialTheme.colorScheme.onSecondaryContainer,
                overflow = TextOverflow.Ellipsis,
                maxLines = if (!expanded) 1 else 10,
                modifier = Modifier
                    .animateContentSize()
            )
        }
    }
}
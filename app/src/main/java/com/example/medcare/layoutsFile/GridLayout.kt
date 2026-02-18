package com.example.medcare.layoutsFile

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
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
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.medcare.R
import com.example.medcare.class_objects.Categories
import com.example.medcare.class_objects.DateDay
import com.example.medcare.class_objects.ReviewContents
import com.example.medcare.servicesScreen.chatDoc.doctorsSyntax

@Composable
fun gridViewLayout(
    categories: Categories,
    navHostController: NavHostController? = null
) {
    val context = LocalContext.current
    Card(
        onClick = {
            Toast.makeText(context,categories.name, Toast.LENGTH_SHORT).show()
            navHostController?.let {
                categories.route?.let {route ->
                    navHostController.navigate(route)
                }
            }
        },
        modifier = Modifier
            .padding(8.dp)
            .size(96.dp),
        colors = CardDefaults.cardColors(MaterialTheme.colorScheme.primaryContainer),
        elevation = CardDefaults.elevatedCardElevation(4.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize()
                .padding(10.dp)
        ) {
            Image(
                painter = painterResource(categories.icon),
                contentDescription = "Image",
                Modifier.size(36.dp),
                colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.surfaceTint)
            )
            Spacer(Modifier.height(8.dp))
            Text(
                text = categories.name,
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.labelMedium,
                color = MaterialTheme.colorScheme.onPrimaryContainer
            )
        }
    }
}

@Composable
fun doctorsListGrid(
    doctorsSyntax: doctorsSyntax,
    navigateToDocDtls: () -> Unit
) {
    Card(
        onClick = { navigateToDocDtls() },
        colors = CardDefaults.cardColors(MaterialTheme.colorScheme.surfaceContainer),
        elevation = CardDefaults.elevatedCardElevation(4.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Image(
                painter = painterResource(doctorsSyntax.image),
                contentDescription = null,
                Modifier
                    .size(90.dp)
                    .padding(start = 4.dp, end = 4.dp)
            )
            Spacer(Modifier.width(6.dp))
            Column(modifier = Modifier.weight(.1f)) {
                Text(
                    text = doctorsSyntax.name,
                    style = MaterialTheme.typography.titleSmall,
                    color = MaterialTheme.colorScheme.primary
                )
                Spacer(Modifier.height(4.dp))
                Text(
                    text = doctorsSyntax.speciality,
                    style = MaterialTheme.typography.labelMedium,
                    color = MaterialTheme.colorScheme.primary
                )
                Spacer(Modifier.height(10.dp))
                Text(
                    text = doctorsSyntax.availability,
                    color = MaterialTheme.colorScheme.onBackground,
                    fontWeight = FontWeight.Normal,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .background(MaterialTheme.colorScheme.background)
                )
            }
            Icon(
                imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.surfaceTint,
                modifier = Modifier.padding(end = 12.dp)
            )
        }
    }
}

@Composable
fun doctorWorkingHours(hours: String) {
    var selected by remember { mutableStateOf(false) }
    Card(
        onClick = {selected = !selected},
        colors = if (selected) CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.inverseOnSurface)
        else CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primaryContainer),
        border = if (selected){
            BorderStroke(width = 2.dp, color = MaterialTheme.colorScheme.surfaceTint)
        }
        else BorderStroke(width = 2.dp, color = MaterialTheme.colorScheme.inverseOnSurface),
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

@Composable
fun selectionDate(dateDay: DateDay) {
    Card(
        onClick = {},
        modifier = Modifier
            .size(60.dp),
        colors = CardDefaults.cardColors(Color.White),
        border = BorderStroke(width = 1.dp, color = Color(0xFFE3E3E3))
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            Text(
                text = dateDay.day
            )
            Text(
                text = dateDay.date
            )
        }
    }
}

@Composable
fun Reviews(reviewContents: ReviewContents) {
    Card(
        onClick = {},
        colors = CardDefaults.cardColors(MaterialTheme.colorScheme.primaryContainer),
        modifier = Modifier.size(height = 150.dp, width = 220.dp)
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
                        color = MaterialTheme.colorScheme.onPrimaryContainer
                    )
                    Text(
                        text = reviewContents.timeperiod,
                        style = MaterialTheme.typography.labelMedium,
                        color = MaterialTheme.colorScheme.onPrimaryContainer
                    )
                }
            }
            Spacer(Modifier.height(4.dp))
            Text(
                text = reviewContents.body,
                style = MaterialTheme.typography.labelMedium,
                color = MaterialTheme.colorScheme.onPrimaryContainer,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}
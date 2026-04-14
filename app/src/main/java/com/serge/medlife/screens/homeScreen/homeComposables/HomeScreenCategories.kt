package com.serge.medlife.screens.homeScreen.homeComposables

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.serge.medlife.R
import com.serge.medlife.navigation.NavRoute

data class HomeScreenCategories(
    val categoryTitle: String,
    val categoryIcon: Int,
    val route: String = NavRoute.ChatDoc.path
)

object CategoriesHomeScreen {
    val servicesHomeScreen = listOf(
        HomeScreenCategories(
            "All",
            R.drawable.all,
        ),
        HomeScreenCategories(
            "General Practitioner",
            R.drawable.general
        ),
        HomeScreenCategories(
            "Dentistry",
            R.drawable.dentist
        ),
        HomeScreenCategories(
            "Gynecology",
            R.drawable.gyanec
        ),
        HomeScreenCategories(
            "Ophthalmology",
            R.drawable.eye
        ),
        HomeScreenCategories(
            "Neurology",
            R.drawable.neuro
        ),
        HomeScreenCategories(
            "Otorhinolaryngology",
            R.drawable.ear
        ),
        HomeScreenCategories(
            "Pulmonologist",
            R.drawable.lungs
        )
    )
}


@Composable
fun CardServicesHomeScreen(
    homeScreenCategories: HomeScreenCategories,
    navigateToCategoryDoc: (String) -> Unit
) {
    Card(
        onClick = {
            Log.d("Category","Clicked: ${homeScreenCategories.categoryTitle}")
            navigateToCategoryDoc(homeScreenCategories.categoryTitle)
        },
        modifier = Modifier
            .size(100.dp),
        colors = CardDefaults.cardColors(MaterialTheme.colorScheme.surfaceContainer),
        border = BorderStroke(0.5.dp, MaterialTheme.colorScheme.outlineVariant),
        elevation = CardDefaults.elevatedCardElevation(1.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize()
                .padding(12.dp)
        ) {
            Image(
                painter = painterResource(homeScreenCategories.categoryIcon),
                contentDescription = "Image",
                Modifier.size(32.dp),
                colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onSurface)
            )
            Spacer(Modifier.height(8.dp))
            Text(
                text = homeScreenCategories.categoryTitle,
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.labelMedium,
                color = MaterialTheme.colorScheme.onSurface,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}
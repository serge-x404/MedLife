package com.serge.medlife.screens.homeScreen.homeComposables

import android.util.Log
import android.widget.Toast
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.serge.medlife.R
import com.serge.medlife.screens.navigation.NavRoute

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
    val context = LocalContext.current
    Card(
        onClick = {
            Log.d("Category","Clicked: ${homeScreenCategories.categoryTitle}")
            Toast.makeText(context, homeScreenCategories.categoryTitle, Toast.LENGTH_SHORT).show()
            navigateToCategoryDoc(homeScreenCategories.categoryTitle)
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
            modifier = Modifier
                .fillMaxSize()
                .padding(12.dp)
        ) {
            Image(
                painter = painterResource(homeScreenCategories.categoryIcon),
                contentDescription = "Image",
                Modifier.size(36.dp),
                colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onBackground)
            )
            Spacer(Modifier.height(8.dp))
            Text(
                text = homeScreenCategories.categoryTitle,
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.labelMedium,
                color = MaterialTheme.colorScheme.onBackground,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}
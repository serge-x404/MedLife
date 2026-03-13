package com.example.medcare.screens.homeScreen.homeComposables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.medcare.R
import com.example.medcare.rtdb.DoctorDetailsDTO
import com.example.medcare.rtdb.RTDB

@Composable
fun DoctorData(
    navigateToChatDoc: () -> Unit
) {
    val rtdb = RTDB()
    var doctorList by remember { mutableStateOf(emptyList<DoctorDetailsDTO>()) }

    LaunchedEffect(Unit) {
        rtdb.FetchDoctorInfo { doctorList = it }
    }

    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(doctorList) {
            Card(
                modifier = Modifier
                    .clickable{navigateToChatDoc()}
                    .background(MaterialTheme.colorScheme.surfaceContainerHighest)
            ) {
                val image = when (it.doctorGender) {
                    "Male" -> R.drawable.dr_rajesh
                    "Female" -> R.drawable.dr_anna
                    else -> R.drawable.profile
                }
                Image(
                    painter = painterResource(image),
                    contentDescription = null,
                    modifier = Modifier
                        .size(120.dp),
                    contentScale = ContentScale.Crop
                )
                Box {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Bottom,
                        modifier = Modifier
                            .width(120.dp)
                    ) {
                        Text(
                            it.doctorUserName,
                            style = MaterialTheme.typography.labelLarge.copy(
                                fontWeight = FontWeight.SemiBold
                            ),
                            color = MaterialTheme.colorScheme.onBackground,
                            textAlign = TextAlign.Center
                        )
                        Text(
                            it.doctorSpecialization,
                            style = MaterialTheme.typography.labelSmall.copy(
                                fontWeight = FontWeight.Bold
                            ),
                            color = MaterialTheme.colorScheme.onBackground,
                            textAlign = TextAlign.Center
                        )
                    }
                }
            }
        }
    }

//    if (doctorList.isNotEmpty()) {
//        Card(
//            modifier = Modifier
//                .background(MaterialTheme.colorScheme.surfaceContainerHighest)
//        ) {
//            val image = when (doctorList.doctorGender ?: "") {
//                "Male" -> R.drawable.doctormale
//                "Female" -> R.drawable.doctorfemale
//                else -> R.drawable.profile
//            }
//            Image(
//                painter = painterResource(image),
//                contentDescription = null,
//                modifier = Modifier
//                    .size(140.dp),
//                contentScale = ContentScale.FillHeight
//            )
//            Box {
//                Column(
//                    horizontalAlignment = Alignment.CenterHorizontally,
//                    verticalArrangement = Arrangement.Bottom,
//                    modifier = Modifier
//                        .width(120.dp)
//                ) {
//                    Text(
//                        doctorList.first().doctorUserName ?: "",
//                        style = MaterialTheme.typography.labelLarge,
//                        color = MaterialTheme.colorScheme.onBackground,
//                        textAlign = TextAlign.Center
//                    )
//                    Text(
//                        doctorList.first().doctorSpecialization ?: "",
//                        style = MaterialTheme.typography.labelSmall,
//                        color = MaterialTheme.colorScheme.onBackground,
//                        textAlign = TextAlign.Center
//                    )
//                }
//            }
//        }
//    }
}
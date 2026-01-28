package com.example.medcare.servicesScreen.chatDoc

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.medcare.R
import com.example.medcare.layoutsFile.doctorsListGrid
import com.example.medcare.layoutsFile.gridViewLayout

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true,
    showSystemUi = true)
@Composable
fun ChatDoctorScreen() {
    Scaffold(
        topBar = { TopAppBar(
            title = { Text(
                text = "Chat Doctor",
                fontSize = 16.sp,
                fontWeight = FontWeight.Normal
            ) },
            navigationIcon = { Icon(
                imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft,
                contentDescription = null
            ) }
        ) }
    ) { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)) {
            Box(modifier = Modifier) {
                Column() {
                    TextField(
                        value = "",
                        onValueChange = {},
                        placeholder = { Text(text = "Find a doctor") },
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Default.Search,
                                contentDescription = null
                            )
                        },
                        modifier = Modifier.padding(start = 8.dp),
                    )
                    Spacer(Modifier.height(10.dp))
                    LazyVerticalGrid(
                        columns = GridCells.Fixed(1),
                        verticalArrangement = Arrangement.SpaceEvenly,
                        modifier = Modifier.padding(start = 8.dp, end = 8.dp)
                    ) {
                        items(DoctorsGrid.listOfDoctors) { image ->
                            doctorsListGrid(image)
                        }
                    }
                }
            }
        }
    }
}

data class doctorsSyntax(
    val image: Int,
    val name: String,
    val speciality: String,
    val availability: String
)

object DoctorsGrid {
    val listOfDoctors = listOf(
        doctorsSyntax(R.drawable.dr_luca, "Dr. Luca Rossi", "Cardiology Specialist","Available on Wed-Sat"),
        doctorsSyntax(R.drawable.dr_marco,"Dr. Marco Ferrari","Orthopedics Specialist","Available on Wed-Tue"),
        doctorsSyntax(R.drawable.dr_sofia,"Dr. Sofia Muller","Dermatology Specialist","Available on Wed-Sat"),
        doctorsSyntax(R.drawable.dr_rajesh,"Dr. Rajesh Patel","General Surgery","Available on Wed-Sat"),
        doctorsSyntax(R.drawable.dr_anna,"Dr. Anna Schmidt","General Practitioner","Available on Wed-Sat"),
        doctorsSyntax(R.drawable.dr_emma,"Dr. Emma Andersen","Neurology Specialist","Available on Wed-Sat"),
        doctorsSyntax(R.drawable.dr_fabian,"Dr. Fabian Weber","General Surgery","Available on Wed-Sat"),
    )
}
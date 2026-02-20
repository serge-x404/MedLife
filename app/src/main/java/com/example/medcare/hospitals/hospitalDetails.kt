package com.example.medcare.hospitals

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
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
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.medcare.R
import com.example.medcare.class_objects.HospitalData
import com.example.medcare.class_objects.ListHospital

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun hospi() {
    HospitalDetails(hospital = HospitalData.data.first()){}
}


@Composable
fun HospitalDetails(hospital: ListHospital,
                    navigateToMap: () -> Unit
) {
    Scaffold() {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
                .verticalScroll(rememberScrollState())
                .padding(16.dp)
        ) {
            Image(
                painter = painterResource(hospital.hospitalImage),
                contentDescription = null,
                contentScale = ContentScale.FillWidth,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp)
                    .clip(shape = RoundedCornerShape(6.dp))
            )
            Spacer(Modifier.height(25.dp))
            Text(
                text = hospital.hospitalName,
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.onBackground
            )
            Spacer(Modifier.height(6.dp))
            Text(
                text = hospital.hospitalLocation,
                style = MaterialTheme.typography.labelMedium,
                color = MaterialTheme.colorScheme.onBackground
            )
            Spacer(Modifier.height(10.dp))
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = painterResource(R.drawable.phone),
                    contentDescription = null,
                    modifier = Modifier.size(15.dp),
                    colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onBackground)
                )
                Spacer(Modifier.width(6.dp))
                Text(
                    text = hospital.hospitalNumber,
                    style = MaterialTheme.typography.labelSmall,
                    color = MaterialTheme.colorScheme.onBackground
                )
            }
            Spacer(Modifier.height(20.dp))
            HorizontalDivider()
            Spacer(Modifier.height(20.dp))
            Text(
                text = "Specialities",
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.onBackground
            )
            Spacer(Modifier.height(12.dp))
            LazyVerticalGrid(
                GridCells.Fixed(4),
                modifier = Modifier.height(170.dp),
                horizontalArrangement = Arrangement.spacedBy(6.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                items(HospitalData.specialities) { item ->
                    SpecialitiesGrid(item)
                }
            }
            Spacer(Modifier.height(18.dp))
            HorizontalDivider()
            Spacer(Modifier.height(12.dp))
            Text(
                text = "Type Rooms",
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.onBackground
            )
            Column {
                HospitalData.rooms.forEach {

                        item ->
                    RoomGrid(item)
                }
            }
            Spacer(Modifier.height(40.dp))
        }
        Box(modifier = Modifier.fillMaxSize()) {
            Row(modifier = Modifier.align(Alignment.BottomCenter)
                .fillMaxWidth()
                .padding(16.dp)) {
                Button(onClick = {
                    navigateToMap()
                },
                    colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.surfaceContainer),
                    border = BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant),
                    modifier = Modifier.weight(1f)
                ) {
                    Text(
                        "Maps",
                        style = MaterialTheme.typography.titleMedium,
                        color = MaterialTheme.colorScheme.onBackground
                    )
                }
                Spacer(Modifier.width(6.dp))
                Button(onClick = {},
                    colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.tertiaryContainer),
                    border = BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant),
                    modifier = Modifier.weight(2f)
                ) {
                    Text(
                        "Contact Now",
                        style = MaterialTheme.typography.titleMedium,
                        color = MaterialTheme.colorScheme.onBackground
                    )
                }
            }
        }
    }
}
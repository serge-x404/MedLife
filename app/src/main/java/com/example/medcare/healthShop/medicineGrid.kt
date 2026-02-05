package com.example.medcare.healthShop

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.medcare.class_objects.pharmaImages

@Preview(showBackground = true,
    showSystemUi = true)
@Composable
fun MedicineGrid(
    navigateToMedDesc: () -> Unit
) {
    LazyVerticalGrid(GridCells.Fixed(2),
        modifier = Modifier.padding(20.dp)) {
        items(pharmaImages.medicineGrid) {
            item -> HotSalesGrid(item, navigateToMedDesc)
        }
    }
}
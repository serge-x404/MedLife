package com.example.medcare.article

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.medcare.class_objects.Hot

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true,
    showSystemUi = true)
@Composable
fun ArticlePage(
    navigateToArticle: () -> Unit
) {
    Scaffold(
        topBar = { CenterAlignedTopAppBar(
            title = { OutlinedTextField(
                value = "",
                onValueChange = {},
                placeholder = { Text("Search for article") },
                leadingIcon = { Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = null
                ) }
            ) },
            navigationIcon = { Icon(
                imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft,
                contentDescription = null
            ) }
        ) }
    ) { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)) {
            LazyVerticalGrid(GridCells.Fixed(1)) {
                items(Hot.latestArticle) {
                        item -> LatestArticle(item, navigateToArticle)
                }
            }
        }
    }
}
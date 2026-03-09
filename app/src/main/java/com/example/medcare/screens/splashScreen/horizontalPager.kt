package com.example.medcare.screens.splashScreen

import android.content.SharedPreferences
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.core.content.edit
import kotlinx.coroutines.launch

@Composable
fun HPager(
    navigateToAuthSplash: () -> Unit,
    sharedPreferences: SharedPreferences
) {
    val pages = _root_ide_package_.com.example.medcare.screens.splashScreen.OnBoardContent.pages
    val pagerState = rememberPagerState(
        initialPage = 0, pageCount = { pages.count() })
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(12.dp),
        modifier = Modifier.background(MaterialTheme.colorScheme.surfaceContainerHighest)
            .padding(horizontal = 12.dp)
    ) {
        HorizontalPager(pagerState,
            Modifier.weight(0.75f)
                .background(MaterialTheme.colorScheme.surfaceContainerHighest)
        ) { index ->
            _root_ide_package_.com.example.medcare.screens.splashScreen.walkthrough(pages[index])
        }

        val isLast = pagerState.currentPage == pages.lastIndex

        val scope = rememberCoroutineScope()
        _root_ide_package_.com.example.medcare.screens.splashScreen.dotIndiactor(pagerState.currentPage)
        Button(
            onClick = {
                scope.launch {
                    if(isLast) {
                        navigateToAuthSplash()
                        sharedPreferences.edit(commit = true) {
                            putBoolean("isOnBoarded", true)
                        }
                    } else {
                        pagerState.animateScrollToPage(
                            pagerState.currentPage+1,
                            animationSpec = tween(600)
                        )
                    }
                }
            },
            colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.secondary),
            border = BorderStroke(2.dp, MaterialTheme.colorScheme.outlineVariant),
            modifier = Modifier.fillMaxWidth()
                .padding(bottom = 36.dp)
        ) {
            Text(
                text = if(isLast) "Continue" else "Next",
                style = MaterialTheme.typography.labelLarge,
                color = MaterialTheme.colorScheme.onTertiary
            )
        }
    }
}
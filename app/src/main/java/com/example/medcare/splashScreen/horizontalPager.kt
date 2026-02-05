package com.example.medcare.splashScreen

import androidx.compose.animation.core.animate
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@Preview(
    showBackground = true, showSystemUi = true
)
@Composable
fun hPager(
    navigateToHome: () -> Unit
) {
    val pages = OnBoardContent.pages
    val pagerState = rememberPagerState(
        initialPage = 0, pageCount = { pages.count() })
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(12.dp),
        modifier = Modifier.padding(12.dp)
    ) {
        HorizontalPager(pagerState,
            Modifier.weight(0.75f)) { index ->
            walkthrough(pages[index])
        }

        val isLast = pagerState.currentPage == pages.lastIndex

        val scope = rememberCoroutineScope()
        dotIndiactor(pagerState.currentPage)
        Button(
            onClick = {
                scope.launch {
                    if(isLast) {
                        navigateToHome()
                    } else {
                        pagerState.animateScrollToPage(
                            pagerState.currentPage+1,
                            animationSpec = tween(600)
                        )
                    }
                }
            }, colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF26408B)
            ), modifier = Modifier.fillMaxWidth()
                .padding(bottom = 36.dp)
        ) {
            Text(
                text = if(isLast) "Continue" else "Next"
            )
        }
    }
}
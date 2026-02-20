package com.example.medcare.article

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.medcare.class_objects.Article

@Composable
fun ArticleLayout(article: Article,
                  navigateToArticle: () -> Unit
) {
    Card() {
        Box {
            Image(
                painter = painterResource(article.image),
                contentDescription = null,
                modifier = Modifier.height(150.dp),
                contentScale = ContentScale.FillHeight,
            )
            Column(verticalArrangement = Arrangement.Bottom,
                modifier = Modifier.padding(top = 60.dp, start = 6.dp)) {
                Text("5 tips for boosting your Immune System\n " +
                        "Naturally",
                    color = Color.White,
                    style = MaterialTheme.typography.titleSmall
                )
                Button(onClick = {
                    navigateToArticle()
                },
                    colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.primary),
                    shape = RoundedCornerShape(14.dp),
                    modifier = Modifier.align(Alignment.Start)
                ) {
                    Text(
                        "Read Article",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onPrimary
                    )
                }
            }
        }
    }
}


@Composable
fun TopicLayout(article: Article) {
    Card {
        Box(modifier = Modifier.fillMaxWidth()) {
            Image(
                painter = painterResource(article.image),
                contentDescription = null,
                modifier = Modifier.height(80.dp),
                contentScale = ContentScale.FillHeight
            )
            Text(
                article.text,
                color = Color.White,
                fontWeight = FontWeight.SemiBold,
                textAlign = TextAlign.Center,
                modifier = Modifier.align(Alignment.Center)
            )
        }
    }
}


@Composable
fun LatestArticle(article: Article,
                  navigateToArticle: () -> Unit
) {
    Card(
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceContainer),
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.outline),
        modifier = Modifier
            .clickable(
            enabled = true,
            onClick = {
                navigateToArticle()
            }
        )) {
        Row(modifier = Modifier.padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(article.image),
                contentDescription = null,
                modifier = Modifier.size(80.dp)
            )
            Spacer(Modifier.width(6.dp))
            Text(article.text,
                style = MaterialTheme.typography.labelLarge,
                color = MaterialTheme.colorScheme.onBackground
            )
        }
    }
}
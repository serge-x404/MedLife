package com.example.medcare.class_objects

import com.example.medcare.R

data class Article(
    val image: Int,
    val text: String,
)

object Hot {
    val hotArticle = listOf(
        Article(R.drawable.fruits,"5 tips for boosting immunity naturally"),
        Article(R.drawable.fruits,"5 tips for boosting immunity naturally"),
        Article(R.drawable.fruits,"5 tips for boosting immunity naturally"),
        Article(R.drawable.fruits,"5 tips for boosting immunity naturally")
    )

    val hotTopic = listOf(
        Article(R.drawable.health,"Mental Health"),
        Article(R.drawable.life,"Lifestyle"),
        Article(R.drawable.globe,"Lorem Ipsum"),
        Article(R.drawable.health,"Mental Health"),
        Article(R.drawable.life,"Lifestyle"),
        Article(R.drawable.globe,"Lorem Ipsum"),
    )

    val latestArticle = listOf(
        Article(R.drawable.hanta,"Getting to know Hanta Virus Disease from Rodents"),
        Article(R.drawable.vaccine,"Getting to know Hanta Virus Disease from Rodents"),
        Article(R.drawable.lab,"Getting to know Hanta Virus Disease from Rodents"),
        Article(R.drawable.hanta,"Getting to know Hanta Virus Disease from Rodents"),
        Article(R.drawable.vaccine,"Getting to know Hanta Virus Disease from Rodents"),
        Article(R.drawable.lab,"Getting to know Hanta Virus Disease from Rodents"),
        Article(R.drawable.hanta,"Getting to know Hanta Virus Disease from Rodents"),
        Article(R.drawable.vaccine,"Getting to know Hanta Virus Disease from Rodents"),
        Article(R.drawable.lab,"Getting to know Hanta Virus Disease from Rodents"),
    )
}
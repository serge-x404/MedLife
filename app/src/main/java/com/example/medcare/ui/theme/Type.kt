package com.example.medcare.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.medcare.R


val Khula = FontFamily(
    Font(R.font.khula_regular, FontWeight.Normal),
    Font(R.font.khula_bold, FontWeight.Bold),
    Font(R.font.khula_semibold, FontWeight.SemiBold),
    Font(R.font.khula_extrabold, FontWeight.ExtraBold),
)

val AppTypography = Typography(
    bodyLarge = TextStyle(
        fontFamily = Khula,
        fontSize = 16.sp
    ),
    titleLarge = TextStyle(
        fontFamily = Khula,
        fontSize = 22.sp
    )
)
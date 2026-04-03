package com.serge.medlife.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import com.serge.medlife.R

val Khula = FontFamily(
    Font(R.font.khula_bold, FontWeight.Bold),
    Font(R.font.khula_semibold, FontWeight.SemiBold),
    Font(R.font.khula_light, FontWeight.Light),
    Font(R.font.khula_regular, FontWeight.Normal),
    Font(R.font.khula_extrabold, FontWeight.ExtraBold)
)

val AppTypography = Typography(

    displayLarge = Typography().displayLarge.copy(fontFamily = Khula),
    displayMedium = Typography().displayMedium.copy(fontFamily = Khula),
    displaySmall = Typography().displaySmall.copy(fontFamily = Khula),

    headlineLarge = Typography().headlineLarge.copy(fontFamily = Khula),
    headlineMedium = Typography().headlineMedium.copy(fontFamily = Khula),
    headlineSmall = Typography().headlineSmall.copy(fontFamily = Khula),

    titleLarge = Typography().titleLarge.copy(fontFamily = Khula),
    titleMedium = Typography().titleMedium.copy(fontFamily = Khula),
    titleSmall = Typography().titleSmall.copy(fontFamily = Khula),

    labelLarge = Typography().labelLarge.copy(fontFamily = Khula),
    labelMedium = Typography().labelMedium.copy(fontFamily = Khula),
    labelSmall = Typography().labelSmall.copy(fontFamily = Khula),

    bodyLarge = Typography().bodyLarge.copy(fontFamily = Khula),
    bodyMedium = Typography().bodyMedium.copy(fontFamily = Khula),
    bodySmall = Typography().bodySmall.copy(fontFamily = Khula),
)
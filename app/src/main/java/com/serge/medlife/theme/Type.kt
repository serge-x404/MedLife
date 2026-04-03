package com.serge.medlife.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.serge.medlife.R

val Khula = FontFamily(
    Font(R.font.khula_bold, FontWeight.Bold),
    Font(R.font.khula_semibold, FontWeight.SemiBold),
    Font(R.font.khula_light, FontWeight.Light),
    Font(R.font.khula_regular, FontWeight.Normal),
    Font(R.font.khula_extrabold, FontWeight.ExtraBold)
)

val AppTypography = Typography(

    displayLarge = Typography().displayLarge.copy(fontFamily = Khula, fontWeight = FontWeight.ExtraBold, fontSize = 26.sp),
    displayMedium = Typography().displayMedium.copy(fontFamily = Khula, fontWeight = FontWeight.ExtraBold),
    displaySmall = Typography().displaySmall.copy(fontFamily = Khula, fontWeight = FontWeight.ExtraBold),

    headlineLarge = Typography().headlineLarge.copy(fontFamily = Khula, fontWeight = FontWeight.Bold, fontSize = 24.sp),
    headlineMedium = Typography().headlineMedium.copy(fontFamily = Khula, fontWeight = FontWeight.Bold),
    headlineSmall = Typography().headlineSmall.copy(fontFamily = Khula, fontWeight = FontWeight.Bold),

    titleLarge = Typography().titleLarge.copy(fontFamily = Khula, fontWeight = FontWeight.SemiBold, fontSize = 18.sp),
    titleMedium = Typography().titleMedium.copy(fontFamily = Khula, fontWeight = FontWeight.SemiBold, fontSize = 18.sp),
    titleSmall = Typography().titleSmall.copy(fontFamily = Khula, fontWeight = FontWeight.SemiBold, fontSize = 18.sp),

    labelLarge = Typography().labelLarge.copy(fontFamily = Khula, fontWeight = FontWeight.Normal, fontSize = 16.sp),
    labelMedium = Typography().labelMedium.copy(fontFamily = Khula, fontWeight = FontWeight.Normal),
    labelSmall = Typography().labelSmall.copy(fontFamily = Khula, fontWeight = FontWeight.Normal),

    bodyLarge = Typography().bodyLarge.copy(fontFamily = Khula, fontWeight = FontWeight.Normal, fontSize = 12.sp),
    bodyMedium = Typography().bodyMedium.copy(fontFamily = Khula, fontWeight = FontWeight.Normal),
    bodySmall = Typography().bodySmall.copy(fontFamily = Khula, fontWeight = FontWeight.Normal),
)
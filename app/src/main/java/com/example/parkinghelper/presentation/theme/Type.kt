package com.example.parkinghelper.presentation.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

val mainFont : FontFamily = FontFamily.Default

val Typography = Typography(
    headlineLarge = TextStyle(
        fontSize = 48.sp,
        fontFamily = mainFont,
        fontWeight = FontWeight.Medium
    ),
    headlineMedium = TextStyle(
        fontSize = 44.sp,
        fontFamily = mainFont,
        fontWeight = FontWeight.SemiBold
    ),
    titleLarge = TextStyle(
        fontSize = 20.sp,
        fontFamily = mainFont,
        fontWeight = FontWeight.Medium
    ),
    titleMedium = TextStyle(
        fontSize = 18.sp,
        fontFamily = mainFont,
        fontWeight = FontWeight.Medium
    ),
    bodyLarge = TextStyle(
        fontSize = 16.sp,
        fontFamily = mainFont,
        fontWeight = FontWeight.Medium
    ),
    bodyMedium = TextStyle(
        fontSize = 15.sp,
        fontFamily = mainFont,
        fontWeight = FontWeight.Medium
    ),
    bodySmall = TextStyle(
        fontSize = 12.sp,
        fontFamily = mainFont,
        fontWeight = FontWeight.Light,
        letterSpacing = 0.05.sp
    )
)
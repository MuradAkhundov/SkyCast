package com.muradakhundov.skycast.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.muradakhundov.skycast.R

// Set of Material typography styles to start with

val ubuntuFont = FontFamily(listOf(
    Font(R.font.ubuntu)
))

val russoFont = FontFamily(
    listOf(Font(R.font.russo_regular))
)
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    )

)
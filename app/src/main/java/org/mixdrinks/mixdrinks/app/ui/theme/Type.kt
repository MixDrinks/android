package org.mixdrinks.mixdrinks.app.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import org.mixdrinks.mixdrinks.R

private val appFontFamily: FontFamily = FontFamily(
    Font(R.font.source_sans_pro_regular, FontWeight.Normal),
    Font(R.font.source_sans_pro_bold, FontWeight.Bold)
)

// Set of Material typography styles to start with
val Typography = Typography(
    body1 = TextStyle(
        fontFamily = appFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 18.sp,
        color = Green700
    ),
    body2 = TextStyle(
        fontSize = 14.sp,
        color = Green700
    ),
    h1 = TextStyle(
        fontWeight = FontWeight.W700,
        fontSize = 32.sp,
        color = Color.Black
    ),
    h2 = TextStyle(
        fontWeight = FontWeight.W700,
        fontSize = 24.sp,
        color = Black18
    ),
    h3 = TextStyle(
        fontWeight = FontWeight.W600,
        fontSize = 18.sp,
        color = Color.Black
    ),
    h4 = TextStyle(
        fontWeight = FontWeight.Bold,
        fontSize = 14.sp,
        color = Green700
    ),
    button = TextStyle(
        fontSize = 14.sp,
        color = Color.White,
    ),

    /* Other default text styles to override
    button = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )
    */
)

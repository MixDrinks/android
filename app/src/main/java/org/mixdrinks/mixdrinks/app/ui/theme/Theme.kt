package org.mixdrinks.mixdrinks.app.ui.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import com.google.accompanist.systemuicontroller.rememberSystemUiController

private val DarkColorPalette = darkColors(
    primary = Green700,
    primaryVariant = Green,
    secondary = Black
)

private val LightColorPalette = lightColors(
    primary = Green700,
    primaryVariant = Green,
    secondary = Black,

    /* Other default colors to override
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
)



@Composable
fun MixDrinksTheme(darkTheme: Boolean = false, content: @Composable () -> Unit) {
    val systemUiController = rememberSystemUiController()
    val colors = if (darkTheme) {
        systemUiController.setSystemBarsColor(color = DarkColorPalette.primary)
        DarkColorPalette
    } else {
        systemUiController.setSystemBarsColor(color = LightColorPalette.primary)
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}


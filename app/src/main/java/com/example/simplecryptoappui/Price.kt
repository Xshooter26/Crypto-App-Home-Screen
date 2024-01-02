package com.example.simplecryptoappui

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector

data class Price(
    val icon : Int,
    val name : String,
    val price : String,
    val color : Brush
)

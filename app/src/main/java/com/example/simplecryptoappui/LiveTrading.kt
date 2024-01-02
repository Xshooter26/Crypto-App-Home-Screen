package com.example.simplecryptoappui

import androidx.compose.ui.graphics.Brush

data class LiveTrading(
    val icon : Int,
    val name : String,
    val price : String,
    val currentPrice : String,
    val availableCoin : String,
    val color : Brush
)

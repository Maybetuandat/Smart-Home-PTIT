package com.example.smarthomeptit.model

import androidx.compose.ui.graphics.painter.Painter

data class ItemCard(
    val data : String,
    val icon: Painter,
    val label : String
)

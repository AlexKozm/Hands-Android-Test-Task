package com.example.handsandroidtesttask

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

enum class CellsTypes(
    val headLine: String,
    val support: String,
    val avatarText: String,
    val brush: Brush
) {
    DEAD(
        avatarText = "\uD83D\uDC80",
        headLine = "Мёртвая",
        support = "или прикидывается",
        brush = Brush.verticalGradient(
            listOf(Color(0xFF0D658A), Color(0xFFB0FFB4))
        )
    ),
    ALIVE(
        avatarText = "\uD83D\uDCA5",
        headLine = "Живая",
        support = "и шевелится!",
        brush = Brush.verticalGradient(
            listOf(Color(0xFFFFB800), Color(0xFFFFF7B0))
        )
    ),
    LIFE(
        avatarText = "\uD83D\uDC23",
        headLine = "Жизнь",
        support = "Ку-ку!",
        brush = Brush.verticalGradient(
            listOf(Color(0xFFAD00FF), Color(0xFFFFB0E9))
        )
    )
}


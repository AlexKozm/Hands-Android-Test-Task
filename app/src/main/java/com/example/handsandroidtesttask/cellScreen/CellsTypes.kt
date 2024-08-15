package com.example.handsandroidtesttask.cellScreen

import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.text.InlineTextContent
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.Placeholder
import androidx.compose.ui.text.PlaceholderVerticalAlign
import androidx.compose.ui.unit.sp
import com.example.handsandroidtesttask.R

enum class CellsTypes(
    @StringRes
    val headLine: Int,
    @StringRes
    val support: Int,
    @StringRes
    val avatarText: Int,
    val brush: Brush
) {
    DEAD(
        avatarText = R.string.skull_emoji,
        headLine = R.string.dead_cell_head_line,
        support = R.string.dead_cell_support,
        brush = Brush.verticalGradient(
            listOf(Color(0xFF0D658A), Color(0xFFB0FFB4))
        )
    ),
    ALIVE(
        avatarText = R.string.boom_emoji,
        headLine = R.string.alive_cell_head_line,
        support = R.string.alive_cell_support,
        brush = Brush.verticalGradient(
            listOf(Color(0xFFFFB800), Color(0xFFFFF7B0))
        )
    ),
    LIFE(
        avatarText = R.string.hatching_chick_emoji,
        headLine = R.string.life_cell_head_line,
        support = R.string.life_cell_support,
        brush = Brush.verticalGradient(
            listOf(Color(0xFFAD00FF), Color(0xFFFFB0E9))
        )
    )
}

private val defaultPlaceholder get() = Placeholder(
    width = 20.sp,
    height = 20.sp,
    placeholderVerticalAlign = PlaceholderVerticalAlign.Center
)

val cellsTypesInlineContent = mapOf(
    CellsTypes.DEAD.avatarText.toString().let { it to InlineTextContent(defaultPlaceholder) {
        Image(
            painter = painterResource(id = R.drawable.skull_emoji),
            contentDescription = "skull emoji",
        )
    } },
    CellsTypes.ALIVE.avatarText.toString().let { it to InlineTextContent(defaultPlaceholder) {
        Image(
            painter = painterResource(id = R.drawable.boom_emoji),
            contentDescription = "boom emoji",
        )
    } },
    CellsTypes.LIFE.avatarText.toString().let { it to InlineTextContent(defaultPlaceholder) {
        Image(
            painter = painterResource(id = R.drawable.hatching_chick_emoji),
            contentDescription = "hatching chick emoji",
        )
    } }
)



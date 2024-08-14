package com.example.handsandroidtesttask

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ListItem
import androidx.compose.material3.ListItemDefaults
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.handsandroidtesttask.ui.theme.HandsAndroidTestTaskTheme
import com.example.handsandroidtesttask.ui.theme.LightColorScheme

@Composable
fun CellCard(
    modifier: Modifier = Modifier,
    headLine: String,
    support: String,
    avatarText: String,
    brush: Brush
) {
    MaterialTheme(colorScheme = LightColorScheme) {
        ListItem(
            modifier = modifier
                .clip(RoundedCornerShape(8.dp)),
            leadingContent = {
                Box(
                    modifier = Modifier
                        .size(40.dp)
                        .background(brush, CircleShape),
                    contentAlignment = Alignment.Center
                ){
                    Text(
                        text = avatarText,
                    )
                }
            },
            headlineContent = {
                Text(
                    text = headLine,
                )
            },
            supportingContent = {
                Text(
                    text = support,
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        )
    }

}

@Composable
fun CellCard(modifier: Modifier = Modifier, cardType: CellsTypes) {
    with(cardType) {
        CellCard(
            modifier = modifier,
            headLine = headLine,
            support = support,
            avatarText = avatarText,
            brush = brush
        )
    }

}

@Preview
@Composable
private fun DeadCellCardPreview() {
    HandsAndroidTestTaskTheme {
        CellCard(cardType = CellsTypes.DEAD)
    }
}

@Preview
@Composable
private fun AliveCellCardPreview() {
    HandsAndroidTestTaskTheme {
        CellCard(cardType = CellsTypes.ALIVE)
    }
}

@Preview
@Composable
private fun LifeCellCardPreview() {
    HandsAndroidTestTaskTheme {
        CellCard(cardType = CellsTypes.LIFE)
    }
}
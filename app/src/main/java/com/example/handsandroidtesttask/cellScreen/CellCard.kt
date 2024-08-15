package com.example.handsandroidtesttask.cellScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.InlineTextContent
import androidx.compose.foundation.text.appendInlineContent
import androidx.compose.material3.ListItem
import androidx.compose.material3.ListItemColors
import androidx.compose.material3.ListItemDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.handsandroidtesttask.ui.theme.HandsAndroidTestTaskTheme


@Composable
fun CellCard(
    modifier: Modifier = Modifier,
    headLineText: String,
    supportText: String,
    avatarText: AnnotatedString,
    avatarInlineContent: Map<String, InlineTextContent>,
    avatarBackground: Brush,
    cardColors: ListItemColors = cellCardColorsDefault()
) {
    ListItem(
        modifier = modifier.clip(RoundedCornerShape(8.dp)),
        colors = cardColors,
        leadingContent = {
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .background(avatarBackground, CircleShape),
                contentAlignment = Alignment.Center
            ){
                Text(
                    text = avatarText,
                    style = MaterialTheme.typography.bodyLarge,
                    inlineContent = avatarInlineContent
                )
            }
        },
        headlineContent = { Text(text = headLineText) },
        supportingContent = { Text(text = supportText) }
    )
}

@Composable
fun CellCard(modifier: Modifier = Modifier, cardType: CellsTypes) {
    with(cardType) {
        val text = buildAnnotatedString {
            appendInlineContent(
                id = avatarText.toString(),
                alternateText = stringResource(id = avatarText)
            )
        }
        CellCard(
            modifier = modifier,
            headLineText = stringResource(id = headLine),
            supportText = stringResource(id = support),
            avatarText = text,
            avatarInlineContent = cellsTypesInlineContent,
            avatarBackground = brush
        )
    }
}

@Composable
fun cellCardColorsDefault(): ListItemColors =
    ListItemDefaults.colors(
        containerColor = MaterialTheme.colorScheme.inverseSurface,
        headlineColor = MaterialTheme.colorScheme.inverseOnSurface,
        supportingColor = MaterialTheme.colorScheme.inverseOnSurface
    )

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
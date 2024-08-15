package com.example.handsandroidtesttask.cellScreen

import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.handsandroidtesttask.R
import com.example.handsandroidtesttask.ui.theme.HandsAndroidTestTaskTheme
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CellsScreen(
    modifier: Modifier = Modifier,
    onCreateClick: () -> Unit,
    items: List<CellsTypes>
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
    ) {
        val listState = rememberLazyListState()
        val coroutineScope = rememberCoroutineScope()
        LazyColumn(
            modifier = Modifier.weight(1f),
            state = listState,
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            itemsIndexed(
                items = items,
                key = {i, _ -> i}
            ) {_, cardType ->
                CellCard(
                    modifier = Modifier.animateItemPlacement(
                        tween(durationMillis = 1000)
                    ),
                    cardType = cardType
                )
            }
        }
        Button(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(4.dp),
            onClick = {
                onCreateClick()
                coroutineScope.launch {
                    if (items.lastIndex >= 0)
                        listState.animateScrollToItem(items.lastIndex)
                }
            }
        ) {
            Text(
                modifier = Modifier.padding(2.dp),
                text = stringResource(R.string.create_cell_button),
                style = MaterialTheme.typography.labelLarge
            )
        }
    }
    
}

@Preview
@Composable
private fun CellsScreenPreview() {
    HandsAndroidTestTaskTheme {
        CellsScreen(
            items = listOf(
                CellsTypes.DEAD,
                CellsTypes.ALIVE,
                CellsTypes.ALIVE,
                CellsTypes.ALIVE,
                CellsTypes.LIFE,
            ),
            onCreateClick = {}
        )
    }
}
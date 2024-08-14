package com.example.handsandroidtesttask

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

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
            items(items) { cardType ->
                CellCard(cardType = cardType)
            }
        }
        Button(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(4.dp),
            colors = ButtonDefaults.buttonColors().copy(
                containerColor = Color(0xFF5A3472),
                contentColor = Color.White
            ),
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
                text = "СОТВОРИТЬ",
                style = MaterialTheme.typography.labelLarge
            )
        }
    }
    
}

@Preview
@Composable
private fun CellsScreenPreview() {
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
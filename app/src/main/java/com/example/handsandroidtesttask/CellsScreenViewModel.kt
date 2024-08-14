package com.example.handsandroidtesttask

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlin.random.Random

class CellsScreenViewModel : ViewModel() {
    private val _cells: MutableStateFlow<List<CellsTypes>> = MutableStateFlow(emptyList())
    val cells: StateFlow<List<CellsTypes>> = _cells.asStateFlow()

    fun addSell() {
        _cells.value += CellsTypes.entries[(0..1).random()]
        if (_cells.value.run {
                size >= 3 && takeLast(3).all { it == CellsTypes.ALIVE }
            }) {
            _cells.value += CellsTypes.LIFE
        }
    }
}
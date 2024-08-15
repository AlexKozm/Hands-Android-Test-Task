package com.example.handsandroidtesttask.cellScreen

import androidx.lifecycle.ViewModel
import com.example.handsandroidtesttask.getValue
import com.example.handsandroidtesttask.setValue
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class CellsScreenViewModel : ViewModel() {
    private val _cellsStateFlow: MutableStateFlow<List<CellsTypes>> = MutableStateFlow(emptyList())
    private var _cells by _cellsStateFlow
    val cells: StateFlow<List<CellsTypes>> = _cellsStateFlow.asStateFlow()

    fun addRandomSell() {
        val cell = CellsTypes.entries[(0..1).random()]
        addCell(cell)
    }

    fun addCell(cell: CellsTypes) {
        _cells += cell
        if (_cells.run { size >= 3 && takeLast(3).all { it == CellsTypes.ALIVE } }) {
            _cells += CellsTypes.LIFE
        }
        if (_cells.run { size >= 4 && takeLast(3).all { it == CellsTypes.DEAD } }) {
            _cells = _cells.filterIndexed{ i, _ -> i != _cells.lastIndex - 4 }
        }
    }

    fun clearCells() {
        _cells = emptyList()
    }
}
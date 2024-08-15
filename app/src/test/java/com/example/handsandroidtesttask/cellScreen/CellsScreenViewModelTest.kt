package com.example.handsandroidtesttask.cellScreen

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import kotlin.math.max


class CellsScreenViewModelTest {

    @Nested
    inner class AddRandomSell {
        @Test
        fun `cells is empty on view model initialization`() {
            Assertions.assertTrue(CellsScreenViewModel().cells.value.isEmpty())
        }
        @Test
        fun `life is not created when number of cells is less than 3`() {
            val vm = CellsScreenViewModel()
            listOf(CellsTypes.LIFE).checkThatListStaysTheSame(vm)
            listOf(CellsTypes.LIFE, CellsTypes.LIFE).checkThatListStaysTheSame(vm)
            listOf(CellsTypes.DEAD, CellsTypes.LIFE).checkThatListStaysTheSame(vm)
            listOf(CellsTypes.LIFE, CellsTypes.DEAD).checkThatListStaysTheSame(vm)
        }

        @Test
        fun `life is not created when number of alive cells in a row is less than 3`() {
            val vm = CellsScreenViewModel()
            List(10) { when(it % 2 == 0) {
                true -> CellsTypes.ALIVE
                false -> CellsTypes.DEAD
            } }.checkThatListStaysTheSame(vm)
        }

        @Test
        fun `delete life before 3 dead cells`() {
            val vm = CellsScreenViewModel()
            (List(3) { CellsTypes.ALIVE } + List(3) { CellsTypes.DEAD })
                .forEach { vm.addCell(it) }
            Assertions.assertEquals(6, vm.cells.value.size)
        }

        @Test
        fun `life is created after 3 alive cells`() {
            val vm = CellsScreenViewModel()
            List(3) { CellsTypes.ALIVE }.checkLifeOnPositions(vm, 3)
            List(6) { CellsTypes.ALIVE }.checkLifeOnPositions(vm, 3, 7)
        }


        private fun List<CellsTypes>.checkLifeOnPositions(
            vm: CellsScreenViewModel,
            vararg pos: Int
        ) {
            forEach { vm.addCell(it) }
            for (i in pos) {
                Assertions.assertEquals(vm.cells.value[i], CellsTypes.LIFE)
            }
            vm.clearCells()
        }


        private fun List<CellsTypes>.checkThatListStaysTheSame(vm: CellsScreenViewModel) {
            forEach { vm.addCell(it) }
            for (i in 0..<max(size, vm.cells.value.size)) {
                Assertions.assertEquals(vm.cells.value[i], this[i])
            }
            vm.clearCells()
        }


    }

}
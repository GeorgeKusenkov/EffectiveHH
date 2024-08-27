package com.egasmith.core.common

import kotlinx.coroutines.flow.StateFlow

interface BottomNavViewModel {
    val selectedItemIndex: StateFlow<Int>
    fun updateSelectedItemIndex(index: Int)
}
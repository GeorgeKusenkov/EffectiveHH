package com.egasmith.effectivemobileprojecthh.ui.main

import androidx.lifecycle.ViewModel
import com.egasmith.core.common.BottomNavViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor() : ViewModel(), BottomNavViewModel {
    private val _selectedItemIndex = MutableStateFlow(0)
    override val selectedItemIndex: StateFlow<Int> = _selectedItemIndex.asStateFlow()

    override fun updateSelectedItemIndex(index: Int) {
        _selectedItemIndex.value = index
    }
}
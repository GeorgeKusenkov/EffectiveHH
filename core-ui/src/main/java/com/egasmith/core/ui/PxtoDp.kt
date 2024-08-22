package com.egasmith.core.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
internal fun Int.pxToDp(): Dp {
    return (this / LocalDensity.current.density).dp
}

@Composable
internal fun Int.pxToSp(): TextUnit {
    return  (this / LocalDensity.current.fontScale).sp
}
package com.egasmith.presentation.recommendations.ui

fun truncateText(text: String, maxLines: Int): String {
    val lines = text.lines()
    return if (lines.size <= maxLines) {
        text
    } else {
        lines.take(maxLines).joinToString(" ") + "..."
    }
}
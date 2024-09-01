package com.egasmith.core.common

import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Locale

fun String.formatToReadableDate(): String {
    val inputFormat = SimpleDateFormat("yyyy-MM-dd", Locale.US)
    val outputFormat = SimpleDateFormat("d MMMM", Locale("ru"))

    return try {
        val date = inputFormat.parse(this)
        "Опубликовано " + date?.let { outputFormat.format(it) }
    } catch (e: Exception) {
        "Неверный формат даты"
    }
}
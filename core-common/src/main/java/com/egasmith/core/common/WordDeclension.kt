package com.egasmith.core.common


// Склонение слова "Вакансий" в зависимости от их колличества
object WordDeclension {
    fun getVacanciesWord(count: Int): String {
        return when {
            count % 100 in 11..19 -> "$count вакансий"
            count % 10 == 1 -> "$count вакансия"
            count % 10 in 2..4 -> "$count вакансии"
            else -> "$count вакансий"
        }
    }
}

fun Int.vacanciesWord(): String =WordDeclension.getVacanciesWord(this)


// Склонение "Человек" в зависимости от их колличества
fun Int.humansWord(): String {
    return when {
        this % 100 in 11..19 -> "$this человек"
        this % 10 == 1 -> "$this человек"
        this % 10 in 2..4 -> "$this человека"
        else -> "$this человек"
    }
}

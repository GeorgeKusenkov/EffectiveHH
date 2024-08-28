package com.egasmith.core.common

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

fun Int.vacanciesWord(): String = WordDeclension.getVacanciesWord(this)

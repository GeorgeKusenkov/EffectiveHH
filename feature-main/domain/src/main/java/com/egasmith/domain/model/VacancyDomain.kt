package com.egasmith.domain.model

data class VacancyDomain(
    val lookingNumber: Int,
    val title: String,
    val town: String,
    val company: String,
    val experience: String,
    val publishedDate: String,
    val isFavorite: Boolean,
    val salary: String
)

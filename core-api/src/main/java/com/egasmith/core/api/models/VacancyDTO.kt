package com.egasmith.core.api.models

data class VacancyDTO(
    val addressDTO: AddressDTO,
    val appliedNumber: Int,
    val company: String,
    val description: String,
    val experienceDTO: ExperienceDTO,
    val id: String,
    val isFavorite: Boolean,
    val lookingNumber: Int,
    val publishedDate: String,
    val questions: List<String>,
    val responsibilities: String,
    val salaryDTO: SalaryDTO,
    val schedules: List<String>,
    val title: String
)
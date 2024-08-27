package com.egasmith.domain.model

data class VacancyDetails(
    val id: String,
    val title: String,
    val salary: Salary?,
    val experience: Experience,
    val schedules: List<String>,
    val appliedNumber: Int?,
    val lookingNumber: Int?,
    val company: Company,
    val responsibilities: String,
    val isFavorite: Boolean
)

data class Salary(
    val full: String
)

data class Experience(
    val text: String
)

data class Company(
    val name: String,
    val address: Address,
    val description: String?
)

data class Address(
    val city: String,
    val street: String,
    val building: String
)
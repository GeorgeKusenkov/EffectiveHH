package com.egasmith.core.api.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class VacancyDTO(
    @SerialName("address") val address: AddressDTO,
    @SerialName("appliedNumber") val appliedNumber: Int,
    @SerialName("company") val company: String,
    @SerialName("description") val description: String,
    @SerialName("experience") val experience: ExperienceDTO,
    @SerialName("id") val id: String,
    @SerialName("isFavorite") val isFavorite: Boolean,
    @SerialName("lookingNumber") val lookingNumber: Int,
    @SerialName("publishedDate") val publishedDate: String,
    @SerialName("questions") val questions: List<String>,
    @SerialName("responsibilities") val responsibilities: String,
    @SerialName("salary") val salary: SalaryDTO,
    @SerialName("schedules") val schedules: List<String>,
    @SerialName("title") val title: String
)
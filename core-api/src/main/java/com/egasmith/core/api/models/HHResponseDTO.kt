package com.egasmith.core.api.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class HHResponseDTO(
    @SerialName("offers") val offers: List<OfferDTO>,
    @SerialName("vacancies") val vacancies: List<VacancyDTO>
)
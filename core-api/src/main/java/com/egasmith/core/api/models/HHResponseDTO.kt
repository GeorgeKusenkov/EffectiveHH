package com.egasmith.core.api.models

data class HHResponseDTO(
    val offerDTOS: List<OfferDTO>,
    val vacancies: List<VacancyDTO>
)
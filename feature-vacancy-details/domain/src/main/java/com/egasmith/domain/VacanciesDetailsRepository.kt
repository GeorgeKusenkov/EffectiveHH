package com.egasmith.domain

import com.egasmith.domain.model.VacancyDetails
import kotlinx.coroutines.flow.Flow

interface VacanciesDetailsRepository {
    suspend fun getVacancies(): Flow<Result<List<VacancyDetails>>>
}
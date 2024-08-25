package com.egasmith.data.repository

import com.egasmith.data.models.VacancyData
import kotlinx.coroutines.flow.Flow

interface MainRepository {
    suspend fun getVacancies(): Flow<Result<List<VacancyData>>>
}
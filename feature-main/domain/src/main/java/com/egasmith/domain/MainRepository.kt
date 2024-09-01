package com.egasmith.domain

import com.egasmith.domain.model.Recommendation
import com.egasmith.domain.model.Vacancy
import kotlinx.coroutines.flow.Flow

interface MainRepository {
    suspend fun getVacancies(): Flow<Result<List<Vacancy>>>
    suspend fun getRecommendations(): Flow<Result<List<Recommendation>>>
}
package com.egasmith.domain.usecases

import com.egasmith.domain.VacanciesDetailsRepository
import com.egasmith.domain.model.VacancyDetails
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetVacanciesDetailsUseCase @Inject constructor(private val repository: VacanciesDetailsRepository) {
    suspend fun execute(): Flow<Result<List<VacancyDetails>>> = repository.getVacancies()
}
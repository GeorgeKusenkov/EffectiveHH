package com.egasmith.domain.usecases

import com.egasmith.domain.VacanciesDetailsRepository
import com.egasmith.domain.model.VacancyDetails
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GetVacanciesDetailsUseCase @Inject constructor(
    private val repository: VacanciesDetailsRepository
) {
    suspend fun execute(vacancyId: String): Flow<Result<VacancyDetails>> =
        repository.getVacancyById(vacancyId)
}
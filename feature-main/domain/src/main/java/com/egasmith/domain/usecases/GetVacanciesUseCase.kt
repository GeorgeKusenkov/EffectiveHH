package com.egasmith.domain.usecases


import com.egasmith.domain.MainRepository
import com.egasmith.domain.model.Vacancy
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetVacanciesUseCase @Inject constructor(private val repository: MainRepository) {
    suspend fun execute(): Flow<Result<List<Vacancy>>> = repository.getVacancies()
}
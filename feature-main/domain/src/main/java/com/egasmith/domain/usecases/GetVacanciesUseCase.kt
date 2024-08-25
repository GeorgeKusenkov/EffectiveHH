package com.egasmith.domain.usecases

import com.egasmith.data.models.VacancyData
import com.egasmith.data.repository.MainRepository
import com.egasmith.domain.model.VacancyDomain
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GetVacanciesUseCase @Inject constructor(private val repository: MainRepository) {
    suspend fun execute(): Flow<Result<List<VacancyDomain>>> {
        return repository.getVacancies().map { result ->
            result.map { vacanciesData ->
                vacanciesData.map { it.toDomainModel() }
            }
        }
    }

    private fun VacancyData.toDomainModel(): VacancyDomain {
        return VacancyDomain(
            lookingNumber = lookingNumber,
            title = title,
            town = town,
            company = company,
            experience = experience,
            publishedDate = publishedDate,
            isFavorite = isFavorite,
            salary = salary
        )
    }
}
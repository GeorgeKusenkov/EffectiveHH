package com.egasmith.data

import com.egasmith.core.api.Api
import com.egasmith.core.api.models.VacancyDTO
import com.egasmith.domain.VacanciesDetailsRepository
import com.egasmith.domain.model.Address
import com.egasmith.domain.model.Company
import com.egasmith.domain.model.Experience
import com.egasmith.domain.model.Salary
import com.egasmith.domain.model.VacancyDetails
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

class VacancyDetailsRepositoryImpl  @Inject constructor(private val api: Api): VacanciesDetailsRepository {
    override suspend fun getVacancies(): Flow<Result<List<VacancyDetails>>> = flow {
        try {
            val response = api.getOffers()
            emit(Result.success(response.vacancies.map { it.toDomain() }))
        } catch (e: Exception) {
            emit(Result.failure(e))
        }
    }

    private fun VacancyDTO.toDomain(): VacancyDetails {
        return VacancyDetails(
            id = id,
            title = title,
            salary = Salary(full = salary.full),
            experience = Experience(text = experience.previewText),
            schedules = schedules,
            appliedNumber = appliedNumber,
            lookingNumber = lookingNumber,
            company = Company(
                name = company,
                isVerified = false, // Предполагаем, что этой информации нет в DTO
                address = Address(
                    city = address.town,
                    street = address.street,
                    building = address.house
                ),
                description = description
            ),
            responsibilities = responsibilities,
            isFavorite = isFavorite
        )
    }
}

@Module
@InstallIn(SingletonComponent::class)
abstract class VacancyDetailsRepositoryModule {
    @Binds
    @Singleton
    abstract fun bindVacancyDetailsRepository(repositoryImpl: VacancyDetailsRepositoryImpl): VacanciesDetailsRepository
}
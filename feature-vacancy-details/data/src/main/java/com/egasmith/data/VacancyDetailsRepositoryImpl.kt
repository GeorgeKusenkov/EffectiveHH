package com.egasmith.data

import com.egasmith.core.api.Api
import com.egasmith.core.api.models.VacancyDTO
import com.egasmith.domain.VacanciesDetailsRepository
import com.egasmith.domain.model.Address
import com.egasmith.domain.model.Company
import com.egasmith.domain.model.Experience
import com.egasmith.domain.model.Salary
import com.egasmith.domain.model.VacancyDetails
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

class VacancyDetailsRepositoryImpl @Inject constructor(
    private val api: Api,
    private val vacancyMapper: VacancyMapper
) : VacanciesDetailsRepository {

    override suspend fun getVacancies(): Flow<Result<List<VacancyDetails>>> = flow {
        try {
            val response = api.getOffers()
            val vacancies = response.vacancies.map { vacancyMapper.toDomain(it) }
            emit(Result.success(vacancies))
        } catch (e: Exception) {
            emit(Result.failure(e))
        }
    }

    override suspend fun getVacancyById(vacancyId: String): Flow<Result<VacancyDetails>> = flow {
        try {
            val response = api.getOffers()
            val vacancy = response.vacancies
                .firstOrNull { it.id == vacancyId }
                ?.let { vacancyMapper.toDomain(it) }
                ?: throw NoSuchElementException("Vacancy with ID $vacancyId not found")
            emit(Result.success(vacancy))
        } catch (e: Exception) {
            emit(Result.failure(e))
        }
    }
}

class VacancyMapper {
    fun toDomain(vacancyDTO: VacancyDTO): VacancyDetails {
        return VacancyDetails(
            id = vacancyDTO.id,
            title = vacancyDTO.title,
            salary = Salary(full = vacancyDTO.salary.full),
            experience = Experience(text = vacancyDTO.experience.previewText),
            schedules = vacancyDTO.schedules,
            appliedNumber = vacancyDTO.appliedNumber,
            lookingNumber = vacancyDTO.lookingNumber,
            company = Company(
                name = vacancyDTO.company,
                address = Address(
                    city = vacancyDTO.address.town,
                    street = vacancyDTO.address.street,
                    building = vacancyDTO.address.house
                ),
                description = vacancyDTO.description
            ),
            responsibilities = vacancyDTO.responsibilities,
            isFavorite = vacancyDTO.isFavorite
        )
    }
}

@Module
@InstallIn(SingletonComponent::class)
object VacancyDetailsRepositoryModule {

    @Provides
    @Singleton
    fun provideVacancyDetailsRepository(
        api: Api,
        vacancyMapper: VacancyMapper
    ): VacanciesDetailsRepository {
        return VacancyDetailsRepositoryImpl(api, vacancyMapper)
    }

    @Provides
    fun provideVacancyMapper(): VacancyMapper {
        return VacancyMapper()
    }
}
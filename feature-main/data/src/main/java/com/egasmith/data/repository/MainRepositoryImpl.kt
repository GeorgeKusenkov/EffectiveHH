package com.egasmith.data.repository

import android.util.Log
import com.egasmith.core.api.Api
import com.egasmith.core.api.models.VacancyDTO
import com.egasmith.data.models.VacancyData
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

class MainRepositoryImpl @Inject constructor(private val api: Api) : MainRepository {
    override suspend fun getVacancies(): Flow<Result<List<VacancyData>>> = flow {
        try {
            val offersDTO = api.getOffers()
            emit(Result.success(offersDTO.vacancies.map { it.toDataModel() }))
        } catch (e: Exception) {
            emit(Result.failure(e))
        }
    }

    private fun VacancyDTO.toDataModel(): VacancyData {
        return VacancyData(
            lookingNumber = lookingNumber,
            title = title,
            town = address.town,
            company = company,
            experience = experience.previewText,
            publishedDate = publishedDate,
            isFavorite = isFavorite,
            salary = salary.full
        )
    }
}

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun bindMainRepository(repositoryImpl: MainRepositoryImpl): MainRepository
}
package com.egasmith.core.data

import com.egasmith.core.api.Api
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Provides
    @Singleton
    fun provideOfferRepository(api: Api): OffersRepository {
        return OffersRepositoryImpl(api)
    }
}
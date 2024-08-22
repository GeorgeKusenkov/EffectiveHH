package com.egasmith.core.data

import com.egasmith.core.api.Api
import com.egasmith.core.api.models.HHResponseDTO

class OffersRepositoryImpl(private val api: Api): OffersRepository {
    override suspend fun getOffers(): HHResponseDTO {
        return api.getOffers()
    }
}
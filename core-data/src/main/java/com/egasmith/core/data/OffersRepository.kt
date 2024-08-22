package com.egasmith.core.data

import com.egasmith.core.api.Api
import com.egasmith.core.api.models.HHResponseDTO

interface  OffersRepository {
    suspend fun getOffers(): HHResponseDTO
}
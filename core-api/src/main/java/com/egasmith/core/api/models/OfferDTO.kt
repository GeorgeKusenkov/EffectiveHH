package com.egasmith.core.api.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class OfferDTO(
    @SerialName("id") val id: String,
    @SerialName("link") val link: String,
    @SerialName("title") val title: String
)
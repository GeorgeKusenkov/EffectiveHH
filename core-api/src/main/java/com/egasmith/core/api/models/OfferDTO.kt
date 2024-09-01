package com.egasmith.core.api.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class OfferDTO(
    @SerialName("id") val id: String? = null,
    @SerialName("title") val title: String,
    @SerialName("button") val button: ButtonDTO? = null,
    @SerialName("link") val link: String
)


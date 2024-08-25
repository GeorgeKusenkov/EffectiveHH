package com.egasmith.core.api.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AddressDTO(
    @SerialName("house") val house: String,
    @SerialName("street") val street: String,
    @SerialName("town") val town: String
)
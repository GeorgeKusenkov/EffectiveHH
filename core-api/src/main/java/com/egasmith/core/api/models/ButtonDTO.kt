package com.egasmith.core.api.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ButtonDTO(
    @SerialName("text") val text: String
)
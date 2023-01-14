package com.farshatov.feature_astronomy.data.remote.response

import com.google.gson.annotations.SerializedName

data class AstronomyDto(
    @SerializedName("astro")
    val astro: AstroDto? = null
)

package com.farshatov.feature_astronomy.data.mapper

import com.farshatov.feature_astronomy.data.remote.response.AstroDto
import com.farshatov.feature_astronomy.data.remote.response.AstronomyDto
import com.farshatov.feature_astronomy.data.remote.response.AstronomyOutputDto
import com.farshatov.feature_astronomy.data.remote.response.LocationDto
import com.farshatov.feature_astronomy.domain.model.AstroModel
import com.farshatov.feature_astronomy.domain.model.AstronomyModel
import com.farshatov.feature_astronomy.domain.model.AstronomyOutputModel
import com.farshatov.feature_astronomy.domain.model.LocationModel

fun mapAstronomyOutputDto(input: AstronomyOutputDto): AstronomyOutputModel {
    return AstronomyOutputModel(
        astronomy = mapAstronomyDto(input.astronomy),
        location = mapLocationDto(input.location)
    )
}

fun mapLocationDto(location: LocationDto?) = LocationModel(
    name = location?.name.orEmpty(),
    region = location?.region.orEmpty(),
    country = location?.country.orEmpty(),
    lat = location?.lat ?: 0.0,
    lon = location?.lon ?: 0.0,
    tzId = location?.tzId.orEmpty(),
    localtimeEpoch = location?.localtimeEpoch ?: 0,
    localtime = location?.localtime.orEmpty()
)

fun mapAstronomyDto(astronomy: AstronomyDto?) = AstronomyModel(
    astro = mapAstroDtoToModel(astronomy?.astro)
)

fun mapAstroDtoToModel(astro: AstroDto?) = AstroModel(
    sunrise = astro?.sunrise.orEmpty(),
    sunset = astro?.sunset.orEmpty(),
    moonrise = astro?.moonrise.orEmpty(),
    moonset = astro?.moonset.orEmpty(),
    moonPhase = astro?.moonPhase.orEmpty(),
    moonIllumination = astro?.moonIllumination.orEmpty()
)

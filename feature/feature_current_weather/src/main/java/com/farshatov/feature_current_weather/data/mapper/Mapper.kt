package com.farshatov.feature_current_weather.data.mapper

import com.farshatov.feature_current_weather.data.remote.response.AirQualityDto
import com.farshatov.feature_current_weather.data.remote.response.ConditionDto
import com.farshatov.feature_current_weather.data.remote.response.CurrentDto
import com.farshatov.feature_current_weather.data.remote.response.CurrentWeatherDto
import com.farshatov.feature_current_weather.data.remote.response.LocationDto
import com.farshatov.feature_current_weather.domain.model.AirQualityModel
import com.farshatov.feature_current_weather.domain.model.ConditionModel
import com.farshatov.feature_current_weather.domain.model.CurrentModel
import com.farshatov.feature_current_weather.domain.model.CurrentWeatherModel
import com.farshatov.feature_current_weather.domain.model.LocationModel

fun mapCurrentWeatherDto(
    input: CurrentWeatherDto
): CurrentWeatherModel {
    return CurrentWeatherModel(
        mapCurrentDto(input.current),
        mapLocationDto(input.location)
    )
}

fun mapLocationDto(location: LocationDto?): LocationModel {
    return LocationModel(
        name = location?.name ?: "",
        region = location?.region ?: "",
        country = location?.country ?: "",
        lat = location?.lat ?: 0.0,
        lon = location?.lon ?: 0.0,
        tzId = location?.tzId ?: "",
        localtimeEpoch = location?.localtimeEpoch ?: 0,
        localtime = location?.localtime ?: ""
    )
}

fun mapCurrentDto(
    input: CurrentDto?
): CurrentModel {
    return CurrentModel(
        airQuality = mapAirQualityDto(input?.airQuality),
        cloud = input?.cloud ?: 0,
        condition = mapConditionDto(input?.condition),
        feelslikeC = input?.feelslikeC ?: 0.0,
        feelslikeF = input?.feelslikeF ?: 0.0,
        gustKph = input?.gustKph ?: 0.0,
        gustMph = input?.gustMph ?: 0.0,
        humidity = input?.humidity ?: 0,
        isDay = input?.isDay ?: 0,
        lastUpdated = input?.lastUpdated ?: "",
        lastUpdatedEpoch = input?.lastUpdatedEpoch ?: 0,
        precipIn = input?.precipIn ?: 0.0,
        precipMm = input?.precipMm ?: 0.0,
        pressureIn = input?.pressureIn ?: 0.0,
        pressureMb = input?.pressureMb ?: 0.0,
        tempC = input?.tempC ?: 0.0,
        tempF = input?.tempF ?: 0.0,
        uv = input?.uv ?: 0.0,
        visKm = input?.visKm ?: 0.0,
        visMiles = input?.visMiles ?: 0.0,
        windDegree = input?.windDegree ?: 0,
        windDir = input?.windDir ?: "",
        windKph = input?.windKph ?: 0.0,
        windMph = input?.windMph ?: 0.0
    )
}

fun mapConditionDto(condition: ConditionDto?): ConditionModel {
    return ConditionModel(
        code = condition?.code ?: 0,
        icon = condition?.icon ?: "",
        text = condition?.text ?: ""
    )
}

fun mapAirQualityDto(airQuality: AirQualityDto?): AirQualityModel {
    return AirQualityModel(
        co = airQuality?.co ?: 0.0,
        no2 = airQuality?.no2 ?: 0.0,
        o3 = airQuality?.o3 ?: 0.0,
        pm10 = airQuality?.pm10 ?: 0.0,
        pm25 = airQuality?.pm25 ?: 0.0,
        so2 = airQuality?.so2 ?: 0.0,
        usEpaIndex = airQuality?.usEpaIndex ?: 0,
        gbDefraIndex = airQuality?.gbDefraIndex ?: 0
    )
}

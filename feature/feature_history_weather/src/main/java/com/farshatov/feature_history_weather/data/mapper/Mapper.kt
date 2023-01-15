package com.farshatov.feature_history_weather.data.mapper

import com.farshatov.feature_history_weather.data.remote.response.AstroDto
import com.farshatov.feature_history_weather.data.remote.response.ConditionDto
import com.farshatov.feature_history_weather.data.remote.response.DayDto
import com.farshatov.feature_history_weather.data.remote.response.ForecastDto
import com.farshatov.feature_history_weather.data.remote.response.ForecastdayDto
import com.farshatov.feature_history_weather.data.remote.response.HistoryWeatherOutputDto
import com.farshatov.feature_history_weather.data.remote.response.HourDto
import com.farshatov.feature_history_weather.data.remote.response.LocationDto
import com.farshatov.feature_history_weather.domain.model.AstroModel
import com.farshatov.feature_history_weather.domain.model.ConditionModel
import com.farshatov.feature_history_weather.domain.model.DayModel
import com.farshatov.feature_history_weather.domain.model.ForecastModel
import com.farshatov.feature_history_weather.domain.model.ForecastdayModel
import com.farshatov.feature_history_weather.domain.model.HistoryWeatherOutputModel
import com.farshatov.feature_history_weather.domain.model.HourModel
import com.farshatov.feature_history_weather.domain.model.LocationModel

fun mapHistoryWeatherOutputDto(historyWeatherOutputDto: HistoryWeatherOutputDto) =
    HistoryWeatherOutputModel(
        location = mapLocationDto(historyWeatherOutputDto.location),
        forecast = mapForecastDto(historyWeatherOutputDto.forecast)
    )

fun mapForecastDto(input: ForecastDto?) = ForecastModel(
    forecastday = input?.forecastday?.map { mapForecastdayDto(it) } ?: emptyList()
)

fun mapForecastdayDto(input: ForecastdayDto?) = ForecastdayModel(
    date = input?.date.orEmpty(),
    dateEpoch = input?.dateEpoch ?: 0,
    day = mapDayDto(input?.day),
    astro = mapAstroDto(input?.astro),
    hour = input?.hour?.map { mapHourDto(it) } ?: emptyList()
)

fun mapHourDto(input: HourDto) = HourModel(
    chanceOfRain = input.chanceOfRain ?: 0,
    chanceOfSnow = input.chanceOfSnow ?: 0,
    cloud = input.cloud ?: 0,
    condition = mapConditionDto(input.condition),
    dewpointC = input.dewpointC ?: 0.0,
    dewpointF = input.dewpointF ?: 0.0,
    feelslikeC = input.feelslikeC ?: 0.0,
    feelslikeF = input.feelslikeF ?: 0.0,
    gustKph = input.gustKph ?: 0.0,
    gustMph = input.gustMph ?: 0.0,
    heatindexC = input.heatindexC ?: 0.0,
    heatindexF = input.heatindexF ?: 0.0,
    humidity = input.humidity ?: 0,
    isDay = input.isDay ?: 0,
    precipIn = input.precipIn ?: 0.0,
    precipMm = input.precipMm ?: 0.0,
    pressureIn = input.pressureIn ?: 0.0,
    pressureMb = input.pressureMb ?: 0.0,
    tempC = input.tempC ?: 0.0,
    tempF = input.tempF ?: 0.0,
    time = input.time.orEmpty(),
    timeEpoch = input.timeEpoch ?: 0,
    visKm = input.visKm ?: 0.0,
    visMiles = input.visMiles ?: 0.0,
    willItRain = input.willItRain ?: 0,
    willItSnow = input.willItSnow ?: 0,
    windDegree = input.windDegree ?: 0,
    windDir = input.windDir.orEmpty(),
    windKph = input.windKph ?: 0.0,
    windMph = input.windMph ?: 0.0,
    windchillC = input.windchillC ?: 0.0,
    windchillF = input.windchillF ?: 0.0
)

fun mapAstroDto(input: AstroDto?) = AstroModel(
    sunrise = input?.sunrise.orEmpty(),
    sunset = input?.sunset.orEmpty(),
    moonrise = input?.moonrise.orEmpty(),
    moonset = input?.moonset.orEmpty(),
    moonPhase = input?.moonPhase.orEmpty(),
    moonIllumination = input?.moonIllumination.orEmpty()
)

fun mapDayDto(input: DayDto?) = DayModel(
    maxtempC = input?.maxtempC ?: 0.0,
    maxtempF = input?.maxtempF ?: 0.0,
    mintempC = input?.mintempC ?: 0.0,
    mintempF = input?.mintempF ?: 0.0,
    avgtempC = input?.avgtempC ?: 0.0,
    avgtempF = input?.avgtempF ?: 0.0,
    maxwindMph = input?.maxwindMph ?: 0.0,
    maxwindKph = input?.maxwindKph ?: 0.0,
    totalprecipMm = input?.totalprecipMm ?: 0.0,
    totalprecipIn = input?.totalprecipIn ?: 0.0,
    avgvisKm = input?.avgvisKm ?: 0.0,
    avgvisMiles = input?.avgvisMiles ?: 0.0,
    avghumidity = input?.avghumidity ?: 0.0,
    condition = mapConditionDto(input?.condition),
    uv = input?.uv ?: 0.0
)

fun mapConditionDto(input: ConditionDto?) = ConditionModel(
    text = input?.text.orEmpty(),
    icon = input?.icon.orEmpty(),
    code = input?.code ?: 0
)

fun mapLocationDto(input: LocationDto?) = LocationModel(
    name = input?.name.orEmpty(),
    region = input?.region.orEmpty(),
    country = input?.country.orEmpty(),
    lat = input?.lat ?: 0.0,
    lon = input?.lon ?: 0.0,
    tzId = input?.tzId.orEmpty(),
    localtimeEpoch = input?.localtimeEpoch ?: 0,
    localtime = input?.localtime.orEmpty()
)

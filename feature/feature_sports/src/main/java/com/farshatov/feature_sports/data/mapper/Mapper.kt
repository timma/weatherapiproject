package com.farshatov.feature_sports.data.mapper

import com.farshatov.feature_sports.data.remote.response.CricketDto
import com.farshatov.feature_sports.data.remote.response.FootballDto
import com.farshatov.feature_sports.data.remote.response.SportsDto
import com.farshatov.feature_sports.domain.model.CricketModel
import com.farshatov.feature_sports.domain.model.FootballModel
import com.farshatov.feature_sports.domain.model.SportsModel

fun mapSportsDto(
    input: SportsDto
): SportsModel {
    return SportsModel(
        cricket = input.cricket?.map { mapCricketDto(it) } ?: emptyList(),
        football = input.football?.map { mapFootballDto(it) } ?: emptyList(),
        golf = emptyList()
    )
}

fun mapCricketDto(it: CricketDto?): CricketModel {
    return CricketModel(
        country = it?.country.orEmpty(),
        match = it?.match.orEmpty(),
        region = it?.region.orEmpty(),
        stadium = it?.stadium.orEmpty(),
        start = it?.start.orEmpty(),
        tournament = it?.tournament.orEmpty()
    )
}

fun mapFootballDto(it: FootballDto?): FootballModel {
    return FootballModel(
        country = it?.country.orEmpty(),
        match = it?.match.orEmpty(),
        region = it?.region.orEmpty(),
        stadium = it?.stadium.orEmpty(),
        start = it?.start.orEmpty(),
        tournament = it?.tournament.orEmpty()
    )
}

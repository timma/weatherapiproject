package com.farshatov.feature_sports

import com.farshatov.feature_sports.domain.model.CricketModel
import com.farshatov.feature_sports.domain.model.FootballModel
import com.farshatov.feature_sports.domain.model.SportsModel

object Generator {
    val sportsModel = SportsModel(
        cricket = listOf(
            CricketModel(
                country = "country",
                match = "match",
                region = "region",
                stadium = "stadium",
                start = "start",
                tournament = "tournament"
            )
        ),
        football = listOf(
            FootballModel(
                country = "country",
                match = "match",
                region = "region",
                stadium = "stadium",
                start = "start",
                tournament = "tournament"
            )
        ),
        golf = listOf(
            FootballModel(
                country = "country",
                match = "match",
                region = "region",
                stadium = "stadium",
                start = "start",
                tournament = "tournament"
            )
        )
    )
}

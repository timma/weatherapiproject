package com.farshatov.feature_sports.domain.model

data class SportsModel(
    val cricket: List<CricketModel>,
    val football: List<FootballModel>,
    val golf: List<Any>
)

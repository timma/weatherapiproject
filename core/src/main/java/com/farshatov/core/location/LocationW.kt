package com.farshatov.core.location

data class LocationW(val latitude: Double, val longitude: Double) {
    companion object {
        val default = LocationW(0.0, 0.0)
        operator fun invoke(latitude: Double?, longitude: Double?) =
            LocationW(latitude ?: 0.0, longitude ?: 0.0)
    }
}

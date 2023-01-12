package com.farshatov.core.location

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationManager
import android.os.Looper
import androidx.core.app.ActivityCompat
import androidx.core.location.LocationManagerCompat
import androidx.core.location.LocationRequestCompat
import androidx.core.location.LocationRequestCompat.QUALITY_BALANCED_POWER_ACCURACY
import java.util.concurrent.Executors
import kotlinx.coroutines.delay

class LocationManager(private val mContext: Context) {
    private var locationManager: LocationManager? = null
    private var isListening: Boolean = false

    fun startUpdatingLocation() {
        if (!isListening) {
            if (ActivityCompat.checkSelfPermission(
                    mContext,
                    Manifest.permission.ACCESS_FINE_LOCATION
                ) == PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                        mContext,
                        Manifest.permission.ACCESS_COARSE_LOCATION
                    ) == PackageManager.PERMISSION_GRANTED
            ) {
                LocationManagerCompat.requestLocationUpdates(
                    getLocationManager(),
                    LocationManager.GPS_PROVIDER,
                    LocationRequestCompat.Builder(LOCATION_REFRESH_TIME)
                        .setQuality(QUALITY_BALANCED_POWER_ACCURACY)
                        .setMinUpdateDistanceMeters(LOCATION_REFRESH_DISTANCE)
                        .build(),
                    {},
                    Looper.getMainLooper()
                )
                isListening = true
            }
        }
    }

    fun stopUpdatingLocation() {
        if (ActivityCompat.checkSelfPermission(
                mContext,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) == PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                    mContext,
                    Manifest.permission.ACCESS_COARSE_LOCATION
                ) == PackageManager.PERMISSION_GRANTED
        ) {
            LocationManagerCompat.removeUpdates(getLocationManager()) {}
            isListening = false
        }
    }

    fun getLastKnownLocation(): LocationW {
        val providers: List<String> = getLocationManager().getProviders(true)
        var bestLocation: Location? = null

        if (ActivityCompat.checkSelfPermission(
                mContext,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) == PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                    mContext,
                    Manifest.permission.ACCESS_COARSE_LOCATION
                ) == PackageManager.PERMISSION_GRANTED
        ) {
            for (provider in providers) {
                LocationManagerCompat.getCurrentLocation(
                    getLocationManager(),
                    provider,
                    null,
                    Executors.newSingleThreadExecutor()
                ) {
                    if (bestLocation == null || it.accuracy < (
                        bestLocation?.accuracy
                            ?: LOCATION_REFRESH_DISTANCE
                        )
                    ) {
                        bestLocation = it
                    }
                }
            }
            return LocationW(
                bestLocation?.latitude,
                bestLocation?.longitude
            )
        } else {
            return LocationW.default
        }
    }

    suspend fun getLocationWithLoop(): LocationW {
        run {
            repeat(5) {
                getLastKnownLocation().let {
                    if (it != LocationW.default) {
                        return it
                    }
                }
                delay(LOCATION_LOOP_INTERVAL)
            }
        }
        return LocationW.default
    }

    private fun getLocationManager(): LocationManager {
        return locationManager
            ?: mContext.getSystemService(Context.LOCATION_SERVICE) as LocationManager
    }

    companion object {
        const val LOCATION_REFRESH_TIME = 30L
        const val LOCATION_REFRESH_DISTANCE = 100.0F
        const val LOCATION_LOOP_INTERVAL = 7000L
        fun getInstance(context: Context) = com.farshatov.core.location.LocationManager(context)
    }
}

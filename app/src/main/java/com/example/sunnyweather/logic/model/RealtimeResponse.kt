package com.example.sunnyweather.logic.model

import com.google.gson.annotations.SerializedName

data class RealtimeResponse(val status: String, val result: Result) {
    data class Result(val realtime: RealTime)

    data class RealTime(
        val skycon: String,
        val temperature: Float,
        @SerializedName("air_quality") val airQuality: AirQulity
    )

    data class AirQulity(val aqi: AQI)
    data class AQI(val chn: Float)
}
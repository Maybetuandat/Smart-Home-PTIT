package com.example.smarthomeptit.model

data class SensorData(
    val id : Int,
    val temperature: Double,
    val humidity: Double,
    val lightIntensity: Double,
    val time : String
)

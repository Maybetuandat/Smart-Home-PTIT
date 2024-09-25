package com.example.smarthomeptit.data.model

import java.util.Date

data class SensorData(
    val Id : Int,
    val Temperature: Float,
    val Humidity: Float,
    val Light: Float,
    val dust : Int,
    val Time : Date
)

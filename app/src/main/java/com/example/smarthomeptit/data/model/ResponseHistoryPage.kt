package com.example.smarthomeptit.data.model

data class ResponseHistoryPage(
    val data : List<SensorData> ,
    val meta : PaginationObject
)

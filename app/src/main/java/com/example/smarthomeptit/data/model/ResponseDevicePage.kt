package com.example.smarthomeptit.data.model

data class ResponseDevicePage(
    var data : List<HistoryDevice>,
    var meta : PaginationObject
)

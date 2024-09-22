package com.example.smarthomeptit.data.model

data class PaginationObject(
    var current_page: Int,
    var page_size: Int,
    var total_page: Int?,
    var total_data: Int?,
    var skip: Int?
)
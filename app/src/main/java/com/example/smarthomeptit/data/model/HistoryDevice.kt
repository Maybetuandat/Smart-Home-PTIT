package com.example.smarthomeptit.data.model

import java.util.Date


data class HistoryDevice(
    val Id: Int,
    val Device: String,
    val Status: String,
    val Time: Date
)
//) : Comparable<HistoryDevice> {
//    override fun compareTo(other: HistoryDevice): Int {
//        return this.time.compareTo(other.time)
//    }
//
//}


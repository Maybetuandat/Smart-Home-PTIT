package com.example.smarthomeptit.data.model

data class HistoryDevice(val nameDevice : String, val time : String, val status : String):Comparable<HistoryDevice>
{
    override fun compareTo(other: HistoryDevice): Int {
         return this.time.compareTo(other.time)
    }

}


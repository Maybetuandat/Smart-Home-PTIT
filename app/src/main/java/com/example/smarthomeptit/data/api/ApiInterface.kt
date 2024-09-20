package com.example.smarthomeptit.data.api


import com.example.smarthomeptit.data.model.ResponseBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {
    @GET("/api/device_controller/led")
    suspend  fun controlDeviceLed(
        @Query("parameter") parameter : Int
    ): Response<ResponseBody>
    @GET("/api/device_controller/fan")
    suspend fun controDeviceFan(
        @Query("parameter") parameter: Int
    ): Response<ResponseBody>
    @GET("/api/device_controller/air_conditioner")
    suspend fun controDeviceAirConditioner(
        @Query("parameter") parameter: Int
    ): Response<ResponseBody>


}
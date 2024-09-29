package com.example.smarthomeptit.data.api


import com.example.smarthomeptit.data.model.ResponseBody
import com.example.smarthomeptit.data.model.ResponseDataForChart
import com.example.smarthomeptit.data.model.ResponseDataWind
import com.example.smarthomeptit.data.model.ResponseDevicePage
import com.example.smarthomeptit.data.model.ResponseHistoryPage
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiInterface {
    @POST("/api/device_controller")
    suspend fun controlDeviceLed(
        @Query("parameter") parameter: Int,
        @Query("id") id: Int
    ): Response<ResponseBody>

    @GET("/api/get_history_device")
    suspend fun getHistoryDevice(
        @Query("value") value: String,
        @Query("typeSearch") typeSearch: String,
        @Query("typeSort") typeSort: String,
        @Query("sort") sort: String,
        @Query("page") page: Int,
        @Query("pageSize") pageSize: Int
    ): Response<ResponseDevicePage>

    @GET("/api/get_history_data_sensor")
    suspend fun getHistoryDataSensor(
        @Query("value") value: String,
        @Query("typeSearch") typeSearch: String,
        @Query("typeSort") typeSort: String,
        @Query("sort") sort: String,
        @Query("page") page: Int,
        @Query("pageSize") pageSize: Int,
    ): Response<ResponseHistoryPage>
    @GET("/api/get_history_data_sensor_for_chart")
    suspend fun getHistoryDataSensorForChart():Response<List<ResponseDataForChart>>

    @GET("/api/wind")
    suspend fun getWind():Response<ResponseDataWind>
    @GET("/api/turn")
    suspend fun getFan():Response<ResponseDataWind>

}
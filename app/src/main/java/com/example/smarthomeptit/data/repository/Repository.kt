package com.example.smarthomeptit.data.repository


import com.example.smarthomeptit.data.model.ResponseBody
import com.example.smarthomeptit.data.model.ResponseDataForChart
import com.example.smarthomeptit.data.model.ResponseDataWind
import com.example.smarthomeptit.data.model.ResponseDevicePage
import com.example.smarthomeptit.data.model.ResponseHistoryPage
import com.example.smarthomeptit.utils.RetrofitInstance
import retrofit2.Response

class Repository {
    suspend fun controlDeviceLed(parameter: Int, id : Int): Response<ResponseBody>
    {
        return RetrofitInstance.api.controlDeviceLed(parameter, id)
    }
    suspend fun getHistoryDevice(value: String, typeSearch: String, typeSort: String, sort: String, page: Int, pageSize: Int):Response<ResponseDevicePage>
    {
        return RetrofitInstance.api.getHistoryDevice(value, typeSearch, typeSort, sort, page, pageSize)
    }
    suspend fun getHistoryDataSensor(value : String, typeSearch: String,typeSort: String, sort: String, page: Int, pageSize: Int):Response<ResponseHistoryPage>
    {
        return RetrofitInstance.api.getHistoryDataSensor(value, typeSearch, typeSort,sort, page, pageSize)
    }
    suspend fun getHistoryDataSensorForChart():Response<List<ResponseDataForChart>>
    {
        return RetrofitInstance.api.getHistoryDataSensorForChart()
    }
    suspend fun getWind():Response<ResponseDataWind>
    {
        return  RetrofitInstance.api.getWind()
    }
    suspend fun getFan():Response<ResponseDataWind>
    {
        return  RetrofitInstance.api.getFan()
    }

}
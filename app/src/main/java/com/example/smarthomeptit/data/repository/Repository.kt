package com.example.smarthomeptit.data.repository

import com.example.smarthomeptit.data.model.ResponseBody
import com.example.smarthomeptit.utils.RetrofitInstance
import retrofit2.Response

class Repository {
    suspend fun controlDeviceLed(parameter: Int): Response<ResponseBody>
    {
        return RetrofitInstance.api.controlDeviceLed(parameter)
    }
    suspend fun controlDeviceFan(parameter: Int):Response<ResponseBody>
    {
        return  RetrofitInstance.api.controDeviceFan(parameter)
    }
    suspend fun controlDeviceAirConditioner(parameter: Int):Response<ResponseBody>
    {
        return RetrofitInstance.api.controDeviceAirConditioner(parameter)
    }
}
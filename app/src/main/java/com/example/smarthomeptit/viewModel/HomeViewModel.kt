package com.example.smarthomeptit.viewModel

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.smarthomeptit.data.model.HistoryDevice
import com.example.smarthomeptit.data.model.ResponseBody

import com.example.smarthomeptit.data.repository.Repository
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.math.log

class HomeViewModel : ViewModel() {

    // data for socket connection
    private val _temperature = MutableLiveData<String>()
    val temperature: LiveData<String> = _temperature
    private val _humidity = MutableLiveData<String>()
    val humidity: LiveData<String> = _humidity
    private val _light = MutableLiveData<String>()
    val light: LiveData<String> = _light

    private val _ledStatus = MutableLiveData<Int>()
    val ledStatus :LiveData<Int> = _ledStatus
    private val _fanStatus = MutableLiveData<Int>()
    val fanStatus :LiveData<Int> = _fanStatus
    private val _airConditionerStatus = MutableLiveData<Int>()
    val airConditionerStatus :LiveData<Int> = _airConditionerStatus
    fun updateDataSensor(message: String) {
        viewModelScope.launch {
            val data = message.split(" ")
            _temperature.value = data[0]
            _humidity.value = data[1]
            _light.value = data[2]
        }
    }
    fun updateLedStatus(status: Int)
    {
        viewModelScope.launch {
            _ledStatus.value = status
        }
    }
    fun updateFanStatus(status: Int) {
        viewModelScope.launch {
            _fanStatus.value = status
        }
    }
    fun updateAirConditionerStatus(status: Int) {
        viewModelScope.launch {
            _airConditionerStatus.value = status
        }
    }
    //update api from server
//    private val apiRepository = ApiRepository()
    private val repository = Repository()
    fun controlDevice(parameter: Int, id : Int) {
        Log.d("control_device", "controlDeviceLed: $parameter")
        viewModelScope.launch {
            try {
                val response = repository.controlDeviceLed(parameter, id)
                if (response.isSuccessful)
                {
                    //handle any thing
                }
            } catch (e : Exception)
            {
                Log.e("control_device", e.toString())
            }
        }
    }
//    fun controlDeviceFan(parameter: Int)
//    {
//        Log.d("control_device", "controlDeviceFan: $parameter")
//        viewModelScope.launch{
//            try {
//                val response = repository.controlDeviceFan(parameter)
//                if(response.isSuccessful)
//                {
//                    //
//                }
//            } catch ( e : Exception)
//            {
//                Log.e("control_device", e.toString())
//            }
//        }
//    }
//    fun controlDeviceAirConditioner(parameter: Int)
//    {
//        Log.d("control_device", "controlDeviceAirConditioner: $parameter")
//        viewModelScope.launch {
//            try {
//                val response = repository.controlDeviceAirConditioner(parameter)
//                if(response.isSuccessful)
//                {
//                    //handle any thing
//                }
//
//            }
//            catch (e : Exception)
//            {
//                Log.e("control_device", e.toString())
//            }
//        }
//    }
}
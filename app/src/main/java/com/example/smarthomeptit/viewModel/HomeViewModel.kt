package com.example.smarthomeptit.viewModel

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.smarthomeptit.data.repository.Repository
import kotlinx.coroutines.launch

@SuppressLint("MutableCollectionMutableState")
class HomeViewModel : ViewModel() {


    var selectedChart by mutableStateOf("Light")
    var listTemperature by mutableStateOf(mutableListOf<Double>())
    var listHumidity by mutableStateOf(mutableListOf<Double>())
    var listLight by mutableStateOf(mutableListOf<Double>())
    var isChartLoading by mutableStateOf(false)


    // data for socket connection
    private val _temperature = MutableLiveData<String>()
    val temperature: LiveData<String> = _temperature
    private val _humidity = MutableLiveData<String>()
    val humidity: LiveData<String> = _humidity
    private val _light = MutableLiveData<String>()
    val light: LiveData<String> = _light

    private val _ledStatus = MutableLiveData<Int>()
    val ledStatus: LiveData<Int> = _ledStatus
    private val _fanStatus = MutableLiveData<Int>()
    val fanStatus: LiveData<Int> = _fanStatus
    private val _airConditionerStatus = MutableLiveData<Int>()
    val airConditionerStatus: LiveData<Int> = _airConditionerStatus
    fun updateDataSensor(message: String) {
        viewModelScope.launch {
            val data = message.split(" ")
            _temperature.value = data[0]
            _humidity.value = data[1]
            _light.value = data[2]
            listTemperature.add(listTemperature.size , data[0].toDouble())
            listHumidity.add(listHumidity.size , data[1].toDouble())
            listLight.add(listLight.size , data[2].toDouble())
            if (listTemperature.size > 5)
                listTemperature.removeAt(0)
            if (listHumidity.size > 5)
                listHumidity.removeAt(0)
            if (listLight.size > 5)
                listLight.removeAt(0)
        }
    }


    fun updateLedStatus(status: Int) {
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


    init {
        viewModelScope.launch {
            try {
                isChartLoading = true
                val tempResponse = repository.getHistoryDataSensorForChart("Temperature")
                val humidityResponse = repository.getHistoryDataSensorForChart("Humidity")
                val lightResponse = repository.getHistoryDataSensorForChart("Light")
                listTemperature = mutableListOf(10.0, 20.0, 30.0, 40.0, 45.0)
                listLight = mutableListOf(100.0,1500.0, 3300.0, 3493.0, 4000.0)
                listHumidity = mutableListOf(30.0, 50.0, 60.0, 70.0, 80.0)

                // Đảm bảo rằng cả ba danh sách đã được tải
                if (tempResponse.isSuccessful && humidityResponse.isSuccessful && lightResponse.isSuccessful) {
                    isChartLoading = false
                    Log.d("HomeModel", listTemperature.toString())
                    Log.d("HomeModel", listHumidity.toString())
                    Log.d("HomeModel", listLight.toString())
                }


            } catch (e: Exception) {
                isChartLoading = false
                Log.e("HomeModel", e.toString())

            }
        }
    }

    fun controlDevice(parameter: Int, id: Int) {
        Log.d("control_device", "controlDeviceLed: $parameter")
        viewModelScope.launch {
            try {
                val response = repository.controlDeviceLed(parameter, id)
                if (response.isSuccessful) {
                    //handle any thing
                }
            } catch (e: Exception) {
                Log.e("control_device", e.toString())
            }
        }
    }
}
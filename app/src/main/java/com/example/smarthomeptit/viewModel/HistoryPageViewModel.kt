package com.example.smarthomeptit.viewModel

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.focus.FocusManager
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.smarthomeptit.data.model.PaginationObject
import com.example.smarthomeptit.data.model.SensorData
import com.example.smarthomeptit.data.repository.Repository
import kotlinx.coroutines.launch

class HistoryPageViewModel : ViewModel() {

    var  state by mutableStateOf(ScreenState())

    private val repository = Repository()

    init {
        fetchHistoryDataSensor()
    }

    fun updateFetchHistoryDataSensor() {
        state.historyDataSensor = emptyList()
        state.pagination.current_page = 1
        state.pagination.total_page = 3
        Log.d("DevicePage", state.valueSearch + "da goi den update")
        Log.d("DevicePage", state.typeSearch)
        Log.d("DevicePage", state.historyDataSensor.toString())
        fetchHistoryDataSensor()
    }

    fun fetchHistoryDataSensor(
    ) {


        viewModelScope.launch {
            try {
//                Log.d("DevicePage", "fectch Device Page  ")
//                Log.d("DevicePage",  state.valueSearch)
//                Log.d("DevicePage",  state.sort)
//                Log.d("DevicePage", state.typeSort)
//                Log.d("DevicePage", state.typeSearch)
                var response = repository.getHistoryDataSensor(
                    state.valueSearch,
                    state.typeSearch,
                    state.typeSort,
                    state.sort,
                    state.pagination.current_page,
                    state.pagination.page_size
                )
                Log.d("DevicePage", response.body()?.data.toString())
                if (response.isSuccessful) {

                    state = state.copy(
                        historyDataSensor = state.historyDataSensor + response.body()?.data!!,
                        pagination = response.body()?.meta!!,
                        endReach = state.pagination.current_page == response.body()?.meta?.total_page,
                    )
                    Log.d("DevicePage", state.historyDataSensor.toString() + "sau fetch data")


                } else {
                    state = state.copy(
                        historyDataSensor = emptyList(),
                        pagination = PaginationObject(1, 25, null, null, null)
                    )
                    Log.d("DevicePage", "da update state")
                }
                Log.d("DevicePage", state.historyDataSensor.toString())
            } catch (e: Exception) {
                Log.d("DevicePageViewModel", e.toString())

            }


        }
        //   Log.d("DevicePage", state.historyDevice.toString())
    }

    override fun onCleared() {
        super.onCleared()
    }

    data class ScreenState(
        var historyDataSensor: List<SensorData> = emptyList(),
        var typeSearch: String = "Time",
        var typeSort: String = "Time",
        var sort: String = "Increase",
        var valueSearch: String = "",
        var focusManager: FocusManager? = null,
        var isLoading: Boolean = false,
        var endReach: Boolean = false,
        val error: String? = null,
        var signal: Int = 1,
        val pagination: PaginationObject = PaginationObject(1, 25, null, null, null)
    )
}


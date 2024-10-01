package com.example.smarthomeptit
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.smarthomeptit.socket.SocketManager
import com.example.smarthomeptit.ui.page.MainScreen
import com.example.smarthomeptit.viewModel.HomeViewModel

class MainActivity : ComponentActivity() {

    private val socketManager = SocketManager()
    private val viewHomeViewModel = HomeViewModel()
    private  val dataSensor ="data_sensor"
    private val statusLed = "led_status"
    private val statusFan = "fan_status"
    private val statusAirConditioner = "air_conditioner_status"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MainScreen(viewHomeViewModel)
        }
        socketManager.connect()
        socketManager.sendMessage("Hello from Android")
        if (socketManager.isConnected()) {
            Log.d("socketActivity", "Connected")
        } else {
            Log.d("socketActivity", "Not connected")
        }
        socketManager.onMessageReceived {event, message ->
            Log.d("socketActivity", "Message received $event: $message")
            when(event){
                dataSensor ->viewHomeViewModel.updateDataSensor(message)
                statusLed -> viewHomeViewModel.updateLedStatus(message.toInt())
                statusFan -> viewHomeViewModel.updateFanStatus(message.toInt())
                statusAirConditioner -> viewHomeViewModel.updateAirConditionerStatus(message.toInt())

            }

        }


    }

    override fun onDestroy() {
        super.onDestroy()
        socketManager.disconnect()
    }


}
package com.example.smarthomeptit.socket

import android.util.Log
import com.example.smarthomeptit.utils.RetrofitInstance
import io.socket.client.IO
import io.socket.client.Socket
import java.net.URISyntaxException


class SocketManager {
    private var socket: Socket? = null


    init {
        try {
            val opts = IO.Options()
            opts.transports = arrayOf(Socket.EVENT_CONNECT)

            socket = IO.socket(RetrofitInstance.url)
            socket?.on(Socket.EVENT_CONNECT) {
                Log.d("SocketManager", "Connected to server")
            }
            socket?.on(Socket.EVENT_CONNECT_ERROR) { args ->
                val error = args[0] as? Exception
                Log.e("SocketManager", "Connection error: ${error?.message}")
            }
            socket?.on(Socket.EVENT_DISCONNECT) {
                Log.d("SocketManager", "Disconnected from server")
            }
        } catch (e: URISyntaxException) {
            Log.e("SocketManager", "URISyntaxException: ${e.message}")
        }
    }


    fun connect() {
        socket?.connect()
    }

    fun disconnect() {
        socket?.disconnect()
    }

    fun isConnected(): Boolean {
        return socket?.connected() ?: false
    }

    private  val dataSensor ="data_sensor"
    private val statusLed = "led_status"
    private val statusFan = "fan_status"
    private val statusAirConditioner = "air_conditioner_status"
    private val statusDust = "dust_status"
    fun onMessageReceived(listener: (event :String, message : String) -> Unit) {
        socket?.on(dataSensor) { args ->
            val message = args[0] as String
            listener.invoke(dataSensor,message)
        }
        socket?.on(statusLed){args ->
            val message = args[0] as String
            listener.invoke(statusLed,message)

        }
        socket?.on(statusFan){args ->
            val message = args[0] as String
            listener.invoke(statusFan,message)
        }
        socket?.on(statusAirConditioner){args ->
            val message = args[0] as String
            listener.invoke(statusAirConditioner,message)
        }
        socket?.on(statusDust){args ->
            val message = args[0] as String
            listener.invoke(statusDust,message)
        }
    }

    fun sendMessage(message: String) {
        socket?.emit("message", message)
    }
}
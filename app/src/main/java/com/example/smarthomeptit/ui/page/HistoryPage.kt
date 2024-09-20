package com.example.smarthomeptit.ui.page


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.TabRowDefaults.Divider
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.smarthomeptit.data.model.SensorData
import com.example.smarthomeptit.ui.theme.BackgroundColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HistoryPage(modifier: Modifier = Modifier) {
    var showBottomSelectedSearch by remember {
        mutableStateOf(false)
    }
    var sheetState = rememberModalBottomSheetState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(BackgroundColor)
    )
    {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .padding(top = 20.dp)
                .padding(horizontal = 20.dp)
        )
        {
            Text(
                text = "History", fontSize = 40.sp,
                fontWeight = FontWeight.Bold
            )
        }
        Box(
            modifier = Modifier
                .weight(2f)
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
                .padding(top = 20.dp)
        ) {
            val listOfOptions = listOf("Temperature", "Humidity", "Light", "Time")
            val onSearchOptionSelected: (Boolean) -> Unit = { isSelected ->
                showBottomSelectedSearch = isSelected

            }
            FilterDevice(
                showBottomSelectedSearch = onSearchOptionSelected,
                listOfTypeSortOptions = listOfOptions
            )
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(10f)
                .padding(bottom = 10.dp)
        )
        {
            SensorHistory()
        }
        if (showBottomSelectedSearch) {
            val listOfOptionsSearchHistoryPage =
                mutableListOf("Tempearture", "Humidity", "Light", "Time")
            BottomSheetSearch(
                sheetState = sheetState,
                onDismissRequest = { showBottomSelectedSearch = false },
                typeOfSearchOptions = listOfOptionsSearchHistoryPage
            )
        }
    }
}

@Composable
fun SensorHistory() {
    val ListSensorData = listOf(
        SensorData(1, 36.7, 60.0, 500.0, "2024/09/02 08:00"),
        SensorData(1, 36.7, 60.0, 500.0, "2024/09/02 08:00"),
        SensorData(1, 36.7, 60.0, 500.0, "2024/09/02 08:00"),
        SensorData(1, 36.7, 60.0, 500.0, "2024/09/02 08:00"),
        SensorData(1, 36.7, 60.0, 500.0, "2024/09/02 08:00"),
        SensorData(1, 36.7, 60.0, 500.0, "2024/09/02 08:00"),
        SensorData(1, 36.7, 60.0, 500.0, "2024/09/02 08:00"),
        SensorData(1, 36.7, 60.0, 500.0, "2024/09/02 08:00"),
        SensorData(1, 36.7, 60.0, 500.0, "2024/09/02 08:00"),
        SensorData(1, 36.7, 60.0, 500.0, "2024/09/02 08:00"),
        SensorData(1, 36.7, 60.0, 500.0, "2024/09/02 08:00"),
        SensorData(1, 36.7, 60.0, 500.0, "2024/09/02 08:00"),
        SensorData(1, 36.7, 60.0, 500.0, "2024/09/02 08:00"),
        SensorData(1, 36.7, 60.0, 500.0, "2024/09/02 08:00"),
        SensorData(1, 36.7, 60.0, 500.0, "2024/09/02 08:00"),
        SensorData(1, 36.7, 60.0, 500.0, "2024/09/02 08:00"),
        SensorData(1, 36.7, 60.0, 500.0, "2024/09/02 08:00"),
        SensorData(1, 36.7, 60.0, 500.0, "2024/09/02 08:00"),
        SensorData(1, 36.7, 60.0, 500.0, "2024/09/02 08:00"),
        SensorData(1, 36.7, 60.0, 500.0, "2024/09/02 08:00"),
        SensorData(1, 36.7, 60.0, 500.0, "2024/09/02 08:00"),
        SensorData(1, 36.7, 60.0, 500.0, "2024/09/02 08:00"),
        SensorData(1, 36.7, 60.0, 500.0, "2024/09/02 08:00"),
        SensorData(1, 36.7, 60.0, 500.0, "2024/09/02 08:00"),
        SensorData(1, 36.7, 60.0, 500.0, "2024/09/02 08:00"),
        SensorData(1, 36.7, 60.0, 500.0, "2024/09/02 08:00"),
        SensorData(1, 36.7, 60.0, 500.0, "2024/09/02 08:00"),
        SensorData(1, 36.7, 60.0, 500.0, "2024/09/02 08:00"),
        SensorData(1, 36.7, 60.0, 500.0, "2024/09/02 08:00"),
        SensorData(1, 36.7, 60.0, 500.0, "2024/09/02 08:00"),
    )
    val fonsize = 15.sp
    Card(
        modifier = Modifier
            .padding(horizontal = 20.dp)
            .padding(top = 10.dp)
            .fillMaxSize(),
        shape = RoundedCornerShape(16.dp), // Hình dạng bo tròn của box
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
    ) {

        LazyColumn(modifier = Modifier.padding(10.dp)) {
            // Add a header at the top of the LazyColumn
            item {
                Row(
                    modifier = Modifier
                        .padding(5.dp)
                        .padding(top = 20.dp)
                        .fillMaxWidth()


                ) {
                    Box(modifier = Modifier.weight(0.5f), contentAlignment = Alignment.Center) {
                        Text(text = "Id", fontSize = fonsize, fontWeight = FontWeight.Bold)
                    }
                    Box(modifier = Modifier.weight(1f), contentAlignment = Alignment.Center) {
                        Text(text = "Temperature", fontSize = fonsize, fontWeight = FontWeight.Bold)
                    }
                    Box(modifier = Modifier.weight(1f), contentAlignment = Alignment.Center) {
                        Text(text = "Humidity", fontSize = fonsize, fontWeight = FontWeight.Bold)
                    }
                    Box(modifier = Modifier.weight(1f), contentAlignment = Alignment.Center) {
                        Text(
                            text = "Light",
                            fontSize = fonsize,
                            fontWeight = FontWeight.Bold
                        )
                    }
                    Box(modifier = Modifier.weight(1f), contentAlignment = Alignment.Center) {
                        Text(text = "Time", fontSize = fonsize, fontWeight = FontWeight.Bold)
                    }


                }
                Divider(
                    color = Color.LightGray.copy(alpha = 0.5f),
                    thickness = 1.dp,
                    modifier = Modifier.padding(horizontal = 20.dp)
                )
                Spacer(modifier = Modifier.height(10.dp))
            }

            // List items
            itemsIndexed(ListSensorData) { index, item ->
                Row(
                    modifier = Modifier.padding(5.dp),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    Box(modifier = Modifier.weight(0.5f), contentAlignment = Alignment.Center) {
                        Text(text = item.id.toString(), fontSize = fonsize)
                    }
                    Box(modifier = Modifier.weight(1f), contentAlignment = Alignment.Center) {
                        Text(text = item.temperature.toString(), fontSize = fonsize)
                    }
                    Box(modifier = Modifier.weight(1f), contentAlignment = Alignment.Center) {
                        Text(text = item.humidity.toString(), fontSize = fonsize)
                    }
                    Box(modifier = Modifier.weight(1f), contentAlignment = Alignment.Center) {
                        Text(text = item.lightIntensity.toString(), fontSize = fonsize)
                    }
                    Box(modifier = Modifier.weight(1f), contentAlignment = Alignment.Center) {
                        Text(text = item.time, fontSize = fonsize)
                    }
                }
                Divider(
                    color = Color.LightGray.copy(alpha = 0.5f),
                    thickness = 1.dp,
                    modifier = Modifier.padding(horizontal = 20.dp)
                )
                Spacer(modifier = Modifier.height(10.dp))
                // Log.i("maybetuandat", "index is $index")
            }


        }
    }
}


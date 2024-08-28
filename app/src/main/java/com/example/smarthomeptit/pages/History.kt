package com.example.smarthomeptit.pages


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.smarthomeptit.R
import com.example.smarthomeptit.model.SensorData
import com.example.smarthomeptit.ui.theme.BackgroundColor
import com.example.smarthomeptit.ui.theme.colorOrange
import com.example.smarthomeptit.ui.theme.iconunselectedcolor

@Composable
fun History(modifier: Modifier = Modifier) {
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
                .padding(horizontal = 10.dp)
        )
        {
            Row(modifier = Modifier.fillMaxSize()) {
                Text(
                    text = "History", fontSize = 40.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(12f).padding(bottom = 10.dp)
        )
        {
            SensorHistory()
        }
    }
}

@Composable
fun SensorHistory() {
    val ListSensorData = listOf(
        SensorData(1, 36.7, 60.0, 500.0, "08:00"),
        SensorData(2, 36.7, 60.0, 500.0, "08:00"),
        SensorData(3, 36.7, 60.0, 500.0, "08:00"),
        SensorData(4, 36.7, 60.0, 500.0, "08:00"),
        SensorData(5, 36.7, 60.0, 500.0, "08:00"),
        SensorData(6, 36.7, 60.0, 500.0, "08:00"),
        SensorData(7, 36.7, 60.0, 500.0, "08:00"),
        SensorData(8, 36.7, 60.0, 500.0, "08:00"),
        SensorData(9, 36.7, 60.0, 500.0, "08:00"),
        SensorData(10, 36.7, 60.0, 500.0, "08:00"),
        SensorData(11, 36.7, 60.0, 500.0, "08:00"),
        SensorData(12, 36.7, 60.0, 500.0, "08:00"),
        SensorData(13, 36.7, 60.0, 500.0, "08:00"),
        SensorData(14, 36.7, 60.0, 500.0, "08:00"),
        SensorData(15, 36.7, 60.0, 500.0, "08:00"),
        SensorData(16, 36.7, 60.0, 500.0, "08:00"),
        SensorData(17, 36.7, 60.0, 500.0, "08:00"),
        SensorData(18, 36.7, 60.0, 500.0, "08:00"),
        SensorData(19, 36.7, 60.0, 500.0, "08:00"),
        SensorData(20, 36.7, 60.0, 500.0, "08:00"),
        SensorData(20, 36.7, 60.0, 500.0, "08:00"),
        SensorData(21, 36.7, 60.0, 500.0, "08:00"),
        SensorData(22, 36.7, 60.0, 500.0, "08:00"),
        SensorData(23, 36.7, 60.0, 500.0, "08:00"),
        SensorData(24, 36.7, 60.0, 500.0, "08:00"),
        SensorData(25, 36.7, 60.0, 500.0, "08:00"),
        SensorData(26, 36.7, 60.0, 500.0, "08:00"),
        SensorData(27, 36.7, 60.0, 500.0, "08:00"),
        SensorData(28, 36.7, 60.0, 500.0, "08:00"),
        SensorData(29, 36.7, 60.0, 500.0, "08:00"),
        SensorData(30, 36.7, 60.0, 500.0, "08:00"),
    )
    val fonsize = 15.sp
    var selectSort by remember{mutableStateOf("")}
    var selectSensor by remember{mutableStateOf("")}
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
                Row(modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                )
                {
                    Box(modifier = Modifier
                        .weight(1f)
                        .fillMaxHeight()

                    )
                    {

                              Box(modifier  = Modifier.fillMaxSize().padding(10.dp), contentAlignment = Alignment.Center )
                              {
                                  Icon(modifier = Modifier, painter = painterResource(id = R.drawable.icon_filter), contentDescription = null, tint = Color.Black,
                                  )
                              }


                    }
                    Box(modifier = Modifier
                        .weight(1f)
                        .fillMaxHeight())
                    {
                        val listSortItem = listOf("Increase", "DeCrease")
                        DropdownMenu(listSortItem, "Sort", selectedDropDownItem = { selectSort = it })
                    }
                    Box(modifier = Modifier
                        .weight(1f)
                        .fillMaxHeight())
                    {
                        // item chua dropdown cua cac loai thong so nhu temperature, humidity, light
                        val listDataSensort = listOf("Temperature", "Humidity", "Light", "Time")
                        DropdownMenu(listDataSensort, "Sensor", selectedDropDownItem = { selectSensor = it })
                    }

                }

            }
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

                // Log.i("maybetuandat", "index is $index")
            }


        }
    }
}

@Preview
@Composable
fun previewhistory() {
    SensorHistory()
}
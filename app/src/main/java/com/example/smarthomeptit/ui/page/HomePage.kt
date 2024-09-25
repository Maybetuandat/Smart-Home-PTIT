package com.example.smarthomeptit.ui.page


import android.util.Log
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Switch
import androidx.compose.material.SwitchDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aay.compose.baseComponents.model.GridOrientation
import com.aay.compose.lineChart.LineChart
import com.aay.compose.lineChart.model.LineParameters
import com.aay.compose.lineChart.model.LineType
import com.example.smarthomeptit.R
import com.example.smarthomeptit.ui.theme.BackGroundDropDow
import com.example.smarthomeptit.ui.theme.BackgroundColor
import com.example.smarthomeptit.ui.theme.LightColor
import com.example.smarthomeptit.ui.theme.Red
import com.example.smarthomeptit.ui.theme.White
import com.example.smarthomeptit.ui.theme.iconselectedcolor
import com.example.smarthomeptit.ui.theme.iconunselectedcolor
import com.example.smarthomeptit.viewModel.HomeViewModel


@Composable
fun HomePage(viewModel: HomeViewModel) {


    val temperature by viewModel.temperature.observeAsState(initial = "32")
    val humidity by viewModel.humidity.observeAsState(initial = "70")
    val light by viewModel.light.observeAsState(initial = "1000")
    val ledStatus by viewModel.ledStatus.observeAsState(initial = 0)
    val fanStatus by viewModel.fanStatus.observeAsState(initial = 0)
    val airConditionerStatus by viewModel.airConditionerStatus.observeAsState(initial = 0)
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(BackgroundColor)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .padding(top = 20.dp)
                .padding(horizontal = 20.dp)
        ) {
            Row(modifier = Modifier.fillMaxSize()) {
                Text(text = "Home", fontSize = 40.sp, fontWeight = FontWeight.Bold)
            }
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(6f)
        ) {
            Column(modifier = Modifier.fillMaxSize()) {

                Box(
                    modifier = Modifier
                        .weight(4f)
                        .fillMaxWidth()

                ) {

                        Chart(viewModel)



                }
                Box(
                    modifier = Modifier
                        .weight(0.6f)
                        .fillMaxWidth()
                        .padding(top = 10.dp)
                ) {
                    DropDown(viewModel)
                }
            }
        }

        Box(
            modifier = Modifier
                .weight(4f)
                .fillMaxWidth()
                .padding(top = 10.dp)
        )
        {
            Column(modifier = Modifier.fillMaxSize()) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)

                ) {
                    HomeStatus(temperature, humidity, light)
                }
                LazyColumn(
                    modifier = Modifier
                        .weight(2f)
                        .fillMaxWidth()
                )
                {
                    val controlDevice: (ac: Int, id: Int) -> Unit = { ac, id ->
                        viewModel.controlDevice(ac, id)

                    }


                    item { DeviceSwitch(controlDevice, ledStatus, fanStatus, airConditionerStatus) }
                }
            }

        }


    }
}

data class DeviceController(
    val label: String,
    val icon: Int
)

@Composable
fun DeviceSwitch(
    controlDevice: (ac: Int, id: Int) -> Unit,

    lightStatus: Int,
    fanStatus: Int,
    airConditionerStatus: Int,
    ledStatus: Int
) {
    val itemList = mutableListOf(
        DeviceController("Fan", R.drawable.icon_fan_device),
        DeviceController("Light", R.drawable.icon_light_device),
        DeviceController("Smart AirConditioner", R.drawable.aircondition_icon),
        DeviceController("Led", R.drawable.icon_led),

    )
    Column(modifier = Modifier
        .height(300.dp)
        .fillMaxWidth()) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(1f)
                    .padding(bottom = 10.dp)
                    .padding(start = 10.dp)

            )
            {
                DeviceSplitTwo(itemList[0], controlDevice, fanStatus, "fan")
            }
            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(1f)
                    .padding(bottom = 10.dp)
                    .padding(horizontal = 10.dp)
            )
            {
                DeviceSplitTwo(itemList[1], controlDevice, lightStatus, "led")
            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(1f)
                    .padding(bottom = 10.dp)
                    .padding(start = 10.dp)

            )
            {
                DeviceSplitTwo(itemList[2], controlDevice, airConditionerStatus, "air conditioner")
            }
            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(1f)
                    .padding(bottom = 10.dp)
                    .padding(horizontal = 10.dp)
            )
            {
                DeviceSplitTwo(itemList[3], controlDevice, ledStatus, "led")
            }
        }
//        Box(
//            modifier = Modifier
//                .fillMaxWidth()
//                .weight(1f)
//                .padding(horizontal = 10.dp)
//                .padding(bottom = 10.dp)
//        )
//        {
//            DeviceSplitOne(itemList[2], controlDevice, airConditionerStatus)
//        }
    }
}


@Composable
fun DeviceSplitOne(
    item: DeviceController,
    controlDevice: (ac: Int, id: Int) -> Unit,
    airConditionerStatus: Int
) {

    var color = if (airConditionerStatus == 1) iconselectedcolor else iconunselectedcolor
    Card(
        modifier = Modifier.fillMaxSize(),
        shape = RoundedCornerShape(4.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    )
    {
        Column(modifier = Modifier.fillMaxSize()) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(2f)
            ) {
                // box nay chua icon
                Box(
                    modifier = Modifier
                        .fillMaxHeight()
                        .weight(1f),
                    contentAlignment = Alignment.Center
                )
                {
                    Icon(
                        painter = painterResource(id = item.icon),
                        contentDescription = item.label,
                        tint = color,
                        modifier = Modifier
                            .height(80.dp)
                            .width(80.dp)
                    )
                }
                // box nay chua switch
                Box(
                    modifier = Modifier
                        .fillMaxHeight()
                        .weight(1f),
                    contentAlignment = Alignment.Center
                )
                {
                    Switch(
                        checked = (if (airConditionerStatus == 1) true else false),
                        onCheckedChange = {


                            controlDevice(if (it) 1 else 0, 3)

                        },
                        modifier = Modifier.scale(1.5f),
                        colors = SwitchDefaults.colors(
                            checkedThumbColor = White,
                            uncheckedThumbColor = Color.White,
                            checkedTrackColor = iconselectedcolor,
                            uncheckedTrackColor = iconunselectedcolor.copy(0.4f)
                        )
                    )
                }
            }
            // box nay chua text
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                contentAlignment = Alignment.Center
            )
            {
                Text(text = item.label, fontSize = 20.sp)
            }

        }
    }
}

@Composable
fun DeviceSplitTwo(
    item: DeviceController,
    action: (ac: Int, id: Int) -> Unit,
    status: Int,
    type: String
) {

    val id : Int
    when(type){
        "led" -> {
            id = 1
        }
        "fan" -> {
            id = 2
        }
        "air conditioner" ->{
            id = 3
        }
        "led" ->{
            id = 4
        }
    }
    val infiniteTransition = rememberInfiniteTransition()
    val rotation by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 360f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 1000, easing = LinearEasing)
        ), label = ""
    )
    var colorFan = if (status == 1) iconselectedcolor else iconunselectedcolor
    var colorLight = if (status == 1) LightColor else iconunselectedcolor
    Card(
        modifier = Modifier
            .height(150.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(4.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    )
    {
        Column(modifier = Modifier.fillMaxSize()) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(2f)
            ) {
                // box nay chua icon
                Box(
                    modifier = Modifier
                        .fillMaxHeight()
                        .weight(1f),
                    contentAlignment = Alignment.Center
                )
                {
                    if (type == "fan") {
                        if (status == 1) {
                            Icon(
                                painter = painterResource(id = item.icon),
                                contentDescription = item.label,
                                tint = colorFan,
                                modifier = Modifier
                                    .height(45.dp)
                                    .width(45.dp)
                                    .rotate(rotation)
                            )
                        } else {
                            Icon(
                                painter = painterResource(id = item.icon),
                                contentDescription = item.label,
                                tint = colorFan,
                                modifier = Modifier
                                    .height(45.dp)
                                    .width(45.dp)
                            )
                        }

                    } else {
                        Icon(
                            painter = painterResource(id = item.icon),
                            contentDescription = item.label,
                            tint = colorLight,
                            modifier = Modifier
                                .height(45.dp)
                                .width(45.dp)
                        )
                    }

                }
                // box nay chua switch
                Box(
                    modifier = Modifier
                        .fillMaxHeight()
                        .weight(1f),
                    contentAlignment = Alignment.Center
                )
                {
                    Switch(
                        checked = if (status == 1) true else false,
                        onCheckedChange = {


                            action(if (it) 1 else 0, id)

                        },
                        modifier = Modifier.scale(1.5f),
                        colors = SwitchDefaults.colors(
                            checkedThumbColor = White,
                            uncheckedThumbColor = Color.White,
                            checkedTrackColor = if (type == "fan") iconselectedcolor else LightColor,
                            uncheckedTrackColor = iconunselectedcolor.copy(0.4f)
                        )
                    )
                }
            }
            // box nay chua text
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                contentAlignment = Alignment.Center
            )
            {
                Text(text = item.label, fontSize = 20.sp)
            }

        }
    }
}


@OptIn(ExperimentalLayoutApi::class)
@Composable
fun HomeStatus(temperature: String, humidity: String, light: String) {
    val colorTemperature = if (temperature.toFloat() > 30) Red else iconselectedcolor
    val colorHumidity = if (humidity.toFloat() > 50) iconselectedcolor else iconunselectedcolor
    val colorLight = if (light.toFloat() > 1000) LightColor else iconunselectedcolor

    Card(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 10.dp)
            .padding(bottom = 10.dp),
        shape = RoundedCornerShape(4.dp),
        colors = CardDefaults.cardColors(Color.White)
    ) {
        Row(modifier = Modifier.fillMaxSize()) {
            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(1f)
            )
            {
                HomeStatusItem(
                    ItemStatus(
                        "Nhiệt độ",
                        R.drawable.temperature_icon,
                        "${temperature}°C", colorTemperature
                    )
                )
            }
            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(1f)
            )
            {
                HomeStatusItem(
                    ItemStatus(
                        "Độ ẩm",
                        R.drawable.humidity_icon,
                        "${humidity}%",
                        colorHumidity
                    )
                )
            }
            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(1f)
            )
            {
                HomeStatusItem(
                    Item = ItemStatus(
                        "Ánh sáng",
                        R.drawable.lights_icon,
                        "${light} lux", colorLight
                    )
                )
            }

        }
    }

}

@Composable
fun HomeStatusItem(Item: ItemStatus) {
    Column(modifier = Modifier.fillMaxSize()) {

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f), contentAlignment = Alignment.Center
        )
        {
            Text(text = Item.label, fontSize = 20.sp)
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f), contentAlignment = Alignment.Center
        )
        {
            Icon(
                painter = painterResource(id = Item.icon),
                contentDescription = null,
                tint = Item.color
            )
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f), contentAlignment = Alignment.Center
        )
        {
            Text(text = Item.data, fontSize = 20.sp)
        }
    }

}

data class ItemStatus(
    val label: String,
    val icon: Int,
    val data: String,
    val color: Color
)


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DropDown(viewModel: HomeViewModel) {
    val list = listOf("Temperature", "Humidity", "Light")


//    var selectedText by remember {
//        mutableStateOf(list[0])
//    }
    var isExpanded by remember {
        mutableStateOf(false)
    }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 90.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ExposedDropdownMenuBox(expanded = isExpanded, onExpandedChange = {
            isExpanded = !isExpanded
        }) {
            BasicTextField(modifier = Modifier
                .menuAnchor()
                .fillMaxWidth()
                .background(
                    color = BackGroundDropDow,  // Màu nền của BasicTextField
                    shape = RoundedCornerShape(40.dp)  // Bo góc cho BasicTextField
                )
                .padding(vertical = 16.dp),  // Padding bên trong
                value = viewModel.selectedChart,
                onValueChange = {},
                readOnly = true,
                decorationBox = { innerTextField ->  // Hộp chứa trang trí cho BasicTextField
                    Row(
                        Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        Box {
                            innerTextField()  // Nội dung của BasicTextField
                        }
                        ExposedDropdownMenuDefaults.TrailingIcon(expanded = isExpanded)  // Biểu tượng mũi tên
                    }
                })

            ExposedDropdownMenu(
                expanded = isExpanded,
                onDismissRequest = { isExpanded = false },
                modifier = Modifier.background(White)
            ) {
                list.forEachIndexed { index, text ->
                    DropdownMenuItem(
                        text = {
                            Text(
                                text = text, color = Color.Black  // Màu chữ của item
                            )
                        },
                        onClick = {
                            viewModel.selectedChart = list[index]
                            isExpanded = false

                        },
                        modifier = Modifier
                            .background(Color.Transparent)  // Nền của DropdownMenuItem
                            .padding(8.dp)
                    )
                }
            }
        }

    }

}


@Composable
fun Chart(viewModel: HomeViewModel) {
    Card(modifier = Modifier.fillMaxSize(),
        shape = RoundedCornerShape(4.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp))
    {
        var listData: List<Double> = emptyList()

        when (viewModel.selectedChart) {
            "Temperature" -> {
                listData = viewModel.listTemperature
            }

            "Humidity" -> {
                listData = viewModel.listHumidity
            }

            "Light" -> {
                listData = viewModel.listLight
            }
        }
        if(listData.isEmpty())
        {
                Box(modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center)
                {
                    Text(text = "No data")
                }
        }
        else
        {
            Log.d("Chart", listData.toString())
            val testLineParameters: List<LineParameters> = listOf(
                LineParameters(
                    label = viewModel.selectedChart,  // Đặt label dựa trên biểu đồ đang được chọn
                    data = listData,
                    lineColor = iconselectedcolor,
                    lineType = LineType.CURVED_LINE,
                    lineShadow = true,
                )
            )


            Box(
                Modifier
                    .fillMaxSize()
                    .padding()) {
                LineChart(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(10.dp),
                    linesParameters = testLineParameters,
                    isGrid = true,
                    gridColor = Color.Gray,
                    xAxisData = listOf("0", "1", "2", "3", "4", "5", "6", "7", "8", "9"),
                    animateChart = true,
                    showGridWithSpacer = true,
                    yAxisStyle = TextStyle(
                        fontSize = 14.sp,
                        color = Color.Gray,
                    ),
                    xAxisStyle = TextStyle(
                        fontSize = 14.sp, color = Color.Gray, fontWeight = FontWeight.W400
                    ),
                    yAxisRange = 5,
                    oneLineChart = false,
                    gridOrientation = GridOrientation.GRID,
                    showXAxis = true
                )
            }
        }

    }
}


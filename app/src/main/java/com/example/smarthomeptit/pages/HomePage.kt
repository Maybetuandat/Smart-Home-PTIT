package com.example.smarthomeptit.pages


import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aay.compose.baseComponents.model.GridOrientation
import com.aay.compose.lineChart.LineChart
import com.aay.compose.lineChart.model.LineParameters
import com.aay.compose.lineChart.model.LineType
import com.example.smarthomeptit.R
import com.example.smarthomeptit.model.ItemCard
import com.example.smarthomeptit.ui.theme.BackGroundDropDow
import com.example.smarthomeptit.ui.theme.BackgroundColor
import com.example.smarthomeptit.ui.theme.Black
import com.example.smarthomeptit.ui.theme.iconselectedcolor
import com.example.smarthomeptit.ui.theme.iconunselectedcolor


@Composable
fun HomePage() {

    var selectedChart by remember {
        mutableStateOf("Temperature")
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(BackgroundColor)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.25f)
                .padding(top = 20.dp)
                .padding(horizontal = 10.dp)
        ) {
            Row(modifier = Modifier.fillMaxSize()) {
                Text(text = "Home", fontSize = 40.sp, fontWeight = FontWeight.Bold)
            }
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1.5f)
        ) {
            Column(modifier = Modifier.fillMaxSize()) {

                Box(
                    modifier = Modifier
                        .weight(4f)
                        .fillMaxWidth()
                ) {

                    Chart(selectedChart)

                }
                Box(
                    modifier = Modifier
                        .weight(0.6f)
                        .fillMaxWidth()
                ) {
                    DropDown(selectedChart = {selectedChart = it}    )
                }
            }
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ) {
            Sensor()
        }
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun CardElements(modifier: Modifier = Modifier, itemCard: ItemCard) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(16.dp), // Hình dạng bo tròn của box
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
    ) {
        FlowRow(maxItemsInEachRow = 2) {
            Box(
                modifier = Modifier
                    .fillMaxHeight(0.7f)
                    .weight(1.5f),
                contentAlignment = Alignment.Center
            ) {
                // box nay chua so lieu
                Text(
                    text = itemCard.data, fontSize = 40.sp, color = Black
                )
            }
            Box(
                modifier = Modifier
                    .fillMaxHeight(0.7f)
                    .weight(1f),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    painter = itemCard.icon,
                    contentDescription = itemCard.label,
                    tint = iconselectedcolor
                )
            }
            Box(
                modifier = Modifier
                    .fillMaxHeight(0.3f)
                    .weight(1f),
                contentAlignment = Alignment.TopCenter
            ) {
                Text(
                    text = itemCard.label, fontSize = 20.sp, color = iconunselectedcolor
                )
            }
        }
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun Sensor() {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        FlowRow(modifier = Modifier.padding(10.dp), maxItemsInEachRow = 2) {
            val listcard = listOf(
                ItemCard(
                    data = "20°C",
                    icon = painterResource(id = R.drawable.temperature_icon),
                    label = "Temperature"
                ), ItemCard(
                    data = "60%",
                    icon = painterResource(id = R.drawable.humidity_icon),
                    label = "Humidity"
                ), ItemCard(
                    data = "500 Lux",
                    icon = painterResource(id = R.drawable.lights_icon),
                    label = "Light"
                )
            )
            listcard.forEachIndexed { index, carditem ->
                if (index == 2) CardElements(
                    modifier = Modifier
                        .padding(horizontal = 10.dp)
                        .padding(bottom = 20.dp)
                        .weight(1f)
                        .fillMaxHeight(0.5f), carditem
                )
                else CardElements(
                    modifier = Modifier
                        .padding(10.dp)
                        .weight(1f)
                        .fillMaxHeight(0.5f), carditem
                )
            }

        }
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DropDown(selectedChart: (String) -> Unit) {
    val list = listOf("Temperature","Humidity" )


    var selectedText by remember {
        mutableStateOf(list[0])
    }
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
                value = selectedText,
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

            ExposedDropdownMenu(expanded = isExpanded, onDismissRequest = { isExpanded = false }) {
                list.forEachIndexed { index, text ->
                    DropdownMenuItem(text = {
                        Text(
                            text = text, color = Color.Black  // Màu chữ của item
                        )
                    },
                        onClick = {
                            selectedText = list[index]
                            isExpanded = false
                            selectedChart(list[index])
                        },
                        modifier = Modifier
                            .background(BackgroundColor)  // Nền của DropdownMenuItem
                            .padding(8.dp)
                    )
                }
            }
        }

    }

}


@Composable
fun Chart(selectedChart: String) {
  //  Log.i("maybetuandat", "selectedChart is $selectedChart")
    val testLineParameters: List<LineParameters> = if (selectedChart == "Temperature") {
        listOf(
            LineParameters(
                label = "Temperature",
                data = listOf(22.0, 18.0, 25.0, 23.0, 27.0),
                lineColor = iconselectedcolor,
                lineType = LineType.CURVED_LINE,
                lineShadow = true,
            )
        )
    } else {
        listOf(
            LineParameters(
                label = "Humidity",
                data = listOf(62.0, 56.0, 51.0, 62.0, 67.0),
                lineColor = iconselectedcolor,
                lineType = LineType.CURVED_LINE,
                lineShadow = true,
            )
        )
    }

    Box(Modifier) {
        LineChart(
            modifier = Modifier.fillMaxSize(),
            linesParameters = testLineParameters,
            isGrid = true,
            gridColor = Color.Gray,
            xAxisData = listOf("1", "2", "3", "4", "5"),
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

@Preview(showSystemUi = true)
@Composable
fun previewHomePage() {

    HomePage()
}

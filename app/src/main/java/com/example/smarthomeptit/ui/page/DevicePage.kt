package com.example.smarthomeptit.ui.page

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.IconButton
import androidx.compose.material.TabRowDefaults.Divider
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SheetState
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.smarthomeptit.R
import com.example.smarthomeptit.data.model.HistoryDevice
import com.example.smarthomeptit.ui.theme.BackgroundColor
import com.example.smarthomeptit.ui.theme.White
import com.example.smarthomeptit.ui.theme.iconunselectedcolor

@OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterialApi::class)
@Composable
fun DevicePage() {
    var showBottomSelectedSearch by remember {
        mutableStateOf(false)
    }
    val sheetState = rememberModalBottomSheetState(
        skipPartiallyExpanded = true,
    )
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
            Text(
                text = "Device",
                fontSize = 40.sp,
                fontWeight = FontWeight.Bold
            )  // hiện thị text
        }
        //thanh tim kiem va loc
        Box(
            modifier = Modifier
                .weight(2f)
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
                .padding(top = 20.dp)
        ) {
            val listOfTypeSortOptionsDevicePage = mutableListOf("Time")
            var onSearchOptionSelected: (Boolean) -> Unit = { isSelected ->
                // Xử lý khi tùy chọn được chọn
                showBottomSelectedSearch = isSelected
            }

            FilterDevice(
                showBottomSelectedSearch = onSearchOptionSelected,
                listOfTypeSortOptions = listOfTypeSortOptionsDevicePage
            )
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(10f)
                .padding(top = 15.dp)
        ) {
            TableHistoryDevice()   // bảng thể hiện giá trị
        }
        if (showBottomSelectedSearch) {
            val typeOfSearchOptionsDevicePage = listOf(
                "Device", "Status", "Time"

            )
            BottomSheetSearch(
                onDismissRequest = { showBottomSelectedSearch = false },
                sheetState = sheetState,
                typeOfSearchOptions = typeOfSearchOptionsDevicePage
            )
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomSheetSearch(
    sheetState: SheetState,
    onDismissRequest: () -> Unit,
    typeOfSearchOptions: List<String>
) {
    ModalBottomSheet(
        sheetState = sheetState,
        onDismissRequest = onDismissRequest,
        dragHandle = { BottomSheetDefaults.DragHandle() }
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            // Title and close icon
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Select type for search",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
                IconButton(onClick = onDismissRequest) {
                    Icon(Icons.Default.Close, contentDescription = "Close")
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // List of salary options


            Column(modifier = Modifier.padding(bottom = 20.dp)) {
                typeOfSearchOptions.forEach { option ->
                    TypeOfSearchItem(option = option, onClick = { /* Handle click */ })
                }
            }
        }
    }
}

@Composable
fun TypeOfSearchItem(option: String, onClick: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
    ) {
        Text(
            text = option,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp)
                .padding(vertical = 12.dp),
            fontSize = 18.sp
        )
        Divider(
            color = Color.LightGray.copy(alpha = 0.5f),
            thickness = 1.dp,
            modifier = Modifier.padding(horizontal = 20.dp)
        )
    }
}


@Composable
fun TableHistoryDevice() {

    val historyDevices: MutableList<HistoryDevice> = mutableListOf(
        HistoryDevice(
            "Air Conditioner",
            time = "2024/09/02 08:00",
            status = "On"
        ),
        HistoryDevice(
            "Light",
            time = "2024/09/02 08:00",
            status = "Off"
        ),
        HistoryDevice(
            "Fan",
            time = "2024/09/02 08:00",
            status = "On"
        ),
        HistoryDevice(
            "Light",
            time = "2024/09/02 08:00",
            status = "Off"
        ),
        HistoryDevice(
            "Air Conditioner",
            time = "2024/09/02 08:00",
            status = "On"
        ),
        HistoryDevice(
            "Air Conditioner",
            time = "2024/09/02 08:00",
            status = "On"
        ),
        HistoryDevice(
            "Light",
            time = "2024/09/02 08:00",
            status = "Off"
        ),
        HistoryDevice(
            "Fan",
            time = "2024/09/02 08:00",
            status = "On"
        ),
        HistoryDevice(
            "Light",
            time = "2024/09/02 08:00",
            status = "Off"
        ),
        HistoryDevice(
            "Air Conditioner",
            time = "2024/09/02 08:00",
            status = "On"
        ),
        HistoryDevice(
            "Air Conditioner",
            time = "2024/09/02 08:00",
            status = "On"
        ),
        HistoryDevice(
            "Light",
            time = "2024/09/02 08:00",
            status = "Off"
        ),
        HistoryDevice(
            "Fan",
            time = "2024/09/02 08:00",
            status = "On"
        ),
        HistoryDevice(
            "Light",
            time = "2024/09/02 08:00",
            status = "Off"
        ),
        HistoryDevice(
            "Air Conditioner",
            time = "2024/09/02 08:00",
            status = "On"
        ),
        HistoryDevice(
            "Air Conditioner",
            time = "2024/09/02 08:00",
            status = "On"
        ),
        HistoryDevice(
            "Light",
            time = "2024/09/02 08:00",
            status = "Off"
        ),
        HistoryDevice(
            "Fan",
            time = "2024/09/02 08:00",
            status = "On"
        ),
        HistoryDevice(
            "Light",
            time = "2024/09/02 08:00",
            status = "Off"
        ),
        HistoryDevice(
            "Air Conditioner",
            time = "2024/09/02 08:00",
            status = "On"
        ),
        HistoryDevice(
            "Air Conditioner",
            time = "2024/09/02 08:00",
            status = "On"
        ),
        HistoryDevice(
            "Light",
            time = "2024/09/02 08:00",
            status = "Off"
        ),
        HistoryDevice(
            "Fan",
            time = "2024/09/02 08:00",
            status = "On"
        ),
        HistoryDevice(
            "Light",
            time = "2024/09/02 08:00",
            status = "Off"
        ),
        HistoryDevice(
            "Air Conditioner",
            time = "2024/09/02 08:00",
            status = "On"
        ),
        HistoryDevice(
            "Air Conditioner",
            time = "2024/09/02 08:00",
            status = "On"
        ),
        HistoryDevice(
            "Light",
            time = "2024/09/02 08:00",
            status = "Off"
        ),
        HistoryDevice(
            "Fan",
            time = "2024/09/02 08:00",
            status = "On"
        ),
        HistoryDevice(
            "Light",
            time = "2024/09/02 08:00",
            status = "Off"
        ),
        HistoryDevice(
            "Air Conditioner",
            time = "2024/09/02 08:00",
            status = "On"
        ),
        HistoryDevice(
            "Air Conditioner",
            time = "2024/09/02 08:00",
            status = "On"
        ),
        HistoryDevice(
            "Light",
            time = "2024/09/02 08:00",
            status = "Off"
        ),
        HistoryDevice(
            "Fan",
            time = "2024/09/02 08:00",
            status = "On"
        ),
        HistoryDevice(
            "Light",
            time = "2024/09/02 08:00",
            status = "Off"
        ),
        HistoryDevice(
            "Air Conditioner",
            time = "2024/09/02 08:00",
            status = "On"
        ),
        HistoryDevice(
            "Air Conditioner",
            time = "2024/09/02 08:00",
            status = "On"
        ),
        HistoryDevice(
            "Light",
            time = "08:00",
            status = "Off"
        ),
        HistoryDevice(
            "Fan",
            time = "08:00",
            status = "On"
        ),
        HistoryDevice(
            "Light",
            time = "08:00",
            status = "Off"
        ),
        HistoryDevice(
            "Air Conditioner",
            time = "08:00",
            status = "On"
        ),
        HistoryDevice(
            "Air Conditioner",
            time = "08:00",
            status = "On"
        ),
        HistoryDevice(
            "Light",
            time = "08:00",
            status = "Off"
        ),
        HistoryDevice(
            "Fan",
            time = "08:00",
            status = "On"
        ),
        HistoryDevice(
            "Light",
            time = "08:00",
            status = "Off"
        ),
        HistoryDevice(
            "Air Conditioner",
            time = "08:00",
            status = "On"
        ),
    )
    val fonsize = 15.sp
    Card(
        modifier = Modifier
            .padding(horizontal = 20.dp)
            .padding(bottom = 20.dp),
        shape = RoundedCornerShape(16.dp), // Hình dạng bo tròn của box
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)

    ) {

        LazyColumn(modifier = Modifier.padding(vertical = 20.dp, horizontal = 10.dp)) {

            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 10.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Box(modifier = Modifier.weight(0.5f), contentAlignment = Alignment.Center) {
                        Text(text = "Id", fontWeight = FontWeight.Bold)
                    }
                    Box(modifier = Modifier.weight(1f), contentAlignment = Alignment.Center) {
                        Text(text = "Device", fontWeight = FontWeight.Bold)
                    }
                    Box(modifier = Modifier.weight(1f), contentAlignment = Alignment.Center) {
                        Text(text = "Status", fontWeight = FontWeight.Bold)
                    }
                    Box(modifier = Modifier.weight(1f), contentAlignment = Alignment.Center) {
                        Text(text = "Time", fontWeight = FontWeight.Bold)
                    }
                }
                Divider(
                    color = Color.LightGray.copy(alpha = 0.5f),
                    thickness = 1.dp
                )
            }
            itemsIndexed(historyDevices) { index, item ->
                Row(
                    modifier = Modifier.padding(vertical = 10.dp),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    Box(modifier = Modifier.weight(0.5f), contentAlignment = Alignment.Center) {
                        Text(text = index.toString(), fontSize = fonsize)
                    }
                    Box(modifier = Modifier.weight(1f), contentAlignment = Alignment.Center) {
                        Text(text = item.nameDevice, fontSize = fonsize)
                    }
                    Box(modifier = Modifier.weight(1f), contentAlignment = Alignment.Center) {
                        Text(text = item.status, fontSize = fonsize)
                    }
                    Box(modifier = Modifier.weight(1f), contentAlignment = Alignment.Center) {
                        Text(text = item.time, fontSize = fonsize)
                    }

                }
                Divider(
                    color = Color.LightGray.copy(alpha = 0.5f),
                    thickness = 1.dp
                )
            }
        }
    }
}


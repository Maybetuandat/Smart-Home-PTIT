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
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MenuDefaults
import androidx.compose.material3.TextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.smarthomeptit.R
import com.example.smarthomeptit.model.HistoryDevice
import com.example.smarthomeptit.model.ItemCard
import com.example.smarthomeptit.model.ItemDevices
import com.example.smarthomeptit.ui.theme.BackGroundDropDow
import com.example.smarthomeptit.ui.theme.BackgroundColor
import com.example.smarthomeptit.ui.theme.Black
import com.example.smarthomeptit.ui.theme.colorOrange
import com.example.smarthomeptit.ui.theme.iconselectedcolor
import com.example.smarthomeptit.ui.theme.iconunselectedcolor


@Composable
fun Device() {
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
        )
        {
            Row(modifier = Modifier.fillMaxSize()) {
                Text(
                    text = "Device", fontSize = 40.sp,
                    fontWeight = FontWeight.Bold
                )
            }

        }


        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1.5f)
        )
        {
            DeviceHistoryList()
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        )
        {
            DeviceList()
        }
    }
}



@Composable
fun DeviceHistoryList()
{
   // var searchItem = remember { mutableStateOf("") }
    var deviceDropDownItem by remember { mutableStateOf("") }
    var statusDropDownItem by remember { mutableStateOf("") }
    var timeDropDownItem by remember { mutableStateOf("") }

    val historyDevices : MutableList<HistoryDevice> = mutableListOf(
        HistoryDevice(
            "Air Conditioner",
            time = "07:00",
            status = "On"
        ),
        HistoryDevice(
            "Light",
            time = "06:00",
            status = "Off"
        ),
        HistoryDevice(
            "Fan",
            time = "01:00",
            status = "On"
        ),
        HistoryDevice(
            "Light",
            time = "08:00",
            status = "Off"
        ),
        HistoryDevice(
            "Air Conditioner",
            time = "18:00",
            status = "On"
        ),
        HistoryDevice(
            "Air Conditioner",
            time = "17:00",
            status = "On"
        ),
        HistoryDevice(
            "Light",
            time = "10:00",
            status = "Off"
        ),
        HistoryDevice(
            "Fan",
            time = "16:00",
            status = "On"
        ),
        HistoryDevice(
            "Light",
            time = "09:00",
            status = "Off"
        ),
        HistoryDevice(
            "Air Conditioner",
            time = "11:00",
            status = "On"
        ),
        HistoryDevice(
            "Air Conditioner",
            time = "12:00",
            status = "On"
        ),
        HistoryDevice(
            "Light",
            time = "13:00",
            status = "Off"
        ),
        HistoryDevice(
            "Fan",
            time = "13:00",
            status = "On"
        ),
        HistoryDevice(
            "Light",
            time = "19:00",
            status = "Off"
        ),
        HistoryDevice(
            "Air Conditioner",
            time = "20:00",
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
    historyDevices.sort()
    Log.i("maybetuandat1", timeDropDownItem)
    val fonsize = 15.sp
    Card(modifier = Modifier.padding(horizontal = 20.dp),
        shape = RoundedCornerShape(16.dp), // Hình dạng bo tròn của box
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
    ){

        LazyColumn(modifier = Modifier.padding(horizontal = 10.dp)) {
            // Add a header at the top of the LazyColumn
//            item {
//                    TextField(
//                        modifier = Modifier
//                            .fillMaxWidth()
//                            .background(Color.White)
//                            .padding(horizontal = 20.dp),
//                        value = searchItem.value, onValueChange = { newtext ->
//                            searchItem.value = newtext
//
//                        } ,
//                        leadingIcon = {
//                            Icon(imageVector = Icons.Default.Search,
//                                contentDescription = null)
//                        },
//                        colors = TextFieldDefaults.colors(
//                            focusedContainerColor = Color.White, // màu  o ben trong cua text field khi được focus (giong nhu background)
//                            unfocusedContainerColor = Color.White, // giong o tren nhung la khong duoc focus
//                            focusedIndicatorColor = Color.White,  // vung ben ngoai chua text field
//                            unfocusedIndicatorColor = Color.White,
//                            focusedPlaceholderColor = Color.Gray,    // mau cua place holder
//                            unfocusedPlaceholderColor = Color.Gray,
//                        ),
//                        placeholder = { Text(text = "Search by name device")}
//                    )
//            }

            item {
                Row(
                    modifier = Modifier
                        .padding(horizontal = 5.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    Box(modifier = Modifier.weight(2f), contentAlignment = Alignment.Center) {
                        val itemsTime = listOf("Air Conditioner", "Light", "Fan", "All")
                        DropdownMenu(itemsTime, "Device", selectedDropDownItem = { deviceDropDownItem = it })
                    }
                    Box(modifier = Modifier.weight(1.5f), contentAlignment = Alignment.Center) {
                        val itemsTime = listOf("On", "Off", "None")
                        DropdownMenu(itemsTime, "Status", selectedDropDownItem = { statusDropDownItem = it } )
                    }
                    Box(modifier = Modifier.weight(1.5f), contentAlignment = Alignment.Center) {
                        val itemsTime = listOf("Increase", "Decrease")
                        DropdownMenu(itemsTime, "Time", selectedDropDownItem = { timeDropDownItem = it })
                    }
                }
            }

            if(timeDropDownItem == "Increase" || timeDropDownItem.isEmpty())
            {
                historyDevices.sort()
            }
            else
            {
                historyDevices.sortDescending()
            }
            // List items
            fun checkName(itemName : String, nameDropDownItem : String):Boolean
            {
                if(nameDropDownItem.isEmpty()) return true
                if(nameDropDownItem == "All") return true
                if(itemName == nameDropDownItem) return true
                return false
            }
            fun checkStatus(itemStatus : String, statusDropDownItem : String):Boolean
            {
                if(statusDropDownItem.isEmpty())   return true
                if(statusDropDownItem == "None") return true
                if(itemStatus == statusDropDownItem) return true
                return false
            }
            val filteredDevices = historyDevices.filter { item ->
                checkName(item.nameDevice, deviceDropDownItem) && checkStatus(item.status, statusDropDownItem)
            }
            if(filteredDevices.isEmpty())
            {
                item{
                    Box(modifier = Modifier
                        .height(100.dp)
                        .fillMaxSize(), contentAlignment = Alignment.Center) {
                        Text(text = "No data", fontSize = fonsize, fontWeight = FontWeight.Bold)
                    }
                }

            }
            else
            {
                itemsIndexed(filteredDevices) { index, item ->

                    if(checkName(item.nameDevice, deviceDropDownItem) && checkStatus(item.status, statusDropDownItem)) {
                        Row(
                            modifier = Modifier.padding(5.dp),
                            horizontalArrangement = Arrangement.SpaceEvenly
                        ) {

                            Box(modifier = Modifier.weight(2f), contentAlignment = Alignment.Center) {
                                Text(text = item.nameDevice, fontSize = fonsize)
                            }
                            Box(modifier = Modifier.weight(1.5f), contentAlignment = Alignment.Center) {
                                Text(text = item.status, fontSize = fonsize)
                            }
                            Box(modifier = Modifier.weight(1.5f), contentAlignment = Alignment.Center) {
                                Text(text = item.time, fontSize = fonsize)
                            }

                        }
                    }
                    Log.i("maybetuandat", "index is $index")
                }
            }


        }

    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DropdownMenu( list: List<String>, itemnamedefault : String, selectedDropDownItem : (String) ->Unit)
{
    var isExpanded by remember { mutableStateOf(false) }
    var selectedItem by remember { mutableStateOf(itemnamedefault) }
    var rememberTextDropDownSelected by remember {
        mutableStateOf("")
    }
    ExposedDropdownMenuBox( expanded = isExpanded, onExpandedChange = {
        isExpanded = !isExpanded
    }) {
        TextField(modifier = Modifier
            .menuAnchor()
            .fillMaxWidth(),
            value = selectedItem,
            onValueChange = {},
            readOnly = true,
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.White, // màu  o ben trong cua text field khi được focus (giong nhu background)
                unfocusedContainerColor = Color.White, // giong o tren nhung la khong duoc focus
                focusedIndicatorColor = Color.White,  // vung ben ngoai chua text field
                unfocusedIndicatorColor = Color.White
            ),
            trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = isExpanded) },
            textStyle = TextStyle(fontWeight = FontWeight.Bold)
            )

        ExposedDropdownMenu(modifier = Modifier.background(Color.White), expanded = isExpanded, onDismissRequest = { isExpanded = false }) {
            list.forEachIndexed { index, text ->
                DropdownMenuItem(
//                    text = {
//                    Text(
//                        text = text, color = Color.Black  // Màu chữ của item
//                    )
//                },
//
//                    onClick = {
//                        selectedItem = itemnamedefault
//                        isExpanded = false
//                        selectedDropDownItem(text)
//                    }
                    text = {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                text = text,
                                color = Color.Black  // Màu chữ của item
                            )
                            // Hiển thị tick nếu mục này là mục đã chọn
                            if (rememberTextDropDownSelected == text) {
                                Icon(
                                    imageVector = Icons.Default.Check, // Icon tick mặc định
                                    contentDescription = "Selected",
                                    tint = Color.Black // Màu của dấu tick
                                )
                            }
                        }
                    },
                    onClick = {
                        selectedItem = itemnamedefault // Cập nhật mục đã chọn
                        isExpanded = false
                        rememberTextDropDownSelected = text
                        selectedDropDownItem(text) // Gọi hàm xử lý khi chọn item
                    }

                )
            }
        }
    }
}
@OptIn(ExperimentalLayoutApi::class)
@Composable
fun DeviceList() {
    Box(
        modifier = Modifier
            .fillMaxSize()
    )
    {
        FlowRow(modifier = Modifier.padding(10.dp), maxItemsInEachRow = 2) {
            val listDevice = listOf(
                ItemDevices(

                    icon = painterResource(id = R.drawable.icon_fan_device),
                    label = "Fan"
                ),
                ItemDevices(

                    icon = painterResource(id = R.drawable.icon_light_device),
                    label = "Light"
                ),
                ItemDevices(
                    icon = painterResource(id = R.drawable.aircondition_icon),
                    label = "Air Conditioner"
                )
            )
            listDevice.forEachIndexed { index, item ->
                if (index == 2)
                    DeviceElements(
                        modifier = Modifier
                            .padding(horizontal = 10.dp)
                            .padding(bottom = 20.dp)
                            .weight(1f)
                            .fillMaxHeight(0.5f), item
                    )
                else
                    DeviceElements(
                        modifier = Modifier
                            .padding(10.dp)
                            .weight(1f)
                            .fillMaxHeight(0.5f), item
                    )
            }

        }
    }

}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun DeviceElements(modifier: Modifier = Modifier, itemCard: ItemDevices) {
    val isChecked = remember { mutableStateOf(false) }
    val iconColor = if (isChecked.value) iconselectedcolor else iconunselectedcolor
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
            )
            {
                Icon(
                    painter = itemCard.icon, contentDescription = itemCard.label,
                    tint = iconColor
                )
            }
            Box(
                modifier = Modifier
                    .fillMaxHeight(0.7f)
                    .weight(1f),
                contentAlignment = Alignment.Center
            )
            {
                Switch(colors = SwitchDefaults.colors(
                    checkedTrackColor = iconselectedcolor,
                    uncheckedThumbColor = Color.Gray,
                    uncheckedTrackColor = Color.Gray.copy(alpha = 0.5f)
                ),checked = isChecked.value, onCheckedChange = { newValue ->
                    isChecked.value = newValue
                })
            }
            Box(
                modifier = Modifier
                    .fillMaxHeight(0.3f)
                    .weight(1f),
                contentAlignment = Alignment.TopCenter
            )
            {
                Text(text = itemCard.label,
                    fontSize = 30.sp)
            }
        }
    }
}
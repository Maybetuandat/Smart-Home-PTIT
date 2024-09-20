package com.example.smarthomeptit.ui.page

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.smarthomeptit.R
import com.example.smarthomeptit.ui.theme.iconselectedcolor
import com.example.smarthomeptit.ui.theme.iconunselectedcolor

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
//if(timeDropDownItem == "Increase" || timeDropDownItem.isEmpty())
//{
//    historyDevices.sort()
//}
//else
//{
//    historyDevices.sortDescending()
//}
//// List items
//fun checkName(itemName : String, nameDropDownItem : String):Boolean
//{
//    if(nameDropDownItem.isEmpty()) return true
//    if(nameDropDownItem == "All") return true
//    if(itemName == nameDropDownItem) return true
//    return false
//}
//fun checkStatus(itemStatus : String, statusDropDownItem : String):Boolean
//{
//    if(statusDropDownItem.isEmpty())   return true
//    if(statusDropDownItem == "None") return true
//    if(itemStatus == statusDropDownItem) return true
//    return false
//}
//val filteredDevices = historyDevices.filter { item ->
//    checkName(item.nameDevice, deviceDropDownItem) && checkStatus(item.status, statusDropDownItem)
//}


//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun DropdownMenu(
//    list: List<String>,
//    itemnamedefault: String,
//    selectedDropDownItem: (String) -> Unit
//) {
//    var isExpanded by remember { mutableStateOf(false) }
//    var selectedItem by remember { mutableStateOf(itemnamedefault) }
//    var rememberTextDropDownSelected by remember {
//        mutableStateOf("")
//    }
//    ExposedDropdownMenuBox(expanded = isExpanded, onExpandedChange = {
//        isExpanded = !isExpanded
//    }) {
//        TextField(
//            modifier = Modifier
//                .menuAnchor()
//                .fillMaxWidth(),
//            value = selectedItem,
//            onValueChange = {},
//            readOnly = true,
//            colors = TextFieldDefaults.colors(
//                focusedContainerColor = Color.White, // màu  o ben trong cua text field khi được focus (giong nhu background)
//                unfocusedContainerColor = Color.White, // giong o tren nhung la khong duoc focus
//                focusedIndicatorColor = Color.White,  // vung ben ngoai chua text field
//                unfocusedIndicatorColor = Color.White
//            ),
//            trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = isExpanded) },
//            textStyle = TextStyle(fontWeight = FontWeight.Bold)
//        )
//
//        ExposedDropdownMenu(
//            modifier = Modifier.background(Color.White),
//            expanded = isExpanded,
//            onDismissRequest = { isExpanded = false }) {
//            list.forEachIndexed { index, text ->
//                DropdownMenuItem(
////                    text = {
////                    Text(
////                        text = text, color = Color.Black  // Màu chữ của item
////                    )
////                },
////
////                    onClick = {
////                        selectedItem = itemnamedefault
////                        isExpanded = false
////                        selectedDropDownItem(text)
////                    }
//                    text = {
//                        Row(
//                            modifier = Modifier.fillMaxWidth(),
//                            horizontalArrangement = Arrangement.SpaceBetween
//                        ) {
//                            Text(
//                                text = text,
//                                color = Color.Black  // Màu chữ của item
//                            )
//                            // Hiển thị tick nếu mục này là mục đã chọn
//                            if (rememberTextDropDownSelected == text) {
//                                Icon(
//                                    imageVector = Icons.Default.Check, // Icon tick mặc định
//                                    contentDescription = "Selected",
//                                    tint = Color.Black // Màu của dấu tick
//                                )
//                            }
//                        }
//                    },
//                    onClick = {
//                        selectedItem = itemnamedefault // Cập nhật mục đã chọn
//                        isExpanded = false
//                        rememberTextDropDownSelected = text
//                        selectedDropDownItem(text) // Gọi hàm xử lý khi chọn item
//                    }
//
//                )
//            }
//        }
//    }
//}
//
//@OptIn(ExperimentalLayoutApi::class)
//@Composable
//fun DeviceList() {
//    Box(modifier = Modifier.fillMaxSize())
//    {
//        FlowRow(modifier = Modifier.padding(10.dp), maxItemsInEachRow = 2) {
//            val listDevice = listOf(
//                ItemDevices(
//
//                    icon = painterResource(id = R.drawable.icon_fan_device),
//                    label = "Fan"
//                ),
//                ItemDevices(
//                    icon = painterResource(id = R.drawable.icon_light_device),
//                    label = "Light"
//                ),
//                ItemDevices(
//                    icon = painterResource(id = R.drawable.aircondition_icon),
//                    label = "Air Conditioner"
//                )
//            )
//            listDevice.forEachIndexed { index, item ->
//                if (index == 2)
//                    DeviceElements(
//                        modifier = Modifier
//                            .padding(horizontal = 10.dp)
//                            .padding(bottom = 20.dp)
//                            .weight(1f)
//                            .fillMaxHeight(0.5f), item
//                    )
//                else
//                    DeviceElements(
//                        modifier = Modifier
//                            .padding(10.dp)
//                            .weight(1f)
//                            .fillMaxHeight(0.5f), item
//                    )
//            }
//
//        }
//    }
//
//}
//
//@OptIn(ExperimentalLayoutApi::class)
//@Composable
//fun DeviceElements(modifier: Modifier = Modifier, itemCard: ItemDevices) {
//    var isChecked = remember { mutableStateOf(false) }
//    val iconColor = if (isChecked.value) iconselectedcolor else iconunselectedcolor
//    Card(
//        modifier = modifier,
//
//        shape = RoundedCornerShape(16.dp), // Hình dạng bo tròn của box
//        colors = CardDefaults.cardColors(containerColor = Color.White),
//        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
//    ) {
//        FlowRow(maxItemsInEachRow = 2) {
//            Box(
//                modifier = Modifier
//                    .fillMaxHeight(0.7f)
//                    .weight(1.5f),
//                contentAlignment = Alignment.Center
//            )
//            {
//                Icon(
//                    painter = itemCard.icon, contentDescription = itemCard.label,
//                    tint = iconColor
//                )
//            }
//            Box(
//                modifier = Modifier
//                    .fillMaxHeight(0.7f)
//                    .weight(1f),
//                contentAlignment = Alignment.Center
//            )
//            {
//                Switch(colors = SwitchDefaults.colors(
//                    checkedTrackColor = iconselectedcolor,
//                    uncheckedThumbColor = Color.Gray,
//                    uncheckedTrackColor = Color.Gray.copy(alpha = 0.5f)
//                ), checked = isChecked.value, onCheckedChange = { newValue ->
//                    isChecked.value = newValue
//                })
//            }
//            Box(
//                modifier = Modifier
//                    .fillMaxHeight(0.3f)
//                    .weight(1f),
//                contentAlignment = Alignment.TopCenter
//            )
//            {
//                Text(
//                    text = itemCard.label,
//                    fontSize = 30.sp
//                )
//            }
//        }
//    }
//}

//                    Box(modifier = Modifier
//                        .weight(1f)
//                        .fillMaxHeight()
//
//                    )
//                    {
//
//                              Box(modifier  = Modifier.fillMaxSize().padding(10.dp), contentAlignment = Alignment.Center )
//                              {
//                                  Icon(modifier = Modifier, painter = painterResource(id = R.drawable.icon_filter), contentDescription = null, tint = Color.Black,
//                                  )
//                              }
//
//
//                    }


//item {
//    Row(modifier = Modifier
//        .fillMaxWidth()
//        .height(50.dp)
//    )
//    {
////                    Box(modifier = Modifier
////                        .weight(1f)
////                        .fillMaxHeight()
////
////                    )
////                    {
////
////                              Box(modifier  = Modifier.fillMaxSize().padding(10.dp), contentAlignment = Alignment.Center )
////                              {
////                                  Icon(modifier = Modifier, painter = painterResource(id = R.drawable.icon_filter), contentDescription = null, tint = Color.Black,
////                                  )
////                              }
////
////
////                    }
//        Box(modifier = Modifier
//            .weight(1f)
//            .fillMaxHeight())
//        {
//            //   val listSortItem = listOf("Increase", "DeCrease")
////                        DropdownMenu(listSortItem, "Sort", selectedDropDownItem = { selectSort = it })
//        }
//        Box(modifier = Modifier
//            .weight(1f)
//            .fillMaxHeight())
//        {
//            // item chua dropdown cua cac loai thong so nhu temperature, humidity, light
//            //   val listDataSensort = listOf("Temperature", "Humidity", "Light", "Time")
////                        DropdownMenu(listDataSensort, "Sensor", selectedDropDownItem = { selectSensor = it })
//        }
//
//    }
//
//}

//@OptIn(ExperimentalLayoutApi::class)
//@Composable
//fun CardElements(modifier: Modifier = Modifier, itemCard: ItemCard) {
//    Card(
//        modifier = modifier,
//        shape = RoundedCornerShape(16.dp), // Hình dạng bo tròn của box
//        colors = CardDefaults.cardColors(containerColor = Color.White),
//        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
//    ) {
//        FlowRow(maxItemsInEachRow = 2) {
//            Box(
//                modifier = Modifier
//                    .fillMaxHeight(0.7f)
//                    .weight(1.5f),
//                contentAlignment = Alignment.Center
//            ) {
//                // box nay chua so lieu
//                Text(
//                    text = itemCard.data, fontSize = 40.sp, color = Black
//                )
//            }
//            Box(
//                modifier = Modifier
//                    .fillMaxHeight(0.7f)
//                    .weight(1f),
//                contentAlignment = Alignment.Center
//            ) {
//                Icon(
//                    painter = itemCard.icon,
//                    contentDescription = itemCard.label,
//                    tint = iconselectedcolor
//                )
//            }
//            Box(
//                modifier = Modifier
//                    .fillMaxHeight(0.3f)
//                    .weight(1f),
//                contentAlignment = Alignment.TopCenter
//            ) {
//                Text(
//                    text = itemCard.label, fontSize = 20.sp, color = iconunselectedcolor
//                )
//            }
//        }
//    }
//}

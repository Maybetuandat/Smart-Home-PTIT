package com.example.smarthomeptit.ui.page

import android.util.Log
import android.widget.Toast
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
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.ProgressIndicatorDefaults
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
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.smarthomeptit.R
import com.example.smarthomeptit.ui.theme.BackgroundColor
import com.example.smarthomeptit.ui.theme.White
import com.example.smarthomeptit.ui.theme.iconunselectedcolor
import com.example.smarthomeptit.viewModel.DeviePageViewModel
import formatDateToString

@OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterialApi::class)
@Composable
fun DevicePage() {

    var showBottomSelectedSearch by remember {
        mutableStateOf(false)
    }


    val viewModel = viewModel<DeviePageViewModel>()
    viewModel.state.focusManager = LocalFocusManager.current
    val focusRequester = remember {
        FocusRequester()
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

            var onSearchOptionSelected: (Boolean) -> Unit = { isSelected ->
                // Xử lý khi tùy chọn được chọn
                showBottomSelectedSearch = isSelected
            }


            FilterDevice(
                showBottomSelectedSearch = onSearchOptionSelected,
                focusRequester = focusRequester,
                focusManager = viewModel.state.focusManager!!,
                viewModel


            )
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(10f)
                .padding(top = 15.dp)
        ) {
            TableHistoryDevice(viewModel)   // bảng thể hiện giá trị
        }
        if (showBottomSelectedSearch) {
            val typeOfSearchOptionsDevicePage = listOf(
                "Device", "Status", "Time"

            )

            BottomSheetSearch(
                onDismissRequest = { showBottomSelectedSearch = false },
                sheetState = sheetState,
                typeOfSearchOptions = typeOfSearchOptionsDevicePage,
                viewModel = viewModel
            )
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomSheetSearch(
    sheetState: SheetState,
    onDismissRequest: () -> Unit,
    typeOfSearchOptions: List<String>,
    viewModel: DeviePageViewModel
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

                    TypeOfSearchItem(
                        option = option,
                        onClick = {
                            viewModel.state.typeSearch = option
                            onDismissRequest()
                        },
                        viewModel
                    )
                }
            }
        }
    }
}

@Composable
fun TypeOfSearchItem(
    option: String,
    onClick: () -> Unit,
    viewModel: DeviePageViewModel,



) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)

            .clickable {
                onClick()
                viewModel.updateFetchHistoryDevice()

            }
    ) {
        Spacer(modifier = Modifier.height(20.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(3f)
            )
            {
                Text(
                    text = option,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 20.dp),
                    fontSize = 18.sp
                )
            }

            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(1f)
            )
            {
                if (viewModel.state.typeSearch == option) {
                    Icon(
                        imageVector = Icons.Default.Check,
                        contentDescription = "Selected",
                        tint = Color.Black
                    )
                }
            }


        }

        Divider(
            color = Color.LightGray.copy(alpha = 0.5f),
            thickness = 1.dp,
            modifier = Modifier
                .padding(horizontal = 20.dp)
                .height(1.dp)
        )
    }
}


@Composable
fun TableHistoryDevice(
    viewModel: DeviePageViewModel
) {

    var historyDevices = viewModel.state.historyDevice
   // Log.d("DevicePage", historyDevices.toString() + "view")
    var state = viewModel.state
    val fonsize = 15.sp
    Card(
        modifier = Modifier
            .padding(horizontal = 20.dp)
            .padding(bottom = 20.dp),
        shape = RoundedCornerShape(16.dp), // Hình dạng bo tròn của box
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)

    ) {

        LazyColumn(
            modifier = Modifier
                .padding(vertical = 20.dp)
                .padding(end = 10.dp)
        ) {

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
                    Box(modifier = Modifier.weight(0.5f), contentAlignment = Alignment.Center) {
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
            if (historyDevices.isEmpty()) {
                item {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(top = 40.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(text = "No data")
                    }
                }
            } else {
                itemsIndexed(historyDevices) { index, item ->
                    if (index >= state.historyDevice.size - 1 && !state.endReach && !state.isLoading) {
                        state.pagination.current_page += 1
                        viewModel.fetchHistoryDevice()
                    }
                    Row(
                        modifier = Modifier.padding(vertical = 10.dp),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        Box(modifier = Modifier.weight(0.5f), contentAlignment = Alignment.Center) {
                            Text(text = item.Id.toString(), fontSize = fonsize)
                        }
                        Box(modifier = Modifier.weight(1f), contentAlignment = Alignment.Center) {
                            Text(text = item.Device, fontSize = fonsize)
                        }
                        Box(modifier = Modifier.weight(0.5f), contentAlignment = Alignment.Center) {
                            Text(text = item.Status, fontSize = fonsize)
                        }
                        Box(modifier = Modifier.weight(1f), contentAlignment = Alignment.Center) {
                            Text(text = formatDateToString(item.Time), fontSize = fonsize)
                        }

                    }
                    Divider(
                        color = Color.LightGray.copy(alpha = 0.5f),
                        thickness = 1.dp
                    )
                }
                if (state.isLoading == true) {
                    item()
                    {
                        Row(
                            Modifier
                                .fillMaxWidth()
                                .padding(8.dp),
                            horizontalArrangement = Arrangement.Center,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            CircularProgressIndicator(color = ProgressIndicatorDefaults.circularColor)
                        }
                        if (!state.error.isNullOrEmpty()) {
                            Toast.makeText(LocalContext.current, state.error, Toast.LENGTH_SHORT)
                                .show()
                        }
                    }
                }


            }

        }
    }
}

@Composable
fun FilterDevice(
    showBottomSelectedSearch: (Boolean) -> Unit,
    focusRequester: FocusRequester,
    focusManager: FocusManager,
    viewModel: DeviePageViewModel

) {
    var hint: String
    if (viewModel.state.typeSearch == "Time") {
        hint = "ex : 2024-09-18 12:00:00"
    } else if (viewModel.state.typeSearch == "Device") {
        hint = "ex :  Fan "
    } else {
        hint = "ex : On"
    }
    Column(modifier = Modifier.fillMaxSize()) {
        Row(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
                .padding(vertical = 5.dp)


        )
        {
            Box(
                modifier = Modifier
                    .weight(7f)
                    .fillMaxHeight()
            )
            {
                SearchBarDevice(
                    hint = hint,
                    focusRequester,
                    focusManager,
                    viewModel


                ) // them
            }

            Card(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(1f)
                    .padding(start = 6.dp),
                shape = RoundedCornerShape(4.dp),
                colors = CardDefaults.cardColors(Color.White)
            )
            {
                Icon(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(5.dp)
                        .clickable {
                            showBottomSelectedSearch(true)
                        },
                    painter = painterResource(id = R.drawable.icon_filter),
                    contentDescription = "icon filter",
                    tint = iconunselectedcolor
                )
            }


        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .background(White)


        ) {
            Card(
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(1f)
                    .padding(5.dp),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(BackgroundColor),


                )
            {
                // chua icon
                Icon(
                    painter = painterResource(id = R.drawable.icon_sort),
                    contentDescription = null,
                    tint = iconunselectedcolor,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(13.dp)
                        .clickable { viewModel.updateFetchHistoryDevice() }
                )
            }

            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(3f)

                //options sort
            )
            {
                val listOfSortOptions = mutableListOf("Increase", "Decrease")
                DropDownOption(listOfSortOptions, "Sort", viewModel)
            }
            Box(
                modifier = Modifier
                    .weight(3f)
                    .padding(horizontal = 10.dp)
            )
            {
                val listOfTypeSortOptions = mutableListOf("Time")
                DropDownOption(listOfTypeSortOptions, "Type", viewModel)
            }


//            Spacer(modifier = Modifier.weight(4f))

        }
    }
}

@Composable
fun SearchBarDevice(
    hint: String,
    focusRequester: FocusRequester,
    focusManager: FocusManager,
    viewModel: DeviePageViewModel,
    isEnabled: (Boolean) = true,
    elevation: Dp = 3.dp,
    cornerShape: RoundedCornerShape = RoundedCornerShape(8.dp),
    backgroundColor: Color = Color.White,
) {


    var valueText by remember {
        mutableStateOf(TextFieldValue(""))
    }
    Row(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .shadow(elevation = elevation, shape = cornerShape)
            .background(color = backgroundColor, shape = cornerShape)
            .clickable { },
        verticalAlignment = Alignment.CenterVertically,
    ) {
        BasicTextField(
            modifier = Modifier
                .focusRequester(focusRequester)
                .weight(5f)
                .fillMaxWidth()
                .padding(horizontal = 24.dp),
            value = valueText,
            onValueChange = {
                valueText = it
                viewModel.state.valueSearch = it.text
            },
            enabled = isEnabled,
            textStyle = TextStyle(
                color = Color.Black,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            ),
            decorationBox = { innerTextField ->
                if (valueText.text.isEmpty()) {
                    Text(
                        text = hint,
                        color = Color.Gray.copy(alpha = 0.5f),
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                    )
                }
                innerTextField()
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Search
            ),
            keyboardActions = KeyboardActions(onSearch = {
                viewModel.updateFetchHistoryDevice()
                focusManager.clearFocus()
            }), // thuc hien gi do khi nhap xong
            singleLine = true
        )
        // box nay de hient thi icon search va khi co text thi xoa cac text trong basic textfield
        Box(
            modifier = Modifier
                .weight(1f)
                .size(40.dp)
                .background(color = Color.Transparent, shape = CircleShape)
                .clickable {
                    if (valueText.text.isNotEmpty()) {


                        viewModel.state.valueSearch = ""
                        valueText = TextFieldValue("")
                        viewModel.updateFetchHistoryDevice()

                    }
                },
        ) {
            if (valueText.text.isNotEmpty()) {
                Icon(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(10.dp),
                    painter = painterResource(id = R.drawable.baseline_clear_24),
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.primary,
                )
            } else {
                Icon(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(10.dp),
                    painter = painterResource(id = R.drawable.ic_search),
                    contentDescription = null,
                    tint = iconunselectedcolor,
                )
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DropDownOption(
    listOptions: List<String>,
    initialDropDownType: String,
    viewModel: DeviePageViewModel


) {

    var selectedText by remember {
        mutableStateOf(initialDropDownType)
    }
    var isExpanded by remember {
        mutableStateOf(false)
    }
    Column(
        modifier = Modifier
            .fillMaxSize()

            .padding(vertical = 5.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        ExposedDropdownMenuBox(expanded = isExpanded, onExpandedChange = {
            isExpanded = !isExpanded
        }) {
            BasicTextField(modifier = Modifier
                .menuAnchor()
                .fillMaxSize()

                .background(
                    color = Color.Transparent,
                    // Màu nền của BasicTextField
                    shape = RoundedCornerShape(40.dp)  // Bo góc cho BasicTextField
                )
                .border(
                    1.dp,
                    iconunselectedcolor,
                    RoundedCornerShape(16.dp)
                ),  // Padding bên trong
                value = selectedText,
                onValueChange = {},
                readOnly = true,
                decorationBox = { innerTextField ->  // Hộp chứa trang trí cho BasicTextField
                    Row(
                        Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
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
                modifier = Modifier.background(
                    White
                )
            ) {
                listOptions.forEachIndexed { index, text ->
                    DropdownMenuItem(
                        text = {
                            Text(
                                text = text, color = Color.Black  // Màu chữ của item
                            )
                        },
                        onClick = {
                            selectedText = listOptions[index]
                            if (initialDropDownType == "Sort")
                                viewModel.state.sort = listOptions[index]
                            else
                                viewModel.state.typeSort = listOptions[index]
                            isExpanded = false
                            viewModel.updateFetchHistoryDevice()

                        },
                        modifier = Modifier
                            .background(White)  // Nền của DropdownMenuItem

                    )
                }
            }
        }

    }
}


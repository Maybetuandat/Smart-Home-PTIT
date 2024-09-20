package com.example.smarthomeptit.ui.page

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
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
import com.example.smarthomeptit.ui.theme.BackgroundColor
import com.example.smarthomeptit.ui.theme.White
import com.example.smarthomeptit.ui.theme.iconunselectedcolor

@Composable
fun FilterDevice(showBottomSelectedSearch: (Boolean) -> Unit,
                 listOfTypeSortOptions : List<String>
                 ) {

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
                SearchBarDevice(hint = "Type to search") // them
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
                    .weight(1f),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(White),


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
                DropDownOption(listOfSortOptions, "Sort")
            }
            Box(modifier = Modifier.weight(3f).padding(horizontal = 10.dp))
            {
                DropDownOption(listOfTypeSortOptions, "Type")
            }


//            Spacer(modifier = Modifier.weight(4f))

        }
    }
}

@Composable
fun SearchBarDevice(
    hint: String,
    modifier: Modifier = Modifier,
    isEnabled: (Boolean) = true,
    elevation: Dp = 3.dp,
    cornerShape: RoundedCornerShape = RoundedCornerShape(8.dp),
    backgroundColor: Color = Color.White,
    onSearchClicked: () -> Unit = {},
    onTextChange: (Any) -> Unit = {},

    ) {
    var text by remember { mutableStateOf(TextFieldValue()) }

    Row(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .shadow(elevation = elevation, shape = cornerShape)
            .background(color = backgroundColor, shape = cornerShape)
            .clickable { onSearchClicked() },
        verticalAlignment = Alignment.CenterVertically,
    ) {
        BasicTextField(
            modifier = modifier
                .weight(5f)
                .fillMaxWidth()
                .padding(horizontal = 24.dp),
            value = text,
            onValueChange = {
                text = it
                onTextChange(it.text)
            },
            enabled = isEnabled,
            textStyle = TextStyle(
                color = Color.Black,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            ),
            decorationBox = { innerTextField ->
                if (text.text.isEmpty()) {
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
            keyboardActions = KeyboardActions(onSearch = { onSearchClicked() }), // thuc hien gi do khi nhap xong
            singleLine = true
        )
        // box nay de hient thi icon search va khi co text thi xoa cac text trong basic textfield
        Box(
            modifier = modifier
                .weight(1f)
                .size(40.dp)
                .background(color = Color.Transparent, shape = CircleShape)
                .clickable {
                    if (text.text.isNotEmpty()) {
                        text = TextFieldValue(text = "")
                        onTextChange("")
                    }
                },
        ) {
            if (text.text.isNotEmpty()) {
                Icon(
                    modifier = modifier
                        .fillMaxSize()
                        .padding(10.dp),
                    painter = painterResource(id = R.drawable.baseline_clear_24),
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.primary,
                )
            } else {
                Icon(
                    modifier = modifier
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
fun DropDownOption(listOptions : List<String>, initialDropDownType : String) {

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

            ExposedDropdownMenu(expanded = isExpanded, onDismissRequest = { isExpanded = false }, modifier = Modifier.background(
                White)) {
                listOptions.forEachIndexed { index, text ->
                    DropdownMenuItem(
                        text = {
                            Text(
                                text = text, color = Color.Black  // Màu chữ của item
                            )
                        },
                        onClick = {
                            selectedText = listOptions[index]
                            isExpanded = false

                        },
                        modifier = Modifier
                            .background(White)  // Nền của DropdownMenuItem

                    )
                }
            }
        }

    }
}


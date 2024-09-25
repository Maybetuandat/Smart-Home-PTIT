package com.example.smarthomeptit.ui.page


import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.smarthomeptit.R
import com.example.smarthomeptit.ui.theme.BackgroundColor
import com.example.smarthomeptit.ui.theme.Black
import com.example.smarthomeptit.ui.theme.iconunselectedcolor
import com.example.smarthomeptit.utils.RetrofitInstance

@Composable
fun ProfilePage() {

    Column(modifier = Modifier.background(BackgroundColor)) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .padding(bottom = 10.dp)
                .background(Color.White)
        )
        {
            describle()
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .background(Color.White)
        )
        {
            AboutCode()
        }
    }

}

@Composable
fun describle() {
    val context: Context = LocalContext.current
    Card(
        modifier = Modifier
            .fillMaxSize(),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    )
    {
        Column(modifier = Modifier.fillMaxSize()) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(3f), horizontalArrangement = Arrangement.Start
            )
            {
                Box(
                    modifier = Modifier
                        .fillMaxHeight()
                        .weight(1f)
                        .padding(start = 20.dp)
                        .padding(top = 20.dp)
                )
                {
                    Image(
                        painter = painterResource(id = R.drawable.image_profile), // Thay thế bằng ảnh của bạn
                        contentDescription = "Circular Image",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(120.dp)
                            .clip(CircleShape)
                    )
                }
                Box(
                    modifier = Modifier
                        .fillMaxHeight()
                        .weight(2f), contentAlignment = Alignment.Center
                )
                {
                    Text(
                        text = "Trịnh Vinh Tuấn Đạt",
                        color = Black,
                        modifier = Modifier.padding(top = 20.dp),
                        textAlign = TextAlign.Center,
                        fontSize = 30.sp
                    )
                }

            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(4f)
            )
            {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                        .padding(start = 20.dp)
                )
                {
                    Row(
                        modifier = Modifier.fillMaxSize(),
                        horizontalArrangement = Arrangement.Start,
                        verticalAlignment = Alignment.CenterVertically
                    )
                    {
                        Icon(
                            painter = painterResource(id = R.drawable.icon_student_card),
                            contentDescription = "student card",
                            modifier = Modifier
                                .size(50.dp)
                                .padding(end = 20.dp),
                            tint = Black
                        )
                        Text(text = "B21DCCN031", fontSize = 20.sp)
                    }

                }
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                        .padding(start = 20.dp)
                )
                {
                    Row(
                        modifier = Modifier.fillMaxSize(),
                        horizontalArrangement = Arrangement.Start,
                        verticalAlignment = Alignment.CenterVertically
                    )
                    {
                        Icon(
                            painter = painterResource(id = R.drawable.icon_class),
                            contentDescription = "student card",
                            modifier = Modifier
                                .size(50.dp)
                                .padding(end = 20.dp),
                            tint = Black
                        )
                        Text(text = "D21CQCN07-B", fontSize = 20.sp)
                    }

                }
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                        .padding(start = 20.dp)
                )
                {
                    Row(
                        modifier = Modifier.fillMaxSize(),
                        horizontalArrangement = Arrangement.Start,
                        verticalAlignment = Alignment.CenterVertically
                    )
                    {
                        Icon(
                            painter = painterResource(id = R.drawable.icon_pdf),
                            contentDescription = "student card",
                            modifier = Modifier
                                .size(50.dp)
                                .padding(end = 20.dp),
                            tint = Black
                        )
                        Text(text = "Báo cáo", fontSize = 20.sp, modifier = Modifier.clickable {
                            val intent = Intent(
                                Intent.ACTION_VIEW,
                                Uri.parse(context.getString(R.string.bao_cao_pdf))
                            )
                            context.startActivity(intent)
                        })
                    }

                }
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                        .padding(start = 20.dp)
                )
                {
                    Row(
                        modifier = Modifier.fillMaxSize(),
                        horizontalArrangement = Arrangement.Start,
                        verticalAlignment = Alignment.CenterVertically
                    )
                    {
                        Icon(
                            painter = painterResource(id = R.drawable.icon_git),
                            contentDescription = "source code",
                            modifier = Modifier
                                .size(50.dp)
                                .padding(end = 20.dp),
                            tint = Black
                        )

                        Text(text = "Smart Home", fontSize = 20.sp, modifier = Modifier.clickable {
                            val intent = Intent(
                                Intent.ACTION_VIEW,
                                Uri.parse(context.getString(R.string.source_code))
                            )
                            context.startActivity(intent)
                        })
                    }

                }
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                        .padding(start = 20.dp)
                )
                {
                    Row(
                        modifier = Modifier.fillMaxSize(),
                        horizontalArrangement = Arrangement.Start,
                        verticalAlignment = Alignment.CenterVertically
                    )
                    {
                        Icon(
                            painter = painterResource(id = R.drawable.icon_api),
                            contentDescription = "student card",
                            modifier = Modifier
                                .size(50.dp)
                                .padding(end = 20.dp),
                            tint = Black
                        )
                        Text(text = "Api docs", fontSize = 20.sp, modifier = Modifier.clickable {  val intent = Intent(
                            Intent.ACTION_VIEW,
                            Uri.parse(RetrofitInstance.url + "/api-docs")
                        )
                            context.startActivity(intent) })
                    }

                }

            }
        }
    }

}

@Composable
fun AboutCode() {
    Card(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 10.dp)
            .padding(),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    )
    {


        Column(modifier = Modifier.fillMaxSize()) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(3f)
            )
            {
                Respository()
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
            )
            {
                DetailsCode(
                    painterResource(id = R.drawable.icon_git_repository),
                    "Repositories",
                    "14"
                )
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
            )
            {
                DetailsCode(painterResource(id = R.drawable.icon_organization), "Organization", "0")
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
            )
            {
                DetailsCode(painterResource(id = R.drawable.icon_start), "Starred", "0")
            }
        }
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun Respository() {
    Column(modifier = Modifier.fillMaxSize()) {
        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
        )
        {
            Row(modifier = Modifier.fillMaxSize(), horizontalArrangement = Arrangement.Start) {
                Icon(
                    modifier = Modifier.padding(horizontal = 20.dp, vertical = 5.dp),
                    painter = painterResource(id = R.drawable.icon_start),
                    contentDescription = null,
                    tint = Black
                )
                Text(
                    text = "Popular",
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(top = 15.dp, start = 5.dp)
                )
            }
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(4f)
        )
        {
            val listRepository = listOf(
                "Game Pong D21 ",
                "Vehicles Detection",
                "Smart Home",
                "Game 2D CLonely Home "
            )
            LazyRow(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(20.dp)
            ) {
                itemsIndexed(listRepository) { index, item ->
                    Box(
                        modifier = Modifier
                            .fillMaxHeight()
                            .width(300.dp)
                            .shadow(1.dp)

                            .padding(end = 40.dp),
                    )
                    {
                        FlowRow(maxItemsInEachRow = 2, modifier = Modifier.fillMaxSize())
                        {
                            Icon(
                                modifier = Modifier
                                    .padding(start = 20.dp, top = 20.dp)
                                    .width(30.dp)
                                    .height(30.dp),
                                painter = painterResource(id = R.drawable.icon_git),
                                contentDescription = null,
                                tint = iconunselectedcolor
                            )
                            Text(
                                text = "Maybetuandat",
                                textAlign = TextAlign.Center,
                                modifier = Modifier.padding(top = 30.dp, start = 10.dp),
                                color = Black
                            )
                            Text(
                                text = item,
                                textAlign = TextAlign.Center,
                                modifier = Modifier.padding(top = 20.dp, start = 40.dp),
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                    // dung de tach cac repository voi nhau
                    Box(
                        modifier = Modifier
                            .width(20.dp)
                            .fillMaxHeight()
                    )
                    {

                    }


                }
            }
        }
    }
}

@Composable
fun DetailsCode(icon: Painter, label: String, number: String) {
    Row(modifier = Modifier.fillMaxSize(), horizontalArrangement = Arrangement.Start) {
        Icon(
            painter = icon, contentDescription = null, modifier = Modifier
                .size(50.dp)
                .padding(start = 25.dp)
        )
        Text(text = label, modifier = Modifier.padding(top = 20.dp, start = 20.dp))
        Spacer(modifier = Modifier.weight(1f))
        Text(text = number, modifier = Modifier.padding(end = 40.dp, top = 25.dp))
    }
}

@Preview
@Composable
fun preview() {
    ProfilePage()
}
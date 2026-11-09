package com.ui.mobile.feature.product

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ui.mobile.R

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun ProductDetailsView() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {},
                navigationIcon = {
                    Icon(
                        Icons.AutoMirrored.Filled.KeyboardArrowLeft, contentDescription = null,
                        modifier = Modifier.size(24.dp)
                    )
                },

                )
        },
        bottomBar = {
            Box(


                contentAlignment = Alignment.Center, modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 12.dp, vertical = 12.dp)
                    .background(Color(0xff53B175), shape = RoundedCornerShape(19.dp))


            ) {
                Text("Add To Basket",
modifier= Modifier.padding(15.dp
                    ),
                    style = TextStyle(fontSize = 18.sp, color = Color.White,


                ))

            }
        }

    ) {

            innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {

            Image(painter = painterResource(R.drawable.banner), contentDescription = null)
            Spacer(modifier = Modifier.height(30.dp))
            ListItem(
                headlineContent = {
                    Text(
                        "Naturel Red Apple",
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold
                    )
                },
                trailingContent = {
                    Icon(
                        painter = painterResource(R.drawable.favourite),
                        contentDescription = null
                    )
                },
                supportingContent = {
                    Text("1Kg Price")
                }
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 25.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                ProductCounter()
                Text("$4.99", fontSize = 24.sp, fontWeight = FontWeight.Bold)
            }
            Spacer(modifier = Modifier.height(30.dp))
            HorizontalDivider(modifier = Modifier.padding(horizontal = 25.dp))
            ExpandableList()
            ListItemList(
                title = "Nutritions",
                component = {
                    Text(
                        "100gr",
                        modifier = Modifier
                            .background(
                                color = Color.Gray,
                                shape = RoundedCornerShape(12.dp)
                            )
                            .padding(5.dp)
                    )
                }
            )
            HorizontalDivider(modifier = Modifier.padding(horizontal = 25.dp, vertical = 12.dp))
            ListItemList(
                title = "Review",
                component = {
                    val icStar = R.drawable.star
                    Row {
                        repeat(5) {
                            Icon(
                                painter = painterResource(icStar),
                                contentDescription = null,
                                tint = Color(0xFFFFC107),
                            )
                        }
                    }
                }
            )

        }


    }
}

@Composable
fun ListItemList(
    title: String,
    component: @Composable (() -> Unit)? = null,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                horizontal = 20.dp
            ),

        verticalAlignment = Alignment.CenterVertically
    ) {


        Text(
            title,
            fontSize = 16.sp,
        )
        Spacer(modifier = Modifier.weight(1f))
        component?.invoke()

        Icon(Icons.AutoMirrored.Filled.KeyboardArrowRight, contentDescription = null)


    }
}

@Composable
fun ExpandableList() {
    var expanded by remember { mutableStateOf(false) }
    val iconArrow: ImageVector =
        if (expanded) Icons.Default.KeyboardArrowUp else Icons.Default.KeyboardArrowDown
    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 20.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text("Product Details", fontSize = 16.sp)
            Icon(iconArrow, contentDescription = null, modifier = Modifier.clickable {
                expanded = !expanded
            })
        }
        if (expanded) {
            Text(
                "Apples are nutritious. Apples may be good for weight loss. apples may be good for your heart. As part of a healtful and varied diet.",
                modifier = Modifier
                    .padding(horizontal = 25.dp),
            )
        }
    }
}

@Composable
fun ProductCounter() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(15.dp)
    ) {
        Text("-", fontSize = 24.sp)
        Text(
            "1",
            fontSize = 18.sp,
            modifier = Modifier

                .border(
                    width = 1.dp,
                    color = Color.Gray,
                    shape = RoundedCornerShape(12.dp)
                )
                .padding(12.dp),
        )
        Text("+", fontSize = 24.sp)
    }
}
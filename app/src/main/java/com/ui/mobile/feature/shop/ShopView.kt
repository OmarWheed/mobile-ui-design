package com.ui.mobile.feature.shop

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ui.mobile.R
import com.ui.mobile.feature.app_shell.AppShell


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ShopView() {
    Scaffold(
        bottomBar = { AppShell() },
        topBar = {
            CenterAlignedTopAppBar(

                title = {

                    Image(
                        painter = painterResource(R.drawable.carrot_logo),
                        contentDescription = null,
                        modifier = Modifier.size(32.dp)
                    )
                }
            )
        }
    ) { innerPadding ->


        Column(
            Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(innerPadding)
                .padding(horizontal = 12.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            AddressHeader()
            Spacer(modifier = Modifier.height(12.dp))
            SearchFiled()
            BannerSection()
            HeaderSectionTitle(
                title = "Exclusive Offer"
            )
            ProductListSection()
            HeaderSectionTitle(
                title = "Best Selling"
            )
            ProductListSection()
            HeaderSectionTitle(
                title = "Groceries"
            )
            GroceriesListSection()
            Spacer(modifier = Modifier.height(12.dp))
            ProductListSection()
        }


    }


}

@Composable
fun GroceriesCard() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .background(color = Color(0xffF8A44C), shape = RoundedCornerShape(18.dp))
            .padding(end = 86.dp, start = 15.dp, top = 15.dp, bottom = 15.dp)

    )
    {
        Image(
            painter = painterResource(R.drawable.pulses),
            contentDescription = null,
            modifier = Modifier.size(71.dp)
        )
        Spacer(modifier = Modifier.width(15.dp))
        Text("Pulses", fontSize = 20.sp)
    }
}

@Composable
fun ProductListSection() {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(horizontal = 8.dp)
    ) {
        items(10) { _ ->
            ProductCard()
        }
    }
}

@Composable
fun GroceriesListSection() {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(horizontal = 8.dp)
    ) {
        items(10) { _ ->
            GroceriesCard()
        }
    }
}


@Composable()
fun ProductCard() {
    Column(

        modifier = Modifier

            .height(250.dp)
            .width(174.dp)

            .border(
                width = 2.dp,
                color = Color(0xffE2E2E2),
                shape = RoundedCornerShape(12.dp)
            )
            .padding(12.dp)
    ) {
        //image
        Image(
            painter = painterResource(R.drawable.apples),
            contentDescription = null,
            modifier = Modifier
                .size(100.dp)
                .align(alignment = Alignment.CenterHorizontally)
        )
        Spacer(modifier = Modifier.height(20.dp))
        //title
        Text("Red Apple", fontSize = 24.sp, fontWeight = FontWeight.SemiBold)
        //subTitle
        Text("1Kg , Pricing", fontSize = 18.sp)

        Spacer(modifier = Modifier.height(20.dp))

        //price
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("/$ 4.93", fontSize = 20.sp, fontWeight = FontWeight.SemiBold)
            Box(


                modifier = Modifier
                    .size(45.dp)
                    .background(color = Color(0xff53B175), shape = RoundedCornerShape(8.dp)),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    Icons.Filled.Add, contentDescription = null,
                    tint = Color.White
                )
            }
        }

    }
}

@Composable
fun HeaderSectionTitle(
    title: String,
    seeAll: () -> Unit = {}
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(title, fontSize = 24.sp, fontWeight = FontWeight.SemiBold)
        Text("See all", color = Color(0xFF53B175), modifier = Modifier.clickable() {
            seeAll()
        })

    }
}

@Composable
fun BannerSection() {
    Image(

        painter = painterResource(R.drawable.banner), contentDescription = null,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 12.dp)
            .aspectRatio(16f / 9f)
            .border(
                width = 2.dp,
                color = Color.Transparent,
                shape = RoundedCornerShape(16.dp)
            )
            .clip(RoundedCornerShape(16.dp)),
        contentScale = ContentScale.Crop


    )
}

@Composable
fun SearchFiled() {
    var value by remember { mutableStateOf("") }

    TextField(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(15.dp),

        prefix = {
            Icon(
                painter = painterResource(R.drawable.search), contentDescription = null,
                modifier = Modifier.padding(end = 10.dp)
            )
        },
        placeholder = { Text("Search Store", fontSize = 14.sp) },
        value = value,
        colors = TextFieldDefaults.colors(
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent,
            errorIndicatorColor = Color.Transparent
        ),
        onValueChange = {
            value = it
        },

        )

}

@Composable
fun AddressHeader() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(Icons.Default.LocationOn, contentDescription = null, tint = Color(0xFF4C4F4D))
        Text(
            "Dhaka, Banassre",
            fontSize = 18.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color(0xFF4C4F4D)
        )
    }
}


@Preview
@Composable
fun ShopViewPreview() {
    ShopView()
}
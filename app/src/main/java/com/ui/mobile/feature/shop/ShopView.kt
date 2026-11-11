package com.ui.mobile.feature.shop

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBarDefaults
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
import com.ui.mobile.feature.product.ProductCard

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ShopView() {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(

                title = {
                    Image(
                        painter = painterResource(R.drawable.carrot_logo),
                        contentDescription = "Logo",
                        modifier = Modifier.size(32.dp)
                    )
                }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(innerPadding)
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            AddressHeader()
            SearchFiled(modifier = Modifier.fillMaxWidth())
            BannerSection()

            HeaderSectionTitle(title = "Exclusive Offer")
            ProductListSection()

            HeaderSectionTitle(title = "Best Selling")
            ProductListSection()

            HeaderSectionTitle(title = "Groceries")
            GroceriesListSection()

            Spacer(modifier = Modifier.height(12.dp))
            ProductListSection()

            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

@Composable
fun GroceriesCard(
    modifier: Modifier = Modifier,
    title: String = "Pulses",
    color: Color = Color(0xffF8A44C),
    imageRes: Int = R.drawable.pulses
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .background(color = color.copy(alpha = 0.15f), shape = RoundedCornerShape(18.dp))
            .padding(horizontal = 16.dp, vertical = 16.dp)
            .width(250.dp)
    ) {
        Image(
            painter = painterResource(imageRes),
            contentDescription = null,
            modifier = Modifier.size(70.dp)
        )
        Spacer(modifier = Modifier.width(15.dp))
        Text(
            text = title,
            fontSize = 20.sp,
            fontWeight = FontWeight.SemiBold,
            color = MaterialTheme.colorScheme.onSurface
        )
    }
}

@Composable
fun ProductListSection() {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        contentPadding = PaddingValues(bottom = 8.dp)
    ) {
        items(10) {
            ProductCard(modifier = Modifier.width(174.dp))
        }
    }
}

@Composable
fun GroceriesListSection() {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        contentPadding = PaddingValues(bottom = 8.dp)
    ) {
        item {
            GroceriesCard(
                color = Color(0xffF8A44C),
                title = "Pulses",
                imageRes = R.drawable.pulses
            )
        }
        item {
            GroceriesCard(
                color = Color(0xff53B175),
                title = "Rice",
                imageRes = R.drawable.fruits
            )
        }
        item {
            GroceriesCard(
                color = Color(0xffD3B0E0),
                title = "Dairy",
                imageRes = R.drawable.eges
            )
        }
    }
}

@Composable
fun HeaderSectionTitle(
    title: String,
    onSeeAllClick: () -> Unit = {}
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = title,
            fontSize = 24.sp,
            fontWeight = FontWeight.SemiBold,
            color = MaterialTheme.colorScheme.onSurface
        )
        Text(
            text = "See all",
            color = MaterialTheme.colorScheme.primary,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.clickable { onSeeAllClick() }
        )
    }
}

@Composable
fun BannerSection() {
    Image(
        painter = painterResource(R.drawable.banner),
        contentDescription = "Banner",
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(16f / 7f)
            .clip(RoundedCornerShape(12.dp)),
        contentScale = ContentScale.Crop
    )
}

@Composable
fun SearchFiled(modifier: Modifier = Modifier) {
    var value by remember { mutableStateOf("") }

    TextField(
        modifier = modifier,
        shape = RoundedCornerShape(15.dp),
        leadingIcon = {
            Icon(
                painter = painterResource(R.drawable.search),
                contentDescription = null,
                modifier = Modifier.size(18.dp)
            )
        },
        placeholder = { Text("Search Store", fontSize = 14.sp) },
        value = value,
        colors = TextFieldDefaults.colors(
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent,
            errorIndicatorColor = Color.Transparent,
            focusedContainerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.4f),
            unfocusedContainerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.4f)
        ),
        onValueChange = { value = it },
        singleLine = true
    )
}

@Composable
fun AddressHeader() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = Icons.Default.LocationOn,
            contentDescription = null,
            tint = MaterialTheme.colorScheme.onSurfaceVariant,
            modifier = Modifier.size(20.dp)
        )
        Spacer(modifier = Modifier.width(4.dp))
        Text(
            text = "Dhaka, Banasree",
            fontSize = 18.sp,
            fontWeight = FontWeight.SemiBold,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ShopViewPreview() {
    ShopView()
}

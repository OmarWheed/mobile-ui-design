package com.ui.mobile.feature.explore

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ui.mobile.R
import com.ui.mobile.feature.shop.SearchFiled

data class CategoryType(
    val title: String,
    val image: Int,
    val color: Color
)


val listOfCategoryType = listOf(
    CategoryType(
        title = "Frash Fruits & Vegetable",
        image = R.drawable.fruits,
        color = Color(0xFF53B175).copy(alpha = 0.7f)
    ),
    CategoryType(
        title = "Cooking Oil& Ghee",
        image = R.drawable.oil,
        color = Color(0xFFF8A44C).copy(alpha = 0.7f)
    ),
    CategoryType(
        title = "Meat & Fish",
        image = R.drawable.fish,
        color = Color(0xFFF7A593).copy(alpha = 0.7f)
    ),
    CategoryType(
        title = "Bakery & Snacks",
        image = R.drawable.backery,
        color = Color(0xFFD3B0E0).copy(alpha = 0.7f)
    ),
    CategoryType(
        title = "Dairy & Eggs",
        image = R.drawable.eges,
        color = Color(0xFFFDE598).copy(alpha = 0.7f)
    ),
    CategoryType(
        title = "Beverages",
        image = R.drawable.beverages,
        color = Color(0xFFB7DFF5).copy(alpha = 0.7f)
    )
)

@Composable
fun CategoryCard(
    title: String,
    image: Int,
    color: Color
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .background(color = color.copy(alpha = 0.2f), shape = RoundedCornerShape(12.dp))
            .border(
                color = color,
                shape = RoundedCornerShape(12.dp),
                width = 2.dp
            )
            .aspectRatio(0.9f)

    ) {
        Image(
            painter = painterResource(image), contentDescription = null,

            modifier = Modifier

                .padding(horizontal = 32.dp, vertical = 21.dp)
                .size(height = 74.dp, width = 111.dp)

        )
        Text(
            title, textAlign = TextAlign.Center,
            fontWeight = FontWeight.SemiBold,
            fontSize = 16.sp
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable()
fun ExploreView() {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("Find Products", fontWeight = FontWeight.Bold, fontSize = 18.sp) }
            )
        }
    ) { innerPadding ->


        LazyVerticalGrid(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            contentPadding = PaddingValues(16.dp),
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp),
            columns = GridCells.Adaptive(minSize = 115.dp),

            ) {

            item(
                span = { GridItemSpan(maxLineSpan) }
            ) {
                SearchFiled(

                )
            }

            items(listOfCategoryType.size) { item ->
                CategoryCard(
                    title = listOfCategoryType[item].title,
                    image = listOfCategoryType[item].image,
                    color = listOfCategoryType[item].color,
                )

            }

        }

    }
}
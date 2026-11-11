package com.ui.mobile.feature.explore

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
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
    CategoryType("Fresh Fruits & Vegetable", R.drawable.fruits, Color(0xFF53B175)),
    CategoryType("Cooking Oil & Ghee", R.drawable.oil, Color(0xFFF8A44C)),
    CategoryType("Meat & Fish", R.drawable.fish, Color(0xFFF7A593)),
    CategoryType("Bakery & Snacks", R.drawable.backery, Color(0xFFD3B0E0)),
    CategoryType("Dairy & Eggs", R.drawable.eges, Color(0xFFFDE598)),
    CategoryType("Beverages", R.drawable.beverages, Color(0xFFB7DFF5))
)

@Composable
fun CategoryCard(
    category: CategoryType,
    onClick: () -> Unit = {}
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .clip(RoundedCornerShape(18.dp))
            .background(color = category.color.copy(alpha = 0.1f))
            .border(
                color = category.color.copy(alpha = 0.7f),
                shape = RoundedCornerShape(18.dp),
                width = 1.dp
            )
            .clickable { onClick() }
            .aspectRatio(1f)
            .padding(16.dp)
    ) {
        Image(
            painter = painterResource(category.image),
            contentDescription = null,
            modifier = Modifier.size(80.dp)
        )
        Text(
            text = category.title,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
            fontSize = 15.sp,
            lineHeight = 20.sp,
            color = MaterialTheme.colorScheme.onSurface,
            modifier = Modifier.padding(top = 10.dp)
        )
    }
}

private fun Modifier.clip(shape: RoundedCornerShape): Modifier = this.then(Modifier.background(Color.Transparent, shape))

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun ExploreView() {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { 
                    Text(
                        text = "Find Products", 
                        fontWeight = FontWeight.Bold, 
                        fontSize = 20.sp
                    ) 
                }
            )
        }
    ) { innerPadding ->
        LazyVerticalGrid(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            contentPadding = PaddingValues(16.dp),
            horizontalArrangement = Arrangement.spacedBy(15.dp),
            verticalArrangement = Arrangement.spacedBy(15.dp),
            columns = GridCells.Fixed(2)
        ) {
            item(span = { GridItemSpan(maxLineSpan) }) {
                SearchFiled(modifier = Modifier.fillMaxWidth().padding(bottom = 8.dp))
            }

            items(listOfCategoryType.size) { index ->
                CategoryCard(category = listOfCategoryType[index])
            }
        }
    }
}

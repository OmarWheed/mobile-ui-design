package com.ui.mobile.feature.cart

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ui.mobile.R

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Preview
@Composable
fun CartView() {
    Scaffold(
        bottomBar = {
            Box(


                contentAlignment = Alignment.Center, modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 12.dp, vertical = 12.dp)
                    .background(Color(0xff53B175), shape = RoundedCornerShape(19.dp))


            ) {
                Text(
                    "Add All To Cart",
                    modifier = Modifier.padding(
                        15.dp
                    ),
                    style = TextStyle(
                        fontSize = 18.sp, color = Color.White,


                        )
                )

            }
        },
        topBar = { CenterAlignedTopAppBar(title = { Text("My Favourite") }) }
    ) { innerPadding ->
        LazyColumn(
            contentPadding = PaddingValues(12.dp),
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            items(10) {
                FavouriteItem()
                HorizontalDivider(
                    modifier = Modifier.padding(vertical = 16.dp),
                    thickness = 1.dp,
                    color = Color.LightGray
                )
            }
            item {

            }
        }
    }

}

@Preview
@Composable
fun FavouriteItem() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 80.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(R.drawable.fish),
            contentDescription = null,
            modifier = Modifier.size(80.dp)
            //  modifier = Modifier.aspectRatio()
        )
        Spacer(modifier = Modifier.width(37.dp))
        Column() {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween

            ) {
                Text("Bell Pepper Red", fontSize = 16.sp, fontWeight = FontWeight.Bold)
                Row (verticalAlignment = Alignment.CenterVertically){
                    Text("$412.1")

                    Icon(
                        Icons.Filled.KeyboardArrowRight,
                        contentDescription = null,
                    )
                }
            }
            Text("1kg, Price")

        }
    }
}


package com.ui.mobile.feature.product

import android.R.attr.contentDescription
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
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ui.mobile.R
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun ProductView(
    modifier: Modifier = Modifier
) {
    val sheetState = rememberModalBottomSheetState()
    val scope = rememberCoroutineScope()
    var showBottomSheet by remember { mutableStateOf(false) }
    Scaffold(

        topBar = {
            CenterAlignedTopAppBar(
                actions = {
                    IconButton(
                        onClick = {
                            //open fillter sheet
                            showBottomSheet = true
                        },
                        content = {
                            Icon(
                                Icons.Default.Search,
                                contentDescription = "filter ",
                            )
                        },
                    )
                },
                navigationIcon = {
                    IconButton(
                        onClick = {},
                        content = {
                            Icon(
                                Icons.AutoMirrored.Filled.KeyboardArrowLeft,
                                contentDescription = null,
                                modifier = Modifier.padding(6.dp)
                            )

                        }
                    )

                },
                title = {
                    Text("Product", fontSize = 20.sp, fontWeight = FontWeight.SemiBold)
                }

            )
        }
    ) { innerPadding ->

        LazyVerticalGrid(
            horizontalArrangement = Arrangement.spacedBy(5.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            contentPadding = PaddingValues(13.dp),
            columns = GridCells.Adaptive(minSize = 150.dp),
            modifier = Modifier.padding(innerPadding)
        ) {
            items(15) {
                ProductCard()
            }
        }

    }
    if (showBottomSheet) {
        ModalBottomSheet(
            onDismissRequest = {
                showBottomSheet = false
            },
            sheetState = sheetState
        ) {
            // Sheet content
            Button(onClick = {
                scope.launch { sheetState.hide() }.invokeOnCompletion {
                    if (!sheetState.isVisible) {
                        showBottomSheet = false
                    }
                }
            }) {
                Text("Hide bottom sheet")
            }
        }
    }
}

@Preview
@Composable
fun ProductCard() {
    Column(
        modifier = Modifier
            .border(
                width = 2.dp, color = Color(0xffE2E2E2), shape = RoundedCornerShape(
                    12.dp
                )
            )
            .padding(15.dp)
            .fillMaxWidth()
    ) {
        Image(
            painter = painterResource(R.drawable.cola),
            contentDescription = null,

            modifier = Modifier
                .align(alignment = Alignment.CenterHorizontally)
                .aspectRatio((90.44f / 48.82f))
        )
        Spacer(modifier = Modifier.height(19.dp))
        Text("Diet Coke", fontSize = 16.sp, fontWeight = FontWeight.SemiBold)
        Spacer(modifier = Modifier.height(5.dp))
        Text("355ml, Price", fontSize = 14.sp, color = Color(0xFF7C7C7C))
        Spacer(modifier = Modifier.height(36.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically

        ) {
            Text("$1.9", fontSize = 18.sp, fontWeight = FontWeight.SemiBold)
            Icon(
                Icons.Default.Add,
                contentDescription = null,
                tint = Color.White,
                modifier = Modifier
                    .background(Color(0xFF53B175), shape = RoundedCornerShape(18.dp))
                    .padding(14.dp)
            )
        }
    }
}
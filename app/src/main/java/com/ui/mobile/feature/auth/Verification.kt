
package com.ui.mobile.feature.auth
import android.widget.Space
import androidx.annotation.RestrictTo
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ui.mobile.R
import kotlinx.coroutines.launch
import java.time.temporal.TemporalAdjusters.next

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun VerificationView(modifier: Modifier){
    val pagerState = rememberPagerState(
        initialPage = 0,
        pageCount = { 2 }
    )
    Scaffold(
        topBar = {
            TopAppBar(
                title ={}
            ,
                navigationIcon = {
                    Icon(imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft, contentDescription = "back",
                        tint =Color.Black,
                        )
                }
            )
        },
        floatingActionButton = {

            Row (
                horizontalArrangement = Arrangement.SpaceBetween,

                verticalAlignment = Alignment.CenterVertically
                , modifier = Modifier.fillMaxWidth()
            ){
            if(pagerState.currentPage==1)Text("Resend Code", color = Color(0xFF53B175), modifier = Modifier.padding(start = 24.dp))
                FloatingActionButton(
                    onClick = {

                    },
                    containerColor = Color(0xFF53B175),

                    shape = CircleShape

                ) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                        contentDescription = "next",
                        tint = Color.White

                    )
                }

            }
        }

    ) { padding ->

        HorizontalPager (
            modifier = Modifier
                .fillMaxSize()
                .padding(padding),
            state = pagerState,
            userScrollEnabled = true

        ) {

            page ->
            when(page){
                0->VerificationStepView()
                1 -> CodeStepView()
            }

        }
    }
}





@Composable
fun VerificationStepView(

){
    Box(modifier = Modifier
        .fillMaxSize()
        .padding(horizontal = 25.dp, vertical = 15.dp))
    {
        Column (
            verticalArrangement = Arrangement.Top
        ){
            Text("Enter your mobile number", style = TextStyle(fontSize = 26.sp, fontWeight = FontWeight.SemiBold, color = Color.Black))
            Spacer(modifier=Modifier.height(27.dp))
            Text("Mobile Number", style = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.SemiBold, color = Color(0xFF7C7C7C)))
            Spacer(modifier=Modifier.height(10.dp))
            OutlinedTextField(

                prefix = {Image(painter= painterResource(R.drawable.flag), contentDescription = null, modifier = Modifier.size(24.dp))},
                modifier = Modifier.fillMaxWidth(),
                value = "+888",
                onValueChange = {

                },

                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number
                )
            )
        }
    }
}


@Composable
fun CodeStepView(

){
    Box(modifier = Modifier
        .fillMaxSize()
        .padding(horizontal = 25.dp, vertical = 15.dp))
    {
        Column (
            verticalArrangement = Arrangement.Top
        ){
            Text("Enter your 4-digit code", style = TextStyle(fontSize = 26.sp, fontWeight = FontWeight.SemiBold, color = Color.Black))
            Spacer(modifier=Modifier.height(27.dp))
            Text("Code", style = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.SemiBold, color = Color(0xFF7C7C7C)))
            Spacer(modifier=Modifier.height(10.dp))
            OutlinedTextField(


                modifier = Modifier.fillMaxWidth(),
                value = "",
                placeholder = {Text("---")},
                onValueChange = {

                },

                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number
                )
            )
        }
    }
}
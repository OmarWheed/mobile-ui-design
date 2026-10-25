package com.ui.mobile.feature.onboarding

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonElevation
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.BrushPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ui.mobile.R

@Composable

fun OnBoardingView(modifier: Modifier){
    Box{
        Image(
            painter = painterResource(R.drawable.onboarding,),
            contentDescription = "onBoardingImage",
            modifier = Modifier.fillMaxSize()
        )
        Column (
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
verticalArrangement = Arrangement.Bottom
        ){

            Image(
                painter = painterResource(R.drawable.logo,),
                contentDescription = "logo",
                modifier = Modifier.size(56.dp)
            )

            Text("Welcome to our Store", style = TextStyle(fontSize = 48.sp, fontWeight = FontWeight.SemiBold, color = Color.White, textAlign = TextAlign.Center),
modifier = Modifier.padding(horizontal = 40.dp, vertical = 35.dp)
            )
            Text("Ger your groceries in as fast as one hour", style = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.SemiBold, color = Color(0xFFFCFCFC), ), modifier = Modifier.padding(bottom = 40.dp)

            )

            Box(contentAlignment = Alignment.Center, modifier = Modifier.padding(bottom = 90.dp).background(Color(0xff53B175), shape =  RoundedCornerShape(19.dp)).padding(horizontal = 127.dp, vertical = 25.dp)) {
                Text("Get Started",style= TextStyle(fontSize = 18.sp, color = Color.White))
            }
        }
    }
}


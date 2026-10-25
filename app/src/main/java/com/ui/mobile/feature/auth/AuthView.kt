package com.ui.mobile.feature.auth

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
import androidx.compose.material3.HorizontalDivider
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

@Composable
fun AuthView(modifier: Modifier){
    Box(
modifier = modifier.background(color = Color.White)
    ){
        Image(
            painter = painterResource(R.drawable.authimage,),
            contentDescription = "imageLogin",
            alignment = Alignment.TopEnd,
            modifier = Modifier.fillMaxSize()
        )
        Column(
            modifier=Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Bottom

        ){
            Text("Get your groceries with nectar ? ",
modifier = Modifier.padding(start = 24.dp, end = 150.dp, bottom = 30.dp),
                textAlign = TextAlign.Start,
                fontSize = 26.sp,
                fontWeight = FontWeight.SemiBold


                )
Row(
verticalAlignment = Alignment.Bottom,
    modifier = Modifier.fillMaxWidth().padding(horizontal = 24.dp, vertical = 15.dp)){

    Image(
        painter = painterResource(R.drawable.flag,),
        contentDescription = "imageLogin",
        alignment = Alignment.BottomStart,
modifier = Modifier.padding(end = 12.dp).size(
    25.dp
)
    )
    Text("+880", textAlign = TextAlign.End)
}
            HorizontalDivider(
                modifier = Modifier.padding(vertical = 10.dp)
            )
            Text("Or connect with social media",
modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                fontSize = 14.sp,
                color = Color(0xff828282),
                fontWeight = FontWeight.SemiBold


            )
            Spacer(modifier = Modifier.height(28.dp))

            SocialMediaButton(
                title = "Sign in with Google",
                icon = R.drawable.google,
                color = Color(0xff5383EC),
                onClick = {}

            )
            SocialMediaButton(
                title = "Sign in with Facebook",
                icon = R.drawable.facebook,
                color = Color(0xff4A66AC),
                onClick = {}
            )
        }
    }
}


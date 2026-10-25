package com.ui.mobile.feature.auth

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SocialMediaButton(

    icon: Int,
    title: String,
    color: Color,
    onClick: () -> Unit = {},
    ){

    Row(


        modifier = Modifier.fillMaxWidth().padding(horizontal = 25.dp, vertical = 15.dp).clickable{onClick},
                Arrangement.Center

    ) {
        Box(

            contentAlignment = Alignment.Center,

            modifier = Modifier.background(color, shape =  RoundedCornerShape(19.dp)).padding(horizontal = 25.dp, vertical =21.dp ),


            ) {
            Row(
                Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Icon(painterResource(icon), contentDescription = null,  )
                Spacer(modifier = Modifier.width(42.dp))
                Text(title,style= TextStyle(fontSize = 18.sp, color = Color.White))
            }

        }
    }

}
package com.ui.mobile.feature.auth

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.sharp.Star
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ui.mobile.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignupView(){

    Column(
        modifier = Modifier.fillMaxSize().background(color = Color.White).padding(horizontal = 24.dp),
        // horizontalAlignment = Alignment.CenterHorizontally

    ) {

        Image(painter = painterResource(R.drawable.carrot_logo), contentDescription = null, modifier = Modifier.align(
            Alignment.CenterHorizontally).padding(top = 32.dp, bottom = 100.dp).size(48.dp))
        Text("Sign Up", fontSize = 26.sp)
        Spacer(Modifier.height(5.dp))
        Text("Enter your credentials to continue", color = Color(0xff7C7C7C))
        Spacer(Modifier.height(40.dp))


        Text("Username", color = Color(0xff7C7C7C))
        Spacer(Modifier.height(10.dp))

        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = "",
            onValueChange = {}
        )



        Text("Email", color = Color(0xff7C7C7C))
        Spacer(Modifier.height(10.dp))

        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = "",
            onValueChange = {}
        )
        Spacer(Modifier.height(24.dp))
        Text("Password", color = Color(0xff7C7C7C))
        Spacer(Modifier.height(10.dp))

        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = "",
            onValueChange = {},
            trailingIcon = {
                Icon(Icons.Sharp.Star, contentDescription = null)
            }
        )
        //By continuing you agree to our Terms of Service
        Spacer(Modifier.height(10.dp))
        Text(text=buildAnnotatedString {

            append("By continuing you agree to our ")
            withStyle(block = {
                append(" Terms of Service ")
            }, style = SpanStyle(
                 color = Color(0xFF53B175)

            ))
            withStyle(block = {
                append("and Privacy Policy.",)
            }, style = SpanStyle(
color = Color(0xff030303)
            ))
        })
        Spacer(Modifier.height(30.dp))
        Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxWidth().background(Color(0xff53B175), shape =  RoundedCornerShape(19.dp)).padding(horizontal = 127.dp, vertical = 18.dp)) {
            Text("Sign Up",style= TextStyle(fontSize = 18.sp, color = Color.White))
        }
        Spacer(Modifier.height(10.dp))
        Text(

            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            text = buildAnnotatedString{
                append("Already have an account? Singup")

                withStyle(
                    style = SpanStyle(
                        color = Color(0xFF53B175)
                    ),
                    block = {
                        append("Signup")
                    }
                )
            })

    }




}



@Preview
@Composable

fun SignupViewPreview(){
    SignupView()
}
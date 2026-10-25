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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MenuAnchorType
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ui.mobile.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SelectLocationView(){
    Scaffold(

        topBar = {
            TopAppBar(
                title = {},
                navigationIcon = {
                    Icon(imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft, tint = Color.Black, contentDescription = null)
                }
            )
        }
    ) {  innerPadding ->
        Column (Modifier.padding(innerPadding).fillMaxSize().padding(horizontal =25.dp),
            horizontalAlignment = Alignment.CenterHorizontally
            ) {

            Image(painter = painterResource(R.drawable.location,

                ), contentDescription = null,
modifier = Modifier.size(188.dp)
                )

            Spacer(modifier = Modifier.height(24.dp))
            Text("Select Your Location", style = TextStyle(fontSize = 29.sp, fontWeight = FontWeight.Bold) )
            Spacer(modifier = Modifier.height(15.dp))
            Text("Switch on your location to stay in tune with what’s happening in your area", style = TextStyle(fontSize = 16.sp,color=Color(0xff7C7C7C), textAlign = TextAlign.Center) )
            Spacer(modifier = Modifier.height(89.dp))
            Text("Your Zone", color = Color(0xff7C7C7C), textAlign = TextAlign.Start, modifier = Modifier.align(
                Alignment.Start))
            Spacer(modifier = Modifier.height(15.dp))
            CountryDropdown()
     Spacer(modifier = Modifier.height(15.dp))
            CountryDropdown()
            Spacer(modifier = Modifier.height(15.dp))
            Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxWidth().background(Color(0xff53B175), shape =  RoundedCornerShape(19.dp)).padding(horizontal = 127.dp, vertical = 18.dp)) {
                Text("Submit",style= TextStyle(fontSize = 18.sp, color = Color.White))
            }


    }}
}


@Preview
@Composable
fun SelectLocationPreviewView(){
    SelectLocationView()
}



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CountryDropdown() {

    val countries = listOf(
        "Egypt",
        "Saudi Arabia",
        "UAE",
        "Kuwait"
    )

    var expanded by remember {
        mutableStateOf(false)
    }

    var selectedCountry by remember {
        mutableStateOf(countries.first())
    }

    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = { expanded = it }
    ) {
        OutlinedTextField(
            value = selectedCountry,
            onValueChange = {},
            readOnly = true,
            label = { Text("Select Country") },
            trailingIcon = {
                ExposedDropdownMenuDefaults.TrailingIcon(
                    expanded = expanded
                )
            },
            modifier = Modifier
                .fillMaxWidth().menuAnchor(
                    type = MenuAnchorType.PrimaryEditable


                )
            ,

        )

        DropdownMenu (
            expanded = expanded,
            onDismissRequest = {
                expanded = false
            }
        ) {
            countries.forEach { country ->
                DropdownMenuItem(
                    text = {
                        Text(country)
                    },
                    onClick = {
                        selectedCountry = country
                        expanded = false
                    }
                )
            }
        }
    }
}
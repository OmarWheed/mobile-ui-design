package com.ui.mobile.feature.account

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ui.mobile.R

@Preview
@Composable
fun AccountView() {

    LazyColumn(
        Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        item {
            AccountHeader()
            Spacer(Modifier.height(20.dp))
        }
        items(8) {
            HorizontalDivider()
            ServiceItem()
            HorizontalDivider()
        }

        item {
            LogoutButton()
        }
    }

}

@Composable
fun LogoutButton() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(24.dp)
            .background(Color(0xffF2F3F2), shape = RoundedCornerShape(12.dp))
            .padding(vertical = 24.dp, horizontal = 24.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ) {
        Icon(Icons.Default.ExitToApp, contentDescription = null, tint = Color(0xFF53B175))
        Spacer(
            modifier = Modifier.weight(1f)
        )
        Text("Log Out", fontSize = 18.sp, color = Color(0xFF53B175))
        Spacer(
            modifier = Modifier.weight(1f)
        )

    }
}

@Composable
fun ServiceItem() {

    ListItem(
        leadingContent = {

            Image(
                painter = painterResource(R.drawable.store), contentDescription = null

            )
        },
        headlineContent = {
            Text("Omar Waheed", fontWeight = FontWeight.Bold, fontSize = 20.sp)
        },
        trailingContent = {
            Icon(Icons.AutoMirrored.Filled.KeyboardArrowRight, contentDescription = null)
        }

    )
}

@Composable
fun AccountHeader() {
    ListItem(
        supportingContent = { Text("Omardev@gmail.com") },
        leadingContent = {

            Image(
                painter = painterResource(R.drawable.backery), contentDescription = null

            )
        },
        headlineContent = {
            Text("Omar Waheed", fontWeight = FontWeight.Bold, fontSize = 20.sp)
        },
        trailingContent = {
            Icon(Icons.Default.Edit, contentDescription = null)
        }

    )
}
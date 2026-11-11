package com.ui.mobile.feature.account

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
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

@Preview(showBackground = true)
@Composable
fun AccountView() {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        item {
            AccountHeader()
            Spacer(Modifier.height(10.dp))
        }

        // List of menu items to optimize code repetition
        val menuItems = listOf(
            "Orders" to R.drawable.store,
            "My Details" to R.drawable.accout,
            "Delivery Address" to R.drawable.explore,
            "Payment Methods" to R.drawable.cart,
            "Promo Card" to R.drawable.favourite,
            "Notifications" to R.drawable.explore,
            "Help" to R.drawable.explore,
            "About" to R.drawable.explore
        )

        items(menuItems.size) { index ->
            HorizontalDivider(
                modifier = Modifier.padding(horizontal = 16.dp),
                color = MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.4f)
            )
            ServiceItem(title = menuItems[index].first, iconRes = menuItems[index].second)
        }

        item {
            HorizontalDivider(
                modifier = Modifier.padding(horizontal = 16.dp),
                color = MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.4f)
            )
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
            .background(
                color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f),
                shape = RoundedCornerShape(12.dp)
            )
            .clickable { /* Handle Logout */ }
            .padding(vertical = 18.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center // Better than using weights
    ) {
        Icon(
            imageVector = Icons.Default.ExitToApp,
            contentDescription = null,
            tint = MaterialTheme.colorScheme.primary
        )
        Spacer(modifier = Modifier.width(12.dp))
        Text(
            text = "Log Out",
            fontSize = 18.sp,
            fontWeight = FontWeight.SemiBold,
            color = MaterialTheme.colorScheme.primary
        )
    }
}

@Composable
fun ServiceItem(title: String, iconRes: Int) {
    ListItem(
        modifier = Modifier.clickable { },
        leadingContent = {
            Icon(
                painter = painterResource(iconRes),
                contentDescription = null,
                modifier = Modifier.size(20.dp),
                tint = MaterialTheme.colorScheme.onSurface
            )
        },
        headlineContent = {
            Text(
                text = title,
                fontWeight = FontWeight.SemiBold,
                fontSize = 18.sp
            )
        },
        trailingContent = {
            Icon(
                imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                contentDescription = null
            )
        }
    )
}

@Composable
fun AccountHeader() {
    ListItem(
        modifier = Modifier.padding(vertical = 10.dp),
        supportingContent = { 
            Text("omardev@gmail.com", color = MaterialTheme.colorScheme.onSurfaceVariant) 
        },
        leadingContent = {
            Image(
                painter = painterResource(R.drawable.backery),
                contentDescription = "Profile Picture",
                modifier = Modifier.size(64.dp)
            )
        },
        headlineContent = {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = "Omar Waheed", 
                    fontWeight = FontWeight.Bold, 
                    fontSize = 20.sp
                )
                Spacer(Modifier.width(8.dp))
                Icon(
                    imageVector = Icons.Default.Edit,
                    contentDescription = "Edit",
                    tint = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.size(16.dp)
                )
            }
        }
    )
}

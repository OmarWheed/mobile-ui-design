package com.ui.mobile.feature.app_shell

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import com.ui.mobile.R
import com.ui.mobile.core.routes.Explore
import com.ui.mobile.core.routes.Favourite
import com.ui.mobile.core.routes.Store
import com.ui.mobile.core.routes.Cart
import com.ui.mobile.core.routes.Account


data class BottomNavItem<T : Any>(
    val icon: Int,
    val route: T,
    val title: String

)

val navItems = listOf(
    BottomNavItem(
        icon = R.drawable.store,
        route = Store,
        title = "Store"
    ),

    BottomNavItem(
        icon = R.drawable.explore,
        route = Explore,
        title = "Explore"
    ),

    BottomNavItem(
        icon = R.drawable.cart,
        route = Cart,
        title = "Cart"
    ),
    BottomNavItem(
        icon = R.drawable.favourite,
        route = Favourite,
        title = "Favourite"
    ),
    BottomNavItem(
        icon = R.drawable.accout,
        route = Account,
        title = "Account"
    ),

    )

@Composable()
fun AppShell() {
    NavigationBar {
        navItems.forEachIndexed { index, item ->

            NavigationBarItem(
                selected = true,
                label = { Text(item.title) },
                onClick = { },
                icon = { Icon(painter = painterResource(item.icon), contentDescription = null) }
            )
        }

    }
}
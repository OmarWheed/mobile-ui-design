package com.ui.mobile.feature.app_shell

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.ui.mobile.R
import com.ui.mobile.core.routes.Account
import com.ui.mobile.core.routes.AppNavHost
import com.ui.mobile.core.routes.Cart
import com.ui.mobile.core.routes.Explore
import com.ui.mobile.core.routes.Favourite
import com.ui.mobile.core.routes.Store

data class BottomNavItem<T : Any>(
    val icon: Int,
    val route: T,
    val title: String
)

val navItems = listOf(
    BottomNavItem(icon = R.drawable.store, route = Store, title = "Store"),
    BottomNavItem(icon = R.drawable.explore, route = Explore, title = "Explore"),
    BottomNavItem(icon = R.drawable.cart, route = Cart, title = "Cart"),
    BottomNavItem(icon = R.drawable.favourite, route = Favourite, title = "Favourite"),
    BottomNavItem(icon = R.drawable.accout, route = Account, title = "Account"),
)

@Composable
fun AppShell() {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    Scaffold(
        bottomBar = {
            NavigationBar(
                containerColor = Color.White,
                tonalElevation = 8.dp
            ) {
                navItems.forEach { item ->
                    // Using modern type-safe check for the current destination
                    val isSelected = currentDestination?.hierarchy?.any { 
                        it.hasRoute(item.route::class) 
                    } == true
                    
                    NavigationBarItem(
                        selected = isSelected,
                        label = { 
                            Text(
                                text = item.title,
                                color = if (isSelected) MaterialTheme.colorScheme.primary else Color.Gray,
                                style = MaterialTheme.typography.labelSmall
                            ) 
                        },
                        onClick = {
                            navController.navigate(item.route) {
                                popUpTo(navController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        },
                        icon = { 
                            Icon(
                                painter = painterResource(item.icon), 
                                contentDescription = item.title,
                                tint = if (isSelected) MaterialTheme.colorScheme.primary else Color.Black
                            ) 
                        },
                        colors = NavigationBarItemDefaults.colors(
                            indicatorColor = MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.2f)
                        )
                    )
                }
            }
        }
    ) { innerPadding ->
        AppNavHost(
            navController = navController,
            modifier = Modifier.padding(innerPadding)
        )
    }
}

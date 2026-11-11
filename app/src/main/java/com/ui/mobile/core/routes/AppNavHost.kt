package com.ui.mobile.core.routes

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.ui.mobile.feature.account.AccountView
import com.ui.mobile.feature.cart.CartView
import com.ui.mobile.feature.explore.ExploreView
import com.ui.mobile.feature.favourite.FavouriteView
import com.ui.mobile.feature.shop.ShopView

@Composable
fun AppNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = Store,
        modifier = modifier
    ) {
        composable<Store> {
            ShopView()
        }
        composable<Explore> {
            ExploreView()
        }
        composable<Cart> {
            CartView()
        }
        composable<Favourite> {
            FavouriteView()
        }
        composable<Account> {
            AccountView()
        }
    }
}

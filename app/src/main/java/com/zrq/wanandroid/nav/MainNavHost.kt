package com.zrq.wanandroid.nav

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.zrq.wanandroid.screen.main.MainScreen
import com.zrq.wanandroid.screen.search.SearchScreen
import com.zrq.wanandroid.screen.system.SystemDetailScreen
import com.zrq.wanandroid.screen.web.WebScreen
import com.zrq.wanandroid.type.Children
import com.zrq.wanandroid.utils.LocalNavController

@Composable
fun MainNavHost() {
    val navController = rememberNavController()
    CompositionLocalProvider(LocalNavController provides navController) {
        NavHost(navController = LocalNavController.current, startDestination = Route.Main.route) {
            composable(Route.Main.route) {
                MainScreen()
            }
            composable(
                route = "${Route.Web.route}?url={url}",
                arguments = listOf(
                    navArgument("url") {
                        type = NavType.StringType
                    }
                )
            ) {
                val url = it.arguments?.getString("url") ?: ""
                WebScreen(url)
            }
            composable(Route.Search.route) {
                SearchScreen()
            }
            composable(
                route = "${Route.SystemDetail.route}?data={data}&index={index}"
            ) {
                val data = it.arguments?.getString("data") ?: ""
                val index = it.arguments?.getString("index")?.toInt() ?: 0
                val type = object : TypeToken<List<Children>>() {}.type
                val list = Gson().fromJson<List<Children>>(data, type)
                SystemDetailScreen(list, index)
            }
        }
    }
}
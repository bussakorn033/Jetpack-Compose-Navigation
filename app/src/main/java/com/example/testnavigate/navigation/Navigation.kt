package com.example.testnavigate.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.testnavigate.screens.add.AddScreen
import com.example.testnavigate.screens.detail.DetailScreen
import com.example.testnavigate.screens.home.HomeScreen
import com.example.testnavigate.screens.jobs.JobsScreen
import com.example.testnavigate.screens.myNetwork.MyNetworkScreen
import com.example.testnavigate.screens.notification.NotificationScreen

@Composable
fun Navigation(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = "home_screen"
    ) {
        composable(
            route = "home_screen",
//            arguments = listOf(navArgument("userId") { type = NavType.StringType })
        ) {
            HomeScreen(
                navController = navController
            )
        }
        composable(
            route = "detail_screen/{userId}",
            arguments = listOf(navArgument("userId") { type = NavType.StringType })
        ) { backStackEntry ->
            DetailScreen(
                navController = navController,
                userId = backStackEntry.arguments?.getString("userId")
            )
        }
        composable(
            route = "mynetwork_screen",
        ) {
            MyNetworkScreen(
                navController = navController
            )
        }
        composable(
            route = "add_screen",
        ) {
            AddScreen(
                navController = navController
            )
        }
        composable(
            route = "notification_screen",
        ) {
            NotificationScreen(
                navController = navController
            )
        }
        composable(
            route = "jobs_screen",
        ) {
           JobsScreen(
                navController = navController
            )
        }
    }
}
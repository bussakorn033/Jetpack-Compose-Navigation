package com.example.testnavigate.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.testnavigate.screens.add.AddScreen
import com.example.testnavigate.screens.detail.DetailScreen
import com.example.testnavigate.screens.childrenDetail.ChildrenDetailScreen
import com.example.testnavigate.screens.home.HomeScreen
import com.example.testnavigate.screens.home.children.ChildrenHomeScreen
import com.example.testnavigate.screens.jobs.JobsScreen
import com.example.testnavigate.screens.myNetwork.MyNetworkScreen
import com.example.testnavigate.screens.notification.NotificationScreen
import com.example.testnavigate.screens.roomLiveData.RoomLiveDataScreen
import com.example.testnavigate.viewModel.TodoViewModel

@Composable
fun Navigation(navController: NavHostController, modifier: Modifier = Modifier, vm: TodoViewModel) {
    NavHost(
        modifier = modifier,
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
            route = "children_home_screen",
        ) {
            ChildrenHomeScreen(
                navController = navController,
            )
        }
        composable(
            route = "room_live_data",
        ) {
            RoomLiveDataScreen()
        }
        composable(
            route = "detail_screen/{userId}",
            arguments =
            listOf(navArgument("userId")
            { type = NavType.StringType }
            )
        ) { backStackEntry ->
            DetailScreen(
                navController = navController,
                userId = backStackEntry.arguments?.getString("userId"),
            )
        }
        composable(
//            route = "children_detail_screen",
            route = "children_detail_screen/{id}",
            arguments =
            listOf(navArgument("id")
            { type = NavType.StringType }
            )
        ) { backStackEntry ->
            ChildrenDetailScreen(
                navController = navController,
                userId = backStackEntry.arguments?.getString("id"),
                vm = vm
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
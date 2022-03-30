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
import com.example.testnavigate.screens.roomLiveDataItem.RoomLiveDataItemScreen
import com.example.testnavigate.viewModel.TodoViewModel

@Composable
fun Navigation(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    vm: TodoViewModel,
    callBackTopBarTitle: (String) -> Unit,
    callBackTopBarGoBack: (Boolean) -> Unit,
) {

    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = "home_screen"
    ) {
        composable(
            route = "home_screen",
//            arguments = listOf(navArgument("userId") { type = NavType.StringType })
        ) {
            callBackTopBarTitle("Home")
            callBackTopBarGoBack(false)
            HomeScreen(
                navController = navController
            )
        }
        composable(
            route = "children_home_screen",
        ) {
            callBackTopBarTitle("Children Home")
            callBackTopBarGoBack(true)
            ChildrenHomeScreen(
                navController = navController,
            )
        }
        composable(
            route = "room_live_data",
        ) {
            callBackTopBarTitle("Room Live Data")
            callBackTopBarGoBack(true)
            RoomLiveDataScreen(
                navController = navController,
            )
        }
        composable(
            route = "room_live_data_item/{productId}",
            arguments = listOf(navArgument("productId") { type = NavType.IntType }),
        ) { backStackEntry ->
            callBackTopBarTitle("Room Live Data Item")
            callBackTopBarGoBack(true)
            RoomLiveDataItemScreen(
                navController = navController,
                productId = backStackEntry.arguments!!.getInt("productId"),
            )
        }
        composable(
            route = "detail_screen/{userId}",
            arguments =
            listOf(navArgument("userId")
            { type = NavType.StringType }
            )
        ) { backStackEntry ->
            callBackTopBarTitle("Detail")
            callBackTopBarGoBack(true)
            DetailScreen(
                navController = navController,
                userId = backStackEntry.arguments?.getString("userId"),
            )
        }
        composable(
            route = "children_detail_screen/{id}",
            arguments =
            listOf(navArgument("id")
            { type = NavType.IntType }
            )
        ) { backStackEntry ->
            callBackTopBarTitle("Children Detail")
            callBackTopBarGoBack(true)
            ChildrenDetailScreen(
                navController = navController,
                userId = backStackEntry.arguments!!.getInt("id"),
                vm = vm
            )
        }
        composable(
            route = "mynetwork_screen",
        ) {
            callBackTopBarTitle("My Network")
            callBackTopBarGoBack(false)
            MyNetworkScreen(
                navController = navController
            )
        }
        composable(
            route = "add_screen",
        ) {
            callBackTopBarTitle("Add")
            callBackTopBarGoBack(false)
            AddScreen(
                navController = navController
            )
        }
        composable(
            route = "notification_screen",
        ) {
            callBackTopBarTitle("Notification")
            callBackTopBarGoBack(false)
            NotificationScreen(
                navController = navController
            )
        }
        composable(
            route = "jobs_screen",
        ) {
            callBackTopBarTitle("Jobs")
            callBackTopBarGoBack(false)
            JobsScreen(
                navController = navController
            )
        }
    }
}
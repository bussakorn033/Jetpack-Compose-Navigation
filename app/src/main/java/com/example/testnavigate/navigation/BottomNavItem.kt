package com.example.testnavigate.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.testnavigate.R

sealed class BottomNavItem(var title:String, var icon: ImageVector, var screen_route:String){
    object Home : BottomNavItem("Home", Icons.Filled.Home,"home_screen")
    object MyNetwork: BottomNavItem("My Network",Icons.Filled.Group,"mynetwork_screen")
//    object MyNetwork: BottomNavItem("My Network",R.drawable.ic_group,"mynetwork_screen")
    object AddPost: BottomNavItem("Post",Icons.Filled.Add,"add_screen")
    object Notification: BottomNavItem("Notification",Icons.Filled.Notifications,"notification_screen")
    object Jobs: BottomNavItem("Jobs",Icons.Filled.Work,"jobs_screen")
//    object Jobs: BottomNavItem("Jobs", R.drawable.ic_job,"jobs_screen")
}

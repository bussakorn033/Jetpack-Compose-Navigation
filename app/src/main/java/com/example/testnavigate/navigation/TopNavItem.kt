package com.example.testnavigate.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.testnavigate.R

sealed class TopNavItem(var title:String, var icon: ImageVector, var screen_route:String){
    object Menu: TopNavItem("Menu",Icons.Filled.Menu,"home_screen")

    object Favorite : TopNavItem("Favorite", Icons.Filled.Favorite,"home_screen")
    object Search: TopNavItem("Search",Icons.Filled.Search,"home_screen")
    object MoreVert: TopNavItem("MoreVert",Icons.Filled.MoreVert,"home_screen")
}

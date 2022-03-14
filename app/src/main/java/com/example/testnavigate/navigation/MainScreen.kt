package com.example.testnavigate.navigation

import android.widget.Toast
import androidx.compose.foundation.layout.size
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

@Composable
fun MainScreenView() {
    val navController = rememberNavController()
    Scaffold(
        topBar = { TopBar(title = "Test Navigate") },
        bottomBar = { BottomBar(navController = navController) },
    ) {
        Navigation(navController = navController)
    }
}


/* ----------------------- TopAppBar ----------------------- */
@Composable
fun TopBar(title: String) {
    val context = LocalContext.current
    TopAppBar(
        backgroundColor = Color.Black,
        contentColor = Color(0xFFFFC0CB),
        title = {
            Text(
                text = title,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
            )
        },
        actions = {
            IconButton(onClick = {
                Toast.makeText(
                    context,
                    "click Favorite",
                    Toast.LENGTH_SHORT
                )
                    .show()
            }) {
                Icon(Icons.Filled.Favorite, contentDescription = "Favorite")
            }

            IconButton(onClick = {
                Toast.makeText(
                    context,
                    "click Search",
                    Toast.LENGTH_SHORT
                )
                    .show()
            }) {
                Icon(Icons.Filled.Search, contentDescription = "Search")
            }

            IconButton(onClick = {
                Toast.makeText(
                    context,
                    "click MoreVert",
                    Toast.LENGTH_SHORT
                )
                    .show()
            }) {
                Icon(Icons.Filled.MoreVert, contentDescription = "MoreVert")
            }
        },
        navigationIcon = {
            IconButton(onClick = {
                Toast.makeText(
                    context,
                    "click Menu",
                    Toast.LENGTH_SHORT
                )
                    .show()
            }) {
                Icon(
                    Icons.Filled.Menu,
                    contentDescription = "Menu",
                    modifier = Modifier
                        .size(30.dp)
                )
            }
        }
    )

}
/* ----------------------- TopAppBar ----------------------- */

/* ----------------------- BottomAppBar ----------------------- */

@Preview(showBackground = true)
@Composable
fun BottomNavigationBarPreview() {
    val navController = rememberNavController()
    BottomBar(navController)
}

@Composable
fun BottomBar(navController: NavHostController) {
    val items = listOf(
        BottomNavItem.Home,
        BottomNavItem.MyNetwork,
        BottomNavItem.AddPost,
        BottomNavItem.Notification,
        BottomNavItem.Jobs
    )
    BottomNavigation(
        backgroundColor = Color(0xff000000),
        contentColor = Color(0xffffc0cb),
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        items.forEach { item ->
            BottomNavigationItem(
                /*painterResource(id = item.icon)*/
                icon = { Icon(item.icon, contentDescription = item.title) },
//                icon = { IconsCustom(icon = item.icon, contentDescription = item.title) },
                label = {
                    Text(
                        text = item.title,
                        fontSize = 9.sp
                    )
                },
                selectedContentColor = Color(0xffffc0cb),
                unselectedContentColor = Color(0xffffc0cb).copy(0.4f),
                alwaysShowLabel = true,
                selected = currentRoute == item.screen_route,
                onClick = {
                    navController.navigate(item.screen_route) {

                        navController.graph.startDestinationRoute?.let { screen_route ->
                            popUpTo(screen_route) {
                                saveState = true
                            }
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }

}

//fun IconsCustom(icon: Any?, contentDescription: String) {
//    return
//    if(icon==="MyNetwork"&&icon==="Jobs"){
//        Icon(painterResource(id = icon), contentDescription = contentDescription)
//    }else{
//        Icon(icon, contentDescription = contentDescription)
//    }
//
//}
/* ----------------------- BottomAppBar ----------------------- */

package com.example.testnavigate.navigation

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIos
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester.Companion.createRefs
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.testnavigate.viewModel.TodoViewModel
import kotlinx.coroutines.NonDisposableHandle.parent

@Composable
fun MainScreenView() {
    val navController = rememberNavController()
    val scrollState = rememberScrollState()
    val vm = TodoViewModel()
    var (callBackTopBarTitle, setCallBackTopBarTitle) = rememberSaveable { mutableStateOf("") }
    var (callBackTopBarGoBack, setCallTopBarGoBack) = rememberSaveable { mutableStateOf(false) }
    Scaffold(
        topBar = {
            TopBar(
                title = "${callBackTopBarTitle}",
                navController = navController,
                callBackTopBarGoBack = callBackTopBarGoBack
            )
        },
        bottomBar = { BottomBar(navController = navController) },
    ) { innerPadding ->
        Navigation(
            modifier = Modifier
                .padding(innerPadding)
                .scrollable(
                    state = scrollState,
                    orientation = Orientation.Vertical
                ),
            navController = navController,
            vm = vm,
            callBackTopBarTitle = { callBackTopBarTitle ->
                setCallBackTopBarTitle(
                    callBackTopBarTitle
                )
            },
            callBackTopBarGoBack = { callBackTopBarGoBack ->
                setCallTopBarGoBack(
                    callBackTopBarGoBack
                )
            },

            )
//    NavHost(navController, startDestination = Screen.Profile.route, Modifier.padding(innerPadding)) {
//        composable(Screen.Profile.route) { Profile(navController) }
//        composable(Screen.FriendsList.route) { FriendsList(navController) }
    }
}


/* ----------------------- TopAppBar ----------------------- */
@Preview(showBackground = true)
@Composable
fun TopBarPreview() {
    val navController = rememberNavController()
    TopBar(
        title = "Test Navigate",
        navController = navController,
        callBackTopBarGoBack = true
    )
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun TopBar(
    title: String,
    navController: NavHostController,
    callBackTopBarGoBack: Boolean
) {
    val context = LocalContext.current
    TopAppBar(
        backgroundColor = Color.Black,
        contentColor = Color(0xFFFFC0CB),
        navigationIcon = {
            if (!callBackTopBarGoBack) {
                val Menu = TopNavItem.Menu
                IconButton(
                    onClick = {
                        navController.navigate(Menu.screen_route)
                        Toast.makeText(
                            context,
                            "click ${Menu.title}",
                            Toast.LENGTH_SHORT
                        )
                            .show()
                    },
                ) {
                    Icon(
                        Menu.icon,
                        contentDescription = "${Menu.title}",
                        modifier = Modifier
                            .size(30.dp)
                    )
                }
            } else {
                IconButton(
                    onClick = { navController.popBackStack() }
                ) {
                    Icon(
                        Icons.Filled.ArrowBackIos,
                        contentDescription = "ArrowBack",
                        modifier = Modifier
                            .size(26.dp)
                            .absoluteOffset( x = 5.dp)
                    )
                }
            }

        },
        title = {
            Text(
                text = title,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
            )
        },
        actions = {
            if (!callBackTopBarGoBack) {
                val items = listOf(
                    TopNavItem.Favorite,
                    TopNavItem.Search,
                    TopNavItem.MoreVert,
                )
                items.forEach { item ->
                    IconButton(
                        onClick = {
                            navController.navigate(item.screen_route)
                            Toast.makeText(
                                context,
                                "click ${item.title}",
                                Toast.LENGTH_SHORT
                            )
                                .show()
                        }
                    ) {
                        Icon(item.icon, contentDescription = "${item.title}")
                    }
                }
            } else null
        },

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
        val context = LocalContext.current
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
                    Toast.makeText(
                        context,
                        "From->$currentRoute\nTo->${item.screen_route}",
                        Toast.LENGTH_LONG
                    )
                        .show()
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

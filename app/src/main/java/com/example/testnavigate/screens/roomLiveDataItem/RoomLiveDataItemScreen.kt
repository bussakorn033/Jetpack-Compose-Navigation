package com.example.testnavigate.screens.roomLiveDataItem

import android.app.Application
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import com.example.testnavigate.room.product.Product
import com.example.testnavigate.screens.roomLiveData.ProductRow
import com.example.testnavigate.screens.roomLiveData.TitleRow
import com.example.testnavigate.viewModel.MainViewModel

@Composable
fun RoomLiveDataItemScreen(
    viewModel: MainViewModel =
        MainViewModel(LocalContext.current.applicationContext as Application),
    navController: NavHostController,
    productId: Int,
) {
    val getIdProductResults by viewModel.getIdProductResults.observeAsState(Product())
//    LaunchedEffect(Unit, block = {
    viewModel.getIdProduct(productId)
//    })



    val product = getIdProductResults
    product?.let {
        Column {
            TitleRow(head1 = "ID", head2 = "Product", head3 = "Quantity")
            ProductRow(
                id = product.id,
                name = product.productName,
                quantity = product.quantity,
                isButton = false,
                navController = navController,
            )
        }
    }

//    LazyColumn(
//        Modifier
//            .fillMaxWidth()
//    ) {
//        val list = getIdProductResults
//
////            item {
////                TitleRow(head1 = "ID", head2 = "Product", head3 = "Quantity")
////            }
//
//        items(list) { product ->
//            ProductRow(
//                id = product.id,
//                name = product.productName,
//                quantity = product.quantity,
//                viewModel = viewModel,
//                isButton = false,
//                navController = navController,
//            )
//        }
//    }

}

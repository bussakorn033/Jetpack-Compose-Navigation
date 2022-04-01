package com.example.testnavigate.screens.roomLiveDataItem

import android.app.Application
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import com.example.testnavigate.components.ProductRow
import com.example.testnavigate.components.TitleRow
import com.example.testnavigate.room.product.Product
import com.example.testnavigate.viewModel.ProductViewModel

@Composable
fun RoomLiveDataItemScreen(
    viewModel: ProductViewModel =
        ProductViewModel(LocalContext.current.applicationContext as Application),
    navController: NavHostController,
    productId: Int,
) {
    val getIdProductResults by viewModel.getIdProductResults.observeAsState(Product())
    viewModel.getIdProduct(productId)



    val product = getIdProductResults
    product?.let {
        Column {
            TitleRow(head1 = "ID", head2 = "Product", head3 = "Quantity")
            ProductRow(
                id = product.id,
                name = product.productName,
                quantity = product.quantity,
                navController = navController,
                isButton = false,
            )
        }
    }
}

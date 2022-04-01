package com.example.testnavigate.screens.roomLiveData

import android.app.Application
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalTextInputService
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.testnavigate.components.CustomTextField
import com.example.testnavigate.components.ProductRow
import com.example.testnavigate.components.TitleRow
import com.example.testnavigate.room.product.Product
import com.example.testnavigate.viewModel.ProductViewModel

@Composable
fun RoomLiveDataScreen(
    viewModel: ProductViewModel =
        ProductViewModel(LocalContext.current.applicationContext as Application),
    navController: NavHostController
) {
    val allProducts by viewModel.allProducts.observeAsState(listOf())
    val searchResults by viewModel.searchResults.observeAsState(listOf())
    RoomLiveDataLayout(
        allProducts = allProducts,
        searchResults = searchResults,
        viewModel = viewModel,
        navController = navController
    )
}

@Composable
fun RoomLiveDataLayout(
    allProducts: List<Product>,
    searchResults: List<Product>,
    viewModel: ProductViewModel,
    navController: NavHostController
) {
    val context = LocalContext.current

    var productName by remember { mutableStateOf("") }
    var productQuantity by remember { mutableStateOf("") }
    var searching by remember { mutableStateOf(false) }

    val onProductTextChange = { text: String ->
        productName = text.trim()
    }

    val onQuantityTextChange = { text: String ->
        productQuantity = text
    }


    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
    ) {
        CustomTextField(
            title = "Product Name",
            textState = productName,
            onTextChange = onProductTextChange,
            keyboardType = KeyboardType.Text
        )

        CustomTextField(
            title = "Quantity",
            textState = productQuantity,
            onTextChange = onQuantityTextChange,
            keyboardType = KeyboardType.Number
        )

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        ) {
            Button(
                onClick = {
                    if (productName.length > 0 && productQuantity.length > 0) {
                        viewModel.insertProduct(
                            Product(
                                productName,
                                productQuantity.toInt()
                            )
                        )
                        searching = false
                    } else {
                        Toast.makeText(
                            context,
                            "Enter your product name or quantity!",
                            Toast.LENGTH_SHORT
                        )
                            .show()
                    }
                }
            ) {
                Text("Add")
            }

            Button(
                onClick = {
                    if (productName.length > 0) {
                        searching = true
                        viewModel.findProduct(productName)
                    } else {
                        Toast.makeText(
                            context,
                            "Enter your product name!",
                            Toast.LENGTH_SHORT
                        )
                            .show()
                    }
                }
            ) {
                Text("Search")
            }
            Button(
                onClick = {
                    if (productName.length > 0) {
                        searching = false
                        viewModel.deleteProduct(productName)
                    } else {
                        Toast.makeText(
                            context,
                            "Enter your product name!",
                            Toast.LENGTH_SHORT
                        )
                            .show()
                    }
                }
            ) {
                Text("Delete")
            }

            Button(
                onClick = {
                    searching = false
                    productName = ""
                    productQuantity = ""
                }
            ) {
                Text("Clear")
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        TitleRow(head1 = "ID", head2 = "Product", head3 = "Quantity")

        LazyColumn(
            Modifier
                .fillMaxWidth()
        ) {
            val list = if (searching) searchResults else allProducts
//            item {
//                TitleRow(head1 = "ID", head2 = "Product", head3 = "Quantity")
//            }

            items(list) { product ->
                ProductRow(
                    id = product.id,
                    name = product.productName,
                    quantity = product.quantity,
                    navController = navController,
                )
            }
        }
    }
}

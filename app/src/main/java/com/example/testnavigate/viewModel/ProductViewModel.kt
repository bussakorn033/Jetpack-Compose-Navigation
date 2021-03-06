package com.example.testnavigate.viewModel

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.testnavigate.room.product.Product
import com.example.testnavigate.room.product.ProductRepository
import com.example.testnavigate.room.product.ProductRoomDatabase

class ProductViewModel(application: Application) {

    val allProducts: LiveData<List<Product>>
    private val repository: ProductRepository
    val searchResults: MutableLiveData<List<Product>>
    val getIdProductResults: MutableLiveData<Product>

    init {
        val productDb = ProductRoomDatabase.getInstance(application)
        val productDao = productDb.productDao()
        repository = ProductRepository(productDao)

        allProducts = repository.allProducts
        searchResults = repository.searchResults
        getIdProductResults = repository.getIdProductResults
    }

    fun insertProduct(product: Product) {
        repository.insertProduct(product)
    }

    fun findProduct(name: String) {
        repository.findProduct(name)
    }

    fun deleteProduct(name: String) {
        repository.deleteProduct(name)
    }

    fun getIdProduct(productId: Int) {
        repository.getIdProduct(productId)
    }
}
package com.alternova.lego.data.datasource.home.products

import com.alternova.lego.data.local.database.entity.ShoppingCarEntity
import com.alternova.lego.data.remote.retrofit.model.ResponseDetailLego
import com.alternova.lego.data.remote.retrofit.model.ResponseLego
import kotlinx.coroutines.flow.Flow

interface ProductNetworkDataSource {

    fun getAllProducts() : Flow<ResponseLego>

    fun getProductById(id: Int) : Flow<ResponseDetailLego>

    suspend fun addProductToCar(product: ShoppingCarEntity)

}
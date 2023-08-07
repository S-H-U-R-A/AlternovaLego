package com.alternova.lego.domain.repository.home.products

import com.alternova.lego.data.local.database.entity.ShoppingCarEntity
import com.alternova.lego.data.remote.retrofit.model.ResponseDetailLego
import com.alternova.lego.domain.model.ProductDomain
import com.alternova.lego.domain.model.ResponseLegoDomain
import com.alternova.lego.domain.model.ShoppingCarDomain
import kotlinx.coroutines.flow.Flow

interface ProductRepository {

    fun getAllProducts() : Flow<ResponseLegoDomain>

    fun getProductById(id: Int) : Flow<ProductDomain>

    suspend fun addProductToCar(product: ShoppingCarDomain)

}

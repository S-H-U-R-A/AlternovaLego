package com.alternova.lego.data.datasource.home.products


import com.alternova.lego.data.local.database.dao.ShoppingCarDao
import com.alternova.lego.data.local.database.entity.ShoppingCarEntity
import com.alternova.lego.data.remote.retrofit.LegoApiServices
import com.alternova.lego.data.remote.retrofit.model.ResponseDetailLego
import com.alternova.lego.data.remote.retrofit.model.ResponseLego
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ProductNetworkDataSourceImpl @Inject constructor(
    private val legoApiServices: LegoApiServices,
    private val shoppingCarDao: ShoppingCarDao
) : ProductNetworkDataSource {
    override fun getAllProducts(): Flow<ResponseLego> = flow {
        emit(legoApiServices.getAllProducts())
    }

    override fun getProductById(id: Int): Flow<ResponseDetailLego>  = flow {
        emit(legoApiServices.getProductById(id))
    }

    override suspend fun addProductToCar(product: ShoppingCarEntity) {
        shoppingCarDao.insertProductInCar(product)
    }
}
package com.alternova.lego.data.datasource.home.products


import com.alternova.lego.data.remote.retrofit.LegoApiServices
import com.alternova.lego.data.remote.retrofit.model.ResponseLego
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ProductNetworkDataSourceImpl @Inject constructor(
    private val legoApiServices: LegoApiServices
) : ProductNetworkDataSource {
    override fun getAllProducts(): Flow<ResponseLego> = flow {
        legoApiServices.getAllProducts()
    }
}
package com.alternova.lego.domain.repository.home.products

import com.alternova.lego.data.datasource.home.products.ProductNetworkDataSource
import com.alternova.lego.data.remote.retrofit.model.ResponseLego
import com.alternova.lego.data.repository.home.products.ProductRepository
import com.alternova.lego.di.qualifiers.IoDispatcher
import com.alternova.lego.domain.model.ListProductsDomain
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class ProductRepositoryImpl @Inject constructor(
    private val productNetworkDataSource: ProductNetworkDataSource,
    @IoDispatcher private val coroutineDispatcher: CoroutineDispatcher
) : ProductRepository {
    override fun getAllProducts(): Flow<ListProductsDomain> =
        productNetworkDataSource.getAllProducts().flowOn(coroutineDispatcher)
            .map { responseLego: ResponseLego ->
                println(responseLego.products.toString())
                responseLego.toDomain()
            }

}
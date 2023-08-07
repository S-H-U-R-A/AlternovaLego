package com.alternova.lego.data.repository.home.products


import com.alternova.lego.data.datasource.home.products.ProductNetworkDataSource
import com.alternova.lego.data.remote.retrofit.model.ResponseLego
import com.alternova.lego.di.qualifiers.IoDispatcher
import com.alternova.lego.domain.model.ProductDomain
import com.alternova.lego.domain.model.ResponseLegoDomain
import com.alternova.lego.domain.model.ShoppingCarDomain
import com.alternova.lego.domain.repository.home.products.ProductRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class ProductRepositoryImpl @Inject constructor(
    private val productNetworkDataSource: ProductNetworkDataSource,
    @IoDispatcher private val coroutineDispatcher: CoroutineDispatcher
) : ProductRepository {

    override fun getAllProducts(): Flow<ResponseLegoDomain> =
        productNetworkDataSource.getAllProducts()
            .map { responseLego: ResponseLego ->
                responseLego.toDomain()
            }
            .flowOn(coroutineDispatcher)

    override fun getProductById(id: Int): Flow<ProductDomain> =
        productNetworkDataSource.getProductById(id)
            .map {  responseDetailLego ->
                responseDetailLego.toDomain()
            }
            .flowOn(coroutineDispatcher)

    override suspend fun addProductToCar(product: ShoppingCarDomain) {
        productNetworkDataSource.addProductToCar(product.toEntity())
    }
}
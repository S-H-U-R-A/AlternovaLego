package com.alternova.lego.domain.useCases.products

import com.alternova.lego.domain.repository.home.products.ProductRepository
import com.alternova.lego.domain.model.ResponseLegoDomain
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAllProductsUseCase @Inject constructor(
    private val productsRepository: ProductRepository
) {

    operator fun invoke() : Flow<ResponseLegoDomain> = productsRepository.getAllProducts()

}
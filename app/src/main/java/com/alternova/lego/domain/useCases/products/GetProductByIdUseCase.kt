package com.alternova.lego.domain.useCases.products

import com.alternova.lego.domain.model.ProductDomain
import com.alternova.lego.domain.repository.home.products.ProductRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetProductByIdUseCase @Inject constructor(
    private val productsRepository: ProductRepository
) {

    operator fun invoke(id: Int) : Flow<ProductDomain> = productsRepository.getProductById(id)

}
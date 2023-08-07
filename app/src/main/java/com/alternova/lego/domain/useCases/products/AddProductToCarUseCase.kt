package com.alternova.lego.domain.useCases.products

import com.alternova.lego.domain.model.ProductDomain
import com.alternova.lego.domain.model.ShoppingCarDomain
import com.alternova.lego.domain.repository.home.products.ProductRepository
import javax.inject.Inject

class AddProductToCarUseCase @Inject constructor(
    private val productRepository: ProductRepository
) {

    suspend operator fun invoke(product: ShoppingCarDomain){
        productRepository.addProductToCar(product)
    }

}
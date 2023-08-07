package com.alternova.lego.domain.model

import com.alternova.lego.data.remote.retrofit.model.ResponseLego

data class ListProductsDomain(
    var products: List<ProductDomain>
){
    fun toResponseServices() : ResponseLego {
        val listProductService = this.products.map{
            it.toResponseService()
        }
        return ResponseLego( listProductService  )
    }
}
package com.alternova.lego.data.remote.retrofit.model


import com.alternova.lego.domain.model.ResponseLegoDomain
import com.alternova.lego.domain.model.ProductDomain
import com.google.gson.annotations.SerializedName

data class ResponseLego(
    @SerializedName("products") var products: List<Product>
){
    fun toDomain() : ResponseLegoDomain {

        val listProductDomain: List<ProductDomain> = products.map{ product: Product ->
            product.toDomain()
        }

        return ResponseLegoDomain(listProductDomain)

    }
}

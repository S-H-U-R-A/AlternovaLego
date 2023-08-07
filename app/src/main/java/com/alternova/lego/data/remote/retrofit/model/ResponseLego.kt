package com.alternova.lego.data.remote.retrofit.model

import com.alternova.lego.domain.model.ListProductsDomain
import com.alternova.lego.domain.model.ProductDomain
import com.google.gson.annotations.SerializedName

data class ResponseLego(
    @SerializedName("products") var products: List<Product>
){
    fun toDomain() : ListProductsDomain {
        val listProductDomain: List<ProductDomain> = this.products.map{
            it.toDomain()
        }
        return ListProductsDomain(listProductDomain)
    }
}

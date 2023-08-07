package com.alternova.lego.data.remote.retrofit.model

import com.alternova.lego.domain.model.ProductDomain
import com.google.gson.annotations.SerializedName

data class Product(
    @SerializedName("id")           val id: Int,
    @SerializedName("name")         val name: String,
    @SerializedName("unit_price")   val unitPrice: Int,
    @SerializedName("stock")        val stock: Int,
    @SerializedName("image")        val image: String
){

    fun toDomain() : ProductDomain = ProductDomain(
        this.id,
        this.name,
        this.unitPrice,
        this.stock,
        this.image
    )

}

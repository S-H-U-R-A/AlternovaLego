package com.alternova.lego.data.remote.retrofit.model

import com.alternova.lego.domain.model.ProductDomain
import com.google.gson.annotations.SerializedName

data class ResponseDetailLego(
    @SerializedName("id")           val id: Int,
    @SerializedName("name")         val name: String,
    @SerializedName("unit_price")    val unit_price: Int,
    @SerializedName("stock")        val stock: Int,
    @SerializedName("image")        val image: String,
    @SerializedName("description")  val description: String
){
    fun toDomain() : ProductDomain = ProductDomain(
        this.id,
        this.name,
        this.unit_price,
        this.stock,
        this.image,
        this.description
    )
}
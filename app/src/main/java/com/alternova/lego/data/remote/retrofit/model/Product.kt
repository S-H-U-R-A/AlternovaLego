package com.alternova.lego.data.remote.retrofit.model

import com.google.gson.annotations.SerializedName

data class Product(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("unitPrice") val unit_price: Int,
    @SerializedName("stock") val stock: Int,
    @SerializedName("image") val image: String
)
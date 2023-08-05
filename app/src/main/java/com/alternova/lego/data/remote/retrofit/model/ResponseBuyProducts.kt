package com.alternova.lego.data.remote.retrofit.model

import com.google.gson.annotations.SerializedName

data class ResponseBuyProducts(
    @SerializedName("listProducts")  val products: List<Product>
)
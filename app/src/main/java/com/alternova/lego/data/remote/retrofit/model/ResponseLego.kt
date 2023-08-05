package com.alternova.lego.data.remote.retrofit.model

import com.google.gson.annotations.SerializedName

data class ResponseLego(
    @SerializedName("listProducts") val products: List<Product>
)

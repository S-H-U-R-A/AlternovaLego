package com.alternova.lego.data.remote.retrofit

import com.alternova.lego.data.remote.retrofit.model.ResponseBuyProducts
import com.alternova.lego.data.remote.retrofit.model.ResponseDetailLego
import com.alternova.lego.data.remote.retrofit.model.ResponseLego
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface LegoApiServices {

    @GET("allProducts")
    suspend fun getAllProducts() : ResponseLego

    @GET("detail")
    suspend fun getProductById(
        @Body id: String
    ) : ResponseDetailLego

    @POST("buy")
    suspend fun buyProducts() : ResponseBuyProducts


}
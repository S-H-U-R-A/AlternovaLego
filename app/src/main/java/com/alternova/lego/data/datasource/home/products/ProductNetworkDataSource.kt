package com.alternova.lego.data.datasource.home.products

import com.alternova.lego.data.remote.retrofit.model.ResponseLego
import kotlinx.coroutines.flow.Flow

interface ProductNetworkDataSource {

    fun getAllProducts() : Flow<ResponseLego>



}
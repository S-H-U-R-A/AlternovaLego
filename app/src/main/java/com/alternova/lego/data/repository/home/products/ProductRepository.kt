package com.alternova.lego.data.repository.home.products

import com.alternova.lego.data.remote.retrofit.model.ResponseLego
import com.alternova.lego.domain.model.ListProductsDomain
import kotlinx.coroutines.flow.Flow

interface ProductRepository {

    fun getAllProducts() : Flow<ListProductsDomain>

}

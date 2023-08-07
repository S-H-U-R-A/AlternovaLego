package com.alternova.lego.domain.model

import com.alternova.lego.data.remote.retrofit.model.Product

data class ProductDomain(
    val id: Int,
    val name: String,
    val unitPrice: Int,
    val stock: Int,
    val image: String
){
    fun toResponseService() : Product = Product(
        this.id,
        this.name,
        this.unitPrice,
        this.stock,
        this.image
    )
}
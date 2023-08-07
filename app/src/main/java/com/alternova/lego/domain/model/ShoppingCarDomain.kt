package com.alternova.lego.domain.model

import com.alternova.lego.data.local.database.entity.ShoppingCarEntity

data class ShoppingCarDomain (
    val id:Int,
    val name: String,
    val unitPrice: Int,
    val stock: Int,
    val image: String,
    val idUser: String
){
    fun toEntity() : ShoppingCarEntity = ShoppingCarEntity(
        this.id,
        this.name,
        this.unitPrice,
        this.stock,
        this.image,
        this.idUser
    )
}
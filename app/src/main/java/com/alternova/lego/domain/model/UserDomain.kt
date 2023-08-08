package com.alternova.lego.domain.model

import com.alternova.lego.data.local.database.entity.UserEntity


data class UserDomain(
    val id: String,
    val email: String,
    val password: String
){
    fun toEntity() : UserEntity = UserEntity(
        this.id,
        this.email,
        this.password
    )
}
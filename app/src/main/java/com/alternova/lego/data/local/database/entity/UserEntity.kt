package com.alternova.lego.data.local.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.alternova.lego.domain.model.UserDomain

@Entity(
    tableName = UserEntity.TABLE_NAME
)
data class UserEntity(
    @ColumnInfo(name = "id") @PrimaryKey(autoGenerate = false) val id: String,
    @ColumnInfo(name = "email") val email: String,
    @ColumnInfo(name = "password") val password: String
) {
    companion object {
        const val TABLE_NAME = "user_table"
    }

    fun toDomain() : UserDomain = UserDomain(
        this.id,
        this.email,
        this.password
    )

}

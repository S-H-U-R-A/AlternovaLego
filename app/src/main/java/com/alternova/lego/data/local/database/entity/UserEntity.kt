package com.alternova.lego.data.local.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = UserEntity.TABLE_NAME
)
data class UserEntity(
    @ColumnInfo(name = "id") @PrimaryKey(autoGenerate = false) val id: Int,
    @ColumnInfo(name = "email") val email: String,
    @ColumnInfo(name = "password") val password: String
) {
    companion object {
        const val TABLE_NAME = "user_table"
    }
}

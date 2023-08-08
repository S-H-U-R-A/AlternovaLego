package com.alternova.lego.data.local.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey


@Entity(
    tableName = ShoppingCarEntity.TABLE_NAME,
    foreignKeys = [
        ForeignKey(
            UserEntity::class,
            parentColumns = ["id"],
            childColumns = ["id_user"]
        )
    ],
    indices = [
        Index(value = ["id_user"])
    ]
)
data class ShoppingCarEntity(
    @ColumnInfo(name = "id") @PrimaryKey(autoGenerate = false) val id:Int,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "unit_price") val unitPrice: Int,
    @ColumnInfo(name = "stock") val stock: Int,
    @ColumnInfo(name = "image") val image: String,
    @ColumnInfo(name = "id_user") val idUser: String
){
    companion object{
        const val TABLE_NAME = "shopping_car_table"
    }
}


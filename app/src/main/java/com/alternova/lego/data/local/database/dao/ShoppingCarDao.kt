package com.alternova.lego.data.local.database.dao


import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.alternova.lego.data.local.database.entity.ShoppingCarEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ShoppingCarDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertProductInCar(product: ShoppingCarEntity)

    @Query(
        """
            SELECT * FROM ${ShoppingCarEntity.TABLE_NAME}
        """
    )
    fun getProductsInCar() : Flow< List<ShoppingCarEntity> >

    @Query(
        """
            DELETE FROM ${ShoppingCarEntity.TABLE_NAME} WHERE id = :idProduct
        """
    )
    suspend fun deleteProductInCar(idProduct: Int)

}
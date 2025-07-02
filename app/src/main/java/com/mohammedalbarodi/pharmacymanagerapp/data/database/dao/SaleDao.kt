package com.mohammedalbarodi.pharmacymanagerapp.data.database.dao

import androidx.room.*
import com.mohammedalbarodi.pharmacymanagerapp.data.database.model.Sale

@Dao
interface SaleDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSale(sale: Sale)

    @Query("SELECT * FROM sales")
    suspend fun getAllSales(): List<Sale>
}

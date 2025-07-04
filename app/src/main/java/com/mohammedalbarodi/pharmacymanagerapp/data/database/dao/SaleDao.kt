package com.mohammedalbarodi.pharmacymanagerapp.data.database.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.mohammedalbarodi.pharmacymanagerapp.data.model.Sale

@Dao
interface SaleDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSale(sale: Sale): Long

    @Update
    suspend fun updateSale(sale: Sale): Int

    @Delete
    suspend fun deleteSale(sale: Sale): Int

    @Query("SELECT * FROM sales ORDER BY date DESC")
    fun getAllSales(): LiveData<List<Sale>>

    @Query("SELECT * FROM sales WHERE date BETWEEN :startDate AND :endDate ORDER BY date ASC")
    fun getSalesBetween(startDate: Long, endDate: Long): LiveData<List<Sale>>

    @Query("SELECT SUM(totalPrice) FROM sales")
    suspend fun getTotalSalesAmount(): Double
    
}

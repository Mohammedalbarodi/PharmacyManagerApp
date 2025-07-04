import androidx.lifecycle.LiveData
package com.mohammedalbarodi.pharmacymanagerapp.data.database.dao
import androidx.room.*
import com.mohammedalbarodi.pharmacymanagerapp.data.model.Sale

@Dao
interface SaleDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSale(sale: Sale): Long

    @Query("SELECT * FROM sales ORDER BY date DESC")
    fun getAllSales(): LiveData<List<Sale>>
}

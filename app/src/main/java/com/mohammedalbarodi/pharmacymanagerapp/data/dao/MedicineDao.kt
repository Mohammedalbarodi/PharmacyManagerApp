package com.mohammedalbarodi.pharmacymanagerapp.data.dao

import androidx.room.*
import com.mohammedalbarodi.pharmacymanagerapp.data.model.Medicine

@Dao
interface MedicineDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMedicine(medicine: Medicine)

    @Update
    suspend fun updateMedicine(medicine: Medicine)

    @Delete
    suspend fun deleteMedicine(medicine: Medicine)

    @Query("SELECT * FROM medicines ORDER BY name ASC")
    suspend fun getAllMedicines(): List<Medicine>

    @Query("SELECT * FROM medicines WHERE id = :id")
    suspend fun getMedicineById(id: Int): Medicine?

    @Query("SELECT * FROM medicines WHERE name LIKE '%' || :name || '%'")
    suspend fun searchMedicinesByName(name: String): List<Medicine>

    @Query("SELECT * FROM medicines WHERE barcode = :barcode LIMIT 1")
    suspend fun getMedicineByBarcode(barcode: String): Medicine?

    @Query("SELECT * FROM medicines WHERE expiryDate < :currentDate")
    suspend fun getExpiredMedicines(currentDate: Long): List<Medicine>

    @Query("UPDATE medicines SET quantity = quantity - :soldQuantity WHERE id = :medicineId")
    suspend fun reduceStock(medicineId: Int, soldQuantity: Int)

    @Query("UPDATE medicines SET quantity = quantity + :addedQuantity WHERE id = :medicineId")
    suspend fun increaseStock(medicineId: Int, addedQuantity: Int)

    @Query("SELECT * FROM medicines WHERE quantity <= :threshold")
    suspend fun getLowStockMedicines(threshold: Int): List<Medicine>

    @Query("SELECT COUNT(*) FROM medicines")
    suspend fun getMedicineCount(): Int
}

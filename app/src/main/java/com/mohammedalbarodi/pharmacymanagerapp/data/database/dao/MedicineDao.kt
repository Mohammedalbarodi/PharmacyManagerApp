package com.mohammedalbarodi.pharmacymanagerapp.data.database.dao

import androidx.room.*
import com.mohammedalbarodi.pharmacymanagerapp.data.model.Medicine

@Dao
interface MedicineDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMedicine(medicine: Medicine): Long

    @Update
    suspend fun updateMedicine(medicine: Medicine): Int

    @Delete
    suspend fun deleteMedicine(medicine: Medicine): Int

    @Query("SELECT * FROM medicines")
    suspend fun getAllMedicines(): List<Medicine>
}

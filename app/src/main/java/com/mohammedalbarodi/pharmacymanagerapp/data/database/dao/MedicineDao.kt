package com.mohammedalbarodi.pharmacymanagerapp.data.database.dao

import androidx.room.*
import com.mohammedalbarodi.pharmacymanagerapp.data.database.model.Medicine

@Dao
interface MedicineDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMedicine(medicine: Medicine)

    @Update
    suspend fun updateMedicine(medicine: Medicine)

    @Delete
    suspend fun deleteMedicine(medicine: Medicine)

    @Query("SELECT * FROM medicines")
    suspend fun getAllMedicines(): List<Medicine>
}

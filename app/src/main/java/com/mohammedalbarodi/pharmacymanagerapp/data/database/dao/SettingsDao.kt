package com.mohammedalbarodi.pharmacymanagerapp.data.database.dao

import androidx.room.*
import com.mohammedalbarodi.pharmacymanagerapp.data.model.Settings

@Dao
interface SettingsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(settings: Settings)

    @Query("SELECT * FROM settings WHERE key = :key")
    suspend fun getSetting(key: String): Settings?

    @Query("SELECT * FROM settings")
    suspend fun getAllSettings(): List<Settings>
}

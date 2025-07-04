package com.mohammedalbarodi.pharmacymanagerapp.data.database.dao

import androidx.room.*
import com.mohammedalbarodi.pharmacymanagerapp.data.model.BackupItem

@Dao
interface BackupDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBackup(backupItem: BackupItem)

    @Query("SELECT * FROM backup_items ORDER BY timestamp DESC")
    suspend fun getAllBackups(): List<BackupItem>

    @Delete
    suspend fun deleteBackup(backupItem: BackupItem)

    @Query("DELETE FROM backup_items")
    suspend fun clearAllBackups()
}

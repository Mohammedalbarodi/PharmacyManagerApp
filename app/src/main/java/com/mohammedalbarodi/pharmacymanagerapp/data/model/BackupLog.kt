package com.mohammedalbarodi.pharmacymanager.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "backup_logs")
data class BackupLog(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val backupDate: Long,
    val backupLocation: String,
    val backupType: String
)

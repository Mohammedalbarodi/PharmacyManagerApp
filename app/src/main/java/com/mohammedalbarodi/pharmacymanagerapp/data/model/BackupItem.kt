package com.mohammedalbarodi.pharmacymanagerapp.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "backup_items")
data class BackupItem(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val title: String,
    val content: String,
    val timestamp: Long = System.currentTimeMillis()
)

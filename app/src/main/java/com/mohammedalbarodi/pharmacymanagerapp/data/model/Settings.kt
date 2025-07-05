package com.mohammedalbarodi.pharmacymanagerapp.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "settings")
data class Settings(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val key: String,
    val value: String
)

package com.mohammedalbarodi.pharmacymanager.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "categories")
data class MedicineCategory(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String,
    val description: String?
)

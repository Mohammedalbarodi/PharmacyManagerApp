package com.mohammedalbarodi.pharmacymanagerapp.data.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "medicines")
data class Medicine(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    val name: String,

    val description: String? = null,

    val quantity: Int,

    val price: Double
)

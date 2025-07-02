package com.mohammedalbarodi.pharmacymanagerapp.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "sales")
data class Sale(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val medicineId: Int,
    val quantitySold: Int,
    val totalPrice: Double,
    val date: Long
)

package com.mohammedalbarodi.pharmacymanager.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "expenses")
data class Expense(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val title: String,
    val category: String,
    val amount: Double,
    val expenseDate: Long,
    val notes: String?
)

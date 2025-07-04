package com.mohammedalbarodi.pharmacymanagerapp.data.database.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.mohammedalbarodi.pharmacymanagerapp.data.model.Expense

@Dao
interface ExpenseDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertExpense(expense: Expense): Long

    @Update
    suspend fun updateExpense(expense: Expense)

    @Delete
    suspend fun deleteExpense(expense: Expense)

    @Query("SELECT * FROM expenses ORDER BY date DESC")
    fun getAllExpenses(): LiveData<List<Expense>>

    @Query("SELECT SUM(amount) FROM expenses")
    fun getTotalExpenses(): Double
}

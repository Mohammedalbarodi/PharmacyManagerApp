package com.mohammedalbarodi.pharmacymanagerapp.data.repository

import androidx.lifecycle.LiveData
import com.mohammedalbarodi.pharmacymanagerapp.data.database.dao.ExpenseDao
import com.mohammedalbarodi.pharmacymanagerapp.data.model.Expense
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ExpenseRepository(private val expenseDao: ExpenseDao) {

    val expenses: LiveData<List<Expense>> = expenseRepository.allExpenses

    suspend fun insertExpense(expense: Expense) {
        withContext(Dispatchers.IO) {
            expenseDao.insertExpense(expense)
        }
    }

    suspend fun updateExpense(expense: Expense) {
        withContext(Dispatchers.IO) {
            expenseDao.updateExpense(expense)
        }
    }

    suspend fun deleteExpense(expense: Expense) {
        withContext(Dispatchers.IO) {
            expenseDao.deleteExpense(expense)
        }
    }

    suspend fun getTotalExpenses(): Double {
        return withContext(Dispatchers.IO) {
            expenseDao.getTotalExpenses()
        }
    }
}

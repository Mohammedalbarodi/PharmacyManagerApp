package com.mohammedalbarodi.pharmacymanagerapp.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mohammedalbarodi.pharmacymanagerapp.data.model.Expense
import com.mohammedalbarodi.pharmacymanagerapp.data.repository.ExpenseRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ExpensesViewModel(private val expenseRepository: ExpenseRepository) : ViewModel() {

    val expenses: LiveData<List<Expense>> = expenseRepository.allExpenses

    private val _errorMessage = MutableLiveData<String>()
    val errorMessage: LiveData<String> get() = _errorMessage

    fun addExpense(expense: Expense) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                expenseRepository.insertExpense(expense)
            } catch (e: Exception) {
                _errorMessage.postValue("فشل في إضافة المصروف: ${e.message}")
            }
        }
    }

    fun deleteExpense(expense: Expense) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                expenseRepository.deleteExpense(expense)
            } catch (e: Exception) {
                _errorMessage.postValue("فشل في حذف المصروف: ${e.message}")
            }
        }
    }

    fun updateExpense(expense: Expense) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                expenseRepository.updateExpense(expense)
            } catch (e: Exception) {
                _errorMessage.postValue("فشل في تعديل المصروف: ${e.message}")
            }
        }
    }
}

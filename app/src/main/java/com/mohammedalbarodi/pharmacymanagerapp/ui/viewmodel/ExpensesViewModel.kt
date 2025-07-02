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

    private val _expenses = MutableLiveData<List<Expense>>()
    val expenses: LiveData<List<Expense>> get() = _expenses

    private val _errorMessage = MutableLiveData<String>()
    val errorMessage: LiveData<String> get() = _errorMessage

    init {
        fetchExpenses()
    }

    // جلب كل المصروفات من المستودع
    fun fetchExpenses() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val expenseList = expenseRepository.getAllExpenses()
                _expenses.postValue(expenseList)
            } catch (e: Exception) {
                _errorMessage.postValue("فشل في تحميل المصروفات: ${e.message}")
            }
        }
    }

    // إضافة مصروف جديد
    fun addExpense(expense: Expense) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                expenseRepository.insertExpense(expense)
                fetchExpenses() // تحديث القائمة بعد الإضافة
            } catch (e: Exception) {
                _errorMessage.postValue("فشل في إضافة المصروف: ${e.message}")
            }
        }
    }

    // حذف مصروف
    fun deleteExpense(expense: Expense) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                expenseRepository.deleteExpense(expense)
                fetchExpenses() // تحديث القائمة بعد الحذف
            } catch (e: Exception) {
                _errorMessage.postValue("فشل في حذف المصروف: ${e.message}")
            }
        }
    }

    // تعديل مصروف
    fun updateExpense(expense: Expense) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                expenseRepository.updateExpense(expense)
                fetchExpenses() // تحديث القائمة بعد التعديل
            } catch (e: Exception) {
                _errorMessage.postValue("فشل في تعديل المصروف: ${e.message}")
            }
        }
    }
}

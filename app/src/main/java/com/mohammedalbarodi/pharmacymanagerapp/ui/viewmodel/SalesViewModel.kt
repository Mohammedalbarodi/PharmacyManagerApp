package com.mohammedalbarodi.pharmacymanagerapp.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mohammedalbarodi.pharmacymanagerapp.data.model.Sale
import com.mohammedalbarodi.pharmacymanagerapp.data.repository.SalesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SalesViewModel(private val salesRepository: SalesRepository) : ViewModel() {

    private val _sales = MutableLiveData<List<Sale>>()
    val sales: LiveData<List<Sale>> get() = _sales

    private val _errorMessage = MutableLiveData<String>()
    val errorMessage: LiveData<String> get() = _errorMessage

    init {
        loadSales()
    }

    fun loadSales() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val list = salesRepository.getAllSales()
                _sales.postValue(list)
            } catch (e: Exception) {
                _errorMessage.postValue("فشل في تحميل المبيعات: ${e.message}")
            }
        }
    }

    fun addSale(sale: Sale) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                salesRepository.insertSale(sale)
                loadSales() // تحديث القائمة بعد الإضافة
            } catch (e: Exception) {
                _errorMessage.postValue("فشل في إضافة البيع: ${e.message}")
            }
        }
    }

    fun deleteSale(sale: Sale) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                salesRepository.deleteSale(sale)
                loadSales() // تحديث القائمة بعد الحذف
            } catch (e: Exception) {
                _errorMessage.postValue("فشل في حذف البيع: ${e.message}")
            }
        }
    }
}

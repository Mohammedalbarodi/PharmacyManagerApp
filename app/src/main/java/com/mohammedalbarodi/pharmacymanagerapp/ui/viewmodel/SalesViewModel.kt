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

    val sales: LiveData<List<Sale>> = salesRepository.allSales

    private val _errorMessage = MutableLiveData<String>()
    val errorMessage: LiveData<String> get() = _errorMessage

    fun addSale(sale: Sale) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                salesRepository.insertSale(sale)
                // LiveData سيتحدث تلقائيًا
            } catch (e: Exception) {
                _errorMessage.postValue("فشل في إضافة البيع: ${e.message}")
            }
        }
    }

    fun deleteSale(sale: Sale) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                salesRepository.deleteSale(sale)
                // LiveData سيتحدث تلقائيًا
            } catch (e: Exception) {
                _errorMessage.postValue("فشل في حذف البيع: ${e.message}")
            }
        }
    }
}

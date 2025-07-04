package com.mohammedalbarodi.pharmacymanagerapp.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mohammedalbarodi.pharmacymanagerapp.data.model.Medicine
import com.mohammedalbarodi.pharmacymanagerapp.data.repository.MedicineRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MedicineViewModel(private val medicineRepository: MedicineRepository) : ViewModel() {

    val medicines: LiveData<List<Medicine>> = medicineRepository.allMedicines

    private val _errorMessage = MutableLiveData<String>()
    val errorMessage: LiveData<String> get() = _errorMessage

    fun addMedicine(medicine: Medicine) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                medicineRepository.insertMedicine(medicine)
                // LiveData سيتحدث تلقائيًا
            } catch (e: Exception) {
                _errorMessage.postValue("فشل في إضافة الدواء: ${e.message}")
            }
        }
    }

    fun updateMedicine(medicine: Medicine) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                medicineRepository.updateMedicine(medicine)
                // LiveData سيتحدث تلقائيًا
            } catch (e: Exception) {
                _errorMessage.postValue("فشل في تحديث الدواء: ${e.message}")
            }
        }
    }

    fun deleteMedicine(medicine: Medicine) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                medicineRepository.deleteMedicine(medicine)
                // LiveData سيتحدث تلقائيًا
            } catch (e: Exception) {
                _errorMessage.postValue("فشل في حذف الدواء: ${e.message}")
            }
        }
    }
}

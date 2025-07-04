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

    private val _medicines = MutableLiveData<List<Medicine>>()
    val medicines: LiveData<List<Medicine>> = medicineRepository.allMedicines

    private val _errorMessage = MutableLiveData<String>()
    val errorMessage: LiveData<String> get() = _errorMessage

    init {
        loadMedicines()
    }

    fun loadMedicines() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val list = medicineRepository.getAllMedicines()
                _medicines.postValue(list)
            } catch (e: Exception) {
                _errorMessage.postValue("فشل في تحميل الأدوية: ${e.message}")
            }
        }
    }

    fun addMedicine(medicine: Medicine) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                medicineRepository.insertMedicine(medicine)
                loadMedicines() // تحديث القائمة بعد الإضافة
            } catch (e: Exception) {
                _errorMessage.postValue("فشل في إضافة الدواء: ${e.message}")
            }
        }
    }

    fun updateMedicine(medicine: Medicine) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                medicineRepository.updateMedicine(medicine)
                loadMedicines() // تحديث القائمة بعد التعديل
            } catch (e: Exception) {
                _errorMessage.postValue("فشل في تحديث الدواء: ${e.message}")
            }
        }
    }

    fun deleteMedicine(medicine: Medicine) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                medicineRepository.deleteMedicine(medicine)
                loadMedicines() // تحديث القائمة بعد الحذف
            } catch (e: Exception) {
                _errorMessage.postValue("فشل في حذف الدواء: ${e.message}")
            }
        }
    }
}

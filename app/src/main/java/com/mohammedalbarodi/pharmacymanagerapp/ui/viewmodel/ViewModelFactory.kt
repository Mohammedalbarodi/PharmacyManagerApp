package com.mohammedalbarodi.pharmacymanagerapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mohammedalbarodi.pharmacymanagerapp.data.repository.BackupRepository
import com.mohammedalbarodi.pharmacymanagerapp.data.repository.MedicineRepository

@Suppress("UNCHECKED_CAST")
class ViewModelFactory(
    private val medicineRepository: MedicineRepository,
    private val backupRepository: BackupRepository
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(LoginViewModel::class.java) -> {
                LoginViewModel(medicineRepository) as T
            }
            modelClass.isAssignableFrom(MedicineViewModel::class.java) -> {
                MedicineViewModel(medicineRepository) as T
            }
            modelClass.isAssignableFrom(SettingsViewModel::class.java) -> {
                SettingsViewModel(backupRepository) as T
            }
            // أضف هنا باقي ViewModels عند الحاجة
            else -> throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
        }
    }
}

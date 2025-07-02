package com.mohammedalbarodi.pharmacymanagerapp.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mohammedalbarodi.pharmacymanagerapp.data.repository.BackupRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SettingsViewModel(
    private val backupRepository: BackupRepository
) : ViewModel() {

    private val _backupStatus = MutableLiveData<String>()
    val backupStatus: LiveData<String> get() = _backupStatus

    private val _restoreStatus = MutableLiveData<String>()
    val restoreStatus: LiveData<String> get() = _restoreStatus

    fun backupData() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                backupRepository.backupDatabase()
                _backupStatus.postValue("تم إنشاء النسخة الاحتياطية بنجاح.")
            } catch (e: Exception) {
                _backupStatus.postValue("فشل في إنشاء النسخة الاحتياطية: ${e.message}")
            }
        }
    }

    fun restoreData() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                backupRepository.restoreDatabase()
                _restoreStatus.postValue("تم استعادة النسخة الاحتياطية بنجاح.")
            } catch (e: Exception) {
                _restoreStatus.postValue("فشل في استعادة النسخة الاحتياطية: ${e.message}")
            }
        }
    }
}

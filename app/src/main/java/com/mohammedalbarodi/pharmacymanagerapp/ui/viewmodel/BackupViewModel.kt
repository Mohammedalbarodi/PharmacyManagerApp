package com.mohammedalbarodi.pharmacymanagerapp.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.io.File

class BackupViewModel : ViewModel() {

    private val _backupStatus = MutableLiveData<Boolean>()
    val backupStatus: LiveData<Boolean> get() = _backupStatus

    private val _errorMessage = MutableLiveData<String>()
    val errorMessage: LiveData<String> get() = _errorMessage

    // دالة لعمل نسخة احتياطية من بيانات التطبيق
    fun createBackup(backupDir: File, databaseFile: File) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                if (!backupDir.exists()) {
                    backupDir.mkdirs()
                }

                val backupFile = File(backupDir, "pharmacy_backup.db")

                databaseFile.copyTo(backupFile, overwrite = true)

                _backupStatus.postValue(true)
            } catch (e: Exception) {
                _errorMessage.postValue("فشل في إنشاء النسخة الاحتياطية: ${e.message}")
                _backupStatus.postValue(false)
            }
        }
    }
}

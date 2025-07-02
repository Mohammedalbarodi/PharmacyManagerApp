package com.mohammedalbarodi.pharmacymanagerapp.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mohammedalbarodi.pharmacymanagerapp.data.repository.UserRepository
import com.mohammedalbarodi.pharmacymanagerapp.data.model.User
import kotlinx.coroutines.launch

class AddUserViewModel(private val userRepository: UserRepository) : ViewModel() {

    private val _addUserResult = MutableLiveData<Boolean>()
    val addUserResult: LiveData<Boolean> get() = _addUserResult

    private val _errorMessage = MutableLiveData<String>()
    val errorMessage: LiveData<String> get() = _errorMessage

    // دالة لإضافة مستخدم جديد
    fun addUser(user: User) {
        if (user.username.isBlank() || user.password.isBlank()) {
            _errorMessage.value = "اسم المستخدم وكلمة المرور لا يمكن أن يكونا فارغين"
            _addUserResult.value = false
            return
        }

        viewModelScope.launch {
            try {
                userRepository.insertUser(user)
                _addUserResult.value = true
            } catch (e: Exception) {
                _errorMessage.value = "حدث خطأ أثناء إضافة المستخدم: ${e.message}"
                _addUserResult.value = false
            }
        }
    }
}

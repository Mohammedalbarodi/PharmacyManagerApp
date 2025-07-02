package com.mohammedalbarodi.pharmacymanagerapp.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mohammedalbarodi.pharmacymanagerapp.data.model.User
import com.mohammedalbarodi.pharmacymanagerapp.data.repository.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LoginViewModel(private val userRepository: UserRepository) : ViewModel() {

    private val _loginSuccess = MutableLiveData<Boolean>()
    val loginSuccess: LiveData<Boolean> get() = _loginSuccess

    private val _errorMessage = MutableLiveData<String>()
    val errorMessage: LiveData<String> get() = _errorMessage

    // تنفيذ تسجيل الدخول
    fun login(username: String, password: String) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val user: User? = userRepository.getUserByUsername(username)
                if (user != null && user.password == password) {
                    _loginSuccess.postValue(true)
                } else {
                    _loginSuccess.postValue(false)
                    _errorMessage.postValue("اسم المستخدم أو كلمة المرور غير صحيحة")
                }
            } catch (e: Exception) {
                _loginSuccess.postValue(false)
                _errorMessage.postValue("حدث خطأ أثناء تسجيل الدخول: ${e.message}")
            }
        }
    }

    // يمكنك إضافة وظيفة لإنشاء مستخدم جديد إذا أردت:
    fun registerUser(newUser: User) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val existingUser = userRepository.getUserByUsername(newUser.username)
                if (existingUser == null) {
                    userRepository.insertUser(newUser)
                    _loginSuccess.postValue(true)
                } else {
                    _errorMessage.postValue("اسم المستخدم موجود بالفعل")
                }
            } catch (e: Exception) {
                _errorMessage.postValue("فشل في التسجيل: ${e.message}")
            }
        }
    }
}

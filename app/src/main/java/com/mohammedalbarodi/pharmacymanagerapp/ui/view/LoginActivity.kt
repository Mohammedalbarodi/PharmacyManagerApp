package com.mohammedalbarodi.pharmacymanagerapp.ui.view

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.mohammedalbarodi.pharmacymanagerapp.databinding.ActivityLoginBinding
import com.mohammedalbarodi.pharmacymanagerapp.ui.viewmodel.LoginViewModel

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private val loginViewModel: LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener {
            val username = binding.etUsername.text.toString().trim()
            val password = binding.etPassword.text.toString().trim()

            if (username.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "الرجاء إدخال اسم المستخدم وكلمة المرور", Toast.LENGTH_SHORT).show()
            } else {
                loginViewModel.login(username, password).observe(this) { success ->
                    if (success) {
                        Toast.makeText(this, "تم تسجيل الدخول بنجاح", Toast.LENGTH_SHORT).show()
                        startActivity(Intent(this, MainActivity::class.java))
                        finish()
                    } else {
                        Toast.makeText(this, "بيانات الدخول غير صحيحة", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }
}

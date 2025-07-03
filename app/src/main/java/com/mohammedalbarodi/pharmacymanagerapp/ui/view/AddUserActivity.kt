package com.mohammedalbarodi.pharmacymanagerapp.ui.view

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class AddUserActivity : AppCompatActivity() {

    private lateinit var etUsername: EditText
    private lateinit var etPassword: EditText
    private lateinit var etConfirmPassword: EditText
    private lateinit var btnSave: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_user)  // لاحقًا سننشئ هذا layout

        etUsername = findViewById(R.id.etUsername)
        etPassword = findViewById(R.id.etPassword)
        etConfirmPassword = findViewById(R.id.etConfirmPassword)
        btnSave = findViewById(R.id.btnAddUser)

        btnSave.setOnClickListener {
            saveUser()
        }
    }

    private fun saveUser() {
        val username = etUsername.text.toString().trim()
        val password = etPassword.text.toString()
        val confirmPassword = etConfirmPassword.text.toString()

        if (username.isEmpty()) {
            Toast.makeText(this, "يرجى إدخال اسم المستخدم", Toast.LENGTH_SHORT).show()
            return
        }
        if (password.isEmpty()) {
            Toast.makeText(this, "يرجى إدخال كلمة المرور", Toast.LENGTH_SHORT).show()
            return
        }
        if (password != confirmPassword) {
            Toast.makeText(this, "كلمة المرور وتأكيدها غير متطابقين", Toast.LENGTH_SHORT).show()
            return
        }

        // هنا سنضيف الكود لاحقًا لحفظ المستخدم في قاعدة البيانات

        Toast.makeText(this, "تم حفظ المستخدم بنجاح (مؤقتاً)", Toast.LENGTH_SHORT).show()

        // بعد الحفظ، ممكن نفرغ الحقول أو نرجع للخلف
        etUsername.text.clear()
        etPassword.text.clear()
        etConfirmPassword.text.clear()
    }
}

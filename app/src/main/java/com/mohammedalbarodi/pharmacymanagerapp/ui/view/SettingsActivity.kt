package com.mohammedalbarodi.pharmacymanagerapp.ui.view

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.mohammedalbarodi.pharmacymanagerapp.R

class SettingsActivity : AppCompatActivity() {

    // private lateinit var btnChangePassword: Button
    private lateinit var btnLogout: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        // btnChangePassword = findViewById(R.id.btnChangePassword)
        btnLogout = findViewById(R.id.btnLogout)

        // btnChangePassword.setOnClickListener {
        //     // لاحقًا: افتح واجهة تغيير كلمة المرور
        //     // startActivity(Intent(this, ChangePasswordActivity::class.java))
        // }

        btnLogout.setOnClickListener {
            confirmLogout()
        }
    }

    private fun confirmLogout() {
        AlertDialog.Builder(this)
            .setTitle("تسجيل الخروج")
            .setMessage("هل أنت متأكد أنك تريد تسجيل الخروج؟")
            .setPositiveButton("نعم") { _, _ ->
                performLogout()
            }
            .setNegativeButton("إلغاء", null)
            .show()
    }

    private fun performLogout() {
        val intent = Intent(this, LoginActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent)
    }
}

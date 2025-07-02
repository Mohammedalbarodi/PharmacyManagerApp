package com.mohammedalbarodi.pharmacymanagerapp.ui.view

import android.app.AlertDialog
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.mohammedalbarodi.pharmacymanagerapp.R

class BackupActivity : AppCompatActivity() {

    private lateinit var btnBackup: Button
    private lateinit var btnRestore: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_backup)

        btnBackup = findViewById(R.id.btnBackup)
        btnRestore = findViewById(R.id.btnRestore)

        btnBackup.setOnClickListener {
            performBackup()
        }

        btnRestore.setOnClickListener {
            confirmRestore()
        }
    }

    private fun performBackup() {
        // لاحقًا: سيتم تنفيذ عملية النسخ الاحتياطي الفعلية هنا
        Toast.makeText(this, "تم إنشاء نسخة احتياطية بنجاح!", Toast.LENGTH_SHORT).show()
    }

    private fun confirmRestore() {
        AlertDialog.Builder(this)
            .setTitle("استعادة النسخة")
            .setMessage("هل أنت متأكد أنك تريد استعادة البيانات من النسخة الاحتياطية؟ سيتم فقدان البيانات الحالية.")
            .setPositiveButton("نعم") { _, _ ->
                performRestore()
            }
            .setNegativeButton("إلغاء", null)
            .show()
    }

    private fun performRestore() {
        // لاحقًا: سيتم تنفيذ استعادة النسخة هنا
        Toast.makeText(this, "تمت استعادة النسخة الاحتياطية!", Toast.LENGTH_SHORT).show()
    }
}

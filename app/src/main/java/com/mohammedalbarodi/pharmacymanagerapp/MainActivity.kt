package com.mohammedalbarodi.pharmacymanagerapp

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import com.mohammedalbarodi.pharmacymanagerapp.data.database.AppDatabase
import com.mohammedalbarodi.pharmacymanagerapp.data.model.Medicine

class MainActivity : AppCompatActivity() {

    private lateinit var db: AppDatabase
    private lateinit var medicineText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        medicineText = TextView(this)
        setContentView(medicineText)

        db = AppDatabase.getInstance(this)

        CoroutineScope(Dispatchers.IO).launch {
            // إدخال دواء تجريبي في قاعدة البيانات
            val testMedicine = Medicine(
                name = "باراسيتامول",
                brand = "Panadol",
                categoryId = null,
                quantity = 25,
                price = 3.5,
                expiryDate = System.currentTimeMillis() + 1000000000, // سنة تقريبًا
                barcode = "1234567890",
                location = "الرف A1",
                notes = "جرعة كل 6 ساعات"
            )
            db.medicineDao().insertMedicine(testMedicine)

            // استدعاء جميع الأدوية من القاعدة
            val medicineList = db.medicineDao().getAllMedicines()

            // عرض النتيجة على الشاشة
            val displayText = medicineList.joinToString("\n") { "${it.name} - ${it.quantity} قطعة" }

            // التحديث داخل واجهة المستخدم
            CoroutineScope(Dispatchers.Main).launch {
                medicineText.text = displayText
            }
        }
    }
}

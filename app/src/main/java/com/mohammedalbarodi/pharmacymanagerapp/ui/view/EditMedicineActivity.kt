package com.mohammedalbarodi.pharmacymanagerapp.ui.view

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.mohammedalbarodi.pharmacymanagerapp.databinding.ActivityEditMedicineBinding
import com.mohammedalbarodi.pharmacymanagerapp.data.database.AppDatabase
import com.mohammedalbarodi.pharmacymanagerapp.data.model.Medicine
import com.mohammedalbarodi.pharmacymanagerapp.data.repository.MedicineRepository
import com.mohammedalbarodi.pharmacymanagerapp.ui.viewmodel.MedicineViewModel
import com.mohammedalbarodi.pharmacymanagerapp.ui.viewmodel.MedicineViewModelFactory

class EditMedicineActivity : AppCompatActivity() {

    private lateinit var binding: ActivityEditMedicineBinding

    // إنشاء الـ ViewModel باستخدام Factory مخصص
    private val viewModel: MedicineViewModel by viewModels {
        val medicineDao = AppDatabase.getDatabase(applicationContext).medicineDao()
        val medicineRepository = MedicineRepository(medicineDao)
        MedicineViewModelFactory(medicineRepository)
    }

    private var currentMedicine: Medicine? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditMedicineBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val medicine = intent.getSerializableExtra("medicine") as? Medicine
        if (medicine == null) {
            Toast.makeText(this, "خطأ في تحميل البيانات", Toast.LENGTH_SHORT).show()
            finish()
            return
        }

        currentMedicine = medicine

        // تعبئة الحقول بالبيانات الحالية
        binding.etMedicineName.setText(medicine.name)
        binding.etMedicineQuantity.setText(medicine.quantity.toString())
        binding.etMedicinePrice.setText(medicine.price.toString())

        binding.btnUpdateMedicine.setOnClickListener {
            val updatedName = binding.etMedicineName.text.toString().trim()
            val updatedQuantity = binding.etMedicineQuantity.text.toString().toIntOrNull()
            val updatedPrice = binding.etMedicinePrice.text.toString().toDoubleOrNull()

            if (updatedName.isEmpty() || updatedQuantity == null || updatedPrice == null) {
                Toast.makeText(this, "يرجى تعبئة الحقول بشكل صحيح", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            currentMedicine?.let {
                val updatedMedicine = it.copy(
                    name = updatedName,
                    quantity = updatedQuantity,
                    price = updatedPrice
                )
                viewModel.updateMedicine(updatedMedicine)
                Toast.makeText(this, "تم تحديث بيانات الدواء", Toast.LENGTH_SHORT).show()
                finish()
            }
        }
    }
}

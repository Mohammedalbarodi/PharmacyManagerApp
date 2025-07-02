package com.mohammedalbarodi.pharmacymanagerapp.ui.view

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.mohammedalbarodi.pharmacymanagerapp.databinding.ActivityAddMedicineBinding
import com.mohammedalbarodi.pharmacymanagerapp.ui.viewmodel.MedicineViewModel
import com.mohammedalbarodi.pharmacymanagerapp.data.model.Medicine

class AddMedicineActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddMedicineBinding
    private val viewModel: MedicineViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddMedicineBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSaveMedicine.setOnClickListener {
            val name = binding.etMedicineName.text.toString().trim()
            val quantity = binding.etMedicineQuantity.text.toString().toIntOrNull()
            val price = binding.etMedicinePrice.text.toString().toDoubleOrNull()

            if (name.isEmpty() || quantity == null || price == null) {
                Toast.makeText(this, "يرجى تعبئة كل الحقول بشكل صحيح", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val newMedicine = Medicine(name = name, quantity = quantity, price = price)
            viewModel.insertMedicine(newMedicine)
            Toast.makeText(this, "تمت إضافة الدواء", Toast.LENGTH_SHORT).show()
            finish()
        }
    }
}

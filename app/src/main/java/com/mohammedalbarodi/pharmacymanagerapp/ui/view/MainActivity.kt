package com.mohammedalbarodi.pharmacymanagerapp.ui.view

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mohammedalbarodi.pharmacymanagerapp.R
import com.mohammedalbarodi.pharmacymanagerapp.data.model.Medicine
import com.mohammedalbarodi.pharmacymanagerapp.ui.adapter.MedicineAdapter

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: MedicineAdapter
    private val medicinesList = mutableListOf<Medicine>()  // مؤقتًا بيانات ثابتة

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerViewMedicines)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // مؤقت: تحميل بيانات ثابتة، لاحقًا نربط مع ViewModel/قاعدة بيانات
        loadMedicines()

        adapter = MedicineAdapter(medicinesList)
        recyclerView.adapter = adapter

        // أزرار التنقل للشاشات المختلفة
        findViewById<Button>(R.id.btnAddMedicine).setOnClickListener {
            startActivity(Intent(this, AddMedicineActivity::class.java))
        }
        findViewById<Button>(R.id.btnSales).setOnClickListener {
            startActivity(Intent(this, SalesActivity::class.java))
        }
        findViewById<Button>(R.id.btnSuppliers).setOnClickListener {
            startActivity(Intent(this, SuppliersActivity::class.java))
        }
        findViewById<Button>(R.id.btnExpenses).setOnClickListener {
            startActivity(Intent(this, ExpensesActivity::class.java))
        }
        findViewById<Button>(R.id.btnSettings).setOnClickListener {
            startActivity(Intent(this, SettingsActivity::class.java))
        }
    }

    private fun loadMedicines() {
        // بيانات تجريبية مؤقتة، لاحقًا تستبدل بتحميل البيانات من قاعدة البيانات
        medicinesList.add(Medicine(1, "باراسيتامول", 50, 10.0))
        medicinesList.add(Medicine(2, "أموكسيسيلين", 30, 25.0))
        medicinesList.add(Medicine(3, "إيبوبروفين", 40, 15.5))
    }
}

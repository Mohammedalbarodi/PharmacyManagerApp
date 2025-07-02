package com.mohammedalbarodi.pharmacymanagerapp.ui.view

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mohammedalbarodi.pharmacymanagerapp.R
import com.mohammedalbarodi.pharmacymanagerapp.ui.adapter.ExpensesAdapter
import com.mohammedalbarodi.pharmacymanagerapp.data.model.Expense

class ExpensesActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: ExpensesAdapter
    private val expensesList = mutableListOf<Expense>() // مؤقتًا، سيتم استبداله لاحقًا بالبيانات من قاعدة البيانات

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_expenses)

        recyclerView = findViewById(R.id.recyclerViewExpenses)
        adapter = ExpensesAdapter(expensesList)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        loadExpenses()
    }

    private fun loadExpenses() {
        // حاليًا بيانات وهمية لاختبار الواجهة
        expensesList.add(Expense("إيجار", "1500", "لشهر يوليو", "2025-07-01"))
        expensesList.add(Expense("فاتورة كهرباء", "350", "", "2025-07-01"))

        adapter.notifyDataSetChanged()

        Toast.makeText(this, "تم تحميل ${expensesList.size} مصروفات", Toast.LENGTH_SHORT).show()
    }
}

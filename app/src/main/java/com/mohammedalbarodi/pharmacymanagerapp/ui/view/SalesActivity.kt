package com.mohammedalbarodi.pharmacymanagerapp.ui.view

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.mohammedalbarodi.pharmacymanagerapp.databinding.ActivitySalesBinding
import com.mohammedalbarodi.pharmacymanagerapp.ui.adapter.SalesAdapter
import com.mohammedalbarodi.pharmacymanagerapp.ui.viewmodel.SalesViewModel

class SalesActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySalesBinding
    private val viewModel: SalesViewModel by viewModels()
    private lateinit var salesAdapter: SalesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySalesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupRecyclerView()
        observeViewModel()

        binding.btnAddSale.setOnClickListener {
            // هنا ستتم إضافة منطق إضافة بيع جديد لاحقًا
            Toast.makeText(this, "ميزة إضافة بيع قيد التطوير", Toast.LENGTH_SHORT).show()
        }
    }

    private fun setupRecyclerView() {
        salesAdapter = SalesAdapter()
        binding.recyclerViewSales.apply {
            layoutManager = LinearLayoutManager(this@SalesActivity)
            adapter = salesAdapter
        }
    }

    private fun observeViewModel() {
        viewModel.salesList.observe(this) { sales ->
            salesAdapter.submitList(sales)
        }
    }
}

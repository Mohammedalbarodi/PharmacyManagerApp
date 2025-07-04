package com.mohammedalbarodi.pharmacymanagerapp.ui.view

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.mohammedalbarodi.pharmacymanagerapp.databinding.ActivitySalesBinding
import com.mohammedalbarodi.pharmacymanagerapp.data.model.Sale
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
            Toast.makeText(this, "ميزة إضافة بيع قيد التطوير", Toast.LENGTH_SHORT).show()
        }
    }

    private fun setupRecyclerView() {
        salesAdapter = SalesAdapter { sale: Sale ->
            Toast.makeText(this, "تم اختيار البيع رقم ${sale.id}", Toast.LENGTH_SHORT).show()
        }

        binding.salesList.apply {
            layoutManager = LinearLayoutManager(this@SalesActivity)
            adapter = salesAdapter
        }
    }

    private fun observeViewModel() {
        viewModel.sales.observe(this) { sales ->
            salesAdapter.submitList(sales)
        }
    }
}

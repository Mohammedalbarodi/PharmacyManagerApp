package com.mohammedalbarodi.pharmacymanagerapp.ui.view

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.mohammedalbarodi.pharmacymanagerapp.databinding.ActivityMedicinesListBinding
import com.mohammedalbarodi.pharmacymanagerapp.ui.adapter.MedicineAdapter
import com.mohammedalbarodi.pharmacymanagerapp.ui.viewmodel.MedicineViewModel

class MedicinesListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMedicinesListBinding
    private val medicineViewModel: MedicineViewModel by viewModels()
    private lateinit var adapter: MedicineAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMedicinesListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = MedicineAdapter()
        binding.recyclerViewMedicines.layoutManager = LinearLayoutManager(this)
        binding.recyclerViewMedicines.adapter = adapter

        medicineViewModel.allMedicines.observe(this, Observer { medicines ->
            adapter.submitList(medicines)
        })
    }
}

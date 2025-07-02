package com.yourname.pharmacymanagerapp.ui.view

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.yourname.pharmacymanagerapp.ui.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // لاحقاً نربط هنا ملف الواجهة xml 
        setContentView(android.R.layout.simple_list_item_1) // مؤقتاً واجهة بسيطة
    }
}

package com.mohammedalbarodi.pharmacymanagerapp.ui.view

import android.app.DatePickerDialog
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.mohammedalbarodi.pharmacymanagerapp.R
import java.text.SimpleDateFormat
import java.util.*

class AddExpenseActivity : AppCompatActivity() {

    private lateinit var etType: EditText
    private lateinit var etAmount: EditText
    private lateinit var etNotes: EditText
    private lateinit var btnDate: Button
    private lateinit var btnSave: Button
    private lateinit var tvSelectedDate: TextView

    private var selectedDate: Calendar = Calendar.getInstance()
    private val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_expense)

        etType = findViewById(R.id.etType)
        etAmount = findViewById(R.id.etAmount)
        etNotes = findViewById(R.id.etNotes)
        btnDate = findViewById(R.id.btnPickDate)
        btnSave = findViewById(R.id.btnSave)
        tvSelectedDate = findViewById(R.id.tvSelectedDate)

        updateDateInView()

        btnDate.setOnClickListener {
            showDatePicker()
        }

        btnSave.setOnClickListener {
            saveExpense()
        }
    }

    private fun showDatePicker() {
        val year = selectedDate.get(Calendar.YEAR)
        val month = selectedDate.get(Calendar.MONTH)
        val day = selectedDate.get(Calendar.DAY_OF_MONTH)

        DatePickerDialog(this, { _, y, m, d ->
            selectedDate.set(y, m, d)
            updateDateInView()
        }, year, month, day).show()
    }

    private fun updateDateInView() {
        tvSelectedDate.text = dateFormat.format(selectedDate.time)
    }

    private fun saveExpense() {
        val type = etType.text.toString().trim()
        val amount = etAmount.text.toString().trim()
        val notes = etNotes.text.toString().trim()
        val date = dateFormat.format(selectedDate.time)

        if (type.isEmpty() || amount.isEmpty()) {
            Toast.makeText(this, "يرجى ملء كل الحقول المطلوبة", Toast.LENGTH_SHORT).show()
            return
        }

        // لاحقًا سيتم الحفظ في قاعدة البيانات
        Toast.makeText(this, "تم حفظ المصروف بنجاح", Toast.LENGTH_SHORT).show()
        finish()
    }
}

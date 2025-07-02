package com.mohammedalbarodi.pharmacymanagerapp.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.mohammedalbarodi.pharmacymanagerapp.data.database.dao.ExpenseDao
import com.mohammedalbarodi.pharmacymanagerapp.data.database.dao.MedicineDao
import com.mohammedalbarodi.pharmacymanagerapp.data.database.dao.SaleDao
import com.mohammedalbarodi.pharmacymanagerapp.data.database.dao.UserDao
import com.mohammedalbarodi.pharmacymanagerapp.data.model.Expense
import com.mohammedalbarodi.pharmacymanagerapp.data.model.Medicine
import com.mohammedalbarodi.pharmacymanagerapp.data.model.Sale
import com.mohammedalbarodi.pharmacymanagerapp.data.model.User

@Database(
    entities = [Medicine::class, Expense::class, Sale::class, User::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun medicineDao(): MedicineDao

    abstract fun expenseDao(): ExpenseDao

    abstract fun saleDao(): SaleDao

    abstract fun userDao(): UserDao
}

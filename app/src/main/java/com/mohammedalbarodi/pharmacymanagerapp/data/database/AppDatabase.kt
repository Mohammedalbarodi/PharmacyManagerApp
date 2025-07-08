package com.mohammedalbarodi.pharmacymanagerapp.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.mohammedalbarodi.pharmacymanagerapp.data.model.Medicine
import com.mohammedalbarodi.pharmacymanagerapp.data.dao.MedicineDao
// استدعاء باقي الكيانات و DAO عند إضافتها لاحقًا

@Database(
    entities = [Medicine::class /* + باقي الكيانات */],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun medicineDao(): MedicineDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "pharmacy.db"
                ).build().also { INSTANCE = it }
            }
        }
    }
}

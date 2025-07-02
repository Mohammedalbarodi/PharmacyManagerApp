package com.mohammedalbarodi.pharmacymanagerapp

import android.app.Application
import androidx.room.Room
import com.mohammedalbarodi.pharmacymanagerapp.data.database.AppDatabase

class PharmacyManagerApp : Application() {

    companion object {
        // متغير ثابت للوصول لقاعدة البيانات من أي مكان
        lateinit var database: AppDatabase
            private set
    }

    override fun onCreate() {
        super.onCreate()

        // إنشاء قاعدة البيانات باستخدام Room
        database = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            "pharmacy_manager_db"
        )
            // لحذف البيانات والبدء من جديد عند تعديل الهيكل (يمكنك تغييره حسب الحاجة)
            .fallbackToDestructiveMigration()
            .build()
    }
}

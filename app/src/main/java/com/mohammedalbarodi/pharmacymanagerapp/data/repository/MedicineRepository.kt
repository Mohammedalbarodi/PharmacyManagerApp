package com.mohammedalbarodi.pharmacymanagerapp.data.repository

import androidx.lifecycle.LiveData
import com.mohammedalbarodi.pharmacymanagerapp.data.database.dao.MedicineDao
import com.mohammedalbarodi.pharmacymanagerapp.data.database.model.Medicine
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MedicineRepository(private val medicineDao: MedicineDao) {

    val allMedicines: LiveData<List<Medicine>> = medicineDao.getAllMedicines()

    suspend fun insertMedicine(medicine: Medicine) {
        withContext(Dispatchers.IO) {
            medicineDao.insertMedicine(medicine)
        }
    }

    suspend fun updateMedicine(medicine: Medicine) {
        withContext(Dispatchers.IO) {
            medicineDao.updateMedicine(medicine)
        }
    }

    suspend fun deleteMedicine(medicine: Medicine) {
        withContext(Dispatchers.IO) {
            medicineDao.deleteMedicine(medicine)
        }
    }

    suspend fun getMedicineById(id: Int): Medicine? {
        return withContext(Dispatchers.IO) {
            medicineDao.getMedicineById(id)
        }
    }

    fun searchMedicines(query: String): LiveData<List<Medicine>> {
        return medicineDao.searchMedicines("%$query%")
    }
}

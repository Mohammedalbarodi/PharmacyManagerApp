package com.mohammedalbarodi.pharmacymanagerapp.data.repository

import androidx.lifecycle.LiveData
import com.mohammedalbarodi.pharmacymanagerapp.data.database.dao.SaleDao
import com.mohammedalbarodi.pharmacymanagerapp.data.database.model.Sale
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class SaleRepository(private val saleDao: SaleDao) {

    val allSales: LiveData<List<Sale>> = saleDao.getAllSales()

    suspend fun insertSale(sale: Sale) {
        withContext(Dispatchers.IO) {
            saleDao.insertSale(sale)
        }
    }

    suspend fun updateSale(sale: Sale) {
        withContext(Dispatchers.IO) {
            saleDao.updateSale(sale)
        }
    }

    suspend fun deleteSale(sale: Sale) {
        withContext(Dispatchers.IO) {
            saleDao.deleteSale(sale)
        }
    }

    fun getSalesBetween(startDate: Long, endDate: Long): LiveData<List<Sale>> {
        return saleDao.getSalesBetween(startDate, endDate)
    }

    suspend fun getTotalSalesAmount(): Double {
        return withContext(Dispatchers.IO) {
            saleDao.getTotalSalesAmount()
        }
    }
}

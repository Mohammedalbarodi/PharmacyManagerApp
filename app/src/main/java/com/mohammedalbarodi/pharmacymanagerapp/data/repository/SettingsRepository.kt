package com.mohammedalbarodi.pharmacymanagerapp.data.repository

import com.mohammedalbarodi.pharmacymanagerapp.data.database.dao.SettingsDao
import com.mohammedalbarodi.pharmacymanagerapp.data.model.Settings
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class SettingsRepository(private val settingsDao: SettingsDao) {

    suspend fun getSettings(): Settings? {
        return withContext(Dispatchers.IO) {
            settingsDao.getSettings()
        }
    }

    suspend fun saveSettings(settings: Settings) {
        withContext(Dispatchers.IO) {
            settingsDao.insertOrUpdateSettings(settings)
        }
    }

    suspend fun resetSettingsToDefault() {
        withContext(Dispatchers.IO) {
            val defaultSettings = Settings(
                id = 1,
                language = "ar",
                notificationsEnabled = true,
                theme = "light"
            )
            settingsDao.insertOrUpdateSettings(defaultSettings)
        }
    }
}

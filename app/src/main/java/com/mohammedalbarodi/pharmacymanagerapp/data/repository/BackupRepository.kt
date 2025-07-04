package com.mohammedalbarodi.pharmacymanagerapp.data.repository

import android.content.Context
import android.os.Environment
import java.io.File
import java.io.FileOutputStream
import java.io.IOException

class BackupRepository(private val context: Context) {

    /**
     * وظيفة تقوم بعمل نسخة احتياطية لقاعدة البيانات في مجلد خارجي
     */
    fun backupDatabase(databaseName: String = "pharmacy_db"): Boolean {
        val dbFile = context.getDatabasePath(databaseName)
        val backupDir = File(Environment.getExternalStorageDirectory(), "PharmacyBackup")

        if (!backupDir.exists()) {
            backupDir.mkdirs()
        }

        val backupFile = File(backupDir, "$databaseName.bak")

        return try {
            val input = dbFile.inputStream()
            val output = FileOutputStream(backupFile)

            val buffer = ByteArray(1024)
            var length: Int

            while (input.read(buffer).also { length = it } > 0) {
                output.write(buffer, 0, length)
            }

            input.close()
            output.flush()
            output.close()

            true
        } catch (e: IOException) {
            e.printStackTrace()
            false
        }
    }

    /**
     * وظيفة تقوم باستعادة قاعدة البيانات من النسخة الاحتياطية
     */
    fun restoreDatabase(databaseName: String = "pharmacy_db"): Boolean {
        val dbFile = context.getDatabasePath(databaseName)
        val backupFile = File(Environment.getExternalStorageDirectory(), "PharmacyBackup/$databaseName.bak")

        return try {
            if (backupFile.exists()) {
                val input = backupFile.inputStream()
                val output = FileOutputStream(dbFile)

                val buffer = ByteArray(1024)
                var length: Int

                while (input.read(buffer).also { length = it } > 0) {
                    output.write(buffer, 0, length)
                }

                input.close()
                output.flush()
                output.close()

                true
            } else {
                false
            }
        } catch (e: IOException) {
            e.printStackTrace()
            false
        }
    }
}

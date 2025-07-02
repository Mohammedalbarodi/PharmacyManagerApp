package com.mohammedalbarodi.pharmacymanagerapp.data.repository

import com.mohammedalbarodi.pharmacymanagerapp.data.database.dao.UserDao
import com.mohammedalbarodi.pharmacymanagerapp.data.database.model.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class UserRepository(private val userDao: UserDao) {

    suspend fun login(username: String, password: String): User? {
        return withContext(Dispatchers.IO) {
            userDao.getUserByUsernameAndPassword(username, password)
        }
    }

    suspend fun getUserByUsername(username: String): User? {
        return withContext(Dispatchers.IO) {
            userDao.getUserByUsername(username)
        }
    }

    suspend fun insertUser(user: User) {
        withContext(Dispatchers.IO) {
            userDao.insertUser(user)
        }
    }

    suspend fun deleteUser(user: User) {
        withContext(Dispatchers.IO) {
            userDao.deleteUser(user)
        }
    }

    suspend fun updateUser(user: User) {
        withContext(Dispatchers.IO) {
            userDao.updateUser(user)
        }
    }

    suspend fun getAllUsers(): List<User> {
        return withContext(Dispatchers.IO) {
            userDao.getAllUsers()
        }
    }
}

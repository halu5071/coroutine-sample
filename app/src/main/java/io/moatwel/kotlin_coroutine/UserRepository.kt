package io.moatwel.kotlin_coroutine

import kotlinx.coroutines.experimental.Deferred

class UserRepository {
    fun loadHalu(): Deferred<User?> {
        val datasource = UserDataSource()
        return datasource.loadHalu()
    }

    fun loadUsers(): List<User> {
        val dataSource = UserDataSource()
        return dataSource.loadManyUser()
    }
}
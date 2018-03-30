package io.moatwel.kotlin_coroutine

class UserRepository {
    fun loadHalu(): User? {
        val datasource = UserDataSource()
        return datasource.loadHalu()
    }

    fun loadUsers(): List<User> {
        val dataSource = UserDataSource()
        return dataSource.loadManyUser()
    }
}
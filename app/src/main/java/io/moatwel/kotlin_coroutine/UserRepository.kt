package io.moatwel.kotlin_coroutine

class UserRepository {
    suspend fun loadHalu(): User? {
        val datasource = UserDataSource()
        return datasource.loadHalu()
    }
}
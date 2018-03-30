package io.moatwel.kotlin_coroutine

import io.reactivex.Observable

class UserRepository {
    fun loadHalu(): Observable<User> {
        val datasource = UserDataSource()
        return datasource.loadHalu()
    }

    fun loadUsers(): Observable<List<User>> {
        val dataSource = UserDataSource()
        return dataSource.loadManyUser()
    }
}
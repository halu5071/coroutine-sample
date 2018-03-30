package io.moatwel.kotlin_coroutine

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.util.Log
import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.Job
import kotlinx.coroutines.experimental.launch

class ViewModel : ViewModel() {
    val repository = UserRepository()

    val halu: MutableLiveData<User> = MutableLiveData()
    val userList: MutableLiveData<List<User>> = MutableLiveData()

    fun loadUser(): Job = launch(CommonPool) {
        Log.d("Main","Now Loading")
        val user = repository.loadHalu()
        halu.postValue(user)
        Log.d("Main", user.toString())
        Log.d("Main","End Loading")
    }

    fun loadMany(): Job = launch(CommonPool) {
        Log.d("Main", "Many Loading")
        val users = repository.loadUsers()
        userList.postValue(users)
        users.forEach {
            Log.d("Main", it.toString())
        }
        Log.d("Main", "End Many Loading")
    }
}
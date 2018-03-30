package io.moatwel.kotlin_coroutine

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.util.Log
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class ViewModel : ViewModel() {
    val repository = UserRepository()

    val halu: MutableLiveData<User> = MutableLiveData()
    val userList: MutableLiveData<List<User>> = MutableLiveData()

    fun loadUser() {
        Log.d("Main","Now Loading")
        repository.loadHalu()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    halu.postValue(it)
                }, {
                    Log.e("Main", "halu error")
                })
        Log.d("Main","End Loading")
    }

    fun loadMany() {
        Log.d("Main", "Many Loading")
        repository.loadUsers()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    userList.postValue(it)
                }, {
                    Log.e("Main", "list error")
                })
        Log.d("Main", "End Many Loading")
    }
}
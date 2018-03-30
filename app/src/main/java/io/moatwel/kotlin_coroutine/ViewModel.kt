package io.moatwel.kotlin_coroutine

import android.util.Log
import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.Job
import kotlinx.coroutines.experimental.launch

class ViewModel {
    val repository = UserRepository()

    fun loadUser(): Job = launch(CommonPool) {
        Log.d("Main","Now Loading")
        val user = repository.loadHalu()
        Log.d("Main", user.toString())
        Log.d("Main","End Loading")
    }
}
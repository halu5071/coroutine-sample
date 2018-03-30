package io.moatwel.kotlin_coroutine

import com.squareup.moshi.Moshi
import io.reactivex.Observable
import okhttp3.OkHttpClient
import okhttp3.Request

class UserDataSource {
    fun loadHalu(): Observable<User> = Observable.create { emitter ->
        val client = OkHttpClient()
        val moshi = Moshi.Builder()
                .build()

        val request = Request.Builder()
                .url("https://api.github.com/users/halu5071")
                .build()

        val response = client.newCall(request).execute()
        response.body()?.let {
            emitter.onNext(moshi.adapter(User::class.java).fromJson(it.string())!!)
        }
    }

    fun loadManyUser(): Observable<List<User>> {
        Thread.sleep(6000)
        return Observable.create {
            arrayListOf(
                User(1, "hoge"),
                User(2, "fuga"),
                User(3, "none"))
        }
    }
}
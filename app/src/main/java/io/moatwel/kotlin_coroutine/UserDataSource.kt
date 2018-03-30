package io.moatwel.kotlin_coroutine

import com.squareup.moshi.Moshi
import okhttp3.OkHttpClient
import okhttp3.Request

class UserDataSource {
    fun loadHalu(): User? {
        val client = OkHttpClient()
        val moshi = Moshi.Builder()
                .build()

        val request = Request.Builder()
                .url("https://api.github.com/users/halu5071")
                .build()

        val response = client.newCall(request).execute()
        response.body()?.let {
            return moshi.adapter<User>(User::class.java).fromJson(it.string())
        } ?: return null
    }
}
package com.zrq.wanandroid.http

import android.util.Log
import com.zrq.wanandroid.http.Constants.BASE_URL
import com.zrq.wanandroid.http.Constants.TIME_OUT
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitClient {

    private const val TAG = "HTTP"

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private val okHttpClient by lazy {
        OkHttpClient.Builder()
            .addNetworkInterceptor(HttpLoggingInterceptor { message -> Log.d(TAG, message) }.apply {
                level = HttpLoggingInterceptor.Level.BODY
            })
            .readTimeout(TIME_OUT, TimeUnit.SECONDS)
            .writeTimeout(TIME_OUT, TimeUnit.SECONDS)
            .connectTimeout(TIME_OUT, TimeUnit.SECONDS)
            .build()
    }

    val apiService by lazy {
        retrofit.create(ApiService::class.java)
    }
}
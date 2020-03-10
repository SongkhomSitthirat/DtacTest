package com.test.dtac.network

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Created by PrewSitthirat on 10/3/2020 AD.
 */

class ApiService {

    private fun getLoggingInterceptor(): HttpLoggingInterceptor {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY
        return logging
    }

    private fun getOkHttpClient(): OkHttpClient {
        val okHttpClient = OkHttpClient.Builder()
            .connectTimeout(ServiceProperties.TIMEOUT, TimeUnit.SECONDS)
            .readTimeout(ServiceProperties.TIMEOUT, TimeUnit.SECONDS)
            .writeTimeout(ServiceProperties.TIMEOUT, TimeUnit.SECONDS)
            .addInterceptor(getLoggingInterceptor())
        return okHttpClient.build()
    }

    private val gson = GsonBuilder()
        .setLenient()
        .setPrettyPrinting()
        .create()

    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .client(getOkHttpClient())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .baseUrl(ServiceProperties.BASE_URL)
            .build()
    }

    fun <T> getEndpointInterface(mService: Class<out T>): T {
        return getRetrofit().create(mService)
    }
}
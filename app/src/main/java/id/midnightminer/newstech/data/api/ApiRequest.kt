package id.midnightminer.newstech.data.api

import android.content.Context
import id.midnightminer.newstech.util.Constant
import okhttp3.*
import okhttp3.internal.addHeaderLenient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException
import java.util.concurrent.TimeUnit

class ApiRequest {
    fun getHeaderInterceptor():Interceptor{
        return object : Interceptor {
            @Throws(IOException::class)
            override fun intercept(chain: Interceptor.Chain): Response {
                val request =
                    chain.request().newBuilder()
                        .header("x-api-key", Constant.APIKEY)
                        .build()
                return chain.proceed(request)
            }
        }
    }
    fun getInterceptor(): OkHttpClient {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

        var okhttp = OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
            .addInterceptor(getHeaderInterceptor())
            .connectTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .retryOnConnectionFailure(true)
            .build()

        return okhttp
    }
    fun getNetwork(): Retrofit{
        return Retrofit.Builder().baseUrl(Constant.BASE_URL)
            .client(getInterceptor())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    fun api(): ApiService{
        return getNetwork().create(ApiService::class.java)
    }
}
package com.hariobudiharjo.swdata.Api

import com.hariobudiharjo.swdata.BuildConfig
import com.hariobudiharjo.swdata.Const.BASE_URL
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitClient {
    companion object {
        private var retrofit: Retrofit? = null

        fun getRetrofitClient(): Retrofit {
            if (retrofit == null) {

                val client = OkHttpClient.Builder()
                    .addInterceptor(createApiKeyQueryInterceptor())
                    .addInterceptor(createLoggingInterceptor())
                    .readTimeout(1, TimeUnit.MINUTES)
                    .connectTimeout(1, TimeUnit.MINUTES)
                    .build()

                retrofit = retrofit2.Retrofit.Builder()
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(client)
                    .baseUrl(BASE_URL)
                    .build()
            }
            return this.retrofit!!
        }


        private fun createLoggingInterceptor(): HttpLoggingInterceptor {
            val interceptor = HttpLoggingInterceptor()
            if (BuildConfig.DEBUG) {
                interceptor.level = HttpLoggingInterceptor.Level.HEADERS
            } else {
                interceptor.level = HttpLoggingInterceptor.Level.NONE
            }
            return interceptor
        }

        private fun createApiKeyQueryInterceptor(): Interceptor {
            return Interceptor { chain ->
                val original = chain.request()
                val originalHttpUrl = original.url()
                val url = originalHttpUrl.newBuilder()
                    .build()
                chain.proceed(original.newBuilder().url(url).build())
            }
        }
    }
}
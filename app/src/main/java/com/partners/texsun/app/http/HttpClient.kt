package com.partners.texsun.app.http

import android.annotation.SuppressLint
import com.google.gson.GsonBuilder
import com.partners.texsun.app.http.apis.AuthApi
import com.partners.texsun.app.http.interceptors.NoConnectionInterceptor
import com.partners.texsun.app.http.interceptors.TokenInterceptor
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object HttpClient {
    private fun getRetrofit(baseUrl: String, withAuth: Boolean = false): Retrofit {
        val okHttpClient = OkHttpClient.Builder()
            //10 seconds is the default value
            .connectTimeout(15, TimeUnit.SECONDS)
            .readTimeout(15, TimeUnit.SECONDS)
            .writeTimeout(15, TimeUnit.SECONDS)
            .addInterceptor(NoConnectionInterceptor())


        if (withAuth) {
            okHttpClient.addInterceptor(TokenInterceptor())
        }
        val timeStampJson = GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create()
        val timeJson = GsonBuilder().setDateFormat("HH:mm:ss").create()

        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create(timeStampJson))
            .addConverterFactory(GsonConverterFactory.create(timeJson))
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .client(okHttpClient.build())
            .build()
    }

    fun getAuthApi(): AuthApi {
        return getRetrofit(
            "https://5dcaace1.ngrok.io/api/",
            withAuth = false
        ).create(AuthApi::class.java)
    }


    fun <T> handleResponse(
        request: Observable<T>,
        onSuccess: ((T) -> Unit) = {  _ -> },
        onError: ((Any) -> Unit) = { _ -> },
        finally: (() -> Unit) = {  }
    ) {
        request.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    onSuccess(it)
                },
                {
                    onError(it)
                }, {
                    finally()
                })
    }

}
package com.partners.texsun.app.http.interceptors


import android.annotation.SuppressLint
import android.content.Context.CONNECTIVITY_SERVICE
import android.net.ConnectivityManager
import android.util.Log
import com.google.android.material.snackbar.Snackbar
import com.partners.texsun.R
import com.partners.texsun.app.TexsunApp
import com.partners.texsun.app.http.exceptions.NoConnectivityException
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import okhttp3.Interceptor
import okhttp3.Response
import retrofit2.HttpException
import java.net.SocketTimeoutException


@Suppress("DEPRECATION")
class NoConnectionInterceptor: Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        if (!isConnected()) throw NoConnectivityException()

        val builder = chain.request().newBuilder()
        return chain.proceed(builder.build())
    }

    private fun isConnected(): Boolean {
        val connectivityManager =
            TexsunApp.instance.applicationContext.getSystemService(CONNECTIVITY_SERVICE) as ConnectivityManager
        val netInfo = connectivityManager.activeNetworkInfo
        return netInfo != null && netInfo.isConnected
    }

}
package com.partners.texsun.app.http.interceptors

import androidx.core.widget.AutoScrollHelper
import com.partners.texsun.app.utils.AuthUtils
import okhttp3.Interceptor
import okhttp3.Response

class TokenInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()

    if (AuthUtils.isLogged()){
        val requestWithToken = request.newBuilder()
            .headers(request.headers())
            .addHeader(
                "Authorization",
                "Bearer ${AuthUtils.getToken()}"
            )
            .method(request.method(), request.body())
            .build()

        return chain.proceed(requestWithToken)
    }

        return chain.proceed(request)
    }

}
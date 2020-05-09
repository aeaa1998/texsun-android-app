package com.partners.texsun.app.http.interceptors

import okhttp3.Interceptor
import okhttp3.Response

class TokenInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
//        val loggedUser = Paper.book().read(Constants.Paper.LOGGED_USER,
//            LoginResponse()
//        )
//
//        if (loggedUser.accessToken != "") {
//            val requestWithToken = request.newBuilder()
//                .headers(request.headers())
//                .addHeader(
//                    "Authorization",
//                    ApplicationQB.instance.getString(R.string.bearer_token, loggedUser.accessToken)
//                )
//                .method(request.method(), request.body())
//                .build()
//
//            return chain.proceed(requestWithToken)
//        }

        return chain.proceed(request)
    }

}
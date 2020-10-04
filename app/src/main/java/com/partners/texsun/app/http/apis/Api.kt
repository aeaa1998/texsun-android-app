package com.partners.texsun.app.http.apis

import com.partners.texsun.app.http.requests.auth.RegisterRequest
import com.partners.texsun.app.http.responses.auth.UserResponse
import com.partners.texsun.app.http.responses.generic.MessageResponse
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface Api {
    @GET("user")
    fun getUser(): Observable<UserResponse>
}
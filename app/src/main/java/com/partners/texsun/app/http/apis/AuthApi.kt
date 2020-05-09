package com.partners.texsun.app.http.apis

import com.partners.texsun.app.http.requests.auth.LoginRequest
import com.partners.texsun.app.http.requests.auth.RegisterRequest
import com.partners.texsun.app.http.responses.auth.LoginResponse
import com.partners.texsun.app.http.responses.generic.MessageResponse
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.Body
import retrofit2.http.POST

/**
 * The interface for the Auth Api.
 */
interface AuthApi {
    @POST("register")
    fun register(@Body registerRequest: RegisterRequest): Observable<MessageResponse>

    @POST("login")
    fun login(@Body loginRequest: LoginRequest): Observable<LoginResponse>
}
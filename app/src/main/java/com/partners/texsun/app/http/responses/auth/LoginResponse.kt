package com.partners.texsun.app.http.responses.auth

import com.google.gson.annotations.SerializedName

class LoginResponse {
    @SerializedName("access_token")
    var accessToken = ""

    @SerializedName("refresh_token")
    var refreshToken = ""


    val verifiedAt: String?
    get() = user.verifiedAt

    @SerializedName("user")
    var user = UserResponse()

//
}
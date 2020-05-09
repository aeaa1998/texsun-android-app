package com.partners.texsun.app.http.requests.auth

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class LoginRequest {
    @Expose
    @SerializedName("client_id")
    var clientId = 0

    @Expose
    @SerializedName("client_secret")
    var clientSecret = ""

    @Expose
    @SerializedName("grant_type")
    var grantType = ""

    @Expose
    @SerializedName("email")
    var email = ""

    @Expose
    @SerializedName("password")
    var password = ""
}
package com.partners.texsun.app.http.requests.auth

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class RegisterRequest {
    @Expose
    @SerializedName("email")
    var email = ""

    @Expose
    @SerializedName("password")
    var password = ""

    @Expose
    @SerializedName("password_confirmation")
    var passwordConfirmation = ""
}
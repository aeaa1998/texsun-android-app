package com.partners.texsun.app.http.responses.auth

import com.google.gson.annotations.SerializedName

class UserResponse {
    @SerializedName("id")
    var id = 0

    @SerializedName("email")
    var email = ""

    @SerializedName("role_id")
    var roleId = 0

    @SerializedName("verified_at")
    var verifiedAt = ""
}
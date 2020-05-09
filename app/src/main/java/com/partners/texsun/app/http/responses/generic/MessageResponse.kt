package com.partners.texsun.app.http.responses.generic

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class MessageResponse {
    @Expose
    @SerializedName("message")
    var message = ""
}
package com.partners.texsun.app.http.exceptions

import java.io.IOException

class NoConnectivityException : IOException() {
    override val message: String?
        get() = "No Internet Connection"

}
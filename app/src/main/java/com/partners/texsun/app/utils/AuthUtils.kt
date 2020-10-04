package com.partners.texsun.app.utils

import com.partners.texsun.app.http.responses.auth.LoginResponse
import io.paperdb.Paper

object AuthUtils {

    fun setLoggedUser(l : LoginResponse){
        Paper.book().write(Constants.Paper.LOGGED_USER, l)
    }

    fun isLogged() : Boolean {
        return Paper.book().contains(Constants.Paper.LOGGED_USER) && getToken() != ""

    }

    fun getLoggedUser() : LoginResponse{
        return Paper.book().read(Constants.Paper.LOGGED_USER, LoginResponse())
    }

    fun getToken(): String {
        return getLoggedUser().accessToken
    }

    fun clearSession() {
        Paper.book().destroy()
    }
}
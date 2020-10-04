package com.partners.texsun.app

import android.animation.Animator
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.partners.texsun.R
import com.partners.texsun.app.app.TexumActivity
import com.partners.texsun.app.boarding.BoardingActivity
import com.partners.texsun.app.http.HttpClient
import com.partners.texsun.app.http.apis.Api
import com.partners.texsun.app.utils.AuthUtils
import kotlinx.android.synthetic.main.activity_splash_screen.*
import retrofit2.HttpException

class SplashScreen : AppCompatActivity() {
    private var intentStarted = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
    }


    override fun onStart() {
        super.onStart()
        Handler(Looper.getMainLooper()).postDelayed({
            if (AuthUtils.isLogged()) {
                fetchUser()
            } else {
                val intent = Intent(this@SplashScreen, BoardingActivity::class.java)
                startActivity(intent)
            }
        }, 1000)
    }


    private fun fetchUser() {
        val request = HttpClient.getApi<Api>().getUser()
        HttpClient.handleResponse(request, {
            val l = AuthUtils.getLoggedUser()
            l.user = it
            AuthUtils.setLoggedUser(l)
            val intent = Intent(this@SplashScreen, TexumActivity::class.java)
            startActivity(intent)
        }, {

            (it as? HttpException)?.let {
                httpException ->
                val intent = when(httpException.code()){
                    401 -> Intent(this@SplashScreen, BoardingActivity::class.java)
                    else -> Intent(this@SplashScreen, TexumActivity::class.java)
                }
                startActivity(intent)
            }
        })
    }
}

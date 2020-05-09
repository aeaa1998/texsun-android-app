package com.partners.texsun.app

import android.animation.Animator
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.partners.texsun.R
import com.partners.texsun.app.boarding.BoardingActivity
import kotlinx.android.synthetic.main.activity_splash_screen.*

class SplashScreen : AppCompatActivity() {
    private var intentStarted = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
    }

    override fun onResume() {
        super.onResume()
        splashAnimation.addAnimatorListener(object : Animator.AnimatorListener{
            override fun onAnimationRepeat(p0: Animator?) {

            }

            override fun onAnimationEnd(p0: Animator?) {
            }

            override fun onAnimationCancel(p0: Animator?) {
            }

            override fun onAnimationStart(p0: Animator?) {
                Handler(Looper.getMainLooper()).postDelayed({
                    if (!intentStarted){
                        intentStarted = true
//                        val intent = Intent(this@SplashScreen, MainActivity::class.java)
                        val intent = Intent(this@SplashScreen, BoardingActivity::class.java)
                        startActivity(intent)
                    }
                }, 100)
            }

        })
    }
}

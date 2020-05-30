package com.partners.texsun.app.app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.navigation.fragment.findNavController
import com.partners.texsun.R
import kotlinx.android.synthetic.main.activity_texum.*

class TexumActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_texum)
    }

    override fun onResume() {
        super.onResume()
        Handler(Looper.getMainLooper()).postDelayed({
            val action =
                HomeFragmentDirections.actionHomeFragmentToPendingVerificationFragment()
            mainAppNavHost.findNavController().navigate(action)
        }, 3000)
    }
}

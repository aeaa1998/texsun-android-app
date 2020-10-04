package com.partners.texsun.app.app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.partners.texsun.R
import kotlinx.android.synthetic.main.activity_texum.*

class TexumActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_texum)
        NavigationUI.setupWithNavController(bottomBarView,mainAppNavHost.findNavController())
    }


    override fun onResume() {
        super.onResume()

    }

    override fun onSupportNavigateUp(): Boolean {
        return findNavController(R.id.mainAppNavHost).navigateUp() || super.onSupportNavigateUp()
    }

    override fun onBackPressed() {
        findNavController(R.id.mainAppNavHost).navigateUp()
    }
}

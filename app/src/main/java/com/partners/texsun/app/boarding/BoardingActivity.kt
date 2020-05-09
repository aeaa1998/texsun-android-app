package com.partners.texsun.app.boarding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.partners.texsun.R
import kotlinx.android.synthetic.main.activity_boarding.*

class BoardingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_boarding)
    }



    /**
     * Go back to the previous fragment.
     */
    fun goBack(view: View? = null) {
        boardingNavHost.findNavController().navigateUp()
    }

    override fun onBackPressed() {
        goBack()
    }
}

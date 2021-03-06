package com.partners.texsun.app.boarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController

import com.partners.texsun.R
import kotlinx.android.synthetic.main.activity_boarding.*
import kotlinx.android.synthetic.main.fragment_boarding.view.*


/**
 * A simple [Fragment] subclass.
 * Use the [BoardingFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class BoardingFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_boarding, container, false)
        view.btnRegister.setOnClickListener{ navigateToRegister() }
        view.btnLogin.setOnClickListener { navigateToLogin() }
        return view
    }

    /**
     * Navigate to login
     */
    fun navigateToLogin() {
        val action =
            BoardingFragmentDirections.actionBoardingFragmentToLoginFragment()
        boardingNavHost.findNavController().navigate(action)
    }

    /**
     * Navigate to register
     */
    fun navigateToRegister() {
        val action =
            BoardingFragmentDirections.actionBoardingFragmentToRegisterFragment()
        boardingNavHost.findNavController().navigate(action)
    }

}

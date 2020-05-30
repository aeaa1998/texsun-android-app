package com.partners.texsun.app.boarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController

import com.partners.texsun.R
import com.partners.texsun.app.http.HttpClient
import com.partners.texsun.app.http.HttpClient.handleResponse
import com.partners.texsun.app.http.requests.auth.LoginRequest
import com.partners.texsun.app.http.requests.auth.RegisterRequest
import kotlinx.android.synthetic.main.activity_boarding.*
import kotlinx.android.synthetic.main.fragment_register.view.*


/**
 * A simple [Fragment] subclass.
 * Use the [RegisterFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class RegisterFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_register, container, false)
        view.btnBackRegister.setOnClickListener { findNavController().navigateUp() }
        view.btnRegister.setOnClickListener { registerUser() }
        return view
    }

    fun registerUser(){
        val registerRequest = RegisterRequest()
        val request = HttpClient.getAuthApi().register(registerRequest)
        handleResponse(request = request, onSuccess = {
            findNavController().navigateUp()
        }){

        }
    }






}

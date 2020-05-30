package com.partners.texsun.app.boarding

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.partners.texsun.R
import com.partners.texsun.app.app.TexumActivity
import com.partners.texsun.app.http.HttpClient
import com.partners.texsun.app.http.requests.auth.LoginRequest
import com.partners.texsun.app.utils.Constants
import com.partners.texsun.app.utils.dialogs.Dialogs
import io.paperdb.Paper
import kotlinx.android.synthetic.main.fragment_login.*
import kotlinx.android.synthetic.main.fragment_login.view.*
import kotlinx.android.synthetic.main.fragment_login.view.txtEmail
import retrofit2.HttpException

class LoginFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_login, container, false)
        view.btnBackToBoarding.setOnClickListener {
            findNavController().navigateUp()
        }
        view.btnLoginEnter.setOnClickListener {
            login()
        }
        return view
    }

    fun login(){
        if(txtEmail.text.isBlank() || txtPassword.text.isBlank()){
            Toast.makeText(activity, getString(R.string.empty_fields), Toast.LENGTH_LONG).show()
            return
        }

        val loginRequest = LoginRequest()
        loginRequest.clientId = getString(R.string.client_id).toInt()
        loginRequest.clientSecret =  getString(R.string.client_secret)
        loginRequest.grantType = getString(R.string.grant_type)
        loginRequest.email = txtEmail.text.toString()
        loginRequest.password = txtPassword.text.toString()
        context?.let { context ->
            val dialog = Dialogs.loadingDialog(context, R.string.please_wait, R.string.login_in)
            dialog.show()
            val request = HttpClient.getAuthApi().login(loginRequest)
            HttpClient.handleResponse(request, {
                loginResponse ->
                Paper.book().write(Constants.Paper.LOGGED_USER, loginResponse)
                dialog.dismiss()
                val intent = Intent(activity, TexumActivity::class.java)
                startActivity(intent)
                activity?.finish()
            }, {
                dialog.dismiss()
                if (it is HttpException && it.code() == 401) {
                    Toast.makeText(
                        activity,
                        getString(R.string.invalid_credentials),
                        Toast.LENGTH_SHORT
                    )
                        .show()
                } else {

                    Toast.makeText(
                        activity,
                        getString(R.string.error_could_not_login),
                        Toast.LENGTH_SHORT
                    )
                        .show()
                }
            })
        }
    }



}

package kz.home.singularitytournaments.presentation.login

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.google.android.material.textfield.TextInputEditText
import kz.home.singularitytournaments.R

class RegistrationFragment(
    val openLogin: () -> Unit
) : Fragment(R.layout.fragment_registration) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val password = view.findViewById<TextInputEditText>(R.id.password_input)
        val retypePassword = view.findViewById<TextInputEditText>(R.id.retype_password_input)

        val registrationButton = view.findViewById<Button>(R.id.registration_button)
        registrationButton.setOnClickListener {
            if(password.text.toString() == retypePassword.text.toString()) {
                openLogin()
            }
        }

        val loginLink = view.findViewById<TextView>(R.id.login_link)
        loginLink.setOnClickListener {
            openLogin()
        }
    }
}
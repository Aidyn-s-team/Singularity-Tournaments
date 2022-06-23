package kz.home.singularitytournaments.presentation.login

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.database.FirebaseDatabase
import kz.home.singularitytournaments.R
import kz.home.singularitytournaments.domain.User

class RegistrationFragment(
    val openLogin: () -> Unit
) : Fragment(R.layout.fragment_registration) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val login = view.findViewById<TextInputEditText>(R.id.login_input)
        val password = view.findViewById<TextInputEditText>(R.id.password_input)
        val retypePassword = view.findViewById<TextInputEditText>(R.id.retype_password_input)

        val registrationButton = view.findViewById<Button>(R.id.registration_button)
        registrationButton.setOnClickListener {
            if(login.text.toString().isNotBlank() && password.text.toString().isNotBlank() && retypePassword.text.toString().isNotBlank()) {
                login.error = null
                password.error = null
                if(password.text.toString() == retypePassword.text.toString()) {
                    password.error = null
                    val reference = rootNode.getReference("Users")
                    val user = User(login.text.toString(), password.text.toString())
                    reference.child(login.text.toString()).setValue(user)
                    openLogin()
                }else{
                    password.error = "Not the same"
                    password.requestFocus()
                    retypePassword.error = "Not the same"
                    retypePassword.requestFocus()
                }
            }else{
                login.error = "No login"
                login.requestFocus()
                password.error = "No password"
                password.requestFocus()
                retypePassword.error = "No password"
                retypePassword.requestFocus()
            }
        }

        val loginLink = view.findViewById<TextView>(R.id.login_link)
        loginLink.setOnClickListener {
            openLogin()
        }
    }
}
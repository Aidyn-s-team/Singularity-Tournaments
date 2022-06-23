package kz.home.singularitytournaments.presentation.login

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.Query
import com.google.firebase.database.ValueEventListener
import kz.home.singularitytournaments.R
import kz.home.singularitytournaments.domain.User

class LoginFragment(
    val openMainActivity: (User) -> Unit,
    val openRegistration: () -> Unit
) : Fragment(R.layout.fragment_login) {
    private lateinit var login: TextInputEditText
    private lateinit var password: TextInputEditText

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        login = view.findViewById(R.id.login_input)
        password = view.findViewById(R.id.password_input)

        val loginButton = view.findViewById<Button>(R.id.login_button)
        loginButton.setOnClickListener {
            loginUSer()
        }

        val registrationLink = view.findViewById<TextView>(R.id.registration_link)
        registrationLink.setOnClickListener {
            openRegistration()
        }
    }

    private fun validateLogin(): Boolean {
        val loginInput = login.text.toString()

        return if (loginInput.isBlank()) {
            login.error = "Field cannot be empty"
            login.requestFocus()
            false
        } else {
            login.error = null
            true
        }
    }

    private fun validatePassword(): Boolean {
        val passwordInput = password.text.toString()

        return if (passwordInput.isBlank()) {
            password.error = "Field cannot be empty"
            password.requestFocus()
            false
        } else {
            password.error = null
            true
        }
    }

    private fun loginUSer() {
        if (!validateLogin() || !validatePassword()) {
            return
        }else{
            isUser()
        }
    }

    private fun isUser() {
        val loginEntered = login.text.toString()
        val passwordEntered = password.text.toString()

        val reference = rootNode.getReference("Users")

        val checkUser: Query = reference.orderByChild("login").equalTo(loginEntered)

        checkUser.addListenerForSingleValueEvent(object : ValueEventListener{
            override fun onDataChange(p0: DataSnapshot) {
                if(p0.exists()) {

                    login.error = null

                    val passwordDB = p0.child(loginEntered).child("password").getValue(String::class.java)

                    if(passwordDB.equals(passwordEntered)) {
                        password.error = null

                        val loginDB = p0.child(loginEntered).child("login").getValue(String::class.java)
                        val user = User(loginDB.toString(), passwordDB.toString())
                        openMainActivity(user)
                    }else{
                        password.error = "Wrong password"
                        password.requestFocus()
                    }
                }else{
                    login.error = "No such User exists"
                    login.requestFocus()
                }
            }

            override fun onCancelled(p0: DatabaseError) {
                TODO("Not yet implemented")
            }

        })

    }
}
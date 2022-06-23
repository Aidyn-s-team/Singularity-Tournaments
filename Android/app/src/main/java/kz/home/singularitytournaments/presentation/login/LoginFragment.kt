package kz.home.singularitytournaments.presentation.login

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.google.android.material.textfield.TextInputEditText
import kz.home.singularitytournaments.R

class LoginFragment(
    val openMainActivity: () -> Unit,
    val openRegistration: () -> Unit
) : Fragment(R.layout.fragment_login) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val loginInput = view.findViewById<TextInputEditText>(R.id.login_input)
        loginInput.setOnEditorActionListener { _, keyCode, _ ->
            if (keyCode == EditorInfo.IME_ACTION_DONE || keyCode == EditorInfo.IME_ACTION_NEXT) {
                inputValue =loginInput.text.toString()
                if (inputValue.isBlank()) {
                    inputValue = "0"
                }

                val inputManager = context?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                inputManager.hideSoftInputFromWindow(view.windowToken, 0)
                return@setOnEditorActionListener true
            }
            return@setOnEditorActionListener false
        }

        val loginButton = view.findViewById<Button>(R.id.login_button)
        loginButton.setOnClickListener {
            openMainActivity()
        }

        val registrationLink = view.findViewById<TextView>(R.id.registration_link)
        registrationLink.setOnClickListener {
            openRegistration()
        }
    }
}
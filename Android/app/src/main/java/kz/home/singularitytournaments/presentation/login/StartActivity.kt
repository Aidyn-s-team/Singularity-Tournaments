package kz.home.singularitytournaments.presentation.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kz.home.singularitytournaments.R
import kz.home.singularitytournaments.presentation.MainActivity
import kz.home.singularitytournaments.presentation.login.LoginFragment
import kz.home.singularitytournaments.presentation.login.RegistrationFragment

var inputValue: String = "0"

class StartActivity : AppCompatActivity(R.layout.activity_start) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        openLogin()
    }

    private fun openMainActivity() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    private fun openRegistration() {
        val registrationFragment = RegistrationFragment(openLogin = {openLogin()})
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, registrationFragment).commit()
    }

    private fun openLogin() {
        val loginFragment = LoginFragment(openMainActivity = {openMainActivity()}, openRegistration = {openRegistration()})
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, loginFragment).commit()
    }
}
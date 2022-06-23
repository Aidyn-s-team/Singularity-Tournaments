package kz.home.singularitytournaments.presentation.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.database.FirebaseDatabase
import kz.home.singularitytournaments.R
import kz.home.singularitytournaments.domain.User
import kz.home.singularitytournaments.presentation.MainActivity
import kz.home.singularitytournaments.presentation.login.LoginFragment
import kz.home.singularitytournaments.presentation.login.RegistrationFragment

val rootNode = FirebaseDatabase.getInstance()

class StartActivity : AppCompatActivity(R.layout.activity_start) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        openLogin()
    }

    private fun openMainActivity(user: User) {
        val intent = Intent(this, MainActivity::class.java)
        intent.putExtra("user", user)
        startActivity(intent)
    }

    private fun openRegistration() {
        val registrationFragment = RegistrationFragment(openLogin = {openLogin()})
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, registrationFragment).commit()
    }

    fun openLogin() {
        val loginFragment = LoginFragment(openMainActivity = {openMainActivity(it)}, openRegistration = {openRegistration()})
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, loginFragment).commit()
    }

}
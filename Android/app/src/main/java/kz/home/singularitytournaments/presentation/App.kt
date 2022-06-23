package kz.home.singularitytournaments.presentation

import android.app.Application
import kz.home.singularitytournaments.di.mainModule
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin { modules(mainModule) }
    }
}
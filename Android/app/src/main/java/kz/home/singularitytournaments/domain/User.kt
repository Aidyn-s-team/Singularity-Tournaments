package kz.home.singularitytournaments.domain

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class User(
    val login: String,
    val password: String
): Parcelable
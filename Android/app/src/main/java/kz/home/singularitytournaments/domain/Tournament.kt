package kz.home.singularitytournaments.domain

class Tournament(
    val name: String,
    var players: MutableList<Player> = mutableListOf(),
    var rounds: MutableList<Round>? = null
)
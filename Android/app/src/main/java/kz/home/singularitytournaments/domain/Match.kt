package kz.home.singularitytournaments.domain

class Match(
    val roundNumber: Int,
    val player1: Player? = null,
    val player2: Player? = null,
    val winner: Player?= null
)
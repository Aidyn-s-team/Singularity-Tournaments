package kz.home.singularitytournaments.domain

class Match(
    val roundNumber: Int,
    val matchNumber: Int,
    val user1: User? = null,
    val user2: User? = null,
    val winner: User?= null
)
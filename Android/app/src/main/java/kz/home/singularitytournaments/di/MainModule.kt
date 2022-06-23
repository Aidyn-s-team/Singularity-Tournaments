package kz.home.singularitytournaments.di

import kz.home.singularitytournaments.presentation.moderator.ModeratorTournamentAdapter
import kz.home.singularitytournaments.presentation.moderator.ModeratorTournamentFragment
import kz.home.singularitytournaments.presentation.player.RoundsAdapter
import kz.home.singularitytournaments.presentation.player.TournamentAdapter
import org.koin.dsl.module

val mainModule = module {
    single { ModeratorTournamentAdapter() }
    single { TournamentAdapter() }
    single { RoundsAdapter() }
}

val modules = listOf(mainModule)
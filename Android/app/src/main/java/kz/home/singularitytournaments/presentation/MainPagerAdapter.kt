package kz.home.singularitytournaments.presentation

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import kz.home.singularitytournaments.presentation.login.inputValue
import kz.home.singularitytournaments.presentation.moderator.AllRoundsFragment
import kz.home.singularitytournaments.presentation.moderator.ModeratorTournamentAdapter
import kz.home.singularitytournaments.presentation.moderator.ModeratorTournamentFragment
import kz.home.singularitytournaments.presentation.player.RoundsAdapter
import kz.home.singularitytournaments.presentation.player.RoundsFragment
import kz.home.singularitytournaments.presentation.player.TournamentAdapter
import kz.home.singularitytournaments.presentation.player.TournamentFragment

class MainPagerAdapter(
    activity: MainActivity,
    val showCreateDialog: () -> Unit,
    private val mTAdapter: ModeratorTournamentAdapter,
    private val TChooseAdapter: TournamentAdapter,
    private val roundsAdapter: RoundsAdapter
    ) : FragmentStateAdapter(activity) {
    private val fragments = mutableListOf<Fragment>()

    init {
        if (inputValue == "1") {
            fragments.add(ModeratorTournamentFragment(mTAdapter, showCreateDialog = {showCreateDialog()}))
        }else{
            fragments.add(TournamentFragment(TChooseAdapter))
        }
        if (inputValue == "1") {
            fragments.add(AllRoundsFragment())
        }else{
            fragments.add(RoundsFragment(roundsAdapter))
        }
        fragments.add(ResultsFragment())
    }

    override fun createFragment(position: Int): Fragment =
        fragments[position]

    override fun getItemCount(): Int =
        fragments.size


}
package kz.home.singularitytournaments.presentation.moderator

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kz.home.singularitytournaments.R
import kz.home.singularitytournaments.domain.User
import kz.home.singularitytournaments.presentation.player.RoundsAdapter
import kz.home.singularitytournaments.presentation.roundsList

class AllRoundsFragment(
    private val allRoundsAdapter: AllRoundsAdapter,
    val user: User
) : Fragment(R.layout.fragment_all_rounds) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = view.findViewById<RecyclerView>(R.id.allRounds_rv)
        val roundsManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

        recyclerView.apply {
            adapter = allRoundsAdapter
            layoutManager = roundsManager
        }
        recyclerView.setHasFixedSize(true)

        allRoundsAdapter.setItems(roundsList)
    }
}
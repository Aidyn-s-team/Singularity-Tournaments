package kz.home.singularitytournaments.presentation.player

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RadioButton
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kz.home.singularitytournaments.R
import kz.home.singularitytournaments.presentation.roundsList
import kz.home.singularitytournaments.presentation.tournamentList

class RoundsFragment(
    private val roundsAdapter: RoundsAdapter
) : Fragment(R.layout.fragment_rounds) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = view.findViewById<RecyclerView>(R.id.rounds_rv)
        val roundsManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

        recyclerView.apply {
            adapter = roundsAdapter
            layoutManager = roundsManager
        }
        recyclerView.setHasFixedSize(true)

        roundsAdapter.setItems(roundsList)
    }
}
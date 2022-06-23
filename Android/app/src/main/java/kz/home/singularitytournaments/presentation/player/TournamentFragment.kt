package kz.home.singularitytournaments.presentation.player

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kz.home.singularitytournaments.R
import kz.home.singularitytournaments.domain.User
import kz.home.singularitytournaments.presentation.tournamentList

class TournamentFragment(
    private val tChooseAdapter: TournamentAdapter,
    val user: User
) : Fragment(R.layout.fragment_tournament) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = view.findViewById<RecyclerView>(R.id.choose_tournament_rv)
        val tChooseManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

        recyclerView.apply {
            adapter = tChooseAdapter
            layoutManager = tChooseManager
        }
        recyclerView.setHasFixedSize(true)

        tChooseAdapter.setItems(tournamentList)

        val submitButton = view.findViewById<Button>(R.id.submit_result_button)
        submitButton.setOnClickListener {
            //записывает где чекбокс отметили

        }
    }
}
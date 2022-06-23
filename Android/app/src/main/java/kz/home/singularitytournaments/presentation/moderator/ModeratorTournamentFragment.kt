package kz.home.singularitytournaments.presentation.moderator

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kz.home.singularitytournaments.R
import kz.home.singularitytournaments.presentation.tournamentList

class ModeratorTournamentFragment(
    private val tAdapter: ModeratorTournamentAdapter,
    val showCreateDialog: () -> Unit
) : Fragment(R.layout.fragment_moderator_tournament) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = view.findViewById<RecyclerView>(R.id.tournament_rv)
        val tManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

        recyclerView.apply {
            adapter = tAdapter
            layoutManager = tManager
        }
        recyclerView.setHasFixedSize(true)

        tAdapter.setItems(tournamentList)

        val createButton = view.findViewById<Button>(R.id.createT_button)
        createButton.setOnClickListener {
            showCreateDialog()
        }
    }
}
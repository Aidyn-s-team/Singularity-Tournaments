package kz.home.singularitytournaments.presentation.player

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kz.home.singularitytournaments.R
import kz.home.singularitytournaments.domain.Tournament

class TournamentViewHolder(inflater: LayoutInflater, parent: ViewGroup) : RecyclerView.ViewHolder(inflater.inflate(
    R.layout.item_tournament_choose, parent, false)) {

    private val nameTextView = itemView.findViewById<TextView>(R.id.tournament_name)
    private val checkBox = itemView.findViewById<CheckBox>(R.id.tournament_checkbox)

    fun bind(item: Tournament) {
        nameTextView.text = item.name

        checkBox.setOnClickListener {

        }
    }
}
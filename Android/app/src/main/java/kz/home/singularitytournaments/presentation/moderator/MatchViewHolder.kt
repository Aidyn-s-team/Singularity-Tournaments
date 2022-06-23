package kz.home.singularitytournaments.presentation.moderator

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kz.home.singularitytournaments.R
import kz.home.singularitytournaments.domain.Match
import kz.home.singularitytournaments.domain.Round

class MatchViewHolder(inflater: LayoutInflater, parent: ViewGroup) : RecyclerView.ViewHolder(inflater.inflate(
    R.layout.item_match, parent, false)) {

    private val matchName = itemView.findViewById<TextView>(R.id.match_number)
    private val player = itemView.findViewById<TextView>(R.id.player)
    private val playerVS = itemView.findViewById<TextView>(R.id.VSplayer)

    fun bind(item: Match) {
        matchName.text = item.matchNumber.toString()
        player.text = item.user1?.login.toString()
        playerVS.text = item.user2?.login.toString()
    }
}
package kz.home.singularitytournaments.presentation.moderator

import android.content.ContentValues.TAG
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kz.home.singularitytournaments.R
import kz.home.singularitytournaments.domain.Tournament

class ModeratorTournamentViewHolder(inflater: LayoutInflater, parent: ViewGroup) : RecyclerView.ViewHolder(inflater.inflate(
    R.layout.item_tournament, parent, false)) {

    private val nameTextView = itemView.findViewById<TextView>(R.id.t_title)
    private val startButton = itemView.findViewById<Button>(R.id.start_button)
    private val stopButton = itemView.findViewById<TextView>(R.id.stop_button)

    fun bind(item: Tournament) {
        nameTextView.text = item.name

        startButton.setOnClickListener {
            Log.d(TAG, "Start")
        }
        stopButton.setOnClickListener {
            Log.d(TAG, "Stop")
        }
    }
}
package kz.home.singularitytournaments.presentation.player

import android.content.ContentValues.TAG
import android.content.res.Resources
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kz.home.singularitytournaments.R
import kz.home.singularitytournaments.domain.Round

class RoundsViewHolder(inflater: LayoutInflater, parent: ViewGroup) : RecyclerView.ViewHolder(inflater.inflate(
    R.layout.item_round_player, parent, false)) {

    private val roundName = itemView.findViewById<TextView>(R.id.round_number)
    private val player = itemView.findViewById<TextView>(R.id.player)
    private val playerVS = itemView.findViewById<TextView>(R.id.VSplayer)
    private val submitResultButton = itemView.findViewById<Button>(R.id.submit_result_button)
    private val radioButton = itemView.findViewById<RadioGroup>(R.id.radio_group)

    fun bind(item: Round) {
        roundName.text = item.number.toString()
        player.text = item.matches[0].player1?.name.toString()
        playerVS.text = item.matches[0].player2?.name.toString()

        submitResultButton.setOnClickListener {

        }

        radioButton.setOnCheckedChangeListener { p0, p1 ->
            when (val checked = p0?.checkedRadioButtonId) {
                R.id.radio_player -> Log.d(TAG, "winner is player 1")
                R.id.radio_playerVS -> Log.d(TAG, "winner is player 2")
            }
        }
    }
}
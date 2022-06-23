package kz.home.singularitytournaments.presentation.moderator

import android.content.ContentValues
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kz.home.singularitytournaments.R
import kz.home.singularitytournaments.domain.Round
import kz.home.singularitytournaments.domain.Tournament
import kz.home.singularitytournaments.presentation.*

class AllRoundsViewHolder(inflater: LayoutInflater, parent: ViewGroup) : RecyclerView.ViewHolder(inflater.inflate(
    R.layout.item_round_all, parent, false)) {

    private val roundName = itemView.findViewById<TextView>(R.id.round_number)
    private val recyclerView = itemView.findViewById<RecyclerView>(R.id.matches_rv)
    private val viewPool = RecyclerView.RecycledViewPool()

    fun bind(item: Round) {
        roundName.text = item.number.toString()

        val adapter = MatchAdapter()
        val manager =
            LinearLayoutManager(itemView.context, LinearLayoutManager.HORIZONTAL, false)

        recyclerView.adapter = adapter
        recyclerView.layoutManager = manager
        recyclerView.setRecycledViewPool(viewPool)

        when (item.number) {
            roundsList[0].number -> {
                adapter.setItems(matchList1)
            }
            roundsList[1].number  -> {
                adapter.setItems(matchList2)
            }
            else  -> {
                adapter.setItems(matchList3)
            }
        }
    }
}
package kz.home.singularitytournaments.presentation.moderator

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kz.home.singularitytournaments.domain.Match
import kz.home.singularitytournaments.domain.Round
import kz.home.singularitytournaments.presentation.player.RoundsViewHolder

class MatchAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var data = mutableListOf<Match>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        return MatchViewHolder(inflater, parent)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as MatchViewHolder).bind(data[position])
    }

    fun setItems(list: MutableList<Match>) {
        data.clear()
        data.addAll(list)
        notifyDataSetChanged()
    }
}
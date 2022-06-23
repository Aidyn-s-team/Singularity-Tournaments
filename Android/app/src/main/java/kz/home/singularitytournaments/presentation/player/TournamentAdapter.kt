package kz.home.singularitytournaments.presentation.player

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kz.home.singularitytournaments.domain.Tournament

class TournamentAdapter() : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var data = mutableListOf<Tournament>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        return TournamentViewHolder(inflater, parent)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as TournamentViewHolder).bind(data[position])
    }

    fun setItems(list: MutableList<Tournament>) {
        data.clear()
        data.addAll(list)
        notifyDataSetChanged()
    }
}
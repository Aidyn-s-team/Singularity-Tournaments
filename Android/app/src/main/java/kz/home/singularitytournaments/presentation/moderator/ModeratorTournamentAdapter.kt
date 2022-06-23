package kz.home.singularitytournaments.presentation.moderator

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kz.home.singularitytournaments.domain.Tournament

class ModeratorTournamentAdapter(
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var data = mutableListOf<Tournament>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        return ModeratorTournamentViewHolder(inflater, parent)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ModeratorTournamentViewHolder).bind(data[position])
    }

    fun setItems(list: MutableList<Tournament>) {
        data.clear()
        data.addAll(list)
        notifyDataSetChanged()
    }

    fun addItem(item: Tournament) {
        data.add(item)
        notifyItemInserted(data.size)
        //notifyDataSetChanged()
    }

    fun removeItem(position: Int) {
        data.removeAt(position)
        notifyItemRemoved(position)
    }
}
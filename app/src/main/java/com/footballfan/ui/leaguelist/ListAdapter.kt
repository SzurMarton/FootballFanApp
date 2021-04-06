package com.footballfan.ui.leaguelist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.footballfan.R
import com.footballfan.ui.leaguelist.model.LeagueData
import kotlinx.android.synthetic.main.row_leagueitem.view.*
import java.util.*
import kotlin.collections.ArrayList

class ListAdapter(private val listener: OnLeagueSelectedListener?) : RecyclerView.Adapter<ListAdapter.LeagueViewHolder>() , Filterable {
    private val leagues : MutableList<LeagueData>
    private var leaguesFilttered : MutableList<LeagueData>

    interface OnLeagueSelectedListener {
        fun onLeagueSelected(league: LeagueData?)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListAdapter.LeagueViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_leagueitem,parent,false)
        return LeagueViewHolder(view)
    }

    override fun getItemCount(): Int {
        return leaguesFilttered.size
    }

    override fun onBindViewHolder(holder: ListAdapter.LeagueViewHolder, position: Int) {
        val item = leaguesFilttered[position]
        holder.item = item
        holder.leagueName.text = item.name
        Glide.with(holder.logo)
                .load(item.logo)
                .into(holder.logo)
    }

    fun addLeague(newLeague: LeagueData){
        leagues.add(newLeague)
        notifyItemInserted(leagues.size - 1)
    }

    inner class LeagueViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val logo : ImageView = itemView.leagueLogo
        val leagueName : TextView = itemView.leagueName
        var item : LeagueData? = null

        init {
            itemView.setOnClickListener {
                listener?.onLeagueSelected(item) }
        }
    }

    init {
        leagues = ArrayList()
        leaguesFilttered = leagues
    }

    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val charSearch = constraint.toString()
                if (charSearch.isEmpty()) {
                    leaguesFilttered = leagues
                }
                else {
                    val resultList = ArrayList<LeagueData>()
                    for (row in leagues) {
                        if (row.name?.toLowerCase(Locale.ROOT)
                                        ?.contains(charSearch.toLowerCase(Locale.ROOT))!!
                        ) {
                            resultList.add(row)
                        }
                    }
                    leaguesFilttered = resultList

                }
                val filterResults = FilterResults()
                filterResults.values = leaguesFilttered
                return filterResults
            }
            @Suppress("UNCHECKED_CAST")
            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                leaguesFilttered = results?.values as ArrayList<LeagueData>
                notifyDataSetChanged()
            }
        }
    }
}
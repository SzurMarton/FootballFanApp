package com.footballfan.ui.leaguelist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.footballfan.R
import com.footballfan.ui.leaguelist.model.LeagueData
import kotlinx.android.synthetic.main.row_leagueitem.view.*

class LeagueAdapter : ListAdapter<LeagueData, LeagueAdapter.LeagueViewHolder>(LeagueComparator) {
    var listener: Listener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LeagueViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_leagueitem,parent,false)
        return LeagueViewHolder(view)
    }

    override fun onBindViewHolder(holder: LeagueViewHolder, position: Int) {
        val league = getItem(position)
        holder.league = league
        holder.leagueName.text = league.name
        Glide.with(holder.logo)
            .load(league.logo)
            .into(holder.logo)
    }

    inner class LeagueViewHolder(leagueView: View) : RecyclerView.ViewHolder(leagueView){
        val logo : ImageView = leagueView.leagueLogo
        val leagueName : TextView = leagueView.leagueName
        var league: LeagueData? = null

        init {
            leagueView.setOnClickListener {
                league?.let { listener?.onLeagueClicked(it) }
            }
        }
    }

    interface Listener{
        fun onLeagueClicked(league: LeagueData)
    }
}
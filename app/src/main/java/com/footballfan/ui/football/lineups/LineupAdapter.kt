package com.footballfan.ui.football.lineups

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.footballfan.R
import com.footballfan.ui.football.lineups.model.UiPlayer
import kotlinx.android.synthetic.main.row_lineupitem.view.*

class LineupAdapter : ListAdapter<UiPlayer, LineupAdapter.LineupListViewHolder>(LineupComparator) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LineupListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_lineupitem,parent,false)
        return LineupListViewHolder(view)
    }

    override fun onBindViewHolder(holder: LineupListViewHolder, position: Int) {
        val player = getItem(position)
        holder.posHome.text = player.pos
        holder.nameHome.text = player.name
    }
    
    inner class LineupListViewHolder(lineupView: View) : RecyclerView.ViewHolder(lineupView) {
        val posHome : TextView = lineupView.posHome
        val nameHome: TextView = lineupView.nameHome
        val player: UiPlayer? = null
    }
}
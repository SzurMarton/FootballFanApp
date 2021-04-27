package com.footballfan.ui.football.leaguestandings

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.footballfan.R
import com.footballfan.ui.football.leaguestandings.model.UiStandingsAway
import com.footballfan.ui.football.leaguestandings.model.UiStandingsHome
import kotlinx.android.synthetic.main.row_standingsitem.view.*

class StandingsListHomeAdapter : ListAdapter<UiStandingsHome,StandingsListHomeAdapter.StandingsListHomeViewHolder>(StandingsListHomeComparator){
    var listener: StandingsListHomeAdapter.Listener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StandingsListHomeViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_standingsitem,parent,false)
        return StandingsListHomeViewHolder(view)
    }

    override fun onBindViewHolder(holder: StandingsListHomeViewHolder, position: Int) {
        val team = getItem(position)
        holder.teamPos.text = (position + 1).toString()
        Glide.with(holder.teamLogo)
                .load(team.teamLogo)
                .into(holder.teamLogo)
        holder.teamName.text = team.teamName
        holder.teamPlayed.text = team.playedHomeGames.toString()
        holder.teamWin.text = team.winHomeGames.toString()
        holder.teamDraw.text = team.drawHomeGames.toString()
        holder.teamLose.text = team.loseHomeGames.toString()
        holder.teamGoalsFor.text = team.goalsHomeGamesFor.toString()
        holder.teamGoalsAgainst.text = team.goalsHomeGamesAgainst.toString()
        holder.teamGoalDiff.text = team.homeGoalDiff.toString()
        holder.teamPoints.text = team.homePoints.toString()
    }

    inner class StandingsListHomeViewHolder(standingView: View) : RecyclerView.ViewHolder(standingView) {
        val teamPos: TextView = standingView.teamPos
        val teamLogo: ImageView = standingView.teamLogo
        val teamName: TextView = standingView.teamName
        val teamPlayed: TextView = standingView.teamPlayed
        val teamWin: TextView = standingView.teamWin
        val teamDraw: TextView = standingView.teamDraw
        val teamLose: TextView = standingView.teamLose
        val teamGoalsFor: TextView = standingView.teamGoalsFor
        val teamGoalsAgainst: TextView = standingView.teamGoalsAgainst
        val teamGoalDiff: TextView = standingView.teamGoalDiff
        val teamPoints: TextView = standingView.teamPoints
        var team: UiStandingsHome? = null

        init {
            standingView.setOnClickListener {
                team?.let { listener?.onTeamHomeClicked(it) }
            }
        }
    }

    interface Listener{
        fun onTeamHomeClicked(team: UiStandingsHome)
    }
}
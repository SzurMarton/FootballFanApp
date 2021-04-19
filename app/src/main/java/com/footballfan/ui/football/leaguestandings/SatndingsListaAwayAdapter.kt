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
import com.footballfan.ui.football.leaguestandings.model.UiStandingsAll
import com.footballfan.ui.football.leaguestandings.model.UiStandingsAway
import kotlinx.android.synthetic.main.row_standingsitem.view.*

class SatndingsListaAwayAdapter : ListAdapter<UiStandingsAway, SatndingsListaAwayAdapter.StandingsListAwayViewHolder>(StandingsListAwayComparator){
    var listener: SatndingsListaAwayAdapter.Listener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StandingsListAwayViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_standingsitem,parent,false)
        return StandingsListAwayViewHolder(view)
    }

    override fun onBindViewHolder(holder: StandingsListAwayViewHolder, position: Int) {
        val team = getItem(position)
        holder.teamPos.text = (position + 1).toString()
        Glide.with(holder.teamLogo)
                .load(team.teamLogo)
                .into(holder.teamLogo)
        holder.teamName.text = team.teamName
        holder.teamPlayed.text = team.playedAwayGames.toString()
        holder.teamWin.text = team.winAwayGames.toString()
        holder.teamDraw.text = team.drawAwayGames.toString()
        holder.teamLose.text = team.loseAwayGames.toString()
        holder.teamGoalsFor.text = team.goalsAwayGamesFor.toString()
        holder.teamGoalsAgainst.text = team.goalsAwayGamesAgainst.toString()
        holder.teamGoalDiff.text = team.awayGoalDiff.toString()
        holder.teamPoints.text = team.awayPoints.toString()
    }

    inner class StandingsListAwayViewHolder(standingView: View) : RecyclerView.ViewHolder(standingView) {
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
        var team: UiStandingsAway? = null

        init {
            standingView.setOnClickListener {
                team?.let { listener?.onTeamAwayClicked(it) }
            }
        }
    }

    interface Listener{
        fun onTeamAwayClicked(team: UiStandingsAway)
    }
}
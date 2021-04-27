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
import com.footballfan.ui.football.fixturelist.model.FixtureListUiData
import com.footballfan.ui.football.leaguestandings.model.UiStandingsAll
import kotlinx.android.synthetic.main.row_standingsitem.view.*

class StandingsListALLAdapter : ListAdapter<UiStandingsAll, StandingsListALLAdapter.StandingsListViewHolder>(StandingsListComparator){
    var listener: Listener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StandingsListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_standingsitem,parent,false)
        return StandingsListViewHolder(view)
    }

    override fun onBindViewHolder(holder: StandingsListViewHolder, position: Int) {
        val team = getItem(position)
        holder.teamPos.text = (position + 1).toString()
        Glide.with(holder.teamLogo)
            .load(team.teamLogo)
            .into(holder.teamLogo)
        holder.teamName.text = team.teamName
        holder.teamPlayed.text = team.playedAllGames.toString()
        holder.teamWin.text = team.winAllGames.toString()
        holder.teamDraw.text = team.drawAllGames.toString()
        holder.teamLose.text = team.loseAllGames.toString()
        holder.teamGoalsFor.text = team.goalsAllGamesFor.toString()
        holder.teamGoalsAgainst.text = team.goalsAllGamesAgainst.toString()
        holder.teamGoalDiff.text = team.goalDiff.toString()
        holder.teamPoints.text = team.points.toString()
    }

    inner class StandingsListViewHolder(standingView: View) : RecyclerView.ViewHolder(standingView) {
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
        var team: UiStandingsAll? = null

        init {
            standingView.setOnClickListener {
                team?.let { listener?.onTeamClicked(it) }
            }
        }
    }

    interface Listener{
        fun onTeamClicked(team: UiStandingsAll)
    }
}
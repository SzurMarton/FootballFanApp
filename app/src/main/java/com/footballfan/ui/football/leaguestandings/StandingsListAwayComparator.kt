package com.footballfan.ui.football.leaguestandings

import androidx.recyclerview.widget.DiffUtil
import com.footballfan.ui.football.leaguestandings.model.UiStandingsAll
import com.footballfan.ui.football.leaguestandings.model.UiStandingsAway

object StandingsListAwayComparator : DiffUtil.ItemCallback<UiStandingsAway>(){
    override fun areItemsTheSame(oldItem: UiStandingsAway, newItem: UiStandingsAway): Boolean {
        return oldItem.teamID == newItem.teamID
    }

    override fun areContentsTheSame(oldItem: UiStandingsAway, newItem: UiStandingsAway): Boolean {
        return oldItem == newItem
    }
}
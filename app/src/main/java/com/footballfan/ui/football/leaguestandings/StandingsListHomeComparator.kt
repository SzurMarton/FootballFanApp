package com.footballfan.ui.football.leaguestandings

import androidx.recyclerview.widget.DiffUtil
import com.footballfan.ui.football.leaguestandings.model.UiStandingsAway
import com.footballfan.ui.football.leaguestandings.model.UiStandingsHome

object StandingsListHomeComparator : DiffUtil.ItemCallback<UiStandingsHome>(){
    override fun areItemsTheSame(oldItem: UiStandingsHome, newItem: UiStandingsHome): Boolean {
        return oldItem.teamID == newItem.teamID
    }

    override fun areContentsTheSame(oldItem: UiStandingsHome, newItem: UiStandingsHome): Boolean {
        return oldItem == newItem
    }
}
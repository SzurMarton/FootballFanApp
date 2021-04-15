package com.footballfan.ui.football.leaguestandings

import androidx.recyclerview.widget.DiffUtil
import com.footballfan.ui.football.leaguestandings.model.UiStandingsAll

object StandingsListComparator : DiffUtil.ItemCallback<UiStandingsAll>(){
    override fun areItemsTheSame(oldItem: UiStandingsAll, newItem: UiStandingsAll): Boolean {
        return oldItem.teamID == newItem.teamID
    }

    override fun areContentsTheSame(oldItem: UiStandingsAll, newItem: UiStandingsAll): Boolean {
        return oldItem == newItem
    }
}
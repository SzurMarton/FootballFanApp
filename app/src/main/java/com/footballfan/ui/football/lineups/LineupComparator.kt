package com.footballfan.ui.football.lineups

import androidx.recyclerview.widget.DiffUtil
import com.footballfan.ui.football.fixturelist.model.FixtureListUiData
import com.footballfan.ui.football.lineups.model.UiPlayer

object LineupComparator : DiffUtil.ItemCallback<UiPlayer>(){
    override fun areItemsTheSame(oldItem: UiPlayer, newItem: UiPlayer): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: UiPlayer, newItem: UiPlayer): Boolean {
        return oldItem == newItem
    }
}
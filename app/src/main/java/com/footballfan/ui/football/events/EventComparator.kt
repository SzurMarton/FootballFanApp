package com.footballfan.ui.football.events

import androidx.recyclerview.widget.DiffUtil
import com.footballfan.ui.football.events.model.UiEvent
import com.footballfan.ui.football.fixturelist.model.FixtureListUiData

object EventComparator : DiffUtil.ItemCallback<UiEvent>(){
    override fun areItemsTheSame(oldItem: UiEvent, newItem: UiEvent): Boolean {
        return oldItem.teamID == newItem.teamID
    }

    override fun areContentsTheSame(oldItem: UiEvent, newItem: UiEvent): Boolean {
        return oldItem == newItem
    }
}
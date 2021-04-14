package com.footballfan.ui.football.fixturelist

import androidx.recyclerview.widget.DiffUtil
import com.footballfan.ui.football.fixturelist.model.FixtureListUiData

object FixtureListComparator : DiffUtil.ItemCallback<FixtureListUiData>(){
    override fun areItemsTheSame(oldItem: FixtureListUiData, newItem: FixtureListUiData): Boolean {
        return oldItem.fixtureID == newItem.fixtureID
    }

    override fun areContentsTheSame(oldItem: FixtureListUiData, newItem: FixtureListUiData): Boolean {
        return oldItem == newItem
    }
}
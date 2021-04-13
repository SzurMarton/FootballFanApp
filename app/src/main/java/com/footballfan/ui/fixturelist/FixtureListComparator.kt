package com.footballfan.ui.fixturelist

import androidx.recyclerview.widget.DiffUtil
import com.footballfan.ui.fixturelist.model.FixtureListUiData

object FixtureListComparator : DiffUtil.ItemCallback<FixtureListUiData>(){
    override fun areItemsTheSame(oldItem: FixtureListUiData, newItem: FixtureListUiData): Boolean {
        return oldItem.fixtureID == newItem.fixtureID
    }

    override fun areContentsTheSame(oldItem: FixtureListUiData, newItem: FixtureListUiData): Boolean {
        return oldItem == newItem
    }
}
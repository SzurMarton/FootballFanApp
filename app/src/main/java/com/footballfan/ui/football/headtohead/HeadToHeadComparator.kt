package com.footballfan.ui.football.headtohead

import androidx.recyclerview.widget.DiffUtil
import com.footballfan.ui.football.headtohead.model.UiH2HFixture

object HeadToHeadComparator : DiffUtil.ItemCallback<UiH2HFixture>(){
    override fun areItemsTheSame(oldItem: UiH2HFixture, newItem: UiH2HFixture): Boolean {
        return oldItem.fixtureID == newItem.fixtureID
    }

    override fun areContentsTheSame(oldItem: UiH2HFixture, newItem: UiH2HFixture): Boolean {
        return oldItem == newItem
    }
}
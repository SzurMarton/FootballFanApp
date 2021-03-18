package com.footballfan.ui.leaguelist

import androidx.recyclerview.widget.DiffUtil
import com.footballfan.ui.leaguelist.model.LeagueData


object LeagueComparator : DiffUtil.ItemCallback<LeagueData>(){
        override fun areItemsTheSame(oldItem: LeagueData, newItem: LeagueData): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: LeagueData, newItem: LeagueData): Boolean {
            return oldItem == newItem
        }
}
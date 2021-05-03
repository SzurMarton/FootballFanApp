package com.footballfan.ui.football.events

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.footballfan.R
import com.footballfan.ui.football.events.model.UiEvent
import kotlinx.android.synthetic.main.row_eventitem.view.*

class EventListAdapter : ListAdapter<UiEvent, EventListAdapter.EventViewHolder>(EventComparator){

    inner class EventViewHolder(eventView: View) : RecyclerView.ViewHolder(eventView){
        val homeEventType: TextView = eventView.homeEventType
        val eventPlayerName : TextView = eventView.eventPlayerName
        //val eventPlayerNameAway: TextView = eventView.eventPlayerNameAway
        //val eventTypeAway: TextView = eventView.awayEventType
        var event: UiEvent? = null
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_eventitem,parent,false)
        return EventViewHolder(view)
    }

    override fun onBindViewHolder(holder: EventViewHolder, position: Int) {
        val event = getItem(position)
        //TODO get away and home team ids from datasource
        holder.eventPlayerName.text = event.eventPlayerName
        holder.homeEventType.text = event.type
    }
}
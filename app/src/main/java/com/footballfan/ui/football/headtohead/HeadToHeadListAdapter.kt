package com.footballfan.ui.football.headtohead

import android.graphics.Typeface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.footballfan.R
import com.footballfan.ui.football.headtohead.model.UiH2HFixture
import kotlinx.android.synthetic.main.row_fixturelist.view.awayEventType
import kotlinx.android.synthetic.main.row_fixturelist.view.awayTeamLogo
import kotlinx.android.synthetic.main.row_fixturelist.view.eventPlayerNameAway
import kotlinx.android.synthetic.main.row_fixturelist.view.homeEventType
import kotlinx.android.synthetic.main.row_fixturelist.view.homeTeamLogo
import kotlinx.android.synthetic.main.row_fixturelist.view.eventPlayerName
import kotlinx.android.synthetic.main.row_headtoheaditem.view.*

class HeadToHeadListAdapter : ListAdapter<UiH2HFixture,HeadToHeadListAdapter.HeadToHeadViewHolder>(HeadToHeadComparator) {
    var listener: Listener? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeadToHeadViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_headtoheaditem,parent,false)
        return HeadToHeadViewHolder(view)
    }

    override fun onBindViewHolder(holder: HeadToHeadViewHolder, position: Int) {
        val fixture = getItem(position)
        holder.fixture = fixture
        holder.homeTeamName.text = fixture.homeTeamName
        holder.awayTeamName.text = fixture.awayTeamName
        if(fixture.homeGoals.equals("null")){
            holder.homeTeamScore.text = "-"
        }
        else{
            holder.homeTeamScore.text = fixture.homeGoals
        }
        if(fixture.awayGoals.equals("null")){
            holder.awayTeamScore.text = "-"
        }
        else{
            holder.awayTeamScore.text = fixture.awayGoals
        }
        Glide.with(holder.homeTeamLogo)
                .load(fixture.homeTeamLogo)
                .into(holder.homeTeamLogo)
        Glide.with(holder.awayTeamLogo)
                .load(fixture.awayTeamLogo)
                .into(holder.awayTeamLogo)
        if(fixture.homeWinner) {
            holder.homeTeamName.setTypeface(null, Typeface.BOLD)
        }
        if(fixture.awayWinner){
            holder.awayTeamName.setTypeface(null, Typeface.BOLD)
        }
        holder.date.text = fixture.date
    }

    inner class HeadToHeadViewHolder(headToHeadView: View) : RecyclerView.ViewHolder(headToHeadView){
        val homeTeamLogo: ImageView = headToHeadView.homeTeamLogo
        val homeTeamName: TextView = headToHeadView.eventPlayerName
        val homeTeamScore: TextView = headToHeadView.homeEventType
        val awayTeamLogo: ImageView = headToHeadView.awayTeamLogo
        val awayTeamName: TextView = headToHeadView.eventPlayerNameAway
        val awayTeamScore: TextView = headToHeadView.awayEventType
        val date: TextView = headToHeadView.date
        var fixture: UiH2HFixture? = null

        init {
            headToHeadView.setOnClickListener {
                fixture?.let { listener?.onFixtureClicked(it) }
            }
        }
    }

    interface Listener{
        fun onFixtureClicked(fixture: UiH2HFixture)
    }
}
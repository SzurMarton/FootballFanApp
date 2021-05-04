package com.footballfan.ui.football.fixturelist

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
import com.footballfan.ui.football.fixturelist.model.FixtureListUiData
import kotlinx.android.synthetic.main.row_fixturelist.view.awayEventType
import kotlinx.android.synthetic.main.row_fixturelist.view.awayTeamLogo
import kotlinx.android.synthetic.main.row_fixturelist.view.eventPlayerNameAway
import kotlinx.android.synthetic.main.row_fixturelist.view.homeEventType
import kotlinx.android.synthetic.main.row_fixturelist.view.homeTeamLogo
import kotlinx.android.synthetic.main.row_fixturelist.view.eventPlayerName

class FixtureListAdapter : ListAdapter<FixtureListUiData, FixtureListAdapter.FixtureListViewHolder>(FixtureListComparator) {
    var listener: Listener? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FixtureListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_fixturelist,parent,false)
        return FixtureListViewHolder(view)
    }

    override fun onBindViewHolder(holder: FixtureListViewHolder, position: Int) {
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
        if(fixture.homeTeamWinner) {
            holder.homeTeamName.setTypeface(null, Typeface.BOLD)
        }
        if(fixture.awayTeamWinner){
            holder.awayTeamName.setTypeface(null, Typeface.BOLD)
        }
    }


    inner class FixtureListViewHolder(fixtureView: View) : RecyclerView.ViewHolder(fixtureView) {
        val homeTeamLogo: ImageView = fixtureView.homeTeamLogo
        val homeTeamName:TextView = fixtureView.eventPlayerName
        val homeTeamScore:TextView = fixtureView.homeEventType
        val awayTeamLogo: ImageView = fixtureView.awayTeamLogo
        val awayTeamName:TextView = fixtureView.eventPlayerNameAway
        val awayTeamScore:TextView = fixtureView.awayEventType
        var fixture: FixtureListUiData? = null

        init {
            fixtureView.setOnClickListener {
                fixture?.let { listener?.onFixtureClicked(it) }
            }
        }
    }

    interface Listener{
        fun onFixtureClicked(fixture: FixtureListUiData)
    }
}

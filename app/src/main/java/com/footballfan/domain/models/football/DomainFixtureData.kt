package com.footballfan.domain.models.football

import com.footballfan.data.network.football.models.FixtureData

//uses data classes from the network model for now
data class DomainFixtureData(val fixtures: List<DomainFixture>?)

data class DomainFixture(
        //TODO delete useless data
        val fixtureID:Int?,
        val referee: String?,
        val timezone:String?,
        val timestamp:Int?,
        val date: String?,
        val firstPeriod:Int?,
        val secondPeriod:Int?,
        val venueID:Int?,
        val venueName:String?,
        val venueCity:String?,
        val statusLong:String?,
        val statusShort:String?,
        val statusElapsed:String?, //matchtime (90 min...)
        val leagueID: Int?,
        val leagueName:String?,
        val leagueCountry: String?,
        val leagueLogo:String?,
        val leagueFlag:String?,
        val leagueSeason: String?,
        val leagueRound: String?,
        val homeTeamID:Int?,
        val homeTeamName:String?,
        val homeTeamLogo:String?,
        val homeTeamWinner:Boolean?,
        val awayTeamID:Int?,
        val awayTeamName:String?,
        val awayTeamLogo:String?,
        val awayTeamWinner:Boolean?,
        val homeGoals:Int?,
        val awayGoals:Int?,
        val homeScoreHalftime:Int?,
        val awayScoreHalftime:Int?,
        val homeScoreFulltime:Int?,
        val awayScoreFulltime:Int?,
        val homeScoreExtratime:Int?,
        val awayScoreExtratime:Int?,
        val homePenalty:Int?,
        val awayPenalty:Int?
)
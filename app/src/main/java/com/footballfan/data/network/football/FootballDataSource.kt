package com.footballfan.data.network.football

import com.footballfan.domain.models.football.*
import com.footballfan.networkutil.NetworkResponse
import com.footballfan.networkutil.executeNetworkCall
import retrofit2.http.Query

import javax.inject.Inject

class FootballDataSource @Inject constructor(private val footballApi: FootballApi){
    suspend fun getLeagues(season: Int) : NetworkResponse<DomainLeagueData> =
            executeNetworkCall{
                DomainLeagueData(
                        leagues = footballApi.getLeagues(season).response
                )
            }

    suspend fun getRounds(season: Int,leagueID: Int) : NetworkResponse<DomainRoundsData> =
            executeNetworkCall {
                footballApi.getRounds(season,leagueID).let {
                    DomainRoundsData(
                            rounds = it.response
                    )
                }
            }

    suspend fun getFixtures(season: Int,leagueID: Int) : NetworkResponse<DomainFixtureData> =
            executeNetworkCall {
                DomainFixtureData(
                        fixtures = footballApi.getFixtures(season,leagueID).response?.map {
                            DomainFixture(
                                    fixtureID = it.fixture?.id,
                                    referee = it.fixture?.referee,
                                    timezone = it.fixture?.timezone,
                                    timestamp = it.fixture?.timestamp,
                                    date = it.fixture?.date,
                                    firstPeriod = it.fixture?.periods?.first,
                                    secondPeriod = it.fixture?.periods?.second,
                                    venueID = it.fixture?.venue?.id,
                                    venueName = it.fixture?.venue?.name,
                                    venueCity = it.fixture?.venue?.city,
                                    statusLong = it.fixture?.status?.long,
                                    statusShort = it.fixture?.status?.short,
                                    statusElapsed = it.fixture?.status?.elapsed,
                                    leagueID = it.league?.id,
                                    leagueName = it.league?.name,
                                    leagueCountry = it.league?.country,
                                    leagueFlag = it.league?.flag,
                                    leagueLogo = it.league?.logo,
                                    leagueRound = it.league?.round,
                                    leagueSeason = it.league?.season,
                                    homeTeamID = it.teams?.home?.id,
                                    homeTeamName = it.teams?.home?.name,
                                    homeTeamLogo = it.teams?.home?.logo,
                                    homeTeamWinner = it.teams?.home?.winner,
                                    awayTeamID = it.teams?.away?.id,
                                    awayTeamName = it.teams?.away?.name,
                                    awayTeamLogo = it.teams?.away?.logo,
                                    awayTeamWinner = it.teams?.away?.winner,
                                    homeGoals = it.goals?.home,
                                    awayGoals = it.goals?.away,
                                    homeScoreHalftime = it.score?.halftime?.home,
                                    awayScoreHalftime = it.score?.halftime?.away,
                                    homeScoreFulltime = it.score?.fulltime?.home,
                                    awayScoreFulltime = it.score?.fulltime?.away,
                                    homeScoreExtratime = it.score?.extratime?.home,
                                    awayScoreExtratime = it.score?.extratime?.away,
                                    homePenalty = it.score?.penalty?.home,
                                    awayPenalty = it.score?.penalty?.away
                            )
                        }
                )
            }

    suspend fun getEvents(fixtureID: String) : NetworkResponse<DomainEventsData> =
            executeNetworkCall {
                DomainEventsData(
                        events = footballApi.getEvents(fixtureID).response?.map {
                            DomainEvent(
                                    time = it.time?.elapsed,
                                    teamID = it.team?.id,
                                    teamName = it.team?.name,
                                    logo = it.team?.logo,
                                    eventPlayerID = it.player?.id,
                                    eventPlayerName = it.player?.name,
                                    eventAssistID = it.assist?.id,
                                    eventAssistName = it.assist?.name
                            )
                        }
                )
            }

    suspend fun getStats(fixtureID: String) : NetworkResponse<DomainStatsData> =
            executeNetworkCall {
                footballApi.getStats(fixtureID).let {
                    DomainStatsData(
                            stats = it.response
                    )
                }
            }

    suspend fun getLineUps(fixtureID: String) : NetworkResponse<DomainLineUpsData> =
            executeNetworkCall {
                footballApi.getLineUps(fixtureID).let {
                    DomainLineUpsData(
                            lineups = it.response
                    )
                }
            }

    suspend fun getHeadtohead( teamIDs: String) : NetworkResponse<DomainH2HData> =
            executeNetworkCall {
                footballApi.getHeadtohead(teamIDs).let {
                    DomainH2HData(
                            h2h = it.response
                    )
                }
            }

    suspend fun getStanding(season: Int, leagueid: Int) : NetworkResponse<DomainStandingsData> =
            executeNetworkCall {
                footballApi.getStandings(season, leagueid).response.first().let { it ->
                    DomainStandingsData(
                            leagueID = it.league.id,
                            leagueLogo = it.league.logo,
                            leagueName = it.league.name,
                            season = it.league.season,
                            standings = it.league.standings.first().map {
                                DomainStandings(
                                        teamID = it.team.id,
                                        teamLogo = it.team.logo,
                                        teamName = it.team.name,
                                        drawAllGames = it.all.draw,
                                        goalsAllGamesFor = it.all.goals.`for`,
                                        goalsAllGamesAgainst = it.all.goals.against,
                                        loseAllGames = it.all.lose,
                                        winAllGames = it.all.win,
                                        drawAwayGames = it.away.draw,
                                        goalsAwayGamesAgainst = it.away.goals.against,
                                        goalsAwayGamesFor = it.away.goals.`for`,
                                        loseAwayGames = it.away.lose,
                                        winAwayGames = it.away.win,
                                        drawHomeGames = it.home.draw,
                                        winHomeGames = it.home.win,
                                        loseHomeGames = it.home.lose,
                                        goalsHomeGamesAgainst = it.home.goals.against,
                                        goalsHomeGamesFor = it.home.goals.`for`,
                                        playedAllGames = it.all.played,
                                        playedAwayGames = it.away.played,
                                        playedHomeGames = it.home.played,
                                        goalsDiff = it.goalsDiff,
                                        points = it.points
                                //TODO handle leagues where List<List> has more than 1 object
                                )
                            }
                    )
                }
            }
}
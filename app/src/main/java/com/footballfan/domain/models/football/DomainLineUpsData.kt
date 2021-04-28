package com.footballfan.domain.models.football

import com.footballfan.data.network.football.models.LineUpData
import com.footballfan.data.network.football.models.PlayerLineUp

data class DomainLineUpsData(
    val homeCoachName: String?,
    val homeFormation: String?,
    val awayCoachName: String?,
    val awayFormation: String?,
    val homeStartXI: List<PlayerLineUp>?, // we can use the PlayerLine no need to transform because we need all data in PlayerLineup
    val awayStartXI: List<PlayerLineUp>?,
    val homeSubstitutes: List<PlayerLineUp>?,
    val awaySubstitutes: List<PlayerLineUp>?
)
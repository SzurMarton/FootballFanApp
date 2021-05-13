package com.footballfan.domain.models.football

import com.footballfan.data.network.football.models.PlayerLineUp
import com.footballfan.data.network.football.models.StartXI
import com.footballfan.data.network.football.models.Substitute

data class DomainLineUpsData(
    val homeCoachName: String?,
    val homeFormation: String?,
    val awayCoachName: String?,
    val awayFormation: String?,
    val homeStartXI: List<StartXI>?, // we can use the PlayerLine no need to transform because we need all data in PlayerLineup
    val awayStartXI: List<StartXI>?,
    val homeSubstitutes: List<Substitute>?,
    val awaySubstitutes: List<Substitute>?
)
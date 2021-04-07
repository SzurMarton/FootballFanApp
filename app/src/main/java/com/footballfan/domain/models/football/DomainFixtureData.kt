package com.footballfan.domain.models.football

import com.footballfan.data.network.football.models.FixtureData

//uses data classes from the network model for now
data class DomainFixtureData(val fixtures: List<FixtureData>?)
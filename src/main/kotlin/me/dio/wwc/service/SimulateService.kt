package me.dio.wwc.service

import me.dio.wwc.domain.model.Team

interface SimulateService {
    fun simulate(team1Id: String, team2Id: String): Team

}

package me.dio.wwc.domain.model

import jakarta.persistence.Entity
import jakarta.persistence.Id

@Entity(name = "tb_team")
data class Team(
        @Id
        var abbreviation: String,
        var name: String,
        var fifaRanking: Double
)
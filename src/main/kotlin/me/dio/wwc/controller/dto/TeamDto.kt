package me.dio.wwc.controller.dto

import me.dio.wwc.domain.model.Team
import java.math.BigDecimal

data class TeamDto(
        val id: String,
        val name: String,
        val score: BigDecimal
) {
    companion object {
        fun fromModel(model: Team): TeamDto {
            return TeamDto(model.id, model.name, model.score)
        }
    }

    fun toModel(): Team {
        return Team(this.id, this.name, this.score)
    }
}
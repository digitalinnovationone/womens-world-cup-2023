package me.dio.wwc.controller.dto

import me.dio.wwc.domain.model.Team
import java.math.BigDecimal

data class TeamDto(
    val id: String,
    val name: String,
    val score: BigDecimal
) {
    constructor(model: Team) : this(
        id = model.id,
        name = model.name,
        score = model.score
    )

    fun toModel(): Team {
        return Team(this.id, this.name, this.score)
    }
}
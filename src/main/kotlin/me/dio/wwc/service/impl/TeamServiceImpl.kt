package me.dio.wwc.service.impl

import me.dio.wwc.domain.model.Team
import me.dio.wwc.domain.repository.TeamRepository
import me.dio.wwc.service.TeamService
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class TeamServiceImpl(private val teamRepository: TeamRepository) : TeamService {

    @Transactional(readOnly = true)
    override fun findAll(): List<Team> {
        return teamRepository.findAll()
    }

    @Transactional(readOnly = true)
    override fun findById(id: String): Team {
        return teamRepository.findById(id).orElseThrow { NoSuchElementException("Team not found with abbreviation: $id") }
    }

    @Transactional
    override fun create(model: Team): Team {
        if (teamRepository.existsById(model.abbreviation)) {
            throw IllegalArgumentException("Team with abbreviation ${model.abbreviation} already exists")
        }
        return teamRepository.save(model)
    }

    @Transactional
    override fun update(id: String, model: Team): Team {
        if (model.abbreviation != id) {
            throw IllegalArgumentException("The abbreviations to be updated must be the same")
        }
        val dbTeam = this.findById(id)

        dbTeam.name = model.name
        dbTeam.fifaRanking = model.fifaRanking

        return teamRepository.save(dbTeam)
    }

    @Transactional
    override fun delete(id: String) {
        val dbTeam = this.findById(id)
        teamRepository.delete(dbTeam)
    }
}
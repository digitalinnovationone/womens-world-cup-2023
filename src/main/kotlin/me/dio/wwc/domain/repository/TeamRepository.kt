package me.dio.wwc.domain.repository

import me.dio.wwc.domain.model.Team
import org.springframework.data.jpa.repository.JpaRepository

interface TeamRepository : JpaRepository<Team, String>
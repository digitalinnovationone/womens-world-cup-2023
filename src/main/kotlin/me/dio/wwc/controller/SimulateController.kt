package me.dio.wwc.controller

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import io.swagger.v3.oas.annotations.tags.Tag
import me.dio.wwc.controller.dto.TeamDto
import me.dio.wwc.service.SimulateService
import me.dio.wwc.service.TeamService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/simulate")
@Tag(name = "Simulate Controller", description = "RESTful API for simulate matches.")
class SimulateController(private val simulateService: SimulateService) {

    @GetMapping("/{team1Id}/{team2Id}")
    @Operation(summary = "Simulate a match between two teams", description = "Simulate a Women's World Cup match between two teams.")
    @ApiResponses(value = [
        ApiResponse(responseCode = "200", description = "Simulate successful"),
        ApiResponse(responseCode = "422", description = "Team(s) not found in the Women's World Cup")
    ])
    fun simulate(@PathVariable team1Id: String, @PathVariable team2Id: String): ResponseEntity<TeamDto> {
        val winner = simulateService.simulate(team1Id, team2Id)
        return ResponseEntity.ok(TeamDto(winner))
    }
}
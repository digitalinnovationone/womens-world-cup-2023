package me.dio.wwc.service.impl

import me.dio.wwc.domain.model.Team
import me.dio.wwc.infra.openai.ChatGptService
import me.dio.wwc.infra.openai.dto.ChatCompletionRequest
import me.dio.wwc.infra.openai.dto.Message
import me.dio.wwc.service.SimulateService
import me.dio.wwc.service.TeamService
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service

@Service
class SimulateServiceImpl(
    private val teamService: TeamService,
    private val chatGptService: ChatGptService,
    @Value("\${openai.api-key}")
    private val openAiApiKey: String
) : SimulateService {

    val womenWorldCupTeams = teamService.findAll()
    override fun simulate(team1Id: String, team2Id: String): Team {
        val team1 = teamService.findById(team1Id)
        val team2 = teamService.findById(team2Id)

        val trainingData = womenWorldCupTeams.joinToString("\n") { "${it.id} (${it.score})" }

        val messages = listOf(
            Message(
                "system",
                """
                    Você é um modelo de análise estatística com foco em simulação de partidas de futebol feminino.
                    Nesse contexto, considere o seguinte ranking da FIFA para entender a força de cada seleção:
                    $trainingData
                """
            ),
            Message(
                "user",
                "Simule a partida entre ${team1.id} e ${team2.id}. Me retorne apenas a seleção vencedora, não divague."
            )
        )

        val authorization = "Bearer $openAiApiKey"
        val request = ChatCompletionRequest("gpt-4", messages)

        val response = chatGptService.createChatCompletion(authorization, request)

        return if (team1.id == response.choices.first().message.content) team1 else team2
    }

}
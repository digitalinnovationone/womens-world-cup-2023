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
    private val openAiApiKey: String,
) : SimulateService {

    val womenWorldCup2023Teams = teamService.findAll()

    override fun simulate(team1Id: String, team2Id: String): Team {
        val team1 = teamService.findById(team1Id)
        val team2 = teamService.findById(team2Id)

        val trainingData = womenWorldCup2023Teams.joinToString("\n") { "${it.id} (${it.score})" }

        val authorization = "Bearer $openAiApiKey"
        val request = ChatCompletionRequest("gpt-4", messages = listOf(
            Message(
                "system",
                """
                    Atue como um modelo de análise estatística para simulação de partidas de futebol feminino.
                    Considere os seguintes dados de treinamento, no formato {SIGLA_SELECAO} ({PONTOS_RANKING_FIFA}):
                    $trainingData
                """.trimIndent()),
            Message(
                "user",
                "Simule a partida entre ${team1.id} vs ${team2.id}. Me envie como resposta apenas a sigla da seleção vencedora, não divague!")

        ))
        val response = chatGptService.createChatCompletion(authorization, request)

        return if (response.choices.first().message.content == team1.id) team1 else team2
    }

}
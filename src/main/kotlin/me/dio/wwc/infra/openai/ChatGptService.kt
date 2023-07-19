package me.dio.wwc.infra.openai

import me.dio.wwc.infra.openai.dto.ChatCompletionRequest
import me.dio.wwc.infra.openai.dto.ChatCompletionResponse
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.http.HttpHeaders
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestHeader

/**
 * Cool references from OpenAI ;)
 *
 * https://platform.openai.com/docs/api-reference/chat/create (API Documentation)
 * https://www.postman.com/devrel/workspace/openai/collection/13183464-90abb798-cb85-43cb-ba3a-ae7941e968da (Postman)
 */
@FeignClient(name = "openai", url = "https://api.openai.com/v1/")
interface ChatGptService {

    @PostMapping("chat/completions")
    fun createChatCompletion(
        @RequestHeader(HttpHeaders.AUTHORIZATION) authorization: String,
        @RequestBody request: ChatCompletionRequest
    ): ChatCompletionResponse
}

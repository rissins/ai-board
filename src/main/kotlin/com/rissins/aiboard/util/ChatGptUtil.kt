package com.rissins.aiboard.util

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.beans.factory.annotation.Value
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.WebClientResponseException
import reactor.core.publisher.Mono
import reactor.util.retry.Retry
import java.time.Duration

@Component
class ChatGptUtil(
    private val webClient: WebClient,
    private val objectMapper: ObjectMapper,
    @Value("\${openai.api.key}")
    private val apiKey: String
) {
    private val apiUrl = "https://api.openai.com/v1/chat/completions"

    fun getChatResponse(prompt: String): Mono<String> {
        val request = mapOf(
            "model" to "gpt-3.5-turbo",
            "messages" to listOf(
                mapOf("role" to "system", "content" to "You are a helpful assistant."),
                mapOf("role" to "user", "content" to prompt)
            )
        )

        return webClient.post()
            .uri(apiUrl)
            .header("Authorization", "Bearer $apiKey")
            .header("Content-Type", "application/json")
            .bodyValue(request)
            .retrieve()
            .bodyToMono(String::class.java)
            .map { response ->
                val jsonNode = objectMapper.readTree(response)
                jsonNode["choices"][0]["message"]["content"].asText()
            }
            .retryWhen(
                Retry.backoff(5, Duration.ofSeconds(1))
                    .filter { throwable ->
                        throwable is WebClientResponseException && throwable.statusCode == HttpStatus.TOO_MANY_REQUESTS
                    }
            )
    }
}
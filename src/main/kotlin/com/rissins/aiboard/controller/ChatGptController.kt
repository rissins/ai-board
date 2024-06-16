package com.rissins.aiboard.controller

import com.rissins.aiboard.util.ChatGptUtil
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono

@RestController
class ChatGptController(private val chatGptUtil: ChatGptUtil) {

    @GetMapping("/chat")
    fun chat(@RequestParam prompt: String): Mono<String> {
        return chatGptUtil.getChatResponse(prompt)
    }
}
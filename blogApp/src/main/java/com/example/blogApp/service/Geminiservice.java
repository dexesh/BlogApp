package com.example.blogApp.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Map;

@Service
public class Geminiservice {
    @Value("${gemini.api.key}")
    private String apiKey;
    private final WebClient webClient;
    public Geminiservice(WebClient.Builder webClientBuilder){
        this.webClient=webClientBuilder.baseUrl("https://generativelanguage.googleapis.com/v1/models/gemini-1.5-pro:generateContent").build();
    }
    public Mono<String> generateSummary(String content){
        String prompt = "Summarize this blog content in 50 words: " + content;

        Map<String, Object> requestBody = Map.of(
                "contents", new Object[]{
                        Map.of("parts", new Object[]{
                                Map.of("text", prompt)
                        })
                }
        );
        return webClient.post()
                .uri(uriBuilder -> uriBuilder.queryParam("key", apiKey).build())
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(requestBody)
                .retrieve()
                .bodyToMono(String.class)
                .onErrorResume(e -> Mono.just("Error: " + e.getMessage()));
    }
}

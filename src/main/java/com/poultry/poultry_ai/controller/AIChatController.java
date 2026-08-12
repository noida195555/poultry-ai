package com.poultry.poultry_ai.controller;

import com.poultry.poultry_ai.dto.request.ChatRequest;
import com.poultry.poultry_ai.dto.response.ChatResponse;
import com.poultry.poultry_ai.service.AIChatService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/ai")
public class AIChatController {

    private final AIChatService aiChatService;

    public AIChatController(AIChatService aiChatService) {
        this.aiChatService = aiChatService;
    }

    @PostMapping("/chat")
    public ResponseEntity<ChatResponse> chat(
             @Valid @RequestBody ChatRequest request) {

        ChatResponse response = aiChatService.chat(request);

        return ResponseEntity.ok(response);
    }
}

package com.poultry.poultry_ai.service.impl;

import com.poultry.poultry_ai.ai.prompt.PromptBuilder;
import com.poultry.poultry_ai.dto.request.ChatRequest;
import com.poultry.poultry_ai.dto.response.ChatResponse;
import com.poultry.poultry_ai.service.AIChatService;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.messages.SystemMessage;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AIChatServiceImpl implements AIChatService {

    private final ChatClient chatClient;

    private final PromptBuilder promptBuilder;

    @Autowired
    public AIChatServiceImpl(ChatClient.Builder builder,
                             PromptBuilder promptBuilder) {

        this.chatClient = builder.build();

        this.promptBuilder = promptBuilder;
    }

    @Override
    public ChatResponse chat(ChatRequest request) {
        Prompt prompt= promptBuilder.build(request);
        String  llmResponse = chatClient.prompt(prompt).call().content();
        return new ChatResponse(llmResponse);
    }

}
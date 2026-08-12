package com.poultry.poultry_ai.service;

import com.poultry.poultry_ai.dto.request.ChatRequest;
import com.poultry.poultry_ai.dto.response.ChatResponse;

public interface AIChatService {
    ChatResponse chat(ChatRequest request);
}

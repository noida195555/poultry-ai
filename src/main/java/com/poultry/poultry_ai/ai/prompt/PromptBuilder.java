package com.poultry.poultry_ai.ai.prompt;

import com.poultry.poultry_ai.constants.AIConstants;
import com.poultry.poultry_ai.dto.request.ChatRequest;
import org.springframework.ai.chat.messages.SystemMessage;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.stereotype.Component;

import java.util.List;

//PromptBuilder is responsible for constructing the final prompt that will be sent to the LLM.
//System Prompt+ Conversation History+User Question+Farm Information+Weather+Response Format->Final Prompt
@Component
public class PromptBuilder{

    public Prompt build(ChatRequest request) {

        SystemMessage systemMessage = createSystemMessage();

        UserMessage userMessage = createUserMessage(request);

        return new Prompt(List.of(systemMessage, userMessage));
    }

    private UserMessage createUserMessage(ChatRequest request) {
        return new UserMessage(request.message());
    }

    private SystemMessage createSystemMessage() {
       return new SystemMessage(SystemPrompts.POULTRY_ASSISTANT);
    }
}

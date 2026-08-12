package com.poultry.poultry_ai.dto.request;

import jakarta.validation.constraints.NotBlank;

public record ChatRequest(

        @NotBlank(message = "Message cannot be blank")
        String message

) {
}


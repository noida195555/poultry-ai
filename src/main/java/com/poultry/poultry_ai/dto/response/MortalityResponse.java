package com.poultry.poultry_ai.dto.response;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record MortalityResponse(
        Long id,
        Long flockId,
        String shedId,
        LocalDate mortalityDate,
        int count,
        String cause,
        String notes,
        LocalDateTime recordedAt
) {
}

package com.poultry.poultry_ai.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record MortalityRequest(

        @NotNull(message = "Flock ID is required")
        Long flockId,

        @NotBlank(message = "Shed ID is required")
        String shedId,

        @NotNull(message = "Mortality date is required")
        LocalDate mortalityDate,

        @Min(value = 1, message = "Mortality count must be at least 1")
        int count,

        String cause,

        String notes
) {
}

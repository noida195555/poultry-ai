package com.poultry.poultry_ai.exception;

public class MortalityNotFoundException extends RuntimeException {

    public MortalityNotFoundException(Long id) {
        super("Mortality record not found with id: " + id);
    }
}

package com.poultry.poultry_ai.controller;

import com.poultry.poultry_ai.dto.request.MortalityRequest;
import com.poultry.poultry_ai.dto.response.MortalityResponse;
import com.poultry.poultry_ai.service.mortality.MortalityService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/v1/mortality")
public class MortalityController {

    private final MortalityService mortalityService;

    public MortalityController(MortalityService mortalityService) {
        this.mortalityService = mortalityService;
    }

    @PostMapping
    public ResponseEntity<MortalityResponse> createMortality(
            @Valid @RequestBody MortalityRequest request) {

        MortalityResponse mortalityresponse = mortalityService.createMortality(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(mortalityresponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MortalityResponse> getMortalityById(@PathVariable Long id) {
        MortalityResponse mortalityresponse = mortalityService.getMortalityById(id);
        return ResponseEntity.ok(mortalityresponse);
    }

    @GetMapping
    public ResponseEntity<List<MortalityResponse>> getAllMortalities() {
        List<MortalityResponse> response = mortalityService.getAllMortalities();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/flock/{flockId}")
    public ResponseEntity<List<MortalityResponse>> getMortalitiesByFlock(
            @PathVariable Long flockId) {

        List<MortalityResponse> response = mortalityService.getMortalitiesByFlock(flockId);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/date/{date}")
    public ResponseEntity<List<MortalityResponse>> getMortalitiesByDate(
            @PathVariable LocalDate date) {

        List<MortalityResponse> response = mortalityService.getMortalitiesByDate(date);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MortalityResponse> updateMortality(
            @PathVariable Long id,
            @Valid @RequestBody MortalityRequest request) {

        MortalityResponse mortalityresponse = mortalityService.updateMortality(id, request);
        return ResponseEntity.ok(mortalityresponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMortality(@PathVariable Long id) {
        mortalityService.deleteMortality(id);
        return ResponseEntity.noContent().build();
    }
}

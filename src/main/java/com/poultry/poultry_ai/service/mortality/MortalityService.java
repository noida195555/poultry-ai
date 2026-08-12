package com.poultry.poultry_ai.service.mortality;

import com.poultry.poultry_ai.dto.request.MortalityRequest;
import com.poultry.poultry_ai.dto.response.MortalityResponse;

import java.time.LocalDate;
import java.util.List;

public interface MortalityService {

    MortalityResponse createMortality(MortalityRequest request);

    MortalityResponse getMortalityById(Long id);

    List<MortalityResponse> getAllMortalities();

    List<MortalityResponse> getMortalitiesByFlock(Long flockId);

    List<MortalityResponse> getMortalitiesByDate(LocalDate date);

    MortalityResponse updateMortality(Long id, MortalityRequest request);

    void deleteMortality(Long id);

    int getTodayMortality();

    int getTodayMortalityByFlock(Long flockId);
}

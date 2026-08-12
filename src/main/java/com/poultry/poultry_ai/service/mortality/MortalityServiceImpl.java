package com.poultry.poultry_ai.service.mortality;

import com.poultry.poultry_ai.dto.request.MortalityRequest;
import com.poultry.poultry_ai.dto.response.MortalityResponse;
import com.poultry.poultry_ai.entity.Mortality;
import com.poultry.poultry_ai.exception.MortalityNotFoundException;
import com.poultry.poultry_ai.repository.MortalityRepository;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
public class MortalityServiceImpl implements MortalityService {

    private final MortalityRepository mortalityRepository;

    public MortalityServiceImpl(MortalityRepository mortalityRepository) {
        this.mortalityRepository = mortalityRepository;
    }

    @Override
    @Transactional
    @Tool(description = "Records a new mortality event for a flock. Requires flock ID, date, count of dead birds, optional cause and notes.")
    public MortalityResponse createMortality(MortalityRequest request) {
        Mortality mortality = Mortality.builder()
                .flockId(request.flockId())
                .shedId(request.shedId())
                .mortalityDate(request.mortalityDate())
                .count(request.count())
                .cause(request.cause())
                .notes(request.notes())
                .build();

        Mortality saved = mortalityRepository.save(mortality);
        return toResponse(saved);
    }

    @Override
    @Transactional(readOnly = true)
    @Tool(description = "Retrieves a specific mortality record by its unique ID. Returns full details including flock ID, date, count, cause, and notes.")
    public MortalityResponse getMortalityById(Long id) {
        Mortality mortality = findOrThrow(id);
        return toResponse(mortality);
    }

    @Override
    @Transactional(readOnly = true)
    @Tool(description = "Retrieves all mortality records across all flocks and all dates.")
    public List<MortalityResponse> getAllMortalities() {
        return mortalityRepository.findAll()
                .stream()
                .map(this::toResponse)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    @Tool(description = "Retrieves all mortality records for a specific flock identified by flock ID.")
    public List<MortalityResponse> getMortalitiesByFlock(Long flockId) {
        return mortalityRepository.findByFlockId(flockId)
                .stream()
                .map(this::toResponse)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    @Tool(description = "Retrieves all mortality records for a specific date (format: YYYY-MM-DD) across all flocks.")
    public List<MortalityResponse> getMortalitiesByDate(LocalDate date) {
        return mortalityRepository.findByMortalityDate(date)
                .stream()
                .map(this::toResponse)
                .toList();
    }

    @Override
    @Transactional
    @Tool(description = "Updates an existing mortality record identified by ID. Replaces flock ID, date, count, cause, and notes with the provided values.")
    public MortalityResponse updateMortality(Long id, MortalityRequest request) {
        Mortality mortality = findOrThrow(id);

        mortality.setFlockId(request.flockId());
        mortality.setMortalityDate(request.mortalityDate());
        mortality.setCount(request.count());
        mortality.setCause(request.cause());
        mortality.setNotes(request.notes());

        Mortality updated = mortalityRepository.save(mortality);
        return toResponse(updated);
    }

    @Override
    @Transactional
    @Tool(description = "Deletes a mortality record by its unique ID. This action is irreversible.")
    public void deleteMortality(Long id) {
        if (!mortalityRepository.existsById(id)) {
            throw new MortalityNotFoundException(id);
        }
        mortalityRepository.deleteById(id);
    }

    @Override
    @Tool(description = "Returns the total number of bird deaths recorded today across all flocks.")
    public int getTodayMortality() {
        return mortalityRepository.sumCountByDate(LocalDate.now());
    }

    @Override
    @Tool(description = "Returns the total number of bird deaths recorded today for a specific flock identified by flock ID.")
    public int getTodayMortalityByFlock(Long flockId) {
        return mortalityRepository.sumCountByFlockIdAndDate(flockId, LocalDate.now());
    }

    // --- helpers ---

    private Mortality findOrThrow(Long id) {
        return mortalityRepository.findById(id)
                .orElseThrow(() -> new MortalityNotFoundException(id));
    }

    private MortalityResponse toResponse(Mortality m) {
        return new MortalityResponse(
                m.getId(),
                m.getFlockId(),
                m.getShedId(),
                m.getMortalityDate(),
                m.getCount(),
                m.getCause(),
                m.getNotes(),
                m.getRecordedAt()
        );
    }
}

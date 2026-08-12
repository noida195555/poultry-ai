package com.poultry.poultry_ai.repository;

import com.poultry.poultry_ai.entity.Mortality;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface MortalityRepository extends JpaRepository<Mortality, Long> {

    List<Mortality> findByFlockId(Long flockId);

    List<Mortality> findByMortalityDate(LocalDate date);

    List<Mortality> findByFlockIdAndMortalityDate(Long flockId, LocalDate date);

    @Query("SELECT COALESCE(SUM(m.count), 0) FROM Mortality m WHERE m.mortalityDate = :date")
    int sumCountByDate(@Param("date") LocalDate date);

    @Query("SELECT COALESCE(SUM(m.count), 0) FROM Mortality m WHERE m.flockId = :flockId AND m.mortalityDate = :date")
    int sumCountByFlockIdAndDate(@Param("flockId") Long flockId, @Param("date") LocalDate date);
}

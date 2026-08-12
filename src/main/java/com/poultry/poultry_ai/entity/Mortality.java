package com.poultry.poultry_ai.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "mortality")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Mortality {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "flock_id", nullable = false)
    private Long flockId;

    @Column(name = "mortality_date", nullable = false)
    private LocalDate mortalityDate;

    @Column(name = "count", nullable = false)
    private int count;

    @Column(name = "shed_id", nullable = false)
    private String shedId;

    @Column(name = "cause")
    private String cause;

    @Column(name = "notes")
    private String notes;

    @Column(name = "recorded_at", nullable = false, updatable = false)
    private LocalDateTime recordedAt;

    @PrePersist
    protected void onCreate() {
        this.recordedAt = LocalDateTime.now();
    }
}

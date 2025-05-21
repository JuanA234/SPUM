package com.example.spum_backend.service.interfaces.internal;

import com.example.spum_backend.entity.Penalty;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface PenaltyServiceEntity {

    Penalty getPenaltyById(Long id);
    Penalty savePenalty(Penalty penalty);
    Optional<Penalty> findActivePenalty(Long id, LocalDateTime startTime);
    List<Penalty> findAllPenalties();
}

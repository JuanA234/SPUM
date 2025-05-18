package com.example.spum_backend.service.interfaces;

import com.example.spum_backend.dto.PenaltyTypeDTO;

import java.util.List;

public interface PenaltyTypeService {

    PenaltyTypeDTO addPenaltyType(PenaltyTypeDTO penaltyTypeDTO);
    List<PenaltyTypeDTO> getAllPenaltyTypes();
    void deletePenaltyType(Long id);
    PenaltyTypeDTO getPenaltyTypeById(Long id);
    PenaltyTypeDTO updatePenaltyType(Long id, PenaltyTypeDTO penaltyTypeDTO);
}

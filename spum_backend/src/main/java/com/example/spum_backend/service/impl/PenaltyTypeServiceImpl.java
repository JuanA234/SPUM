package com.example.spum_backend.service.impl;

import com.example.spum_backend.dto.PenaltyTypeDTO;
import com.example.spum_backend.service.interfaces.PenaltyTypeService;

import java.util.List;

public class PenaltyTypeServiceImpl implements PenaltyTypeService {
    @Override
    public PenaltyTypeDTO addPenaltyType(PenaltyTypeDTO penaltyTypeDTO) {
        return null;
    }

    @Override
    public List<PenaltyTypeDTO> getAllPenaltyTypes() {
        return List.of();
    }

    @Override
    public void deletePenaltyType(Long id) {

    }

    @Override
    public PenaltyTypeDTO getPenaltyTypeById(Long id) {
        return null;
    }

    @Override
    public PenaltyTypeDTO updatePenaltyType(Long id, PenaltyTypeDTO penaltyTypeDTO) {
        return null;
    }
}

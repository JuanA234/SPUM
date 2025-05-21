package com.example.spum_backend.service.interfaces;

import com.example.spum_backend.dto.PenaltyTypeDTO;

import java.util.List;

public interface PenaltyTypeService {

    String addPenaltyType(String penaltyTypeToSave);
    List<String> getAllPenaltyTypes();
    void deletePenaltyType(Long id);
    String getPenaltyTypeById(Long id);
    String updatePenaltyType(Long id, PenaltyTypeDTO penaltyTypeDTO);
}

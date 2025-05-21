package com.example.spum_backend.service.impl;

import com.example.spum_backend.dto.PenaltyTypeDTO;
import com.example.spum_backend.entity.PenaltyType;
import com.example.spum_backend.exception.PenaltyTypeNotFoundException;
import com.example.spum_backend.repository.PenaltyTypeRepository;
import com.example.spum_backend.service.interfaces.PenaltyTypeService;
import com.example.spum_backend.service.interfaces.internal.PenaltyTypeServiceEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PenaltyTypeServiceImpl implements PenaltyTypeService, PenaltyTypeServiceEntity {

    private final PenaltyTypeRepository penaltyTypeRepository;

    public PenaltyTypeServiceImpl(PenaltyTypeRepository penaltyTypeRepository) {
        this.penaltyTypeRepository = penaltyTypeRepository;
    }

    @Override
    public String addPenaltyType(String penaltyTypeToSave) {
        PenaltyType penaltyType = PenaltyType
                .builder()
                .penaltyType(penaltyTypeToSave)
                .build();

        penaltyTypeRepository.save(penaltyType);
        return penaltyTypeToSave;
    }

    @Override
    public List<String> getAllPenaltyTypes() {
        return penaltyTypeRepository.findAll()
                .stream().map(PenaltyType::getPenaltyType)
                .collect(Collectors.toList());
    }

    @Override
    public void deletePenaltyType(Long id) {

        penaltyTypeRepository.findById(id)
                .orElseThrow(() -> new PenaltyTypeNotFoundException("Penalty type not found"));

        penaltyTypeRepository.deleteById(id);
    }

    @Override
    public String getPenaltyTypeById(Long id) {

         PenaltyType penaltyType = penaltyTypeRepository.findById(id)
                .orElseThrow(() -> new PenaltyTypeNotFoundException("Penalty type not found"));

         return penaltyType.getPenaltyType();
    }

    @Override
    public String updatePenaltyType(Long id, PenaltyTypeDTO penaltyTypeDTO) {

        PenaltyType penaltyType = penaltyTypeRepository.findById(id)
                .orElseThrow(() -> new PenaltyTypeNotFoundException("Penalty type not found"));

        penaltyType.setPenaltyType(penaltyTypeDTO.getPenaltyType());
        return penaltyTypeRepository.save(penaltyType).getPenaltyType();
    }


    @Override
    public PenaltyType getPenaltyTypeEntityById(Long id) {
        return penaltyTypeRepository.findById(id)
                .orElseThrow(() -> new PenaltyTypeNotFoundException("Penalty type not found"));
    }
}

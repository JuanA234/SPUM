package com.example.spum_backend.service.impl;

import com.example.spum_backend.dto.request.PenaltyRequestDTO;
import com.example.spum_backend.dto.response.PenaltyResponseDTO;
import com.example.spum_backend.entity.Penalty;
import com.example.spum_backend.entity.PenaltyType;
import com.example.spum_backend.entity.Student;
import com.example.spum_backend.exception.PenaltyNotFoundException;
import com.example.spum_backend.exception.PenaltyTypeNotFoundException;
import com.example.spum_backend.exception.StudentNotFoundException;
import com.example.spum_backend.repository.PenaltyRepository;
import com.example.spum_backend.repository.PenaltyTypeRepository;
import com.example.spum_backend.repository.StudentRepository;
import com.example.spum_backend.service.interfaces.PenaltyService;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

public class PenaltyServiceImpl implements PenaltyService {

    private final ModelMapper modelMapper;
    private final PenaltyRepository penaltyRepository;
    private final StudentRepository studentRepository;
    private final PenaltyTypeRepository penaltyTypeRepository;


    public PenaltyServiceImpl(ModelMapper modelMapper, PenaltyRepository penaltyRepository, StudentRepository studentRepository, PenaltyTypeRepository penaltyTypeRepository) {
        this.modelMapper = modelMapper;
        this.penaltyRepository = penaltyRepository;
        this.studentRepository = studentRepository;
        this.penaltyTypeRepository = penaltyTypeRepository;
    }

    @Override
    public List<PenaltyResponseDTO> getAllPenalties() {
        return penaltyRepository.findAll()
                .stream()
                .map((penalty) -> modelMapper.map(penalty, PenaltyResponseDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public PenaltyResponseDTO createPenalty(PenaltyRequestDTO penaltyRequestDTO) {
        // Verify a student exists in our db

        Student student = studentRepository.findByUser_Email(penaltyRequestDTO.email())
                .orElseThrow(() -> new StudentNotFoundException("Student Not Found"));


        PenaltyType penaltyType = penaltyTypeRepository.findById(penaltyRequestDTO.penaltyType())
                .orElseThrow(() -> new PenaltyTypeNotFoundException("Penalty Type Not Found"));

        // Applying the penalty.

        Penalty penalty = Penalty.builder()
                .penaltyDate(penaltyRequestDTO.penaltyDate())
                .description(penaltyRequestDTO.description())
                .type(penaltyType)
                .student(student)
                .build();

        return modelMapper.map(penaltyRepository.save(penalty), PenaltyResponseDTO.class);
    }

    @Override
    public void deletePenalty(Long id) {
        Penalty penalty = penaltyRepository.findById(id)
                .orElseThrow(() -> new PenaltyNotFoundException("Penalty Type Not Found"));

        penaltyRepository.delete(penalty);
    }
}

package com.example.spum_backend.service.impl;

import com.example.spum_backend.dto.request.StudentUserRegisterRequestDTO;
import com.example.spum_backend.dto.response.StudentResponseDTO;
import com.example.spum_backend.service.interfaces.StudentService;

import java.util.List;
import java.util.Optional;

public class StudentServiceImpl implements StudentService {
    @Override
    public StudentResponseDTO registerAStudent(StudentUserRegisterRequestDTO student) {
        return null;
    }

    @Override
    public void deleteStudent(String studentId) {

    }

    @Override
    public Optional<StudentResponseDTO> getStudent(String studentId) {
        return Optional.empty();
    }

    @Override
    public List<StudentResponseDTO> getAllStudents() {
        return List.of();
    }
}

package com.example.spum_backend.service.interfaces;

import com.example.spum_backend.dto.request.StudentUserRegisterRequestDTO;
import com.example.spum_backend.dto.response.StudentResponseDTO;

import java.util.List;
import java.util.Optional;

public interface StudentService {

    StudentResponseDTO registerAStudent(StudentUserRegisterRequestDTO student);
    void deleteStudent(String studentId);
    Optional<StudentResponseDTO> getStudent(String studentId);
    List<StudentResponseDTO> getAllStudents();

}

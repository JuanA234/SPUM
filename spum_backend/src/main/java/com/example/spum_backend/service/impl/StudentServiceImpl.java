package com.example.spum_backend.service.impl;

import com.example.spum_backend.dto.response.StudentResponseDTO;
import com.example.spum_backend.entity.Student;
import com.example.spum_backend.exception.StudentNotFoundException;
import com.example.spum_backend.repository.StudentRepository;
import com.example.spum_backend.service.interfaces.StudentService;
import com.example.spum_backend.service.interfaces.internal.StudentServiceEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService, StudentServiceEntity {

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
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


    @Override
    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElseThrow(() -> new StudentNotFoundException("Student not found"));
    }


    @Override
    public List<Student> getAllStudentsEntities() {
        return studentRepository.findAll();
    }

    @Override
    public Student findStudentByEmail(String email) {
        return studentRepository.findByUser_Email(email)
                .orElseThrow(() -> new StudentNotFoundException("Student not found"));
    }
}

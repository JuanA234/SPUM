package com.example.spum_backend.service.interfaces.internal;

import com.example.spum_backend.entity.Student;

import java.util.List;

public interface StudentServiceEntity {

    Student getStudentById(Long id);
    List<Student> getAllStudentsEntities();
    Student findStudentByEmail(String email);
}

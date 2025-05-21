package com.example.spum_backend.dto.request;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentUserRegisterRequestDTO{
    String firstName;
    String lastName;
    String email;
    String password;
    Long studentCollegeId;
}

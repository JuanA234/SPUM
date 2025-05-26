package com.example.spum_backend.controller;

import com.example.spum_backend.dto.request.StudentUserRegisterRequestDTO;
import com.example.spum_backend.dto.request.UserLoginRequestDTO;
import com.example.spum_backend.dto.request.UserRegisterRequestDTO;
import com.example.spum_backend.dto.response.TokenResponseDTO;
import com.example.spum_backend.service.AuthService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin(value = "http://localhost:5173")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register-student")
    public String registerStudent(@RequestBody StudentUserRegisterRequestDTO studentUserRegisterRequestDTO) {
        authService.registerStudent(studentUserRegisterRequestDTO);
        return "Student registered successfully";
    }

    @PostMapping("/register-user")
    public String registerUser(@RequestBody UserRegisterRequestDTO userDetails) {
        authService.registerUser(userDetails);
        return "User registered successfully";
    }

    @PostMapping("/login")
    public TokenResponseDTO login(@RequestBody UserLoginRequestDTO loginDetails){
        return authService.login(loginDetails);
    }
}

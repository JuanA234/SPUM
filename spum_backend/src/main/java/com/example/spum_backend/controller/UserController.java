package com.example.spum_backend.controller;

import com.example.spum_backend.service.interfaces.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@CrossOrigin(value = "http://localhost:5173")
@AllArgsConstructor
public class UserController {
    private final UserService userService;
}

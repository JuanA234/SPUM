package com.example.spum_backend.service.impl;

import com.example.spum_backend.dto.request.UserRegisterRequestDTO;
import com.example.spum_backend.dto.response.UserInfo;
import com.example.spum_backend.repository.UserRepository;
import com.example.spum_backend.service.interfaces.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    @Override
    public UserInfo getUserById(Long id) {
        return null;
    }

    @Override
    public List<UserInfo> getAllUsers() {
        return List.of();
    }

    @Override
    public UserInfo updateUser(Long id, UserRegisterRequestDTO user) {
        return null;
    }

    @Override
    public void deleteUser(Long id) {

    }
}

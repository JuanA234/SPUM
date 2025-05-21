package com.example.spum_backend.dto.request;

import com.example.spum_backend.enumeration.RolesEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRegisterRequestDTO {
    String name;
    String lastName;
    String email;
    String password;
    RolesEnum role;
}

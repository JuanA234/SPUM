package com.example.spum_backend.mapper;

import com.example.spum_backend.dto.request.StudentUserRegisterRequestDTO;
import com.example.spum_backend.dto.request.UserRegisterRequestDTO;
import com.example.spum_backend.dto.response.StudentResponseDTO;
import com.example.spum_backend.dto.response.UserInfo;
import com.example.spum_backend.entity.Student;
import com.example.spum_backend.entity.User;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "roles", ignore = true)
    User toUser(UserRegisterRequestDTO dto);

    @Mapping(target = "roles", ignore = true)
    User toUser(StudentUserRegisterRequestDTO dto);

    @Mapping(target = "user", source = "user")
    @Mapping(target = "penalties", ignore = true)
    Student toStudent(StudentUserRegisterRequestDTO dto, User user);

    @Mapping(target = "studentName", expression = "java(user.getUserName() + ' ' + user.getUserLastName())")
    StudentResponseDTO toStudentResponseDTO(User user);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "userName", target = "name")
    @Mapping(source = "userLastName", target = "lastName")
    @Mapping(source = "email", target = "email")
    @Mapping(target = "role", expression = "java(user.getRoles().stream().findFirst().orElseThrow().getRole().name())")
    UserInfo toUserInfo(User user);
}

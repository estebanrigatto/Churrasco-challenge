package com.churrasco.challenge.auth.mapper;

import com.churrasco.challenge.auth.config.RoleEnum;
import com.churrasco.challenge.auth.dto.UserDTO;
import com.churrasco.challenge.auth.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class UserMapper {

    @Autowired
    @Lazy
    private PasswordEncoder passwordEncoder;

    public UserEntity DTO2Entity(UserDTO dto) {
        UserEntity entity = new UserEntity();
        entity.setCreated(LocalDateTime.now());
        entity.setEmail(dto.getEmail());
        entity.setFirstname(dto.getFirstname());
        entity.setLastname(dto.getLastname());
        entity.setPassword(passwordEncoder.encode(dto.getPassword()));
        entity.setUsername(dto.getUsername());
        entity.setRole(RoleEnum.USER.name());
        return entity;
    }
}

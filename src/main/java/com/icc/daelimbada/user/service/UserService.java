package com.icc.daelimbada.user.service;

import com.icc.daelimbada.user.domain.User;
import com.icc.daelimbada.user.dto.JoinDTO;
import com.icc.daelimbada.user.dto.LoginDTO;

public interface UserService {
    String saveUser(JoinDTO joinDTO);

    String login(LoginDTO loginDTO) throws Exception;

    String getEmail(String username);

    default User dtoToEntity(JoinDTO dto) {
        return User.builder()
                .email(dto.getEmail())
                .username(dto.getUsername())
                .password(dto.getPassword())
                .build();
    }

}

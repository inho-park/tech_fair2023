package com.icc.daelimbada.user.service;

import com.icc.daelimbada.user.domain.User;
import com.icc.daelimbada.user.dto.JoinDTO;
import com.icc.daelimbada.user.dto.LoginDTO;
import com.icc.daelimbada.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Log4j2
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public String saveUser(JoinDTO joinDTO) {
        User user = dtoToEntity(joinDTO);
        userRepository.save(user);
        return user.getEmail();
    }

    @Override
    public String register(LoginDTO loginDTO) throws Exception {
        User user = userRepository.findByEmail(loginDTO.getUsername()).orElseThrow(NoSuchElementException::new);
        return user.getUsername();
    }
}

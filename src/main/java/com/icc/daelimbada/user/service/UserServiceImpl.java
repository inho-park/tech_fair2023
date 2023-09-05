package com.icc.daelimbada.user.service;

import com.icc.daelimbada.user.domain.User;
import com.icc.daelimbada.user.dto.JoinDTO;
import com.icc.daelimbada.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

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
}

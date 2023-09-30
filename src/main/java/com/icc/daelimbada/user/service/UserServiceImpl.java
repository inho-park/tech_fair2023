package com.icc.daelimbada.user.service;

import com.icc.daelimbada.user.domain.User;
import com.icc.daelimbada.user.dto.JoinDTO;
import com.icc.daelimbada.user.dto.LoginDTO;
import com.icc.daelimbada.user.exception.NoUserException;
import com.icc.daelimbada.user.exception.PasswordException;
import com.icc.daelimbada.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Log4j2
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public String saveUser(JoinDTO joinDTO) {
        try {
            User user = dtoToEntity(joinDTO);
//            user.encodingPassword(passwordEncoder.encode(user.getPassword()));
            userRepository.save(user);
            return user.getEmail();
            // email 검증 로직 필요
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String login(LoginDTO loginDTO) {
        try {
            User user = userRepository.findByEmail(loginDTO.getEmail()).orElseThrow(NoUserException::new);
//            String password = user.getPassword();
//            if (passwordEncoder.matches(password, loginDTO.getPassword())) {
                return user.getUsername();
//            } else {
//                throw new PasswordException("비밀번호 불일치");
//            }
        } catch (NoUserException e) {
            throw e;
        } catch (PasswordException e) {
            throw e;
        }
    }
}

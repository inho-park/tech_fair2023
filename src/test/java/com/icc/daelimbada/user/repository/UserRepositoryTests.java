package com.icc.daelimbada.user.repository;

import com.icc.daelimbada.user.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserRepositoryTests {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void 회원등록() {
        userRepository.save(User.builder()
                .email("201930340@email.daelim.ac.kr")
                .username("박준성")
                .password("password")
                .build()
        );
    }
}

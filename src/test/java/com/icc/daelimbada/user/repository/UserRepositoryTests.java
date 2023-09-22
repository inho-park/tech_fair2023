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
        for (int i = 1; i <= 10; i++) {
            userRepository.save(User.builder()
                    .email(i + "@email.daelim.ac.kr")
                    .username("username" + i)
                    .password("password" + i)
                    .build()
            );
        }
    }
}

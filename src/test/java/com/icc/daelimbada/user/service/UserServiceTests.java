package com.icc.daelimbada.user.service;

import com.icc.daelimbada.user.dto.JoinDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.IntStream;

@SpringBootTest
public class UserServiceTests {
    @Autowired
    private UserService userService;

    @Test
    public void 유저_생성() {
        IntStream.rangeClosed(1, 10).forEach(
                i -> {
                    userService.saveUser(
                            JoinDTO.builder()
                                    .username("username" + i)
                                    .password("password" + i)
                                    .email("email" + i + "@daelim.com")
                                    .build()
                    );
                }
        );
    }
}

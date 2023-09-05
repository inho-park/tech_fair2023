package com.icc.daelimbada.user.controller;

import com.icc.daelimbada.user.domain.User;
import com.icc.daelimbada.user.dto.JoinDTO;
import com.icc.daelimbada.user.dto.LoginDTO;
import com.icc.daelimbada.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Log4j2
@Controller
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @PostMapping(value = "/signup", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String join(JoinDTO joinDTO) {
        try {
            userService.saveUser(joinDTO);
            return "redirect:/user/login";
        } catch(Exception e) {
            e.printStackTrace();
            return "/user/join";
        }
    }

    @GetMapping("/login")
    public String loginPage() {
        return "/user/login";
    }

    @PostMapping("/signin")
    public String login(@RequestBody LoginDTO loginDTO) {

        return "/home";
    }
}

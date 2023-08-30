package com.icc.daelimbada.user.controller;

import com.icc.daelimbada.user.domain.User;
import com.icc.daelimbada.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Log4j2
@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    @GetMapping("/signup")
    public String login(@RequestBody User user) {
        userService.saveUser(user);
        return "redirect:/index";
    }
}

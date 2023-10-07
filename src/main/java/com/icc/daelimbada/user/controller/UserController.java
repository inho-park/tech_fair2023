package com.icc.daelimbada.user.controller;

import com.icc.daelimbada.article.dto.ArticlePageRequestDTO;
import com.icc.daelimbada.article.service.ArticleService;
import com.icc.daelimbada.user.dto.JoinDTO;
import com.icc.daelimbada.user.dto.LoginDTO;
import com.icc.daelimbada.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Log4j2
@Controller
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;
    private final ArticleService articleService;

    @GetMapping("/join")
    public String joinPage() {
        return "/user/join";
    }
    @GetMapping("/login")
    public String loginPage() {
        return "/user/login";
    }
    @GetMapping("/addProduct")
    public String addProductPage() {
        return "/user/addProduct";
    }
    @GetMapping("/mypage")
    public String myPage(ArticlePageRequestDTO pageRequestDTO, Model model, HttpSession session) {
        pageRequestDTO.setUsername((String) session.getAttribute("username"));
        model.addAttribute("result", articleService.getMyList(pageRequestDTO));
        model.addAttribute("email", userService.getEmail(pageRequestDTO.getUsername()));
        return "/user/mypage";
    }

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


    @PostMapping(value = "/signin", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String login(LoginDTO loginDTO, HttpSession session) {
        try {
            String result = userService.login(loginDTO);

            if (result != null) {
                // login 성공
                session.setAttribute("username", result);
                return "redirect:/article/list";
            } else {
                // login 실패
                return "user/login";
            }
        } catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
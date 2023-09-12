package com.icc.daelimbada.article.controller;

import com.icc.daelimbada.article.dto.PageRequestDTO;
import com.icc.daelimbada.article.service.ArticleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Log4j2
@Controller
@RequiredArgsConstructor
@RequestMapping("/article")
public class ArticleController {
    private final ArticleService articleService;

    @GetMapping("/")
    public String home() {
        return "redirect:/article/list";
    }

    @GetMapping("/list")
    public void list (PageRequestDTO pageRequestDTO, Model model) {
        model.addAttribute("result", articleService.getList(pageRequestDTO));
    }
}

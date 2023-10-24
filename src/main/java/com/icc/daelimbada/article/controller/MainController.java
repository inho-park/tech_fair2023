package com.icc.daelimbada.article.controller;

import com.icc.daelimbada.article.service.ArticleService;
import com.icc.daelimbada.image.service.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class MainController {
    final private ArticleService articleService;
    final private ImageService imageService;

    @GetMapping({"", "/"})
    public String index() {
        return "redirect:/article/list";
    }
}

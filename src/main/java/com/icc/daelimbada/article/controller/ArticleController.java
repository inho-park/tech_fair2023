package com.icc.daelimbada.article.controller;

import com.icc.daelimbada.article.dto.ArticleDTO;
import com.icc.daelimbada.article.dto.ArticlePageRequestDTO;
import com.icc.daelimbada.article.service.ArticleService;
import com.icc.daelimbada.image.service.ImageService;
import com.icc.daelimbada.reply.service.ReplyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;

@Log4j2
@Controller
@RequiredArgsConstructor
@RequestMapping("/article")
public class ArticleController {
    final private ArticleService articleService;
    final private ReplyService replyService;
    final private ImageService imageService;

    @GetMapping("/")
    public String home() {
        return "redirect:/article/list";
    }

    @GetMapping({"/read", "/modify"})
    public void read(long id,
                     @ModelAttribute("requestDTO") ArticlePageRequestDTO requestDTO,
                     Model model) {

        model.addAttribute("articleDTO", articleService.getArticle(id));
    }

    @GetMapping("/list")
    public void list (ArticlePageRequestDTO pageRequestDTO, Model model) {
        model.addAttribute("result", articleService.getList(pageRequestDTO));
    }

    @PostMapping(value = "/register")
    public String register(ArticleDTO articleDTO,MultipartFile multipartFile, RedirectAttributes redirectAttributes) {
        // 처리 로직
        redirectAttributes.addFlashAttribute("result", articleService.saveArticle(articleDTO));
        try {
            imageService.postImages(articleDTO.getId(), multipartFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return "redirect:/article/list";
    }

    @PostMapping("/modify")
    public String modify(ArticleDTO articleDTO,
                         @ModelAttribute("requestDTO") ArticlePageRequestDTO requestDTO,
                         RedirectAttributes redirectAttributes) {

        articleService.modify(articleDTO);

        redirectAttributes.addAttribute("page", requestDTO.getPage());
        redirectAttributes.addAttribute("id", articleDTO.getId());
        redirectAttributes.addAttribute("type", requestDTO.getType());
        redirectAttributes.addAttribute("keyword", requestDTO.getKeyword());

        return "redirect:/article/read";
    }

    @PostMapping("/delete")
    public String delete(long id) {
        replyService.deleteAll(id);
        articleService.remove(id);
        return "redirect:/user/myPage";
    }
}

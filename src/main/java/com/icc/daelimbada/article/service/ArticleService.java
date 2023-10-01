package com.icc.daelimbada.article.service;

import com.icc.daelimbada.article.domain.Article;
import com.icc.daelimbada.article.domain.Major;
import com.icc.daelimbada.article.dto.ArticleDTO;
import com.icc.daelimbada.article.dto.ArticlePageRequestDTO;
import com.icc.daelimbada.common.dto.PageResultDTO;
import com.icc.daelimbada.user.domain.User;

public interface ArticleService {
    void checkUser(Long articleId, Long userId);
    Long saveArticle(ArticleDTO articleDTO);
    ArticleDTO getArticle(Long articleId);
    PageResultDTO<ArticleDTO, Object[]> getList(ArticlePageRequestDTO requestDTO);
    PageResultDTO<ArticleDTO, Object[]> searchList(ArticlePageRequestDTO requestDTO);
    PageResultDTO<ArticleDTO, Object[]> getMyList(ArticlePageRequestDTO requestDTO);
    Long remove(Long articleId);
    Long modify(ArticleDTO dto);

    default Article dtoToEntity(ArticleDTO dto, User user) {
        return Article.builder()
                .title(dto.getTitle())
                .isSold(dto.isSold())
                .price(dto.getPrice())
                .major(Major.getMajor(dto.getMajorCode()))
                .content(dto.getContent())
                .user(user)
                .build();
    }
    default ArticleDTO entityToDTO(Article article, User user) {
        return ArticleDTO.builder()
                .id(article.getId())
                .title(article.getTitle())
                .majorCode(article.getMajor().getCode())
                .content(article.getContent())
                .isSold(article.isSold())
                .price(article.getPrice())
                .username(user.getUsername())
                .modDate(article.getModDate())
                .regDate(article.getRegDate())
                .build();
    }

}

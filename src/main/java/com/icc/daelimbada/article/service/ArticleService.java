package com.icc.daelimbada.article.service;

import com.icc.daelimbada.article.dto.ArticleDTO;

public interface ArticleService {
    void saveArticle(ArticleDTO articleDTO);

    ArticleDTO getArticle(Long articleId);
}

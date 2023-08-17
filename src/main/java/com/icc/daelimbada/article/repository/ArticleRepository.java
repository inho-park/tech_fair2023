package com.icc.daelimbada.article.repository;

import com.icc.daelimbada.article.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Long> {
}

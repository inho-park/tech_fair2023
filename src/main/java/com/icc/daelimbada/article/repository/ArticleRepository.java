package com.icc.daelimbada.article.repository;

import com.icc.daelimbada.article.domain.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ArticleRepository extends JpaRepository<Article, Long> {
    @Query(
            "SELECT a, a.user " +
                    "FROM Article a " +
                    "WHERE a.isSold=:isSold"
    )
    Page<Object[]> getArticlesBySold(Pageable pageable, boolean isSold);

    @Query(
            value = "SELECT a, a.user " +
                    "FROM Article a " +
                    "WHERE a.title LIKE %:word%"
    )
    Page<Object[]> getArticlesByTitleLike(Pageable pageable, @Param("word") String word);
}

package com.icc.daelimbada.article.repository;

import com.icc.daelimbada.article.domain.Article;
import com.icc.daelimbada.article.domain.Major;
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
    Page<Object[]> getArticlesBySold(Pageable pageable,
                                     @Param("isSold") boolean isSold);

    @Query(
            "SELECT a, a.user " +
                    "FROM Article a " +
                    "WHERE a.isSold=:isSold AND a.major=:major"
    )
    Page<Object[]> getArticlesBySoldAndMajor(Pageable pageable,
                                             @Param("major") Major major,
                                             @Param("isSold") boolean isSold);
    @Query(
            value = "SELECT a, a.user " +
                    "FROM Article a " +
                    "WHERE a.title LIKE %:word% AND a.isSold=:isSold"
    )
    Page<Object[]> getArticlesByTitleLike(Pageable pageable,
                                          @Param("word") String word,
                                          @Param("isSold") boolean isSold);

    @Query(
            value = "SELECT a, a.user " +
                    "FROM Article a " +
                    "WHERE a.title LIKE %:word% AND a.major=:major AND a.isSold=:isSold"
    )
    Page<Object[]> getArticlesByTitleLikeaAndMajorAndSold(Pageable pageable,
                                                   @Param("word") String word,
                                                   @Param("major") Major major,
                                                   @Param("isSold") boolean isSold);

    @Query(
            "SELECT a, a.user " +
                    "FROM Article a " +
                    "WHERE a.user.username=:username"
    )
    Page<Object[]> getArticlesByUser_Username(Pageable pageable,
                                              @Param("username") String username);

}

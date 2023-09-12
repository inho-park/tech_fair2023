package com.icc.daelimbada.article.repository;

import com.icc.daelimbada.article.domain.Article;
import com.icc.daelimbada.article.domain.Major;
import com.icc.daelimbada.user.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ArticleRepositoryTests {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ArticleRepository articleRepository;

    @Test
    public void 중고물품등록() {
        articleRepository.save(Article.builder()
                        .title("자료구조")
                        .content("알고리즘 공부 강추")
                        .price(30000l)
                        .isSold(false)
                        .major(Major.getMajor(120l))
                        .user(userRepository.getReferenceById(1l))
                .build()
        );
    }
}

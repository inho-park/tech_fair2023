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
        for (int i = 0; i < 10; i++) {
            articleRepository.save(Article.builder()
                            .title("자료구조")
                            .content("알고리즘 공부 강추")
                            .price(30000l + i)
                            .isSold(false)
                            .major(Major.getMajor(101l + i))
                            .user(userRepository.getReferenceById(i + 1l))
                    .build()
            );
        }
    }
}

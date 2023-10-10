package com.icc.daelimbada.image.repository;

import com.icc.daelimbada.article.domain.Article;
import com.icc.daelimbada.article.repository.ArticleRepository;
import com.icc.daelimbada.image.domain.Image;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

@SpringBootTest
public class ImageRepositoryTests {
    @Autowired
    private ImageRepository imageRepository;
    @Autowired
    private ArticleRepository articleRepository;

    @Test
    public void 이미지_생성() {
        for (long i = 1; i <= 10; i++) {
            Article article = articleRepository.findById(i).orElseThrow();
            for (int j = 1; j <=3; j++) {
                imageRepository.save(Image.builder()
                        .filePath(UUID.randomUUID().toString())
                        .article(article)
                        .build());
            }
        }
    }
}

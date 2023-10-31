package com.icc.daelimbada.reply.repository;

import com.icc.daelimbada.article.domain.Article;
import com.icc.daelimbada.article.repository.ArticleRepository;
import com.icc.daelimbada.reply.domain.Reply;
import com.icc.daelimbada.user.domain.User;
import com.icc.daelimbada.user.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ReplyRepositoryTests {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ArticleRepository articleRepository;
    @Autowired
    private ReplyRepository replyRepository;
    @Test
    public void 댓글_등록() {
        for (long i = 2; i <= 10; i++) {
            User user = userRepository.findById(11 - i).orElseThrow();
            Article article = articleRepository.findById(i).orElseThrow();
            for (long j = 1; j <= 10; j++) {
                replyRepository.save(Reply.builder()
                        .content("댓글 테스트 " + j)
                        .article(article)
                        .user(user)
                        .build()
                );
            }
        }
    }
}

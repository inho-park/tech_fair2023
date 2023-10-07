package com.icc.daelimbada.reply.repository;

import com.icc.daelimbada.reply.domain.Reply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;

public interface ReplyRepository extends JpaRepository<Reply, Long> {
    @Modifying
    @Transactional
    void deleteAllByArticle_Id(Long articleId);
}

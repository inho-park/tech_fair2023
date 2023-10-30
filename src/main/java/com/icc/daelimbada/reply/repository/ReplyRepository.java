package com.icc.daelimbada.reply.repository;

import com.icc.daelimbada.reply.domain.Reply;
import com.icc.daelimbada.reply.dto.ReplyDTO;
import com.icc.daelimbada.reply.dto.ReplyPageRequestDTO;
import com.icc.daelimbada.user.domain.User;
import com.icc.daelimbada.user.repository.UserRepository;
import org.hibernate.annotations.SQLUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ReplyRepository extends JpaRepository<Reply, Long> {

    final UserRepository userRepository = null;

    @Modifying
    @Transactional
    void deleteAllByArticle_Id(Long articleId);

    @Transactional
    @Query(value = "update Reply set content = ?1 where id = ?2")
    void updateReply(String contents, Long replyId);

    @Transactional
    @Query(value = "select R.id from Reply R, Article A where R.id = A.id AND R.id = ?1")
    Long findByReplyId(Long id);

    @Transactional
    @Query(value = "select R.id, R.content, R.regDate" +
            " from Reply R, Article A where R.id = A.id AND R.id = ?1")
    Reply findAll(Long id);

    @Transactional
    @Query(value = "select id from Reply where id = ?1")
    Long findbyReplyId(String id);

    @Transactional
    @Query(value = "select R.content, R.user " +
            "from Reply R, Article A " +
            "where R.id = A.id " +
            "and R.id = ?1")
    Page<Object[]> findbyReplyOfArticle(@Param("id") Long id, Pageable pageable);
}

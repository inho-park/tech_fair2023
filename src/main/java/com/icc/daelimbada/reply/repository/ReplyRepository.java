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

    @Modifying
    @Transactional
    void deleteAllByArticle_Id(Long articleId);

    @Transactional
    @Query(value = "update Reply set content = ?1 where id = ?2")
    void updateReply(String contents, Long replyId);


    @Query(value = "select R, R.user " +
            " from Reply R where R.article.id =:id")
    List<Object[]> findAll(@Param("id") Long id);

    @Query(value = "select id from Reply where id = ?1")
    Long findbyReplyId(String id);

}

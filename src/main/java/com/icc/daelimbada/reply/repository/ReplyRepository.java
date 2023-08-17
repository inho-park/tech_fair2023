package com.icc.daelimbada.reply.repository;

import com.icc.daelimbada.reply.domain.Reply;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReplyRepository extends JpaRepository<Reply, Long> {
}

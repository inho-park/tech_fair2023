package com.icc.daelimbada.reply.service;

import com.icc.daelimbada.common.dto.PageResultDTO;
import com.icc.daelimbada.common.dto.StatusDTO;
import com.icc.daelimbada.reply.domain.Reply;
import com.icc.daelimbada.reply.dto.ReplyDTO;
import com.icc.daelimbada.reply.dto.ReplyPageRequestDTO;
import com.icc.daelimbada.user.domain.User;
import com.icc.daelimbada.user.repository.UserRepository;

import java.util.List;

public interface ReplyService {

    List<ReplyDTO> getList(Long articleId);
    ReplyDTO saveReply(ReplyDTO replyDTO);
    StatusDTO deleteReply(Long replyId);
    StatusDTO updateReply(Long replyId, String content);
    StatusDTO deleteAll(Long articleId);


    // DTO -> Entity 변환
    default Reply dtoToEntity(ReplyDTO replyDTO, User user) {

        Reply reply = Reply.builder()
                .content(replyDTO.getContent())
                .user(user)
                .build();

        return reply;
    }

    // Entity -> DTO 변환
    default ReplyDTO entityToDTO(Reply reply, User user) {
        return ReplyDTO.builder()
                .content(reply.getContent())
                .username(user.getUsername())
                .regDate(reply.getRegDate())
                .build();
    }
}

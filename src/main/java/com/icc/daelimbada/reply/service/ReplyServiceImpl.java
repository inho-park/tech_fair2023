package com.icc.daelimbada.reply.service;

import com.icc.daelimbada.common.dto.PageResultDTO;
import com.icc.daelimbada.common.dto.StatusDTO;
import com.icc.daelimbada.reply.dto.ReplyDTO;
import com.icc.daelimbada.reply.repository.ReplyRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Log4j2
@Service
@RequiredArgsConstructor
public class ReplyServiceImpl implements ReplyService {

    final private ReplyRepository replyRepository;

    @Override
    public PageResultDTO getList(Long articleId) {
        
        return null;
    }

    @Override
    public ReplyDTO saveReply(ReplyDTO replyDTO) {
        return null;
    }

    @Override
    public StatusDTO deleteReply(Long replyId) {
        return null;
    }

    @Override
    public StatusDTO updateReply(Long replyId, String content) {
        return null;
    }

    @Override
    public StatusDTO deleteAll(Long articleId) {
        try {
            replyRepository.deleteAllByArticle_Id(articleId);
            return StatusDTO.builder().status("article id : " + articleId).build();
        } catch (Exception e) {
            e.printStackTrace();
            return StatusDTO.builder().status(e.getMessage()).build();
        }
    }
}

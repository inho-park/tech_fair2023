package com.icc.daelimbada.reply.service;

import com.icc.daelimbada.common.dto.PageResultDTO;
import com.icc.daelimbada.common.dto.StatusDTO;
import com.icc.daelimbada.reply.dto.ReplyDTO;

public interface ReplyService {
    PageResultDTO getList(Long articleId);
    ReplyDTO saveReply(ReplyDTO replyDTO);
    StatusDTO deleteReply(Long replyId);
    StatusDTO updateReply(Long replyId, String content);
    StatusDTO deleteAll(Long articleId);


}

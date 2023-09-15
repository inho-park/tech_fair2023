package com.icc.daelimbada.reply.service;

import com.icc.daelimbada.common.dto.StatusDTO;
import com.icc.daelimbada.reply.dto.ReplyDTO;

public interface ReplyService {
    ReplyDTO getReply(Long replyId);
    ReplyDTO saveReply(ReplyDTO replyDTO);
    StatusDTO deleteReply(Long replyId);
    StatusDTO updateReply(Long replyId, String content);
}

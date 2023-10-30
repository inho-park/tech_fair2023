package com.icc.daelimbada.reply.service;

import com.icc.daelimbada.article.domain.Article;
import com.icc.daelimbada.article.dto.ArticleDTO;
import com.icc.daelimbada.common.dto.PageResultDTO;
import com.icc.daelimbada.common.dto.StatusDTO;
import com.icc.daelimbada.reply.domain.Reply;
import com.icc.daelimbada.reply.dto.ReplyDTO;
import com.icc.daelimbada.reply.dto.ReplyPageRequestDTO;
import com.icc.daelimbada.reply.repository.ReplyRepository;
import com.icc.daelimbada.user.domain.User;
import com.icc.daelimbada.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Log4j2
@Service
@RequiredArgsConstructor
public class ReplyServiceImpl implements ReplyService {

    final private ReplyRepository replyRepository;


   // 한 게시글 댓글 목록 가져오기
    @Override
    public PageResultDTO getList(Long articleId) {
        // 아티클 아이디로 해당 아티클에 해당되는 댓글들 가지고 옴
        Function<Object[], ReplyDTO> fn = (
                entity -> EntityToDTO(
                        (Reply) entity[0]
                )
        );

        Page<Object[]> result = null;
        ReplyPageRequestDTO replyPageRequestDTO = null;

        if(articleId == replyRepository.findByReplyId(articleId)) {
            result = replyRepository.findbyReplyOfArticle(articleId,
                    replyPageRequestDTO.getPageable(Sort.by("id").descending()));
        }

        PageResultDTO<ReplyDTO, Object[]> replyPageResultDTO = new PageResultDTO<>(result, fn);

        return replyPageResultDTO;
    }

    // 댓글 저장
    @Override
    public ReplyDTO saveReply(ReplyDTO replyDTO) {
        replyRepository.save(dtoToEntity(replyDTO));
        return null;
    }

    // 댓글 삭제
    @Override
    public StatusDTO deleteReply(Long replyId) {
        replyRepository.deleteById(replyId);
        return null;
    }

    // 댓글 업데이트
    @Override
    public StatusDTO updateReply(Long replyId, String content) {
        replyRepository.updateReply(content, replyId);
        return null;
    }

    // 모두 삭제
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

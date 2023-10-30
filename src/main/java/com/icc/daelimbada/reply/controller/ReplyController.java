package com.icc.daelimbada.reply.controller;

import com.icc.daelimbada.reply.dto.ReplyDTO;
import com.icc.daelimbada.reply.dto.ReplyPageRequestDTO;
import com.icc.daelimbada.reply.repository.ReplyRepository;
import com.icc.daelimbada.reply.service.ReplyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Map;


@Log4j2
@RestController
@RequiredArgsConstructor
@RequestMapping("/reply")
public class ReplyController {
    final private ReplyService replyService;
    final private ReplyRepository replyRepository;
    /**
     * 해당 게시글의 댓글 리스트 불러오기
     * @param pageRequestDTO
     * @return ResponseEntity
     */

    @GetMapping
    public ResponseEntity getReplyList(@ModelAttribute ReplyPageRequestDTO pageRequestDTO) {
        try {
            return new ResponseEntity<>(replyService.getList(pageRequestDTO.getArticleId()), HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


    // 댓글 저장
    @PostMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity addComment(@RequestBody ReplyDTO replyDTO,
                                     @PathVariable(value = "id") String id) {
        try {
            return new ResponseEntity<>(replyService.saveReply(replyDTO), HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity modifyComment(@PathVariable(value = "id") String id, @RequestBody Map<String, String> map) {

        try {
            return new ResponseEntity<>(null, HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity deleteComment(@PathVariable(value = "id") String id) {

        Long deleteId = replyRepository.findbyReplyId(id);

        try {
            return new ResponseEntity<>(replyService.deleteReply(deleteId), HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}

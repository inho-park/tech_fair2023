package com.icc.daelimbada.reply.dto;

import com.icc.daelimbada.user.domain.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReplyDTO {
    private Long id;
    private String content;
    private String username;
    private LocalDateTime regDate;

}

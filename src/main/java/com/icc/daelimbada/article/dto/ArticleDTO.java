package com.icc.daelimbada.article.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ArticleDTO {
    private Long id;
    private String title;
    private Long price;
    private String content;
    private boolean isSold;
    private int majorCode;
    private String username;
    private String filePath;
    private LocalDateTime regDate, modDate;
}

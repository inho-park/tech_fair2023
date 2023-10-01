package com.icc.daelimbada.article.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

@Data
@Builder
@AllArgsConstructor
public class ArticlePageRequestDTO {

    private int page;
    private int size;
    private int type;
    private String keyword;
    private String username;

    public ArticlePageRequestDTO() {
        this.page = 1;
        this.size = 12;
        this.keyword = "";
        this.type = 0;
    }

    public Pageable getPageable(Sort sort) {
        return PageRequest.of(page - 1, size, sort);
    }
}

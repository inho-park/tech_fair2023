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
    private String type;
    private String keyword;

    public ArticlePageRequestDTO() {
        this.page = 1;
        this.size = 10;
    }

    public Pageable getPageable(Sort sort) {
        return PageRequest.of(page - 1, size, sort);
    }
}

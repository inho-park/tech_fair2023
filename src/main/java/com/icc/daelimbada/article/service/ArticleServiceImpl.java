package com.icc.daelimbada.article.service;

import com.icc.daelimbada.article.domain.Article;
import com.icc.daelimbada.article.dto.ArticleDTO;
import com.icc.daelimbada.article.dto.PageRequestDTO;
import com.icc.daelimbada.article.dto.PageResultDTO;
import com.icc.daelimbada.article.repository.ArticleRepository;
import com.icc.daelimbada.user.domain.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.function.Function;


@Log4j2
@Service
@Transactional
@RequiredArgsConstructor
public class ArticleServiceImpl implements ArticleService {
    private final ArticleRepository articleRepository;

    @Override
    public Long saveArticle(ArticleDTO articleDTO) {
        return null;
    }

    @Override
    public ArticleDTO getArticle(Long articleId) {
        return null;
    }

    @Override
    public PageResultDTO<ArticleDTO, Object[]> getList(PageRequestDTO requestDTO) {
        Function<Object[], ArticleDTO> fn = (
                entity -> entityToDTO(
                        (Article) entity[0],
                        (User) entity[1]
                )
        );
        Page<Object[]> result = articleRepository.getArticlesBySold(requestDTO.getPageable(Sort.by("id").descending()), false);

        return new PageResultDTO<>(result, fn);
    }

    @Override
    public Long remove(Long articleId) {
        return null;
    }

    @Override
    public Long modify(ArticleDTO dto) {
        return null;
    }
}

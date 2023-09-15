package com.icc.daelimbada.article.service;

import com.icc.daelimbada.article.domain.Article;
import com.icc.daelimbada.article.dto.ArticleDTO;
import com.icc.daelimbada.article.dto.ArticlePageRequestDTO;
import com.icc.daelimbada.article.dto.PageResultDTO;
import com.icc.daelimbada.article.repository.ArticleRepository;
import com.icc.daelimbada.user.domain.User;
import com.icc.daelimbada.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
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
    private final UserRepository userRepository;

    /**
     * get 요청 외에는 유저가 해당 게시글의 주인인지 확인해야함
     * @param articleId
     * @param userId
     */
    @Override
    public void checkUser(Long articleId, Long userId) {
        
    }

    /**
     * 게시글 등록
     * @param articleDTO
     * @return
     */
    @Override
    public Long saveArticle(ArticleDTO articleDTO) {
        User user = userRepository.findByUsername(articleDTO.getUsername()).orElseThrow();
        return articleRepository.save(dtoToEntity(articleDTO, user)).getId();
    }

    /**
     * 게시글 보기
     * @param articleId
     * @return
     */
    @Override
    public ArticleDTO getArticle(Long articleId) {
        Article article = articleRepository.findById(articleId).orElseThrow();
        return entityToDTO(article, article.getUser());
    }

    /**
     * 게시판 보기
     * @param requestDTO
     * @return
     */
    @Override
    public PageResultDTO<ArticleDTO, Object[]> getList(ArticlePageRequestDTO requestDTO) {
        Function<Object[], ArticleDTO> fn = (
                entity -> entityToDTO(
                        (Article) entity[0],
                        (User) entity[1]
                )
        );
        Page<Object[]> result = articleRepository.getArticlesBySold(requestDTO.getPageable(Sort.by("id").descending()), false);
        log.info(result.toString());
        return new PageResultDTO<>(result, fn);
    }

    /**
     * 게시글 삭제
     * @param articleId
     * @return
     */
    @Override
    public Long remove(Long articleId) {
        return null;
    }

    /**
     * 게시글 수정
     * @param dto
     * @return
     */
    @Override
    public Long modify(ArticleDTO dto) {
        return null;
    }
}

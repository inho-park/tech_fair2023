package com.icc.daelimbada.article.service;

import com.icc.daelimbada.article.domain.Article;
import com.icc.daelimbada.article.domain.Major;
import com.icc.daelimbada.article.dto.ArticleDTO;
import com.icc.daelimbada.article.dto.ArticlePageRequestDTO;
import com.icc.daelimbada.common.dto.PageResultDTO;
import com.icc.daelimbada.article.repository.ArticleRepository;
import com.icc.daelimbada.image.domain.Image;
import com.icc.daelimbada.image.repository.ImageRepository;
import com.icc.daelimbada.user.domain.User;
import com.icc.daelimbada.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.function.Function;


@Log4j2
@Service
@Transactional
@RequiredArgsConstructor
public class ArticleServiceImpl implements ArticleService {
    private final ArticleRepository articleRepository;
    private final UserRepository userRepository;
    private final ImageRepository imageRepository;

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
    @Transactional
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
        Page<Object[]> result = null;
        if (requestDTO.getType() == 0) result = articleRepository.getArticlesBySold(
                requestDTO.getPageable(Sort.by("id").descending()),
                false);
        else result = articleRepository.getArticlesBySoldAndMajor(
                requestDTO.getPageable(Sort.by("id").descending()),
                Major.getMajor(requestDTO.getType()),
                false);

        PageResultDTO<ArticleDTO, Object[]> pageResultDTO = new PageResultDTO<>(result, fn);
        return setImage(pageResultDTO);
    }

    @Override
    public PageResultDTO<ArticleDTO, Object[]> searchList(ArticlePageRequestDTO requestDTO) {
        Function<Object[], ArticleDTO> fn = (
                entity -> entityToDTO(
                        (Article) entity[0],
                        (User) entity[1]
                )
        );
        Page<Object[]> result = null;
        // major 를 정하지 않고 검색했을 시
        if (requestDTO.getType() == 0) result = articleRepository.getArticlesByTitleLike(
                requestDTO.getPageable(Sort.by("id").descending()),
                requestDTO.getKeyword(),
                false);
        // major 를 정하고 검색했을 시
        else result = articleRepository.getArticlesByTitleLikeaAndMajorAndSold(
                requestDTO.getPageable(Sort.by("id").descending()),
                requestDTO.getKeyword(),
                Major.getMajor(requestDTO.getType()),
               false);

        PageResultDTO<ArticleDTO, Object[]> pageResultDTO = new PageResultDTO<>(result, fn);
        return setImage(pageResultDTO);
    }

    @Override
    public PageResultDTO<ArticleDTO, Object[]> getMyList(ArticlePageRequestDTO requestDTO) {
        Function<Object[], ArticleDTO> fn = (
                entity -> entityToDTO(
                        (Article) entity[0],
                        (User) entity[1]
                )
        );
        Page<Object[]> result = articleRepository.getArticlesByUser_Username(
                requestDTO.getPageable(Sort.by("id").descending()),
                requestDTO.getUsername());
        PageResultDTO<ArticleDTO, Object[]> pageResultDTO = new PageResultDTO<>(result, fn);
        return setImage(pageResultDTO);
    }

    /**
     * 게시글 삭제
     * @param articleId
     * @return
     */
    @Override
    public Long remove(Long articleId) {
        try {
            articleRepository.deleteById(articleId);
            return 1l;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    /**
     * 게시글 수정
     * @param dto
     * @return
     */
    @Override
    public Long modify(ArticleDTO dto) {
        try {
            articleRepository.save(dtoToEntity(dto, userRepository.findByUsername(dto.getUsername()).orElseThrow()));
            return dto.getId();
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public PageResultDTO<ArticleDTO, Object[]> setImage(PageResultDTO<ArticleDTO, Object[]> pageResultDTO) {
        pageResultDTO.getDtoList().forEach(
                i -> {
                    Optional<Image> imageOptional = imageRepository.findTopByArticle_IdOrderByIdDesc(i.getId());
                    if (imageOptional.isPresent()) {
                        i.setFilePath(imageOptional.get().getFileName());
                    } else {
                        i.setFilePath("");
                    }
                }
        );
        return pageResultDTO;
    }
}

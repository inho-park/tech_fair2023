package com.icc.daelimbada.image.repository;

import com.icc.daelimbada.image.domain.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface ImageRepository extends JpaRepository<Image, Long> {
    Optional<Image> findByArticle_Id(Long articleId);

//    List<Image> findAllByArticle_Id(Long articleId);

    @Modifying
    @Transactional
    void deleteByArticle_Id(Long articleId);

    Optional<Image> findTopByArticle_IdOrderByIdDesc(Long articleId);
}

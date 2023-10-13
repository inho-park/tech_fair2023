package com.icc.daelimbada.image.repository;

import com.icc.daelimbada.image.domain.Image;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ImageRepository extends JpaRepository<Image, Long> {
    List<Image> findByArticle_Id(Long articleId);
//    List<Image> findAllByArticle_Id(Long articleId);
    void deleteAllByArticle_Id(Long articleId);

    Optional<Image> findTopByArticle_IdOrderByIdDesc(Long articleId);
}

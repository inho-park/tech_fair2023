package com.icc.daelimbada.image.service;

import com.icc.daelimbada.article.domain.Article;
import com.icc.daelimbada.image.domain.Image;
import com.icc.daelimbada.image.dto.ImageDTO;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ImageService {
    ImageDTO getImage(Long articleId);
//    List<ImageDTO> getList(Long articleId);
    ImageDTO postImages(Long articleId, MultipartFile multipartFile);
    ImageDTO modifyImages(Long articleId, MultipartFile multipartFile);
    void deleteImages(Long articleId);

    default Image dtoToEntity(ImageDTO imageDTO, Article article) {
        return Image.builder()
                .uuid(imageDTO.getUuid())
                .article(article)
                .build();
    }

    default ImageDTO entityToDTO(Image image) {
        return ImageDTO.builder()
                .uuid(image.getUuid())
                .build();
    }
}

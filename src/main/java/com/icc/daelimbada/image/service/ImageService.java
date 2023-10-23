package com.icc.daelimbada.image.service;

import com.icc.daelimbada.article.domain.Article;
import com.icc.daelimbada.image.domain.Image;
import com.icc.daelimbada.image.dto.ImageDTO;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface ImageService {

    ImageDTO getImage(Long articleId);
    String postImage(Long articleId, MultipartFile multipartFile) throws IOException;
    ImageDTO modifyImages(Long articleId, MultipartFile multipartFile);
    void deleteImages(Long articleId);

    default Image dtoToEntity(ImageDTO imageDTO, Article article) {
        return Image.builder()
                .filePath(imageDTO.getFilePath())
                .article(article)
                .build();
    }

    default ImageDTO entityToDTO(Image image) {
        return ImageDTO.builder()
                .filePath(image.getFilePath())
                .build();
    }
}

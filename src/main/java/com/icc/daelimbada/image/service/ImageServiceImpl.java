package com.icc.daelimbada.image.service;

import com.icc.daelimbada.article.repository.ArticleRepository;
import com.icc.daelimbada.image.domain.Image;
import com.icc.daelimbada.image.dto.ImageDTO;
import com.icc.daelimbada.image.repository.ImageRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Log4j2
@Service
@RequiredArgsConstructor
public class ImageServiceImpl implements ImageService {
    @Value("${upload-path}")
    private String uploadPath;
    final private ImageRepository imageRepository;
    final private ArticleRepository articleRepository;

    @Override
    public List<ImageDTO> getImages(Long articleId) {
        try {
            List<ImageDTO> list = new ArrayList<>();
            List<Image> images = imageRepository.findByArticle_Id(articleId);
            if (!images.isEmpty()) images.forEach(
                    i -> {
                        list.add(ImageDTO.builder().filePath(i.getFilePath()).build());
                    }
            );
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public String postImages(Long articleId, MultipartFile multipartFile) throws IOException {
        String folderPath = "/clients/";
        String fileName = UUID.randomUUID() + multipartFile.getOriginalFilename();
        String filePath = folderPath + fileName;
        imageRepository.save(
                Image.builder()
                        .filePath(filePath)
                        .article(articleRepository.findById(articleId).orElseThrow())
                        .build()
        );
        File file = new File(uploadPath + fileName);
        multipartFile.transferTo(file);

        return filePath;
    }

    @Override
    public ImageDTO modifyImages(Long articleId, MultipartFile multipartFile) {
        return null;
    }

    @Override
    public void deleteImages(Long articleId) {
        try {
            imageRepository.deleteAllByArticle_Id(articleId);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
}

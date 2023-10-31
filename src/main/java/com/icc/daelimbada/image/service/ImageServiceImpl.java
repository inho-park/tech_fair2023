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
import java.util.Optional;
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
    public ImageDTO getImage(Long articleId) {
        try {
            // image 를 여러 장 올렸을 때
//            List<ImageDTO> list = new ArrayList<>();
//            List<Image> images = imageRepository.findByArticle_Id(articleId);
//            if (!images.isEmpty()) images.forEach(
//                    i -> {
//                        list.add(ImageDTO.builder().filePath(i.getFilePath()).build());
//                    }
//            );
//            return list;


            Optional<Image> optional = imageRepository.findByArticle_Id(articleId);
            if (optional.isPresent())
                return ImageDTO.builder()
                        .filePath(optional.get().getFileName())
                        .build();
            else return ImageDTO.builder()
                    .filePath("")
                    .build();

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public String postImage(Long articleId, MultipartFile multipartFile) throws IOException {
        // 확장자 분리 로직 구현하기
        String fileName = UUID.randomUUID() + multipartFile.getOriginalFilename();
        String filePath = uploadPath + fileName;
        imageRepository.save(
                Image.builder()
                        .fileName(fileName)
                        .article(articleRepository.findById(articleId).orElseThrow())
                        .build()
        );
        File file = new File(filePath);
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
            Optional<Image> optional = imageRepository.findByArticle_Id(articleId);
            if (optional.isPresent()) {
                File file = new File(uploadPath + optional.get().getFileName());
                if (file.exists()) log.info(file.delete()?"파일 삭제 성공":"파일 삭제 실패");
            }
            imageRepository.deleteByArticle_Id(articleId);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
}

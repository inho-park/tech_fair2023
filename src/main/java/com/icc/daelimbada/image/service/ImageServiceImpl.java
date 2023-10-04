package com.icc.daelimbada.image.service;

import com.icc.daelimbada.image.domain.Image;
import com.icc.daelimbada.image.dto.ImageDTO;
import com.icc.daelimbada.image.repository.ImageRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Log4j2
@Service
@RequiredArgsConstructor
public class ImageServiceImpl implements ImageService {
    final private ImageRepository imageRepository;

    @Override
    public ImageDTO getImage(Long articleId) {
        try {
            return entityToDTO(imageRepository.findByArticle_IdAndNumber(articleId, 1).orElseThrow());
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<ImageDTO> getList(Long articleId) {
        try {
            List<ImageDTO> list = new ArrayList<>();
            imageRepository.findAllByArticle_Id(articleId).forEach(
                    i -> list.add(entityToDTO(i))
            );
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<ImageDTO> postImages(Long articleId, MultipartFile[] multipartFiles) {
        return null;
    }

    @Override
    public List<ImageDTO> modifyImages(Long articleId, MultipartFile[] multipartFiles) {
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

package com.icc.daelimbada.image.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@SpringBootTest
public class ImageServiceTests {
    @Autowired
    private ImageService imageService;

    @Test
    public void 이미지_생성() {
        try {
            MockMultipartFile multipartFile = getMockMultipartFile("변신", "jpg",
                    "D:\\tech_fair2023\\변신.jpg");
            System.out.println(imageService.postImages(200L, multipartFile));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private MockMultipartFile getMockMultipartFile(String fileName, String contentType, String path) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(new File(path));
        return new MockMultipartFile(fileName, fileName + "." + contentType, contentType, fileInputStream);
    }
}

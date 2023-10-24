package com.icc.daelimbada.image.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


@Log4j2
@Controller
@RequiredArgsConstructor
@RequestMapping("/image")
public class ImageController {
    @Value("${upload-path}")
    private String uploadPath;
    @GetMapping("/display/{filename}")
    public ResponseEntity<Resource> showImage(@PathVariable("filename") String filename) {
        Resource resource = new FileSystemResource(uploadPath + filename);
        if (!resource.exists()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        HttpHeaders header = new HttpHeaders();
        Path filePath = null;
        try {
            filePath = Paths.get(uploadPath + filename);
            header.add("Content-type", Files.probeContentType(filePath));
        } catch(IOException e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(resource, header, HttpStatus.OK);
    }
}

package com.icc.daelimbada.image.repository;

import com.icc.daelimbada.image.domain.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, Long> {
}

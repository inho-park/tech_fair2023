package com.icc.daelimbada.image.domain;

import com.icc.daelimbada.article.domain.Article;
import com.icc.daelimbada.common.domain.BaseTime;
import lombok.*;

import javax.persistence.*;

@Getter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Image extends BaseTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, unique = true, nullable = false)
    private String filePath;

    @OneToOne(fetch = FetchType.LAZY)
    private Article article;
}

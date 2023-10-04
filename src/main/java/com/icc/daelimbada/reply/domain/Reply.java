package com.icc.daelimbada.reply.domain;

import com.icc.daelimbada.article.domain.Article;
import com.icc.daelimbada.common.domain.BaseTime;
import com.icc.daelimbada.user.domain.User;
import lombok.*;

import javax.persistence.*;

/**
 * 대댓글도 추가할건지 의논해봐야함
 */
@Getter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Reply extends BaseTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 1000)
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    private Article article;
}

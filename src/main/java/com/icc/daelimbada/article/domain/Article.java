package com.icc.daelimbada.article.domain;

import com.icc.daelimbada.common.domain.BaseTime;
import com.icc.daelimbada.common.domain.BooleanToYNConverter;
import com.icc.daelimbada.reply.domain.Reply;
import com.icc.daelimbada.user.domain.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.List;

/**
 * 1. img 를 2개 이상 사용하려면 해당 ERD 구조로는 해겳 불가능
 * 2. major code 를 사용하려는 취지는 좋으나 불필요한 쿼리 연산을 또 실행하는 과정이 과연 효율적인지 의문
 *      (2번 문제는 Enum 으로 처리하는 방식이 효율적으로 보임)
 */

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Article extends BaseTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String title;

    @Column(nullable = false)
    private Long price;

    @Column(nullable = false, length = 1000)
    private String content;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Major major;

    @Column(nullable = false)
    @Convert(converter = BooleanToYNConverter.class)
    private boolean isSold;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;
}

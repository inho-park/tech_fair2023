package com.icc.daelimbada.article.domain;

import com.icc.daelimbada.common.domain.BaseTime;
import com.icc.daelimbada.common.domain.BooleanToYNConverter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * img 를 2개 이상 사용하려면 해당 ERD 구조로는 해겳 불가능
 * major code 를 사용하려는 취지는 좋으나 불필요한 쿼리 연산을 또 실행하는 과정이 과연 효율적인지 의문
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

    @Column(length = 100)
    private String title;

    @Column
    private Long price;

    @Column(length = 1000)
    private String content;

    @Column
    @Convert(converter = BooleanToYNConverter.class)
    private boolean isSold;
}

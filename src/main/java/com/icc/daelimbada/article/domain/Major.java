package com.icc.daelimbada.article.domain;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Major {

    // 공학분야
    컴퓨터정보학부(101l, "컴퓨터정보학부"),
    건설환경공학과(102l, "건설환경공학과"),
    전기공학과(103l, "전기공학과"),
    미래자동차학부(104l, "미래자동차학부"),
    기계공학과(105l, "기계공학과"),
    실내디자인학부(106l, "실내디자인학부"),
    AI시스템과(107l, "AI시스템과"),
    건축과(108l, "건축과"),
    메카트로닉스과(109l, "메카트로닉스전공"),
    반도체학과(110l, "반도체학과"),
    방송음향기술과(111l, "방송음향기술과"),
    소방안전설비과(112l, "소방안전설비과"),
    영상디자인과(113l, "영상디자인과"),

    // 인문사회분야
    경영학과(201l, "경영학과"),
    도서관미디어정보과(202l, "도서관미디어정보과"),
    사무행정학과(203l, "사무행정학과"),
    사회복지과(204l, "사회복지과"),
    항공서비스과(205l, "항공서비스과"),
    호텔레저학과(206l, "호텔관광학과"),
    유아교육과(207l, "유아교육과"),

    // 그 외 (예체능, 보건, 제빵)
    스포츠재활과(301l, "스포츠재활과"),
    제과제빵과(302l, "제과제빵과"),
    호텔조리과(303l, "호텔조리과"),
    보건안전학과(304l, "보건안전학과"),
    보건의료공학과(305l, "보건의료공학과"),
    보건의료행정과(306l, "보건의료행정과"),
    언어치료학과(307l, "언어치료학과"),
    해군기술부사관과(308l, "해군기술부사관과"),
    교양(309l, "교양");

    // 교양

    private final Long code;
    private final String major;

    Major(Long code, String major) {
        this.code = code;
        this.major = major;
    }

    public Long getCode() {
        return code;
    }

    private static final Map<Long, Major> BY_CODE =
            Stream.of(values()).collect(Collectors.toMap(Major::getCode, e -> e));

    public static Major getMajor(Long code) {
        return BY_CODE.get(code);
    }
}

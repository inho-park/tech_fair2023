package com.icc.daelimbada.article.domain;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Major {

    // 공학분야
    컴퓨터정보학부(101, "컴퓨터정보학부"),
    건설환경공학과(102, "건설환경공학과"),
    전기공학과(103, "전기공학과"),
    미래자동차학부(104, "미래자동차학부"),
    기계공학과(105, "기계공학과"),
    실내디자인학부(106, "실내디자인학부"),
    AI시스템과(107, "AI시스템과"),
    건축과(108, "건축과"),
    메카트로닉스과(109, "메카트로닉스전공"),
    반도체학과(110, "반도체학과"),
    방송음향기술과(111, "방송음향기술과"),
    소방안전설비과(112, "소방안전설비과"),
    영상디자인과(113, "영상디자인과"),

    // 인문사회분야
    경영학과(201, "경영학과"),
    도서관미디어정보과(202, "도서관미디어정보과"),
    사무행정학과(203, "사무행정학과"),
    사회복지과(204, "사회복지과"),
    항공서비스과(205, "항공서비스과"),
    호텔레저학과(206, "호텔관광학과"),
    유아교육과(207, "유아교육과"),

    // 그 외 (예체능, 보건, 제빵)
    스포츠재활과(301, "스포츠재활과"),
    제과제빵과(302, "제과제빵과"),
    호텔조리과(303, "호텔조리과"),
    보건안전학과(304, "보건안전학과"),
    보건의료공학과(305, "보건의료공학과"),
    보건의료행정과(306, "보건의료행정과"),
    언어치료학과(307, "언어치료학과"),
    해군기술부사관과(308, "해군기술부사관과"),

    교양(310, "교양");

    // 교양

    private final int code;
    private final String name;

    Major(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public int getCode() {
        return code;
    }
    public String getName() {
        return name;
    }
    private static final Map<Integer, Major> BY_CODE =
            Stream.of(values()).collect(Collectors.toMap(Major::getCode, e -> e));

    public static Major getMajor(int code) {
        return BY_CODE.get(code);
    }
}

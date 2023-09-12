package com.icc.daelimbada.article.domain;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Major {

    // 공학분야
    AI시스템과(101l, "AI시스템과"),
    로봇자동화공학과(102l, "로봇자동화공학과"),
    응용SW전공(103l, "응용SW전공"),
    건축과(104l, "건축과"),
    기계공학과(105l, "기계공학과"),
    미래자동차학부(106l, "미래자동차학부"),
    방송음향영상학부(107l, "방송음향영상학부"),
    방송음향기술과(108l, "방송음향기술과"),
    영상디자인과(109l, "영상디자인과"),
    산업경영과(110l, "산업경영과"),
    소방안전설비과(111l, "소방안전설비과"),
    전자통신과(112l, "전자통신과"),
    메카트로닉스전공(113l, "메카트로닉스전공"),
    스마트팩토리학부(114l, "스마트팩토리학부"),
    반도체장비전공(115l, "반도체장비전공"),
    스마트자동화전공(116l, "스마트자동화전공"),
    실내디자인학부(117l, "실내디자인학부"),
    의공융합과(118l, "의공융합과"),
    전기공학과(119l, "전기공학과"),
    컴퓨터정보학부(120l, "컴퓨터정보학부"),
    건설환경공학과(121l, "건설환경공학과"),
    반도체학과(122l, "반도체학과"),

    // 인문사회분야
    경영학과(201l, "경영학과"),
    도서관미디어정보과(202l, "도서관미디어정보과"),
    사무행정학과(203l, "사무행정학과"),
    사회복지과(204l, "사회복지과"),
    유아교육과(205l, "유아교육과"),
    항공서비스과(206l, "항공서비스과"),
    호텔레저학과(207l, "호텔레저학과"),
    아동보육과(208l, "아동보육과"),

    // 그 외 (예체능, 보건, 제빵)
    스포츠지도과(301l, "스포츠지도과"),
    스포츠재활과(302l, "스포츠재활과"),
    제과제빵과(303l, "제과제빵과"),
    호텔조리과(304l, "호텔조리과"),
    보건안전학과(305l, "보건안전학과"),
    보건의료공학과(306l, "보건의료공학과"),
    보건의료행정과(307l, "보건의료행정과"),
    언어치료학과(308l, "언어치료학과"),
    해군기술부사관과(309l, "해군기술부사관과"),
    
    // 교양
    교양(400l, "교양");

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

const majors = [
  {
    id : 1,
    name: "majors",
    classification: "공학분야",
    list: [
      '컴퓨터정보학부',
      '건설환경공학과',
      '전기공학과',
      '미래자동차공학부',
      '기계공학과',
      '실내디자인학부',
      'AI시스템과',
      '건축과',
      '메카트로닉스과',
      '반도체학과',
      '방송음향기술과',
      '소방안전설비과',
      '영상디자인과'
    ]
  },
  {
    id : 2,
    name: "majors",
    classification: "인문사회분야",
    list: [
      '경영학과',
      '도서관미디어정보과',
      '사무행정학과',
      '사회복지학과',
      '항공서비스과',
      '호텔관광학과',
      '유아교육과',
    ]
  },
  {
    id : 3,
    name: "majors",
    classification: "기타분야",
    list: [
      '스포츠재활분야',
      '제과제빵과',
      '호텔조리과',
      '보건안전학과',
      '보건의료공학과',
      '보건의료행정과',
      '언어치료학과',
      '기타교양'
    ]
  },
  
  
  ]

  const classificationSelect = document.getElementById("classificationSelect");
  majors.forEach(category => {
      const option = document.createElement("option");
      option.value = category.classification;
      option.textContent = category.classification;
      classificationSelect.appendChild(option);
  });

  // 소분류 선택 목록 생성 및 초기화
  const majorSelect = document.getElementById("majorSelect");
  const defaultClassification = "공학분야";
  const defaultCategory = majors.find(category => category.classification === defaultClassification);
  if (defaultCategory) {
      defaultCategory.list.forEach(major => {
          const option = document.createElement("option");
          option.value = major;
          option.textContent = major;
          majorSelect.appendChild(option);
      });
  }

  // 대분류 선택 변경 이벤트 핸들러
  classificationSelect.addEventListener("change", () => {
      const selectedClassification = classificationSelect.value;
      majorSelect.innerHTML = ""; // 이전 선택을 지웁니다.
      const selectedCategory = majors.find(category => category.classification === selectedClassification);
      if (selectedCategory) {
          selectedCategory.list.forEach(major => {
              const option = document.createElement("option");
              option.value = major;
              option.textContent = major;
              majorSelect.appendChild(option);
          });
      }
  });

  const fileInput = document.getElementById('file');
  const uploadNameInput = document.querySelector('.upload-name');
  
  fileInput.addEventListener('change', function () {
      const fileName = fileInput.value;
      uploadNameInput.value = fileName;
  });

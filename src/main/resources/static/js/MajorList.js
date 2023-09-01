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

  
  const majorList = document.querySelector(".major-list");

  majors.forEach((majorData) => {
    const majorContainer = document.createElement("div");
    majorContainer.innerHTML = /* html */ `
      <span class="major-name">${majorData.classification}</span>
      <button class="material-symbols-outlined add none">add</button>
      <button class="material-symbols-outlined remove">remove</button>
      <hr>
      <ul class="major">
        ${majorData.list.map((majorName) => `<li>${majorName}</li>`).join("")}
      </ul>
    `;
  
    majorList.appendChild(majorContainer);
  
    const addButton = majorContainer.querySelector(".add");
    const removeButton = majorContainer.querySelector(".remove");
    const major = majorContainer.querySelector(".major");
  
    addButton.addEventListener("click", () => {
      addButton.classList.toggle("none");
      removeButton.classList.toggle("none");
      major.classList.toggle("none");
    });
  
    removeButton.addEventListener("click", () => {
      removeButton.classList.toggle("none");
      addButton.classList.toggle("none");
      major.classList.toggle("none");
    });
  });
  
  
  
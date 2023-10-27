const majors = [
  {
    id : 1,
    name: "majors",
    classification: "공학분야",
    list: [
      {code: 101, major: '컴퓨터정보학부'},
      {code: 102, major: '건설환경공학과'},
      {code: 103, major: '전기공학과'},
      {code: 104, major: '미래자동차학부'},
      {code: 105, major: '기계공학과'},
      {code: 106, major: '실내디자인과'},
      {code: 107, major: 'AI시스템과'},
      {code: 108, major: '건축과'},
      {code: 109, major: '메카트로닉스전공'},
      {code: 110, major: '반도체학과'},
      {code: 111, major: '방송음향기술과'},
      {code: 112, major: '소방안전설비과'},
      {code: 113, major: '영상디자인'},
    ]
  },
  {
    id : 2,
    name: "majors",
    classification: "인문사회분야",
    list: [
      {code: 201, major: '경영학과'},
      {code: 202, major: '도서관미디어정보과'},
      {code: 203, major: '사무행정학과'},
      {code: 204, major: '사회복지과'},
      {code: 205, major: '항공서비스과'},
      {code: 206, major: '호텔관광학과'},
      {code: 207, major: '유아교육과'},
    ]
  },
  {
    id : 3,
    name: "majors",
    classification: "기타분야",
    list: [
      {code: 301, major: '스포츠재활과'},
      {code: 302, major: '제과재빵과'},
      {code: 303, major: '호텔조리과'},
      {code: 304, major: '보건안전학과'},
      {code: 305, major: '보건의료공학과'},
      {code: 306, major: '보건의료행정과'},
      {code: 307, major: '언어치료학과'},
      {code: 308, major: '해군기술부사관과'},
      {code: 310, major: '교양'},
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
      ${majorData.list.map((majorName) => `<a class="major_aTag" href="list?type=${majorName.code}"><li class="major_item">${majorName.major}</li></a>`).join("")}
      
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

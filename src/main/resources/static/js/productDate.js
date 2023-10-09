const dateElements = document.querySelectorAll(".date");
const dates = [];

dateElements.forEach(dateElement => {
    dates.push(dateElement.innerText);
});

console.log(dates);

for(let i=0; i < dates.length; i++){
    const dateObject = new Date(dates[i]);
    const month = (dateObject.getMonth() + 1).toString().padStart(2, '0'); // 월 (0부터 시작하므로 +1 필요)
    const day = dateObject.getDate().toString().padStart(2, '0'); // 일

    const extractedDate = `${month}-${day}`;

    dateElements[i].innerText=extractedDate;
}
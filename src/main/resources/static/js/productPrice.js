const priceTag  = document.querySelectorAll('.product_price');

const productPrice = [];

priceTag.forEach((price)=>{
    productPrice.push((Number)(price.innerText));
})

console.log(productPrice);

for(let i = 0; i < productPrice.length; i++){
    const dataPrice = `${productPrice[i].toLocaleString()} 원`
    priceTag[i].innerText = dataPrice;
}


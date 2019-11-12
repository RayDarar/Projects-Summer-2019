import logic from "./logic.js";

const kz = document.querySelector(".kz");
const usd = document.querySelector(".usd");

kz.onkeyup = (event) => {
    usd.value = logic.convert2Dollars(kz.value);
}
usd.onkeyup = (event) => {
    kz.value = logic.convert2Tenge(usd.value);
}

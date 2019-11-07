import logic from "./logic.js";

const input = document.querySelector(".input");
const output = document.querySelector(".output");
const convert_btn = document.querySelector(".convert-btn");

convert_btn.onclick = () => {
    output.value = JSON.stringify(logic.convert(input.value));
}
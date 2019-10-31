/**
 * @author Anakharsis9
 *  
 */
const days = document.querySelector(".days");
const hours = document.querySelector(".hours");
const minutes = document.querySelector(".minutes");
const seconds = document.querySelector(".seconds");
let difDate = calculate("2020-01-01");

document.querySelector(".time-to").onchange = () => {
    difDate = calculate(document.querySelector(".time-to").value);
}

setInterval(() => {
    difDate = decrement(difDate);
    days.innerHTML = difDate.days;
    hours.innerHTML = difDate.hours;
    minutes.innerHTML = difDate.minutes;
    seconds.innerHTML = difDate.seconds;

}, 1000);
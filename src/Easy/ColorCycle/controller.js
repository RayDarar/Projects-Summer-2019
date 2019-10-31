/**
 * @author RayDarar
 * @description Implemented UX of the system
 * 
 * 
 * logic methods:
 * getState(),
 * start(),
 * changeState(),
 * getCurrentColor(),
 * changeSpeed()
 */

const ball = document.querySelector(".ball");
const objects = document.querySelectorAll(".object");
const button = document.querySelector(".button");
const range = document.querySelector(".range");

button.onclick = () => {
    logic.changeState();
}

range.onchange = () => {
    logic.changeSpeed(parseInt(range.value));
}

const loop = () => {
    if (logic.isOn) {
        const color = logic.getCurrentColor();
        
        ball.style.background = `radial-gradient(circle at 10% 10%, white, ${color} 100%)`;
        ball.style.boxShadow = `0px 0px 200px 10px ${color}`;
        document.querySelector(".overlay").style.backgroundColor = color;

        for (const object of objects) {
            const state = object.style.transform;
            object.style.transform = 
                state === "rotateY(0deg)" ? "rotateY(180deg) " : " rotateY(0deg)";
        }
    }
    setTimeout(loop, logic.speed);
}

logic.start();
loop();
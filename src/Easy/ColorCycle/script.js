const red = ["#CD5C5C", "#F08080", "#FA8072", "#E9967A", "#FFA07A", "#DC143C", "#FF0000", "#B22222", "#8B0000"];
const pink = ["#FFC0CB", "#FFB6C1", "#FF69B4", "#FF1493", "#C71585", "#DB7093"];
const orange = ["#FF7F50", "#FF6347", "#FF4500", "#FF8C00", "#FFA500"];
const yellow = ["#FFD700", "#FFFF00", "#FFE4B5", "#EEE8AA", "#F0E68C"];
const purple = ["#EE82EE", "#FF00FF", "#BA55D3", "#8A2BE2", "#9932CC", "#800080", "#4B0082"];
const green = ["#7FFF00", "#00FF00", "#32CD32", "#228B22", "#006400", "#00FF7F", "#9ACD32"];
const blue = ["#00FFFF", "#00CED1", "#00BFFF", "#0000FF", "#0000CD", "#000080", "#40E0D0"];
const colors = [red, pink, orange, yellow, purple, green, blue];
const logic = {
    isOn: true,
    speed: 1000,
    currentColor: "#FF0000",
    changeState: () => {
        logic.isOn = !logic.isOn;
    },
    getCurrentColor: () => currentColor,
    start: () => {
        logic.changeColor();
    },
    changeColor: () => {
        setTimeout(() => {

            if (logic.isOn){
                let colorI = getRandomInt(colors.length);
                let tintJ = getRandomInt(colors[colorI].length);
                currentColor = colors[colorI][tintJ];
                // console.log(logic.getCurrentColor());
            }
                
            logic.changeColor();
        }, logic.speed);
    },
    changeSpeed: (new_speed) => {
        logic.speed = new_speed;
    }
}

function getRandomInt(max) {
    return Math.floor(Math.random() * Math.floor(max));
}

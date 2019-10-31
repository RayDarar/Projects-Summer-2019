const logic = {
    getState: () => {
        return false;
    },
    getCurrentColor: () => {

    },
    start: () => {
        let count = 0;
        const idInterval = setInterval(() => {
            console.log("Tick");
            count++;

            if (count === 5)
                clearInterval(idInterval);
        }, 1000);
        
    }
}

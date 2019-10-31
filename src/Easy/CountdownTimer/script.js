/**
 * @author RayDarar
 *  
 */

const calculate = (str) => {
    const current = new Date();
    const given = new Date(str);
    let difference = given.getTime() - current.getTime();

    return generateObject(difference);
}

const generateObject = (ms) => {
    const result = {
        days: Number,
        hours: Number,
        minutes: Number,
        seconds: Number
    }

    // count days ms / 1000 * 60 * 60 * 24
    result.days = Math.floor(ms / (1000 * 60 * 60 * 24));
    ms -= result.days * 24 * 60 * 60 * 1000;

    // count hours ms / 1000 * 60 * 60
    result.hours = Math.floor(ms / (1000 * 60 * 60));
    ms -= result.hours * 60 * 60 * 1000;

    // count minutes ms / 1000 * 60
    result.minutes = Math.floor(ms / (1000 * 60));
    ms -= result.minutes * 60 * 1000;

    // count seconds ms / 1000
    result.seconds = Math.floor(ms / 1000);
    return result;
}

const decrement = (date) => {
    const result = generateObject(date.days * 24 * 60 * 60 * 1000 + date.hours * 60 * 60 * 1000 + date.minutes * 60 * 1000 + date.seconds * 1000 - 1000);

    return result.days >= 0 ? result : "done";
}

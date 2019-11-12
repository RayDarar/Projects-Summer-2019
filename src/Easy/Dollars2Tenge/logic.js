/**
 * @author RayDarar
 * 
 * @description proportion used: 1 dollar = 388.77 tenge
 * 
 */

const proportion = 388.77;
const logic = {
    convert2Dollars: (tenge) => {
        return tenge < 1 ? 0 : tenge / proportion;
    },
    convert2Tenge: (dollars) => {
        return dollars < 1 ? 0 : dollars * proportion;
    }
}

export default logic;

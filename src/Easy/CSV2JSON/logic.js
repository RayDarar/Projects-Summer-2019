export default {
    convert: (csv) => {
        while(csv.includes('"')){
            csv = csv.replace('"','');
        }
        const array = csv.split("\n");
        const properties = array[0].split(",");
        const jsons = [];
        for (let i = 1; i < array.length; i++) {
           const item = {};
           const value = array[i].split(",");
           for (let j = 0; j < properties.length; j++) {
               item[properties[j]] = value[j];
           }
           jsons.push(item);
        }
        return jsons;

    },
};

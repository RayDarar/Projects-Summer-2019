let todo = [];

const fs = require("fs");
const path = require("path");

const dataPath = path.join(process.env.dirname, "database", "data.txt");

module.exports = {
  serialize() {
    fs.writeFileSync(dataPath, JSON.stringify(todo));
  },
  deserialize() {
    const data = fs.readFileSync(dataPath);
    todo = JSON.parse(data);
    return data;
  }
};

require("dotenv").config();

const assert = require("assert");
const express = require("express");
const server = express();

const db = require("./database/db");

process.on("SIGINT", () => {
  db.serialize();
  process.exit(0);
});

server.listen(process.env.PORT | 80, () => {
  assert.notEqual(db.deserialize(), undefined);
  console.log("Server runs at port: " + (process.env.PORT | 80));
});

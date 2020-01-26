require("dotenv").config();

const assert = require("assert");
const express = require("express");
const bodyParser = require("body-parser");
const path = require("path");
const server = express();

const apiRoute = require("./routes/api-route");
const db = require("./database/db");

server.use(express.static(path.join(__dirname, "public")));

server.use((req, res, next) => {
  console.log(
    `${req.method} request on ${req.url} at ${new Date().toTimeString()}`
  );
  next();
});

server.use(bodyParser.json());

server.use("/api", apiRoute);

process.on("SIGINT", () => {
  db.serialize();
  process.exit(0);
});

server.listen(process.env.PORT | 80, () => {
  assert.notEqual(db.deserialize(), undefined);
  console.log("Server runs at port: " + (process.env.PORT | 80));
});

import { config } from "dotenv";
config();

import express from "express";
import cors from "cors";
import bodyParser from "body-parser";
import cookieParser from "cookie-parser";
import path from "path";

const app = express();

app.use(cors());
app.use(bodyParser.json());
app.use(cookieParser());
app.use(express.static(path.join(process.env.PWD, "public")));

app.use((req, res, next) => {
  console.log(`${req.method} request on ${req.url} at ${new Date().toTimeString()}`);
});

app.listen(process.env.PORT, () => {
  console.log("Server is running!");
});

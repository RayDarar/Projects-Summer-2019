const express = require("express");
const db = require("../database/db");
const router = express.Router();

router.get("/get", (req, res) => {
  res.send(db.getToDo());
});

router.post("/create", (req, res) => {
  db.create(req.body.text, req.body.priority, req.body.deadline);
  res.status(201).end();
});

router.put("/update", (req, res) => {
  db.update(req.body.id, req.body.text, req.body.priority, req.body.deadline);
  res.status(204).end();
});

router.put("/complete", (req, res) => {
  db.completeTask(req.body.id);
  res.status(204).end();
});

router.delete("/delete", (req, res) => {
  db.delete(req.body.id);
  res.status(204).end();
});

module.exports = router;

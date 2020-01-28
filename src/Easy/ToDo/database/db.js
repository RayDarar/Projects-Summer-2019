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
  },
  create(text = null, priority = null, deadline = null) {
    const entry = {
      id: todo[0] ? todo[todo.length - 1].id + 1 : 1,
      text,
      priority,
      deadline,
      completed: false
    };
    todo.push(entry);
  },
  getToDo: () => todo,
  update(id, text, priority, deadline) {
    for (const todoItem of todo)
      if (todoItem.id === id) {
        todoItem.text = text;
        todoItem.priority = priority;
        todoItem.deadline = deadline;
        break;
      }
  },
  completeTask(id) {
    for (const todoItem of todo)
      if (todoItem.id === id) {
        todoItem.completed = !todoItem.completed;
        break;
      }
  },
  delete(id) {
    todo = todo.filter(item => item.id !== id);
  }
};

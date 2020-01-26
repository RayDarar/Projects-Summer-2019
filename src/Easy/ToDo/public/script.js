const vm = new Vue({
  el: "#vm",
  data: {
    message: "UTodo for you!",
    todos: [
      { id: 1, text: "Изучить JavaScript", isComplete: false },
      { id: 2, text: "Изучить Vue.js", isComplete: false },
      { id: 3, text: "Создать что-нибудь классное", isComplete: false },
      { id: 4, text: "Создать что-нибудь классное", isComplete: false },
      { id: 5, text: "Создать что-нибудь классное", isComplete: false },
      { id: 6, text: "Создать что-нибудь классное", isComplete: false },
      { id: 7, text: "Создать что-нибудь классное", isComplete: false },
      { id: 8, text: "Создать что-нибудь классное", isComplete: false },
      { id: 9, text: "Создать что-нибудь классное", isComplete: false },
      { id: 10, text: "Создать что-нибудь классное", isComplete: false }
    ]
  },
  methods: {
    complete(todo) {
      todo.isComplete = !todo.isComplete;
    }
  }
});

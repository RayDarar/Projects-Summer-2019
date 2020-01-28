const baseUrl = "http://localhost:80/";

const vm = new Vue({
  el: "#vm",
  data: {
    message: "UTodo for you!",
    show: false,
    todos: [],
    form: {
      text: "",
      priority: 0,
      deadline: "",
      isEditing: false
    },
    formError: {
      text: false
    }
  },
  methods: {
    complete(todo) {
      todo.completed = !todo.completed;
      axios.put(baseUrl + "api/complete", { id: todo.id });
    },
    create() {
      const todo = _.clone(this.form);
      if (todo.text) {
        axios.post(baseUrl + "api/create", todo);
        this.todos.push(todo);
        this.show = false;
        this.formError.text = false;
      } else this.formError.text = true;

      this.form.text = "";
      this.form.priority = 0;
      this.form.deadline = "";
      this.toDefaultColor();
    },
    remove(id) {
      axios.delete(baseUrl + "api/delete", { data: { id } });
      this.todos = this.todos.filter(item => item.id !== id);
    },
    setPriority(priority) {
      this.form.priority = priority;
      this.toDefaultColor();
      if (priority === 1) {
        this.$refs.tempLow.style.backgroundColor = "#13FF14";
      } else if (priority === 2) {
        this.$refs.tempLow.style.backgroundColor = "#FFE319";
        this.$refs.tempNormal.style.backgroundColor = "#FFE319";
      } else {
        this.$refs.tempLow.style.backgroundColor = "#FF2218";
        this.$refs.tempNormal.style.backgroundColor = "#FF2218";
        this.$refs.tempHigh.style.backgroundColor = "#FF2218";
      }
    },
    toShow() {
      this.show = !this.show;
    },
    toDefaultColor() {
      this.$refs.tempLow.style.backgroundColor = "#446085";
      this.$refs.tempNormal.style.backgroundColor = "#446085";
      this.$refs.tempHigh.style.backgroundColor = "#446085";
    },
    enableEditing(event, item) {
      event.target.parentNode.querySelector("input").focus();
      item.isEditing = !item.isEditing;
    },
    update(event, item) {
      if (item.isEditing) {
        axios.put(baseUrl + "api/update", item);
        event.target.blur();
        item.isEditing = !item.isEditing;
      }
    },
    updatePriority(event, item, priority) {
      this.toDefaultColor();
      if (priority === 1) {
        event.target.style.backgroundColor = "#13FF14";
        event.target.parentNode.querySelector(".normal").style.backgroundColor =
          "#446085";
        event.target.parentNode.querySelector(".high").style.backgroundColor =
          "#446085";
        item.priority = 1;
        axios.put(baseUrl + "api/update", item);
      } else if (priority === 2) {
        event.target.parentNode.querySelector(".low").style.backgroundColor =
          "#FFE319";
        event.target.style.backgroundColor = "#FFE319";
        event.target.parentNode.querySelector(".high").style.backgroundColor =
          "#446085";
        item.priority = 2;
        axios.put(baseUrl + "api/update", item);
      } else {
        event.target.parentNode.querySelector(".low").style.backgroundColor =
          "#FF2218";
        event.target.parentNode.querySelector(".normal").style.backgroundColor =
          "#FF2218";
        event.target.style.backgroundColor = "#FF2218";
        item.priority = 3;
        axios.put(baseUrl + "api/update", item);
      }
    },
    updateDeadline(event,item) {
      item.deadline = event.target.value;
      axios.put(baseUrl + "api/update", item);
    }
  },
  async created() {
    const response = await axios.get(baseUrl + "api/get");
    this.todos = response.data.map(item => {
      item.isEditing = false;
      return item;
    });
  },
  computed: {
    completedList() {
      return this.todos.filter(item => item.completed === true);
    },
    unCompletedList() {
      return this.todos.filter(item => item.completed !== true);
    }
  }
});

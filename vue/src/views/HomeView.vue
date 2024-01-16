<template>
  <div class="home">
    <h1>Home</h1>
    <p>You must be authenticated to see this</p>
    <form @submit.prevent="chat()">
      <label for="chatInput">Chat Input</label>
      <input id="chatInput" type="text" v-model="chatRequest"/>
      <button type="submit">Submit</button>
    </form>
    <div>{{ chatResponse }}</div>


  </div>
</template>

<script>
import ChatService from "@/services/ChatService";

export default {
  data() {
    return {
      chatResponse: "",
      chatRequest: ""
    }
  },
  methods: {
    async chat() {
      ChatService.chat({ prompt: this.chatRequest })
          .then(response => {
            this.chatResponse = response.data;
          })
          .catch(error => {
            console.log(error);
          });
    }
  }
};
</script>

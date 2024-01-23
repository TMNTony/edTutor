<template>
  <div>Submission</div>
  <div>{{this.$route.params.id}}</div>
  <div>Current Score: {{this.score}}</div>
  <Submit/>
</template>

<script>
import Submit from "@/components/Submit.vue";

export default {
  components: {
    Submit
  },
  data() {
    return {
      score: 0,
    }
  },
}

</script>

<style scoped>

</style>
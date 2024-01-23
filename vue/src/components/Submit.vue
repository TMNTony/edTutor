<template>
  <div>Add Content</div>
  <TextEditor
      class="mt-4"
      v-model="submission"
      :content="submission">
  </TextEditor>
  <button @click.prevent="saveSubmission">Save</button>
</template>
<script>
import TextEditor from "@/components/TextEditor.vue";
import SubmissionService from "@/services/SubmissionService";

export default {
  components: {
    TextEditor,
    SubmissionService
  },
  data() {
    return {
      submission: "",
      user: "",
      module: this.$route.params.id
    }
  },
  methods: {
    saveSubmission() {
      SubmissionService.save(this.user, this.module, this.submission)
          .then(response => {
            console.log("Successfully Saved")
          })
          .catch(err => {
            console.log(err)
          })
    },
    getUser() {
      this.user = this.$store.state.user.id
    }
  },
  created() {
    this.getUser()
  }
}

</script>
<style scoped>

</style>
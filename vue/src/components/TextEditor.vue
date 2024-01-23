<template>
  <editor
      ref="editor"
      api-key="vc91q08hd6uey57md65ljphk6byh7xots8qwkvy02x9cm402"
      :init="{
        height: 500,
        menubar: true,
        plugins: [
          'autolink',
          'lists',
          'link',
          'image',
          'preview',
          'anchor',
          'fullscreen',
          'media',
          'table',
          'help',
        ],
        toolbar:
          'undo redo | casechange blocks | bold italic backcolor | \
           alignleft aligncenter alignright alignjustify | \
           bullist numlst checklist outdent indent | removeformat | a11ycheck code table help',
      }"
  />
</template>

<script>
import Editor from "@tinymce/tinymce-vue";
export default {
  name: "text-editor",
  components: {
    Editor,
  },
  props: {
    content: String,
  },
};
</script>

<style scoped>
@media (min-width: 1024px) {
  #sample {
    display: flex;
    flex-direction: column;
    place-items: center;
    width: 1000px;
  }
}
</style>
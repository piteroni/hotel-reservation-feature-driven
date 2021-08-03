<template>
  <div class="mb-2 about">
    <slot />
  </div>
</template>

<script lang="ts">
import { defineComponent } from "@nuxtjs/composition-api"

export default defineComponent({})
</script>

<style scoped>
.about {
  margin-top: 12px;
  margin-bottom: 8px;
  color: rgb(90, 72, 43);
  font-family: Georgia, "MS 明朝", "Hiragino Mincho Pro W3", "ヒラギノ明朝 Pro W3", serif;
  font-size: 12px;
  font-weight: bold;
  line-height: 28px;
  padding: 0px 0px 0px 10px;
  border-width: 1px;
  border-style: solid;
  border-color: rgb(216, 216, 216);
  border-image: initial;
}
</style>

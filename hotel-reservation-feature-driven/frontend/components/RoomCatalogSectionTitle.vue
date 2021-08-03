<template>
  <div class="section-title text-lg font-bold">
    <slot />
  </div>
</template>

<script lang="ts">
import { defineComponent } from "@nuxtjs/composition-api"

export default defineComponent({})
</script>

<style scoped>
.section-title {
  margin-bottom: 8px;
  font-size: 14px;
  border-bottom: 1px solid #999;
}
</style>

<template>
  <div class="app-container">
    <header class="my-3">
      <div class="my-3">
        <p>部活・サークル等のグループ利用に最適！アットホームなペンション！</p>
      </div>

      <div class="flex items-end justify-between">
        <a href="#">
          <img class="logo" src="/image/logo.png" alt="ロゴ">
        </a>

        <div class="text-lg">
          <div>ご予約／お問い合わせ</div>
          <span class="tel">
            ☎ 0120-000-000
          </span>
        </div>
      </div>
    </header>

    <Nuxt />

    <footer class="footer">
      © 2021 Hotel Reservation All Rights Reserved.
    </footer>
  </div>
</template>

<script lang="ts">
import { defineComponent } from "@nuxtjs/composition-api"

export default defineComponent({})
</script>

<style scoped>
.app-container {
  padding: 0 450px;
}
.logo {
  width: 500px;
  height: 80px;
}
.footer {
  padding-top: 20px;
  padding-bottom: 20px;
  text-align: center;
}
</style>

<template>
  <div class="app-container">
    <header class="my-3">
      <div class="my-3">
        <p>部活・サークル等のグループ利用に最適！アットホームなペンション！</p>
      </div>

      <div class="flex items-end justify-between">
        <NuxtLink to="/">
          <img class="logo" src="/image/logo.png" alt="ロゴ">
        </NuxtLink>

        <div>
          <div class="text-sm">
            ご予約／お問い合わせ
          </div>
          <span class="tel text-lg">
            ☎ 0120-000-000
          </span>
        </div>
      </div>
    </header>

    <nav>
      <ul class="flex">
        <li class="menu-item">
          <NuxtLink class="menu-item-link" to="/">
            ホーム
          </NuxtLink>
        </li>
        <li class="menu-item">
          <NuxtLink class="menu-item-link" to="/rooms/catalog">
            お部屋紹介
          </NuxtLink>
        </li>
        <li class="menu-item">
          <a class="menu-item-link" href="#">ご予約</a>
        </li>
        <li class="menu-item">
          <a class="menu-item-link" href="#">ログイン</a>
        </li>
      </ul>
    </nav>

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
.menu-item {
  color: #000000;
  text-align: center;
  list-style-type: none;
}
.menu-item-link {
  display: block;
  width: 129px;
  line-height: 40px;
  border-collapse: collapse;
  border: 1px solid #D8D8D8;
  font-weight: bold;
  font-size: 16px;
  white-space: nowrap;
}
.footer {
  padding-top: 20px;
  padding-bottom: 20px;
  text-align: center;
}
</style>

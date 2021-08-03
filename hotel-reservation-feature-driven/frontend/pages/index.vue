<template>
  <div>
    <span class="icatch">
      <img src="/image/icatch.jpg" alt="アイキャッチ">
    </span>

    <main class="my-4">
      <article>
        <section class="mb-4">
          <div class="section-title">
            <img class="small-img" src="/image/whats_new.png" alt="whats_new">
            <p>更新情報</p>
          </div>

          <div class="flex">
            <div>
              2016-02-15
            </div>
            <div class="ml-4">
              サイトオープンしました。
            </div>
          </div>
        </section>

        <section class="mb-4">
          <div class="section-title">
            <img class="small-img" src="/image/about_us.png" alt="about_us">
            <p>JikkyoPensionについて</p>
          </div>

          <div class="mb-4">
            <h3 class="message-title">
              にこやか笑顔でお出迎え
            </h3>
            <p>
              少人数で営業している当ペンションですが、スタッフ一同心掛けているのは、
              <br> にこやかな笑顔で接客対応することです！
            </p>
          </div>

          <div class="mb-4">
            <h3 class="message-title">
              大人数でワイワイと
            </h3>
            <p>
              部活やサークル、仲の良いお友達同士などと、
              <br> 大人数でワイワイしながら過ごすのに最適な環境づくりを目指しています！
            </p>
          </div>

          <div class="mb-4">
            <h3 class="message-title">
              観光スポットに恵まれた好立地
            </h3>
            <p>
              ゲレンデ、テニスコート、各種レクリエーション施設へのアクセスは抜群です！
              <br> また、温泉地の中心街からも近いため、観光にも最適です！
            </p>
          </div>
        </section>
      </article>
    </main>
  </div>
</template>

<script lang="ts">
import { defineComponent } from "@nuxtjs/composition-api"

export default defineComponent({
  auth: false
})
</script>

<style scoped>
.icatch {
  width: 542px;
  margin: 0 auto;
}

.small-img {
  width: 180px;
}

.section-title {
  margin-bottom: 8px;
  padding: 12px 0 6px 10px;
  color: #5A482B;
  font-family: Georgia, "MS 明朝", "Hiragino Mincho Pro W3", "ヒラギノ明朝 Pro W3", serif;
  font-size: 12px;
  font-weight: bold;
  line-height: 28px;
  border: 1px solid #D8D8D8;
}

.message-title {
  margin-bottom: 8px;
  font-size: 14px;
  border-bottom: 1px solid #999;
}
</style>

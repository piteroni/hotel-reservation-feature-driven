<template>
  <div>
    <div class="mb-2">
      <div class="title">
        お部屋のご紹介
      </div>

      <h3 class="message-title text-lg font-bold">
        自慢のお部屋をご紹介
      </h3>

      <p>
        和室・洋室・和洋室と、ご希望に沿った形でお部屋をお選び頂けます。
      </p>
    </div>

    <table class="table-auto w-full">
      <thead>
        <tr>
          <th class="table-head" scope="col">
            お部屋名称
          </th>
          <th class="table-head" scope="col">
            お部屋タイプ
          </th>
          <th class="table-head" scope="col">
            一泊料金<br>（部屋単位）
          </th>
          <th class="table-head" scope="col">
            お部屋イメージ
          </th>
          <th class="table-head" scope="col">
            詳細
          </th>
        </tr>
      </thead>

      <tbody>
        <tr v-for="(room, key) in rooms" :key="key">
          <td class="table-body">
            {{ room.name }}
          </td>
          <td class="table-body">
            {{ room.type }}
          </td>
          <td class="table-body app-text-right">
            {{ room.dayFee }}
          </td>
          <td class="table-body">
            <img class="w-64 h-48 mx-auto" :src="room.imagePath" alt="部屋画像">
          </td>
          <td class="table-body">
            <span @click="() => showRoom(room.id)">
              <svg xmlns="http://www.w3.org/2000/svg" class="h-6 w-6 opacity-60 cursor-pointer mx-auto" fill="none" viewBox="0 0 24 24" stroke="currentColor">
                <path fill="currentColor" d="M9,5V7H15.59L4,18.59L5.41,20L17,8.41V15H19V5" />
              </svg>
            </span>
          </td>
        </tr>
      </tbody>
    </table>
  </div>
</template>

<script lang="ts">
import { defineComponent, useContext, useAsync, computed } from "@nuxtjs/composition-api"

export default defineComponent({
  auth: false,
  setup() {
    const { $axios, redirect } = useContext()

    type RoomCatalogItem = {
      id: number,
      name: string,
      type: string,
      dayFee: number,
      imagePath: string,
    }

    const prepared = useAsync(async () => {
      const items = await $axios.$get<RoomCatalogItem[]>("/rooms/catalog")

      const formatter = new Intl.NumberFormat("ja-JP", {
        style: "currency",
        currency: "JPY"
      })

      return items.map(room => {
        return {
          id: room.id,
          name: room.name,
          type: room.type,
          dayFee: formatter.format(room.dayFee),
          imagePath: room.imagePath
        }
      })
    })

    const rooms = computed(() => prepared ?? [])

    const showRoom = (roomId: number) => {
      redirect(`/rooms/catalog/${roomId}`)
    }

    return { rooms, showRoom }
  }
})
</script>

<style scoped>
.title {
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

.message-title {
  margin-bottom: 8px;
  font-size: 14px;
  border-bottom: 1px solid #999;
}

.table-head {
  font-size: 12px;
  padding: 5px;
  border-width: 1px;
  border-style: solid;
  border-color: rgb(221, 221, 221);
  border-image: initial;
  background: rgb(235, 234, 221);
  display: table-cell;
  vertical-align: inherit;
  font-weight: bold;
}

.table-body {
  padding: 5px;
  font-size: 12px;
  text-align: center;
  border-width: 1px;
  border-style: solid;
  border-color: rgb(221, 221, 221);
  border-image: initial;
  display: table-cell;
  vertical-align: inherit;
}

.app-text-right {
  text-align: right !important;
}

.details-button {
  border: 1px solid rgb(221, 221, 221);
}
</style>

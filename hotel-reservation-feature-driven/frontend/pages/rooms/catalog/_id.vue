<template>
  <div>
    <room-catalog-about>
      <div>
        お部屋の詳細
      </div>
    </room-catalog-about>

    <room-catalog-section-title>
      {{ roomDetails.value.name }}
    </room-catalog-section-title>
    <p>
      {{ roomDetails.description }}
    </p>
  </div>
</template>

<script lang="ts">
import { defineComponent, useContext, useAsync, computed } from "@nuxtjs/composition-api"
import RoomCatalogAbout from "@/components/RoomCatalogAbout.vue"
import RoomCatalogSectionTitle from "@/components/RoomCatalogSectionTitle.vue"

export default defineComponent({
  auth: false,
  components: {
    "room-catalog-about": RoomCatalogAbout,
    "room-catalog-section-title": RoomCatalogSectionTitle
  },
  setup() {
    const { $axios, route } = useContext()

    type RoomCatalogItemDetails = {
      name: string,
      description: string,
      type: string,
      dayFee: number,
      amenity: string,
      imagePaths: string[],
    }

    const roomDetails = useAsync(async () => {
      return await $axios.$get<RoomCatalogItemDetails>(`/rooms/catalog/${route.value.params.id}`)
    })

    return { roomDetails: computed(() => roomDetails ?? {}) }
  }
})
</script>

<style>

</style>

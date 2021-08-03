package io.github.piteroni.hotel.reservation.app.entity

import org.jetbrains.exposed.dao.EntityID
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.IntIdTable

object RoomCatalogImages : IntIdTable("room_catalog_images") {
    val path = varchar("image_path", 256)
    val room = reference("rooms", Rooms)
}

class RoomCatalogImage(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<RoomCatalogImage>(RoomCatalogImages)

    var path by RoomCatalogImages.path
    var room by Room referencedOn RoomCatalogImages.room
}

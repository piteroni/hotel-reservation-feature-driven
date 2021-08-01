package io.github.piteroni.hotel.reservation.app.entities

import org.jetbrains.exposed.dao.EntityID
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.IntIdTable

object RoomIntroductionImages : IntIdTable("room_introduction_images") {
    val path = varchar("image_path", 256)
    val room = reference("rooms", Rooms)
}

class RoomIntroductionImage(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<RoomIntroductionImage>(RoomIntroductionImages)

    var path by RoomIntroductionImages.path
    var room by Room referencedOn RoomIntroductionImages.room
}

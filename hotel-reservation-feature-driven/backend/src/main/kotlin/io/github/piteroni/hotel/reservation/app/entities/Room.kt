package io.github.piteroni.hotel.reservation.app.entities

import org.jetbrains.exposed.dao.EntityID
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.IntIdTable
import org.jetbrains.exposed.sql.CurrentDateTime

object Rooms : IntIdTable("rooms") {
    val name = varchar("name", 256)
    val description = varchar("description", 256)
    val amenity = varchar("amenity", 256)
    val type = reference("room_types", RoomTypes)
    val dayFee = short("day_fee")
    val capacity = short("capacity")
    val imagePath = varchar("image_path", 256)
    val createdAt = datetime("created_at").defaultExpression(CurrentDateTime())
    val updatedAt = datetime("updated_at").defaultExpression(CurrentDateTime())
}

class Room(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<Room>(Rooms)

    var name by Rooms.name
    var description by Rooms.description
    var amenity by Rooms.amenity
    var type by RoomType referencedOn Rooms.type
    var dayFee by Rooms.dayFee
    var capacity by Rooms.capacity
    var imagePath by Rooms.imagePath
    val introductionImages by RoomIntroductionImage referrersOn RoomIntroductionImages.room
    var createdAt by Rooms.createdAt
    var updatedAt by Rooms.updatedAt
}

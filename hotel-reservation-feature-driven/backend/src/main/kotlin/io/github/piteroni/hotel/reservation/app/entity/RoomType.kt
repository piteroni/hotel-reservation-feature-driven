package io.github.piteroni.hotel.reservation.app.entity

import org.jetbrains.exposed.dao.EntityID
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.IntIdTable
import org.jetbrains.exposed.sql.CurrentDateTime

object RoomTypes : IntIdTable("room_types") {
    val name = varchar("name", 256)
    val createdAt = datetime("created_at").defaultExpression(CurrentDateTime())
    val updatedAt = datetime("updated_at").defaultExpression(CurrentDateTime())
}

class RoomType(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<RoomType>(RoomTypes)

    var name by RoomTypes.name
    var createdAt by RoomTypes.createdAt
    var updatedAt by RoomTypes.updatedAt
}

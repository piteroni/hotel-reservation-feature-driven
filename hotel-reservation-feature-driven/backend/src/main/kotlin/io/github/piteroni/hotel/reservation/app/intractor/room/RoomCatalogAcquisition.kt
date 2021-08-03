package io.github.piteroni.hotel.reservation.app.intractor.room

import io.github.piteroni.hotel.reservation.app.entity.Room
import io.github.piteroni.hotel.reservation.app.entity.RoomTypes
import io.github.piteroni.hotel.reservation.app.entity.Rooms
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction

class RoomCatalogAcquisition {
    fun getRoomCatalog(): List<RoomCatalogItem> {
        return transaction {
            (RoomTypes innerJoin Rooms).slice(
                Rooms.id,
                Rooms.name,
                RoomTypes.name,
                Rooms.dayFee,
                Rooms.imagePath
            ).selectAll().map {
                RoomCatalogItem(
                    it[Rooms.id].value,
                    it[Rooms.name],
                    it[RoomTypes.name],
                    it[Rooms.dayFee].toInt(),
                    it[Rooms.imagePath]
                )
            }
        }
    }

    fun getRoomCatalogItemDetails(roomId: Int): RoomCatalogItemDetails {
        return transaction {
            Room.findById(roomId)?.let { room ->
                RoomCatalogItemDetails(
                    room.name,
                    room.description,
                    room.type.name,
                    room.dayFee.toInt(),
                    room.amenity,
                    room.catalogImages.map { it.path }
                )
            } ?: throw RoomNotFoundException("specified room does not exist. roomId = $roomId")
        }
    }
}

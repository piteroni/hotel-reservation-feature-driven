package io.github.piteroni.hotel.reservation.app.http.controllers

import io.github.piteroni.hotel.reservation.app.http.exceptions.BadRequestException
import io.github.piteroni.hotel.reservation.app.http.exceptions.NotFoundException
import io.github.piteroni.hotel.reservation.app.intractor.room.RoomCatalogAcquisition
import io.github.piteroni.hotel.reservation.app.intractor.room.RoomNotFoundException
import io.ktor.application.ApplicationCall
import io.ktor.http.HttpStatusCode
import io.ktor.response.respond

class RoomController(
    private val roomCatalogAcquisition: RoomCatalogAcquisition
) {
    suspend fun getRoomCatalog(call: ApplicationCall) {
        val catalog = roomCatalogAcquisition.getRoomCatalog()

        call.respond(HttpStatusCode.OK, catalog)
    }

    suspend fun getRoomCatalogItemDetails(call: ApplicationCall, param: String?) {
        val roomId = param?.toIntOrNull() ?: throw BadRequestException("path parameter is not an integer. param = $param")

        val roomCatalogItemDetails = try {
            roomCatalogAcquisition.getRoomCatalogItemDetails(roomId)
        } catch (exception: RoomNotFoundException) {
            throw NotFoundException(exception)
        }

        call.respond(HttpStatusCode.OK, roomCatalogItemDetails)
    }
}

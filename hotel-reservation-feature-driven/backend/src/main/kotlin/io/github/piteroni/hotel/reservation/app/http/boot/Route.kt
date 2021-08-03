package io.github.piteroni.hotel.reservation.app.http.boot

import io.github.piteroni.hotel.reservation.app.http.controllers.RoomController
import io.github.piteroni.hotel.reservation.app.intractor.room.RoomCatalogAcquisition
import io.ktor.application.Application
import io.ktor.application.call
import io.ktor.auth.authenticate
import io.ktor.http.HttpStatusCode
import io.ktor.response.respond
import io.ktor.routing.Route
import io.ktor.routing.get
import io.ktor.routing.route
import io.ktor.routing.routing

internal fun Application.applyRoutes() {
    routing {
        internalApiRoutes()
    }
}

internal fun Route.internalApiRoutes() {
    val roomController = RoomController(
        RoomCatalogAcquisition()
    )

    route("/api/i/v0") {
//        authenticate {
            route("/users/auth") {
                get {
                    call.respond(HttpStatusCode.OK)
                }
            }
//        }

        route("/rooms/catalog") {
            get {
                roomController.getRoomCatalog(call)
            }

            get("/{roomId}") {
                roomController.getRoomCatalogItemDetails(call, call.parameters["roomId"])
            }
        }
    }
}

package io.github.piteroni.hotel.reservation.app.http.boot

import io.github.piteroni.hotel.reservation.app.database.connectToDatabase
import io.ktor.application.Application

fun Application.main() {
    connectToDatabase()
    applyMiddlewares()
    applyRoutes()
}
package io.github.piteroni.hotel.reservation.migration

import io.github.piteroni.hotel.reservation.app.database.connectToDatabase
import io.github.piteroni.hotel.reservation.app.entity.RoomCatalogImages
import io.github.piteroni.hotel.reservation.app.entity.RoomTypes
import io.github.piteroni.hotel.reservation.app.entity.Rooms
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.StdOutSqlLogger
import org.jetbrains.exposed.sql.addLogger
import org.jetbrains.exposed.sql.transactions.transaction

fun drop() {
    transaction {
        addLogger(StdOutSqlLogger)

        SchemaUtils.drop(RoomCatalogImages)
        SchemaUtils.drop(Rooms)
        SchemaUtils.drop(RoomTypes)
    }
}

fun main() {
    connectToDatabase()
    drop()
}
